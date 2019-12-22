//
// Created by lism on 2019/12/22.
//

#include "include/InputReader.h"

namespace android {
    sp<InputReaderInterface> createInputReader(const sp<InputReaderPolicyInterface> &policy, const sp<InputListenerInterface> &listener) {
        return new InputReader(new EventHub(), policy, listener);
    }
}