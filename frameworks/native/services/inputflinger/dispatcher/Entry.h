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
        int32_t type;
        bool dispatchInProgress;
    };

    struct KeyEntry : EventEntry {
        int32_t deviceId;
        int32_t displayId;

    };

    struct MotionEntry : EventEntry {

    };

    struct DispatchEntry : Link<DispatchEntry> {
        const uint32_t seq;
        EventEntry *eventEntry;

        DispatchEntry(EventEntry *eventEntry, int32_t targetFlags, float xOffset, float yOffset, float globalScaleFactor, float windowXScale,
                      float windowYScale);
    };
}

#endif //ANDROID_ENTRY_H
