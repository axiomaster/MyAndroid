//
// Created by lism on 2019/12/22.
//

#include "InputDispatcher.h"

namespace android {
    sp<InputDispatcherInterface> createInputDispatcher(const sp<InputDispatcherPolicyInterface> &policy) {
        return new InputDispatcher(policy);
    }
}