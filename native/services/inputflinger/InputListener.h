//
// Created by shimi on 19/12/8.
//

#ifndef DROID_INPUTLISTENER_H
#define DROID_INPUTLISTENER_H

#include <utils/RefBase.h>

namespace android {
    class InputListenerInterface;

    class InputListenerInterface : public virtual RefBase {
    protected:
        InputListenerInterface() {}

        virtual ~InputListenerInterface() {}
    };
};

#endif //DROID_INPUTLISTENER_H
