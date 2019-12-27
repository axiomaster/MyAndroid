#include "nativehelper/JNIHelp.h"
#include "jni.h"
#include "../../../core/jni/android_os_MessageQueue.h"
#include "../../../../native/include/input/InputTransport.h"
#include <utils/Looper.h>
#include <inputflinger/InputManager.h>

namespace android {
    class NativeInputManager : public virtual RefBase, public virtual InputReaderPolicyInterface, public virtual InputDispatcherPolicyInterface {
    protected:
        virtual ~NativeInputManager();

    public:
        NativeInputManager(jobject contextObj, jobject serviceObj, const sp<Looper> &looper);

        inline sp<InputManager> getInputManager() const { return mInputManager; }

        status_t registerInputChannel(JNIEnv * /* env */, const sp<InputChannel> &inputChannel, int32_t displayId);

    private:
        sp<InputManager> mInputManager;

        sp<Looper> mLooper;

        std::atomic<bool> mInteractive;

        void notifyInputDevicesChanged(const std::vector<InputDevice> &inputDevices);
    };

    NativeInputManager::NativeInputManager(jobject contextObj, jobject serviceObj, const android::sp<android::Looper> &looper) : mLooper(looper),
                                                                                                                                 mInteractive(true) {
        mInputManager = new InputManager(this, this);
    }

    void NativeInputManager::notifyInputDevicesChanged(const std::vector<InputDevice> &inputDevices) {

    }

    status_t NativeInputManager::registerInputChannel(JNIEnv *, const sp<InputChannel> &inputChannel, int32_t displayId) {

    }

    static jlong nativeInit(JNIEnv *env, jclass, jobject serviceObj, jobject contextObj, jobject messageQueueObj) {
        // fixme
        sp<MessageQueue> messageQueue;
        if (messageQueue == nullptr) {
            return 0;
        }

        NativeInputManager *im = new NativeInputManager(contextObj, serviceObj, messageQueue->getLooper());
        im->incStrong(0);
        return reinterpret_cast<jlong>(im);
    }

    static void nativeStart(JNIEnv *env, jclass, jlong ptr) {
        NativeInputManager *im = reinterpret_cast<NativeInputManager *>(ptr);

        im->getInputManager()->start();
    }

    static void nativeRegisterInputChannel(JNIEnv *env, jclass /* clazz */, jlong ptr, jobject inputChannelObj, jint displayId) {
        NativeInputManager *im = reinterpret_cast<NativeInputManager *>(ptr);

        sp<InputChannel> inputChannel;

        status_t status = im->registerInputChannel(env, inputChannel, displayId);
        if (status) {
        }
    }
}

