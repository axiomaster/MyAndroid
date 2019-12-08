#include "EventHub.h"
#include "InputListener.h"
#include <utils/threads.h>

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
    };

    class InputReaderContext {

    };

    class InputReader : public InputReaderInterface {
    public:
        InputReader(const sp<EventHubInterface> &eventHub, const sp<InputReaderPolicyInterface> &policy,
                    const sp<InputListenerInterface> &listener);

        virtual ~InputReader();

    private:
        sp<EventHubInterface> mEventHub;
    };

    class InputReaderThread : public Thread {
    public:
        InputReaderThread(const sp<InputReaderInterface> &reader);

        virtual ~InputReaderThread();

    private:
        sp<InputReaderInterface> mReader;

        virtual bool threadLoop();
    };
};