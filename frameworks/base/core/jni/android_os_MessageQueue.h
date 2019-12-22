//
// Created by lism on 2019/12/22.
//

#ifndef DROID_ANDROID_OS_MESSAGEQUEUE_H
#define DROID_ANDROID_OS_MESSAGEQUEUE_H

#include <utils/RefBase.h>
#include <utils/Looper.h>

namespace android {
    class MessageQueue : public virtual RefBase {
    public:
        inline sp<Looper> getLooper() const {
            return mLooper;
        }

    protected:
        sp<Looper> mLooper;
    };
}

#endif //DROID_ANDROID_OS_MESSAGEQUEUE_H
