//
// Created by lism on 2019/12/26.
//

#ifndef ANDROID_INPUTWINDOW_H
#define ANDROID_INPUTWINDOW_H

#include <utils/RefBase.h>
#include <binder/IBinder.h>

namespace android {
    struct InputWindowInfo {

    };

    class InputWindowHandle : public RefBase {
    public:
        inline const InputWindowInfo *getInfo() const {
            return &mInfo;
        }

        sp<IBinder> getToken() const;

    protected:
        InputWindowInfo mInfo;
    };
}

#endif //ANDROID_INPUTWINDOW_H
