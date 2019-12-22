//
// Created by lism on 2019/12/22.
//

#ifndef DROID_INPUTDEVICE_H
#define DROID_INPUTDEVICE_H

#include <vector>
#include "InputReader.h"

namespace android {
    class InputMapper;

    class InputDevice {
    public :

        InputDevice(InputReaderContext *context, int32_t id, int32_t generation,
                    int32_t controllerNumber, const InputDeviceIdentifier &identifier,
                    uint32_t classes);

        ~InputDevice();

        inline bool isIgnored() { return mMappers.empty(); }

    private:
        std::vector<InputMapper *> mMappers;
    };
}

#endif //DROID_INPUTDEVICE_H
