//
// Created by lism on 2019/12/22.
//

#include <android/input.h>
#include "include/InputReader.h"
#include "include/InputDevice.h"
#include "mapper/KeyboardInputMapper.h"

namespace android {
    InputReader::InputReader(const sp<EventHubInterface> &eventHub, const sp<InputReaderPolicyInterface> &policy,
                             const sp<InputListenerInterface> &listener) : mEventHub(eventHub), mPolicy(policy) {
        mQueuedListener = new QueuedInputListener(listener);
    }

    void InputReader::loopOnce() {
        int32_t timeoutMillis;
        bool inputDevicesChanged = false;
        std::vector<InputDeviceInfo> inputDevices;

        size_t count = mEventHub->getEvents(timeoutMillis, mEventBuffer, EVENT_BUFFER_SIZE);
        { // lock
            if (count) {
                processEventsLocked(mEventBuffer, count);
            }
        }

        if (inputDevicesChanged) {
            mPolicy->notifyInputDevicesChanged(inputDevices);
        }

        mQueuedListener->flush();
    }

    void InputReader::processEventsLocked(const RawEvent *rawEvents, size_t count) {
        for (const RawEvent *rawEvent = rawEvents; count;) {
            int32_t type = rawEvent->type;
            size_t batchSize = 1;
            if (type < EventHubInterface::FIRST_SYNTHETIC_EVENT) {
                int32_t deviceId = rawEvent->deviceId;
                while (batchSize < count) {
                    if (rawEvent[batchSize].type >= EventHubInterface::FIRST_SYNTHETIC_EVENT || rawEvent[batchSize].type != deviceId) {
                        break;
                    }
                    batchSize += 1;
                }
                processEventsForDeviceLocked(deviceId, rawEvent, batchSize);
            } else {
                switch (rawEvent->type) {
                    case EventHubInterface::DEVICE_ADDED:
                        addDeviceLocked(rawEvent->when, rawEvent->deviceId);
                        break;
                    default:
                        break;
                }
            }
            count -= batchSize;
            rawEvent += batchSize;
        }
    }

    void InputReader::addDeviceLocked(nsecs_t when, int32_t deviceId) {
        InputDeviceIdentifier identifier = mEventHub->getDeviceIdentifier(deviceId);
        uint32_t classes = mEventHub->getDeviceClasses(deviceId);
        int32_t controllerNumber = mEventHub->getDeviceControllerNumber(deviceId);

        InputDevice *device = createDeviceLocked(deviceId, controllerNumber, identifier, classes);

        if (device->isIgnored()) {
        } else {
        }

        mDevices.add(deviceId, device);

    }

    InputDevice *InputReader::createDeviceLocked(int32_t deviceId, int32_t controllerNumber, const InputDeviceIdentifier &identifier,
                                                 uint32_t classes) {
        InputDevice *device = new InputDevice(&mContext, deviceId, bumpGenerationLocked(), controllerNumber, identifier, classes);

        uint32_t keyboardSource = 0;
        int32_t keyboardType = AINPUT_KEYBOARD_TYPE_NON_ALPHABETIC;
        if (classes & INPUT_DEVICE_CLASS_KEYBOARD) {
            keyboardSource |= AINPUT_CLASS_KEYBOARD;
        }

        if (keyboardSource != 0) {
            device->addMapper(new KeyboardInputMapper(device, keyboardSource, keyboardType));
        }
    }

    void InputReader::processEventsForDeviceLocked(int32_t deviceId, const RawEvent *rawEvents, size_t count) {
        size_t deviceIndex = mDevices.indexOfKey(deviceId);
        InputDevice *device = mDevices.valueAt(deviceIndex);
        device->process(rawEvents, count);
    }
}