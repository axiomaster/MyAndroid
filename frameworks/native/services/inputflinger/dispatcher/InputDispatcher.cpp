//
// Created by lism on 2019/12/24.
//


#include <input/Input.h>
#include <input/InputTransport.h>
#include <android/looper.h>
#include "InputDispatcher.h"
#include "Entry.h"
#include "Connection.h"

namespace android {
    static inline nsecs_t now() {
        return systemTime(SYSTEM_TIME_MONOTONIC);
    }

    template<typename T, typename U>
    static T getValueByKey(std::unordered_map<U, T> &map, U key) {
        typename std::unordered_map<U, T>::const_iterator it = map.find(key);
        return it != map.end() ? it->second : T{};
    }

    InputDispatcher::InputDispatcher(const sp<InputDispatcherPolicyInterface> &policy) {

    }

    void InputDispatcher::dispatchOnce() {
        nsecs_t nextWakeupTime = LONG_LONG_MAX;
        {
            if (!haveCommandsLocked()) {
                dispatchOnceInnerLocked(&nextWakeupTime);
            }
        }

        nsecs_t currentTime = now();
        int timeoutMillis = toMillisecondTimeoutDelay(currentTime, nextWakeupTime);
        mLooper->pollOnce(timeoutMillis);
    }

    void InputDispatcher::notifyKey(const NotifyKeyArgs *args) {

        KeyEvent event;

        bool needWake;
        {
            KeyEntry *newEntry;
            needWake = enqueueInboundEventLocked(newEntry);
        }
        if (needWake) {
            mLooper->wake();
        }
    }

    void InputDispatcher::dispatchOnceInnerLocked(nsecs_t *nextWakeupTime) {
        nsecs_t currentTime = now();
        // grab a pending event
        if (!mPendingEvent) {
            if (mInboundQueue.isEmpty()) {
            } else {
                mPendingEvent = mInboundQueue.dequeueAtHead();
            }
        }

        bool done = false;
        DropReason dropReason = DROP_REASON_NOT_DROPPED;
        switch (mPendingEvent->type) {
            case EventEntry::TYPE_KEY: {
                KeyEntry *typedEntry = static_cast<KeyEntry *>(mPendingEvent);
                done = dispatchKeyLocked(currentTime, typedEntry, &dropReason, nextWakeupTime);
                break;
            }
            case EventEntry::TYPE_MOTION: {

            }
        }
    }

    bool InputDispatcher::dispatchKeyLocked(nsecs_t currentTime, KeyEntry *entry, InputDispatcher::DropReason *dropReason,
                                            nsecs_t *nextWakeupTime) {
        if (!entry->dispatchInProgress) {
        }

        std::vector<InputTarget> inputTargets;
        int32_t injectionResult = findFocusedWindowTargetsLocked(currentTime, entry, inputTargets, nextWakeupTime);

        dispatchEventLocked(currentTime, entry, inputTargets);
        return true;
    }

    void InputDispatcher::dispatchEventLocked(nsecs_t currentTime, EventEntry *entry, const std::vector<InputTarget> &inputTargets) {
        for (const InputTarget &inputTarget:inputTargets) {
            ssize_t connectionIndex = getConnectionIndexLocked(inputTarget.inputChannel);
            if (connectionIndex >= 0) {
                sp<Connection> connection = mConnectionsByFd.valueAt(connectionIndex);
                prepareDispatchCycleLocked(currentTime, connection, entry, &inputTarget);
            }
        }
    }

    ssize_t InputDispatcher::getConnectionIndexLocked(const sp<InputChannel> &inputChannel) {
        for (size_t i = 0; i < mConnectionsByFd.size(); i++) {
            sp<Connection> connection = mConnectionsByFd.valueAt(i);
            if (connection->inputChannel->getToken() == inputChannel->getToken()) {
                return i;
            }
        }
    }

    void InputDispatcher::prepareDispatchCycleLocked(nsecs_t currentTime, const sp<Connection> &connection, EventEntry *eventEntry,
                                                     const InputTarget *inputTarget) {
        enqueueDispatchEntriesLocked(currentTime, connection, eventEntry, inputTarget);
    }

    void InputDispatcher::enqueueDispatchEntriesLocked(nsecs_t currentTime, const sp<Connection> &connection, EventEntry *eventEntry,
                                                       const InputTarget *inputTarget) {
        bool wasEmpty = connection->outboundQueue.isEmpty();

        enqueueDispatchEntryLocked(connection, eventEntry, inputTarget, InputTarget::FLAG_DISPATCH_AS_IS);
        if (wasEmpty && !connection->outboundQueue.isEmpty()) {
            startDispatchCycleLocked(currentTime, connection);
        }
    }

