#include "nativehelper/JNIHelp.h"
#include "nativehelper/jni.h"
#include <utils/Looper.h>
#include <inputflinger/InputManager.h>

namespace android {
    class NativeInputManager {
    protected:
        virtual ~NativeInputManager();

    public:
        NativeInputManager(jobject contextObj, jobject serviceObj, const sp<Looper> &looper);

    private:
        sp<InputManager> mInputManager;
    };
}

