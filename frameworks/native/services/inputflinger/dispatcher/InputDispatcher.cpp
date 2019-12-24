//
// Created by lism on 2019/12/24.
//

<<<<<<< HEAD
#include <input/Input.h>
#include "InputDispatcher.h"
#include "Entry.h"
=======
#include "InputDispatcher.h"
>>>>>>> 17d5b6cca3f37c762cbc7b8729af38048880cad3

namespace android {
    InputDispatcher::InputDispatcher(const sp<InputDispatcherPolicyInterface> &policy) {

    }

    void InputDispatcher::dispatchOnce() {

    }

    void InputDispatcher::notifyKey(const NotifyKeyArgs *args) {
<<<<<<< HEAD
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
=======
>>>>>>> 17d5b6cca3f37c762cbc7b8729af38048880cad3

    }
}