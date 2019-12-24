//
// Created by lism on 2019/12/24.
//

#include "include/InputDevice.h"
#include "mapper/InputMapper.h"

namespace android {
    void InputDevice::process(const RawEvent *rawEvents, size_t count) {
        for (const RawEvent *rawEvent = rawEvents; count != 0; rawEvent++) {
            if (mDropUntilNextSync) {
            } else if (rawEvent->type == EV_SYN && rawEvent->code == SYN_DROPPED) {
            } else {
                for (InputMapper *mapper:mMappers) {
                    mapper->process(rawEvent);
                }
            }
            --count;
        }
    }
}

