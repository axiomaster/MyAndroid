#include <utils/RefBase.h>
#include <utils/Thread.h>
#include "../include/InputListener.h"


#ifndef DROID_INPUTDISPATCHER_H
#define DROID_INPUTDISPATCHER_H

namespace android {
    struct InputTarget {

    };

    struct InputDispatcherConfiguration {

    };

    class InputDispatcherPolicyInterface : public virtual RefBase {

    };

    class InputDispatcherInterface : public virtual RefBase, public InputListenerInterface {

    };

    class InputDispatcher : public InputDispatcherInterface {
    public:
        explicit InputDispatcher(const sp<InputDispatcherPolicyInterface> &policy);
    };
};

#endif
