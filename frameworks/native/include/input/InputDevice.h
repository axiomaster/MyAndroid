//
// Created by lism on 2019/12/22.
//

#ifndef DROID_LIB_INPUTDEVICE_H
#define DROID_LIB_INPUTDEVICE_H

#include <string>

namespace android {
    struct InputDeviceIdentifier {
        std::string name;
        std::string location;
        std::string uniqueId;
    };

    class InputDeviceInfo {
    private:
        int32_t mId;
    };
}

#endif //DROID_LIB_INPUTDEVICE_H
