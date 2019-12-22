//
// Created by lism on 2019/12/22.
//

#include "include/InputReader.h"

namespace android {
    InputReader::InputReader(const sp<EventHubInterface> &eventHub, const sp<InputReaderPolicyInterface> &policy,
                             const sp<InputListenerInterface> &listener) : mEventHub(eventHub), mPolicy(policy) {
        mQueuedListener = new QueuedInputListener(listener);
    }
}