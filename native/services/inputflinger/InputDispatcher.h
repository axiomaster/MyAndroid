#include <utils/RefBase.h>
#include <utils/Thread.h>
#include "InputListener.h"

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

    };

    class InputDispatcherThread : public Thread {
    private:
        virtual bool threadLoop();

        sp<InputDispatcherInterface> mDispatcher;
    };
};