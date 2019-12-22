//
// Created by lism on 2019/12/22.
//

#include "include/InputReaderThread.h"

namespace android {
    InputReaderThread::InputReaderThread(const sp<InputReaderInterface> &reader) : Thread(true), mReader(reader) {
    }

    bool InputReaderThread::threadLoop() {
        mReader->loopOnce();
        return true;
    }
}