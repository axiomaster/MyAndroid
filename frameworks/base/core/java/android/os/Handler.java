package android.os;

import android.telecom.Call;

public class Handler {
    public interface Callback {
        boolean handleMessage(Message msg);
    }

    public void handleCallback(Message msg) {
    }

    public Handler() {
        this(null, false);
    }

    public Handler(Callback callback) {
        this(callback, false);
    }

    public Handler(Looper looper) {
        this(looper, null, false);
    }

    public Handler(Looper looper, Callback callback) {
        this(looper, callback, false);
    }

    final Looper mLooper;
    final MessageQueue mQueue;
    final Callback mCallback;
    IMessenger mMessenger;

    public Handler(Callback callback, boolean async) {
        mLooper = Looper.myLooper();
        mQueue = mLooper.mQueue;
        mCallback = callback;
    }

    public Handler(Looper looper, Callback callback, boolean async) {
        mLooper = looper;
        mQueue = looper.mQueue;
        mCallback = callback;
    }

    public final boolean sendMessage(Message msg) {
    }

    public final boolean sendMessageAtTime(Message msg, long uptimeMillis) {
        MessageQueue queue = mQueue;
        if (queue == null) {
        }

        return enqueueMessage(queue, msg, uptimeMillis);
    }

    public void dispatchMessage(Message msg) {
        if (msg.callback != null) {
            handleCallback(msg);
        } else {
            if (mCallback != null) {
                if (mCallback.handleMessage(msg)) {
                    return;
                }
            }
            handleCallback(msg);
        }
    }

    public final boolean post(Runnable r) {

    }

    public final boolean postAtTime(Runnable r, long uptimeMillis) {

    }

    public final boolean postDelayed(Runnable r, long delayMillis) {

    }

    private boolean enqueueMessage(MessageQueue queue, Message msg, long uptimeMillis) {
        msg.target = this;

        return queue.enqueueMessage(msg, uptimeMillis);
    }
}
