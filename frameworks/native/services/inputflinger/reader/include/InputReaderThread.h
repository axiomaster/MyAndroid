//
// Created by lism on 2019/12/22.
//

#ifndef DROID_INPUTREADERTHREAD_H
#define DROID_INPUTREADERTHREAD_H

#include <utils/Thread.h>
#include "InputReader.h"

namespace android {
    class InputReaderThread : public Thread {
    public:
        InputReaderThread(const sp<InputReaderInterface> &reader);

        virtual ~InputReaderThread();

    private:
        sp<InputReaderInterface> mReader;

        virtual bool threadLoop();
    };
}

#endif //DROID_INPUTREADERTHREAD_H
