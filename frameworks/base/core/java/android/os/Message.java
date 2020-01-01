package android.os;


public final class Message implements Parcelable {
    public int what;
    public int arg1;
    public int arg2;
    public Object obj;

    static final int FLAG_IN_USE = 1 << 0;

    int flags;

    public long when;
    Handler target;
    Runnable callback;
    Message next;

    public static final Creator<Message> CREATOR = new Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel in) {
        }

        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(what);
        dest.writeInt(arg1);
        dest.writeInt(arg2);
        dest.writeInt(flags);
        dest.writeParcelable(next, flags);
    }

    boolean isInUse() {
    }

    void markInUse() {
        flags |= FLAG_IN_USE;
    }
}
