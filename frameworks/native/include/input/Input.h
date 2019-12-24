#include <stdint.h>
#include <utils/Timers.h>
#include <utils/RefBase.h>

struct AInputEvent {
};

namespace android {
    class InputEvent : public AInputEvent {

    };

    class KeyEvent : public InputEvent {

    };
}