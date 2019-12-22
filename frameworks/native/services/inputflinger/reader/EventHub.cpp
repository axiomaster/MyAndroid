//
// Created by lism on 2019/12/22.
//

#include "include/EventHub.h"

namespace android {
    size_t EventHub::getEvents(int timeoutMillis, RawEvent *buffer, size_t bufferSize) {
        struct input_event readBuffer[bufferSize];
    }
}