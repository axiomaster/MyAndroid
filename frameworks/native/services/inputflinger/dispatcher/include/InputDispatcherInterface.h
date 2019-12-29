//
// Created by lism on 2019/12/24.
//

#ifndef ANDROID_INPUTDISPATCHERINTERFACE_H
#define ANDROID_INPUTDISPATCHERINTERFACE_H

#include <utils/RefBase.h>
#include "../../include/InputListener.h"

namespace android {
    enum {
        INPUT_EVENT_INJECTION_SUCCEEDED = 0,
    };

    class InputDispatcherInterface : public virtual RefBase, public InputListenerInterface {
    public:
        virtual void dispatchOnce() = 0;

        virtual status_t registerInputChannel(const sp <InputChannel> &inputChannel, int32_t displayId) = 0;
    };
}

#endif //ANDROID_INPUTDISPATCHERINTERFACE_H
