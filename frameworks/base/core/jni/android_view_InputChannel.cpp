//
// Created by lism on 2019/12/27.
//

#include <utils/StrongPointer.h>
#include <jni.h>
#include "../../../native/include/input/InputTransport.h"

namespace android {
    class NativeInputChannel {
    public:
    private:
        sp<InputChannel> mInputChannel;
    };

    static jobjectArray android_view_InputChannel_nativeOpenInputChannelPair(JNIEnv *env, jclass clazz, jstring nameObj) {
        ScopedUtfChars nameChars(env, nameObj);
        std::string name = nameChars.c_str();

        sp<InputChannel> serverChannel;
        sp<InputChannel> clientChannel;

        status_t result = InputChannel::openInputChannelPair(name, serverChannel, clientChannel);

        jobjectArray channelPair;
        return channelPair;
    }


}