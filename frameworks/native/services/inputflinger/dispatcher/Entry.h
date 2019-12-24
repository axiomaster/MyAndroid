//
// Created by lism on 2019/12/24.
//

#ifndef ANDROID_ENTRY_H
#define ANDROID_ENTRY_H

namespace android {
    template<typename T>
    struct Link {
        T *next;
        T *prev;
    };

    struct EventEntry : Link<EventEntry> {
        enum {
            TYPE_KEY,
            TYPE_MOTION
        };
    };

    struct KeyEntry : EventEntry {

    };

    struct MotionEntry : EventEntry {

    };
}

#endif //ANDROID_ENTRY_H
