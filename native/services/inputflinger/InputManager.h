
#include <input/Input.h>
#include <utils/RefBase.h>
#include "InputReader.h"
#include "InputDispatcher.h"

namespace android {
    class InputManagerInterface : public virtual RefBase {

    };

    class InputManager : public InputManagerInterface {
    protected:
        virtual ~InputManager();

    public:
    private:
        sp<InputReaderInterface> mReader;
        sp<InputReaderThread> mReaderThread;

        sp<InputDispatcherInterface> mDispatcher;
        sp<InputDispatcherThread> mDispatcherThread;
    };
}
