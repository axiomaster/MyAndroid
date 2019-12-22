//
// Created by lism on 2019/12/22.
//

#ifndef DROID_INPUTCLASSIFIER_H
#define DROID_INPUTCLASSIFIER_H

#include <utils/RefBase.h>
#include "include/InputListener.h"

namespace android {
    class InputClassifierInterface : public virtual RefBase {

    };

    class InputClassifier : public InputClassifierInterface {
    public:
        explicit InputClassifier(const sp<InputListenerInterface> &listener);
    };
}

#endif //DROID_INPUTCLASSIFIER_H
