//
// Created by lism on 2019/12/27.
//

#include <utils/StrongPointer.h>
#include <jni.h>
#include <memory>
#include "../../../native/include/input/InputTransport.h"

namespace android {
    class NativeInputChannel {
    public:
        explicit NativeInputChannel(const sp<InputChannel> &inputChannel);

    private:
        sp<InputChannel> mInputChannel;
    };

    static jobjectArray android_view_InputChannel_nativeOpenInputChannelPair(JNIEnv *env, jclass clazz, jstring nameObj) {
        ScopedUtfChars nameChars(env, nameObj);
        std::string name = nameChars.c_str();

        sp<InputChannel> serverChannel;
        sp<InputChannel> clientChannel;

        status_t result = InputChannel::openInputChannelPair(name, serverChannel, clientChannel);

        jobject serverChannelObj = android_view_InputChannel_createInputChannel(env, new NativeInputChannel(serverChannel));

        jobject clientChannelObj = android_view_InputChannel_createInputChannel(env, new NativeInputChannel(clientChannel));

        jobjectArray channelPair;
        return channelPair;
    }

    static jobject android_view_InputChannel_createInputChannel(JNIEnv *env, std::unique_ptr<NativeInputChannel> nativeInputChannel) {

    }

    static void android_view_InputChannel_setNativeInputChannel(JNIEnv *env, jobject inputChannelObj, NativeInputChannel *nativeInputChannel) {

    }

    static void android_view_InputChannel_nativeTransferTo(JNIEnv *env, jobject obj, jobject otherObj) {

    }

}