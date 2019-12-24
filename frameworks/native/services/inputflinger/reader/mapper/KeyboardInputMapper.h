//
// Created by lism on 2019/12/24.
//

#ifndef ANDROID_KEYBOARDINPUTMAPPER_H
#define ANDROID_KEYBOARDINPUTMAPPER_H

#include "InputMapper.h"

namespace android {
    class KeyboardInputMapper : public InputMapper {
    public :
        KeyboardInputMapper(InputDevice *device, uint32_t source, int32_t keyboardType);

        virtual void process(const RawEvent *rawEvent);

        void processKey(nsecs_t when, bool down, int32_t scanCode, int32_t usageCode);
    };
}


#endif //ANDROID_KEYBOARDINPUTMAPPER_H
