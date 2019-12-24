#include "EventHub.h"
#include "../../include/InputListener.h"
#include <utils/threads.h>
#include <utils/KeyedVector.h>
#include <input/InputDevice.h>
#include <vector>


#ifndef DROID_INPUTREADER_H
#define DROID_INPUTREADER_H

namespace android {
    class InputDevice;

    class InputMapper;

    struct DisplayViewport {

    };

    struct InputReaderConfiguration {
    private:
        DisplayViewport mInternalDisplay;
        DisplayViewport mExternalDisplay;
    };

    class InputReaderPolicyInterface : public virtual RefBase {
    public:
        virtual void notifyInputDevicesChanged(const std::vector<InputDeviceInfo> &inputDevices) = 0;
    };

    class InputReaderInterface : public virtual RefBase {
    protected:
        InputReaderInterface() {}

        virtual ~InputReaderInterface() {}

    public:
        virtual void loopOnce() = 0;
    };

    class InputReaderContext {

    };

    class InputReader : public InputReaderInterface {
    public:
        InputReader(const sp<EventHubInterface> &eventHub, const sp<InputReaderPolicyInterface> &policy,
                    const sp<InputListenerInterface> &listener);

        virtual ~InputReader();

        virtual void loopOnce();

    protected:
        virtual InputDevice *createDeviceLocked(int32_t deviceId, int32_t controllerNumber,
                                                const InputDeviceIdentifier &identifier,
                                                uint32_t classes);

        class ContextImpl : public InputReaderContext {

        } mContext;

    private:
        sp<EventHubInterface> mEventHub;
        sp<InputReaderPolicyInterface> mPolicy;
        sp<QueuedInputListener> mQueuedListener;

        static const int EVENT_BUFFER_SIZE = 256;
        RawEvent mEventBuffer[EVENT_BUFFER_SIZE];

        KeyedVector<int32_t, InputDevice *> mDevices;

        void processEventsLocked(const RawEvent *rawEvents, size_t count);

        void addDeviceLocked(nsecs_t when, int32_t deviceId);

        void processEventsForDeviceLocked(int32_t deviceId, const RawEvent *rawEvents, size_t count);


        int32_t bumpGenerationLocked();
    };
};

#endif