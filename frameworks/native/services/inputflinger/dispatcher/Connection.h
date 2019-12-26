//
// Created by lism on 2019/12/26.
//

#ifndef ANDROID_CONNECTION_H
#define ANDROID_CONNECTION_H

#include <utils/RefBase.h>
#include <input/InputTransport.h>
#include "Queue.h"
#include "Entry.h"

namespace android {
    class Connection : public RefBase {
    public:
        sp<InputChannel> inputChannel;

        Queue<DispatchEntry> outboundQueue;

        InputPublisher inputPublisher;
    };
}

#endif //ANDROID_CONNECTION_H
