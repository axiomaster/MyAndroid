//
// Created by lism on 2019/12/26.
//

#ifndef ANDROID_QUEUE_H
#define ANDROID_QUEUE_H

namespace android {
    template<typename T>
    struct Queue {
        T *head;
        T *tail;

        inline bool isEmpty() const { return !head; }

        inline void enqueueAtTail(T *entry) {}

        inline void dequeue(T *entry) {}

        inline T *dequeueAtHead() {}
    };
}

#endif //ANDROID_QUEUE_H
