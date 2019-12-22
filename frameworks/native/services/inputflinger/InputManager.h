#include <utils/RefBase.h>
#include "reader/include/InputReader.h"
#include "dispatcher/InputDispatcher.h"
#include "InputClassifier.h"
#include "reader/include/InputReaderThread.h"
#include "dispatcher/include/InputDispatcherThread.h"


#ifndef DROID_INPUTMANAGER_H
#define DROID_INPUTMANAGER_H

namespace android {
    class InputManagerInterface : public virtual RefBase {

    };

    class InputManager : public InputManagerInterface {
    protected:
        virtual ~InputManager();

    public:
        InputManager(const sp<InputReaderPolicyInterface> &readerPolicy, const sp<InputDispatcherPolicyInterface> &dispatcherPolicy);

        virtual status_t start();

    private:
        sp<InputReaderInterface> mReader;
        sp<InputReaderThread> mReaderThread;

        sp<InputClassifierInterface> mClassifier;

        sp<InputDispatcherInterface> mDispatcher;
        sp<InputDispatcherThread> mDispatcherThread;

        void initialize();
    };
}

#endif