#include <utils/RefBase.h>
#include <utils/Thread.h>
#include "../include/InputListener.h"
#include "include/InputDispatcherPolicyInterface.h"
#include "include/InputDispatcherInterface.h"


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
    };
};

#endif
