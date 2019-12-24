//
// Created by lism on 2019/12/24.
//

#include "KeyboardInputMapper.h"

namespace android {
    void KeyboardInputMapper::process(const RawEvent *rawEvent) {
        switch (rawEvent->type) {
            case EV_KEY: {
                int32_t scanCode = rawEvent->code;
                int32_t usageCode = mCurrentHidUsage;
                mCurrentHidUsage = 0;
                //
                processKey(rawEvent->when, rawEvent->value != 0, scanCode, usageCode);
            }
        }
    }

    void KeyboardInputMapper::processKey(nsecs_t when, bool down, int32_t scanCode, int32_t usageCode) {
        if (down) {
        } else {
        }

        NotifyKeyArgs args;
        getListener()->notifyKey(&args);
    }
}