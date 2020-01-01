package android.os;

public final class MessageQueue {

    private final boolean mQuitAllowed;

    private long mPtr;

    Message mMessages;

    private boolean mBlocked;

    private native static long nativeInit();

    private native void nativePollOnce(long ptr, int timeoutMillis);

    private native static void nativeWake(long ptr);

    MessageQueue(boolean quitAllowed) {
        mQuitAllowed = quitAllowed;
        mPtr = nativeInit();
    }

    void quit(boolean safe) {

    }

    boolean enqueueMessage(Message msg, long when) {
        if (msg.target == null) {
        }
        if (msg.isInUse()) {
        }

        synchronized (this) {
            msg.markInUse();
            msg.when = when;
            Message p = mMessages;
            boolean needWake;
            if (p == null || when == 0 || when < p.when) {
                msg.next = p;
                mMessages = msg;
                needWake = mBlocked;
            } else {
                Message prev;
                for (; ; ) {
                    prev = p;
                    p = p.next;
                    if (p == null || when < p.when) {
                        break;
                    }
                }
                msg.next = p;
                prev.next = msg;

                if (needWake) {
                    nativeWake(mPtr);
                }
            }
        }
        return true;
    }

    Message next() {
        final long ptr = mPtr;

        int nextPollTimeoutMillis = 0;
        for (; ; ) {

            nativePollOnce(ptr, nextPollTimeoutMillis);

            synchronized (this) {
                final long now = SystemClock.uptimeMillis();
                Message prevMsg = null;
                Message msg = mMessages;
                if (msg != null && msg.target == null) {
                }
                if (msg != null) {
                    if (now < msg.when) {
                        nextPollTimeoutMillis = (int) Math.min(msg.when - now, Integer.MAX_VALUE);
                    } else {
                        mBlocked = false;
                        if (prevMsg != null) {
                            prevMsg.next = msg.next;
                        } else {
                            mMessages = msg.next;
                        }
                        msg.next = null;
                        msg.markInUse();
                        return msg;
                    }
                } else {
                    nextPollTimeoutMillis = -1;
                }
            }

            nextPollTimeoutMillis = 0;
        }
    }
}
