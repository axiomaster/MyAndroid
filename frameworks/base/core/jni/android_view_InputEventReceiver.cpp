//
// Created by lism on 2019/12/28.
//

#include <utils/Looper.h>
#include <jni.h>
#include "../../../native/include/input/InputTransport.h"
#include "android_os_MessageQueue.h"

namespace android {
    class NativeInputEventReceiver : public LooperCallback {
    public:
        NativeInputEventReceiver(JNIEnv *env, jobject receiverWeak, const sp<InputChannel> &inputChannel, const sp<MessageQueue> &messageQueue);

        status_t initialize();


    private:
        sp<MessageQueue> mMessageQueue;

    public:
        virtual int handleEvent(int fd, int events, void *data);
    };

    static jlong nativeInit(JNIEnv *env, jclass clazz, jobject receiverWeak, jobject inputChannelObj, jobject messageQueueObj) {
        sp<InputChannel> inputChannel = android_view_InputChannel_getInputChannle(env, inputChannelObj);
        sp<MessageQueue> messageQueue = android_os_MessageQueue_getMessageQueue(env, messageQueueObj);

        sp<NativeInputEventReceiver> receiver = new NativeInputEventReceiver(env, receiverWeak, inputChannel, messageQueue);
        receiver->initialize();
    }
}