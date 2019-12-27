package android.view;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public class InputChannel implements Parcelable {

    public static final Parcelable.Creator<InputChannel> CREATOR = new Parcelable.Creator<InputChannel>() {
        @Override
        public InputChannel createFromParcel(Parcel source) {
            return null;
        }

        @Override
        public InputChannel[] newArray(int size) {
            return new InputChannel[size];
        }
    };


    private long mPtr; // used by native code

    private static native InputChannel[] nativeOpenInputChannelPair(String name);

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public static InputChannel[] openInputChannelPair(String name) {
        return nativeOpenInputChannelPair(name);
    }

    public void dispose() {

    }

    public void transferTo(InputChannel outChannel) {

    }

    public void setToken(IBinder token) {

    }
}
