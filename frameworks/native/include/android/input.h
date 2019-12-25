//
// Created by lism on 2019/12/24.
//

#ifndef ANDROID_INPUT_H
#define ANDROID_INPUT_H


enum {
    AINPUT_KEYBOARD_TYPE_NON_ALPHABETIC = 1,
};

struct AInputEvent;

typedef struct AInputEvent AInputEvent;

namespace android {
    enum {
        AINPUT_KEYBOARD_TYPE_NON_ALPHABETIC = 1,
    };
}


#endif //ANDROID_INPUT_H