    void InputDispatcher::enqueueDispatchEntryLocked(const sp<Connection> &connection, EventEntry *eventEntry, const InputTarget *inputTarget,
                                                     int32_t dispatchMode) {
        int32_t inputTargetFlags = inputTarget->flags;
        DispatchEntry *dispatchEntry = new DispatchEntry(eventEntry, inputTargetFlags, inputTarget->xOffset, inputTarget->yOffset,
                                                         inputTarget->globalScaleFactor,
                                                         inputTarget->windowXScale, inputTarget->windowYScale);
        switch (eventEntry->type) {
            case EventEntry::TYPE_KEY: {
                KeyEntry *keyEntry = static_cast<KeyEntry *>(eventEntry);
            }
        }

        connection->outboundQueue.enqueueAtTail(dispatchEntry);
    }

    void InputDispatcher::startDispatchCycleLocked(nsecs_t currentTime, const sp<Connection> &connection) {
        while (!connection->outboundQueue.isEmpty()) {
            DispatchEntry *dispatchEntry = connection->outboundQueue.head;

            status_t status;
            EventEntry *eventEntry = dispatchEntry->eventEntry;
            switch (eventEntry->type) {
                case EventEntry::TYPE_KEY: {
                    KeyEntry *keyEntry = static_cast<KeyEntry *>(eventEntry);

                    status = connection->inputPublisher.publishKeyEvent(dispatchEntry->seq, keyEntry->deviceId);
                    break;
                }
            }

            // check result
            connection->outboundQueue.dequeue(dispatchEntry);
        }
    }

    bool InputDispatcher::enqueueInboundEventLocked(EventEntry *entry) {

    }

    int32_t InputDispatcher::getTargetDisplayId(const EventEntry *entry) {
        int32_t displayId;
        switch (entry->type) {
            case EventEntry::TYPE_KEY: {
                const KeyEntry *typedEntry = static_cast<const KeyEntry *>(entry);
                displayId = typedEntry->displayId;
                break;
            }
        }
        // check
        return displayId;
    }

    int32_t InputDispatcher::findFocusedWindowTargetsLocked(nsecs_t currentTime, const EventEntry *entry,
                                                            std::vector<InputTarget> &inputTargets, nsecs_t *nextWakeupTime) {
        int32_t injectionResult;
        int32_t displayId = getTargetDisplayId(entry);
        sp<InputWindowHandle> focusedWindowHandle = getValueByKey(mFocusedWindowHandlesByDisplay, displayId);
        sp<InputApplicationHandle> focusedApplicationHandle = getValueByKey(mFocusedApplicationHandlesByDisplay, displayId);

        // check permissions

        // success
        injectionResult = INPUT_EVENT_INJECTION_SUCCEEDED;
        addWindowTargetLocked(focusedWindowHandle, InputTarget::FLAG_FOREGROUND | InputTarget::FLAG_DISPATCH_AS_IS, BitSet32(0), inputTargets);
        return injectionResult;
    }

    void InputDispatcher::addWindowTargetLocked(const sp<InputWindowHandle> &windowHandle, int32_t targetFlags, BitSet32 pointerIds,
                                                std::vector<InputTarget> &inputTargets) {
        sp<InputChannel> inputChannel = getInputChannelLocked(windowHandle->getToken());

        const InputWindowInfo *windowInfo = windowHandle->getInfo();

        // construct input target
        InputTarget target;
        target.inputChannel = inputChannel;
        target.flags = targetFlags;
        target.pointerIds = pointerIds;
        inputTargets.push_back(target);
    }

    sp<InputChannel> InputDispatcher::getInputChannelLocked(const sp<IBinder> &token) const {
        size_t count = mInputChannelsByToken.count(token);
        if (count == 0) {
            return nullptr;
        }
        return mInputChannelsByToken.at(token);
    }

    status_t InputDispatcher::registerInputChannel(const sp<InputChannel> &inputChannel, int32_t displayId) {
        {
            sp<Connection> connection = new Connection(inputChannel, false);

            int fd = inputChannel->getFd();
            mConnectionsByFd.add(fd, connection);
            mInputChannelsByToken[inputChannel->getToken()] = inputChannel;

            mLooper->addFd(fd, 0, ALOOPER_EVENT_INPUT, handleReceiveCallback, this);
        }

        mLooper->wake();
        return 0;
    }
}