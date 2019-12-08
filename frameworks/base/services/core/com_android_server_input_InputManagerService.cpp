#include "nativehelper/JNIHelp.h"
#include "nativehelper/jni.h"

class NativeInputManager {
protected:
	virtual ~NativeInputManager();

public:
	NativeInputManager(jobject contextObj, jobject serviceObj, const sp<Looper>& looper);

private:
	sp<InputManager> mInputManager;
};