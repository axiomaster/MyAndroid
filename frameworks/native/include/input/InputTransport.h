//
// Created by lism on 2019/12/26.
//

#ifndef ANDROID_INPUTTRANSPORT_H
#define ANDROID_INPUTTRANSPORT_H

#include <utils/RefBase.h>
#include "../binder/IBinder.h"

namespace android {
    class InputChannel : public RefBase {
    public:
        static status_t openInputChannelPair(const std::string &name, sp<InputChannel> &outServerChannel, sp<InputChannel> &outClientChannel);

        sp<IBinder> getToken() const;
    };

    class InputPublisher {
    public:
        status_t publishKeyEvent(uint32_t seq, int32_t deviceId);
    };
}

#endif //ANDROID_INPUTTRANSPORT_H
