package android.view;

import android.os.Looper;
import android.os.MessageQueue;

import java.lang.ref.WeakReference;

public abstract class InputEventReceiver {
    private long mReceiverPtr;

    private InputChannel mInputChannel;
    private MessageQueue mMessageQueue;

    private static native long nativeInit(WeakReference<InputEventReceiver> receiver, InputChannel inputChannel, MessageQueue messageQueue);

    public InputEventReceiver(InputChannel inputChannel, Looper looper) {
        this.mInputChannel = inputChannel;

        mReceiverPtr = nativeInit(new WeakReference<>(this), inputChannel, mMessageQueue);
    }
}
