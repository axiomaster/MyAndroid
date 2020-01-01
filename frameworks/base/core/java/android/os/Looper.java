package android.os;

public final class Looper {

    static final ThreadLocal<Looper> sThreadLocal = new ThreadLocal<>();

    private static Looper sMainLooper;

    final MessageQueue mQueue;
    final Thread mThread;

    public static void prepare() {
        prepare(true);
    }

    public static void prepare(boolean quitAllowed) {
        if (sThreadLocal.get() != null) {
        }
        sThreadLocal.set(new Looper(quitAllowed));
    }

    public static void prepareMainLooper() {
        prepare(false);
        synchronized (Looper.class) {
            if (sMainLooper != null) {
            }
            sMainLooper = myLooper();
        }
    }

    public static Looper getMainLooper() {
        synchronized (Looper.class) {
            return sMainLooper;
        }
    }

    public static void loop() {
        final Looper me = myLooper();
        final MessageQueue queue = me.mQueue;

        for (; ; ) {
            Message msg = queue.next();
            if (msg == null) {
                return;
            }

            try {
                msg.target.dispatchMessage(msg);
            } catch (Exception e) {
            } finally {
            }
        }
    }

    public static Looper myLooper() {
        return sThreadLocal.get();
    }

    public static MessageQueue myQueue() {
        return myLooper().mQueue;
    }

    private Looper(boolean quitAllowed) {
        mQueue = new MessageQueue(quitAllowed);
        mThread = Thread.currentThread();
    }

    public void quit() {
        mQueue.quit(false);
    }
}
