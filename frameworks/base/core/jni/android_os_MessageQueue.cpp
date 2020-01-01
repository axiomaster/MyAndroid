//
// Created by lism on 2020/1/1.
//

#include <utils/Looper.h>
#include <jni.h>
#include "android_os_MessageQueue.h"

namespace android {
    class NativeMessageQueue : public MessageQueue, public LooperCallback {
    public:
        NativeMessageQueue();

        virtual ~NativeMessageQueue();

        void pollOnce(JNIEnv *env, jobject obj, int timeoutMillis);

        virtual int handleEvent(int fd, int events, void *data);

    private:
        JNIEnv *mPollEnv;
        jobject mPollObj;
        jthrowable mExceptionObj;
    };

    NativeMessageQueue::NativeMessageQueue() : mPollEnv(nullptr), mPollObj(nullptr), mExceptionObj(nullptr) {
        mLooper = Looper::getForThread();
        if (mLooper == nullptr) {
            mLooper = new Looper(false);
            Looper::setForThread(mLooper);
        }
    }

    void NativeMessageQueue::pollOnce(JNIEnv *env, jobject obj, int timeoutMillis) {
        mPollEnv = env;
        mPollObj = obj;
        mLooper->pollOnce(timeoutMillis);
        mPollObj = nullptr;
        mPollEnv = nullptr;

    }

    // ----------------------------------------------------------------------------

    static jlong android_os_MessageQueue_nativeInit(JNIEnv *env, jclass clazz) {
        NativeMessageQueue *nativeMessageQueue = new NativeMessageQueue();
        if (!nativeMessageQueue) {
            return 0;
        }
        nativeMessageQueue->incStrong(env);
        return reinterpret_cast<jlong>(nativeMessageQueue);
    }

    static void android_os_MessageQueue_nativePollOnce(JNIEnv *env, jobject obj, jlong ptr, jint timeoutMillis) {
        NativeMessageQueue *nativeMessageQueue = reinterpret_cast<NativeMessageQueue *>(ptr);
        nativeMessageQueue->pollOnce(env, obj, timeoutMillis);
    }
}

