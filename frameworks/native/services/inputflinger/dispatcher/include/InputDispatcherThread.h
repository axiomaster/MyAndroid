//
// Created by lism on 2019/12/22.
//

#ifndef DROID_INPUTDISPATCHERTHREAD_H
#define DROID_INPUTDISPATCHERTHREAD_H

#include <utils/Thread.h>
#include "../InputDispatcher.h"

namespace android {
    class InputDispatcherThread : public Thread {
    public:
        explicit InputDispatcherThread(const sp<InputDispatcherInterface> &dispatcher);

    private:
        virtual bool threadLoop();

        sp<InputDispatcherInterface> mDispatcher;
    };
}

#endif //DROID_INPUTDISPATCHERTHREAD_H
