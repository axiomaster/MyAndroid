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
    public:
        virtual sp<InputDispatcherInterface> getDispatcher() = 0;
    };

    class InputManager : public InputManagerInterface {
    protected:
        virtual ~InputManager();

    public:
        InputManager(const sp<InputReaderPolicyInterface> &readerPolicy, const sp<InputDispatcherPolicyInterface> &dispatcherPolicy);

        virtual status_t start();

        sp<InputDispatcherInterface> getDispatcher() override;

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