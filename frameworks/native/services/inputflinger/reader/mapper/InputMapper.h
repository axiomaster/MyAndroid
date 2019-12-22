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

    protected:
        InputDevice *mDevice;
    };
}

#endif //DROID_INPUTMAPPER_H
