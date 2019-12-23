package android.view;

import android.os.Parcel;
import android.os.Parcelable;

public final class InputDevice implements Parcelable {

    public static final Parcelable.Creator<InputDevice> CREATOR = new Parcelable.Creator<InputDevice>() {
        @Override
        public InputDevice createFromParcel(Parcel in) {
            return new InputDevice(in);
        }

        @Override
        public InputDevice[] newArray(int size) {
            return new InputDevice[0];
        }
    };

    private InputDevice(Parcel in) {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
