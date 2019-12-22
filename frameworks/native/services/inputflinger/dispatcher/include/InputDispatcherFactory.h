//
// Created by lism on 2019/12/22.
//

#ifndef DROID_INPUTDISPATCHERFACTORY_H
#define DROID_INPUTDISPATCHERFACTORY_H

namespace android {
    sp <InputDispatcherInterface> createInputDispatcher(const sp <InputDispatcherPolicyInterface> &policy);
}

#endif //DROID_INPUTDISPATCHERFACTORY_H
