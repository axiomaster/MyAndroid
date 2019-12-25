//
// Created by lism on 2019/12/24.
//


#include <input/Input.h>
#include "InputDispatcher.h"
#include "Entry.h"

namespace android {
    InputDispatcher::InputDispatcher(const sp<InputDispatcherPolicyInterface> &policy) {

    }

    void InputDispatcher::dispatchOnce() {

    }

    void InputDispatcher::notifyKey(const NotifyKeyArgs *args) {

        KeyEvent event;

        bool needWake;
        {
            KeyEntry *newEntry;
            needWake = enqueueInboundEventLocked(newEntry);
        }
        if (needWake) {
            mLooper->wake();
        }
    }

    bool InputDispatcher::enqueueInboundEventLocked(EventEntry *entry) {

    }
}