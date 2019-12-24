//
// Created by lism on 2019/12/24.
//


#include "include/InputListener.h"

namespace android {
    void NotifyKeyArgs::notify(const sp<InputListenerInterface> &listener) const {
        listener->notifyKey(this);
    }

    void QueuedInputListener::notifyKey(const NotifyKeyArgs *args) {
        mArgsQueue.push_back(new NotifyKeyArgs(*args));
    }

    void QueuedInputListener::flush() {
        size_t count = mArgsQueue.size();
        for (size_t i = 0; i < count; i++) {
            NotifyArgs *args = mArgsQueue[i];
            args->notify(mInnerListener);
            delete args;
        }
        mArgsQueue.clear();
    }
}