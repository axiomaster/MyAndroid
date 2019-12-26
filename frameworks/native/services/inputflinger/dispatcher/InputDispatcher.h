#include <utils/RefBase.h>
#include <utils/Thread.h>
#include <utils/Looper.h>
#include <utils/BitSet.h>
#include <mutex>
#include "../include/InputListener.h"
#include "include/InputDispatcherPolicyInterface.h"
#include "include/InputDispatcherInterface.h"

#include <unordered_map>
#include <input/InputWindow.h>
#include <input/InputApplication.h>
#include "Queue.h"
#include "Entry.h"
#include "Connection.h"


#ifndef DROID_INPUTDISPATCHER_H
#define DROID_INPUTDISPATCHER_H

namespace android {
    struct InputTarget {
        enum {
            FLAG_FOREGROUND = 1 << 0,
            FLAG_DISPATCH_AS_IS = 1 << 8,
        };
        sp<InputChannel> inputChannel;
        int32_t flags;
        float xOffset, yOffset;
        float globalScaleFactor;
        float windowXScale = 1.0f;
        float windowYScale = 1.0f;
        BitSet32 pointerIds;
    };

    struct InputDispatcherConfiguration {

    };


    class InputDispatcher : public InputDispatcherInterface {
    public:
        explicit InputDispatcher(const sp<InputDispatcherPolicyInterface> &policy);

        virtual void dispatchOnce() override;

        virtual void notifyKey(const NotifyKeyArgs *args) override;


    private:
        enum DropReason {
            DROP_REASON_NOT_DROPPED = 0,
        };
        std::mutex mLock;
        sp<Looper> mLooper;

        EventEntry *mPendingEvent GUARDED_BY(mLock);
        Queue<EventEntry> mInboundQueue GUARDED_BY(mLock);

        void dispatchOnceInnerLocked(nsecs_t *nextWakeupTime) REQUIRES(mLock);

        bool dispatchKeyLocked(nsecs_t currentTime, KeyEntry *entry, DropReason *dropReason,
                               nsecs_t *nextWakeupTime) REQUIRES(mLock);

        void dispatchEventLocked(nsecs_t currentTime, EventEntry *entry,
                                 const std::vector<InputTarget> &inputTargets) REQUIRES(mLock);

        bool enqueueInboundEventLocked(EventEntry *entry) REQUIRES(mLock);

        bool haveCommandsLocked() const REQUIRES(mLock);

        std::unordered_map<int32_t, sp<InputWindowHandle>> mFocusedWindowHandlesByDisplay
        GUARDED_BY(mLock);
        std::unordered_map<int32_t, sp<InputApplicationHandle>> mFocusedApplicationHandlesByDisplay
        GUARDED_BY(mLock);

        struct IBinderHash {
            std::size_t operator()(const sp<IBinder> &b) const {
                return std::hash<IBinder *>{}(b.get());
            }
        };

        std::unordered_map<sp<IBinder>, sp<InputChannel>, IBinderHash> mInputChannelsByToken
        GUARDED_BY(mLock);

        int32_t getTargetDisplayId(const EventEntry *entry);

        int32_t findFocusedWindowTargetsLocked(nsecs_t currentTime, const EventEntry *entry,
                                               std::vector<InputTarget> &inputTargets,
                                               nsecs_t *nextWakeupTime) REQUIRES(mLock);

        void addWindowTargetLocked(const sp<InputWindowHandle> &windowHandle, int32_t targetFlags, BitSet32 pointerIds,
                                   std::vector<InputTarget> &inputTargets) REQUIRES(mLock);

        sp<InputChannel> getInputChannelLocked(const sp<IBinder> &windowToken) const REQUIRES(mLock);

        KeyedVector<int, sp<Connection>> mConnectionsByFd GUARDED_BY(mLock);

        ssize_t getConnectionIndexLocked(const sp<InputChannel> &inputChannel) REQUIRES(mLock);

        void prepareDispatchCycleLocked(nsecs_t currentTime, const sp<Connection> &connection, EventEntry *eventEntry,
                                        const InputTarget *inputTarget) REQUIRES(mLock);

        void enqueueDispatchEntriesLocked(nsecs_t currentTime, const sp<Connection> &connection, EventEntry *eventEntry,
                                          const InputTarget *inputTarget) REQUIRES(mLock);

        void enqueueDispatchEntryLocked(const sp<Connection> &connection, EventEntry *eventEntry, const InputTarget *inputTarget,
                                        int32_t dispatchMode) REQUIRES(mLock);

        void startDispatchCycleLocked(nsecs_t currentTime, const sp<Connection> &connection)        REQUIRES(mLock);
    };
};

#endif
