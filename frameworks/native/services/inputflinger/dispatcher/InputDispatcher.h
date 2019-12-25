#include <utils/RefBase.h>
#include <utils/Thread.h>
#include <utils/Looper.h>
#include <mutex>
#include "../include/InputListener.h"
#include "include/InputDispatcherPolicyInterface.h"
#include "include/InputDispatcherInterface.h"

#include "Entry.h"


#ifndef DROID_INPUTDISPATCHER_H
#define DROID_INPUTDISPATCHER_H

namespace android {
    struct InputTarget {

    };

    struct InputDispatcherConfiguration {

    };


    class InputDispatcher : public InputDispatcherInterface {
    public:
        explicit InputDispatcher(const sp<InputDispatcherPolicyInterface> &policy);

        virtual void dispatchOnce() override;

        virtual void notifyKey(const NotifyKeyArgs *args) override;


    private:
        std::mutex mLock;
        sp<Looper> mLooper;

        bool enqueueInboundEventLocked(EventEntry *entry) REQUIRES(mLock);
    };
};

#endif
