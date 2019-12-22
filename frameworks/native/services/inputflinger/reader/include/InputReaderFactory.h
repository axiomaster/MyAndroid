//
// Created by lism on 2019/12/22.
//

#ifndef DROID_INPUTREADERFACTORY_H
#define DROID_INPUTREADERFACTORY_H


namespace android {
    sp <InputReaderInterface> createInputReader(const sp <InputReaderPolicyInterface> &policy, const sp <InputListenerInterface> &listener);
}

#endif //DROID_INPUTREADERFACTORY_H
