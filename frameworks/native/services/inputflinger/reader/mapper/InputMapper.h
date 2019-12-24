//
// Created by lism on 2019/12/22.
//

#ifndef DROID_INPUTMAPPER_H
#define DROID_INPUTMAPPER_H


#include "../include/InputDevice.h"

namespace android {
    class InputMapper {
    public:
        explicit InputMapper(InputDevice *device);

        inline InputListenerInterface *getListener() { return mContext->getListener(); }

        virtual void process(const RawEvent *rawEvent) = 0;

    protected:
        InputDevice *mDevice;
        InputReaderContext *mContext;
    };
}

#endif //DROID_INPUTMAPPER_H
