#include <utils/RefBase.h>
#include <utils/Thread.h>
#include <utils/Looper.h>
#include <mutex>
#include "../include/InputListener.h"
#include "include/InputDispatcherPolicyInterface.h"
#include "include/InputDispatcherInterface.h"
<<<<<<< HEAD
#include "Entry.h"
=======
>>>>>>> 17d5b6cca3f37c762cbc7b8729af38048880cad3


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
<<<<<<< HEAD

    private:
        std::mutex mLock;
        sp<Looper> mLooper;

        bool enqueueInboundEventLocked(EventEntry *entry) REQUIRES(mLock);
=======
>>>>>>> 17d5b6cca3f37c762cbc7b8729af38048880cad3
    };
};

#endif
