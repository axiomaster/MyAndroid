#include "EventHub.h"
#include "../../include/InputListener.h"
#include <utils/threads.h>


#ifndef DROID_INPUTREADER_H
#define DROID_INPUTREADER_H

namespace android {
    struct DisplayViewport {

    };

    struct InputReaderConfiguration {
    private:
        DisplayViewport mInternalDisplay;
        DisplayViewport mExternalDisplay;
    };

    class InputReaderPolicyInterface : public virtual RefBase {

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

    private:
        sp<EventHubInterface> mEventHub;
        sp<InputReaderPolicyInterface> mPolicy;
        sp<QueuedInputListener> mQueuedListener;
    };
};

#endif