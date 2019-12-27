//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package android.hardware.input;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.InputDevice;
import android.view.InputEvent;
import android.view.InputMonitor;
import android.view.PointerIcon;

public interface IInputManager extends IInterface {
    InputDevice getInputDevice(int var1) throws RemoteException;

    int[] getInputDeviceIds() throws RemoteException;

    boolean isInputDeviceEnabled(int var1) throws RemoteException;

    void enableInputDevice(int var1) throws RemoteException;

    void disableInputDevice(int var1) throws RemoteException;

    boolean hasKeys(int var1, int var2, int[] var3, boolean[] var4) throws RemoteException;

    void tryPointerSpeed(int var1) throws RemoteException;

    boolean injectInputEvent(InputEvent var1, int var2) throws RemoteException;

    TouchCalibration getTouchCalibrationForInputDevice(String var1, int var2) throws RemoteException;

    void setTouchCalibrationForInputDevice(String var1, int var2, TouchCalibration var3) throws RemoteException;

    KeyboardLayout[] getKeyboardLayouts() throws RemoteException;

    KeyboardLayout[] getKeyboardLayoutsForInputDevice(InputDeviceIdentifier var1) throws RemoteException;

    KeyboardLayout getKeyboardLayout(String var1) throws RemoteException;

    String getCurrentKeyboardLayoutForInputDevice(InputDeviceIdentifier var1) throws RemoteException;

    void setCurrentKeyboardLayoutForInputDevice(InputDeviceIdentifier var1, String var2) throws RemoteException;

    String[] getEnabledKeyboardLayoutsForInputDevice(InputDeviceIdentifier var1) throws RemoteException;

    void addKeyboardLayoutForInputDevice(InputDeviceIdentifier var1, String var2) throws RemoteException;

    void removeKeyboardLayoutForInputDevice(InputDeviceIdentifier var1, String var2) throws RemoteException;

    void registerInputDevicesChangedListener(IInputDevicesChangedListener var1) throws RemoteException;

    int isInTabletMode() throws RemoteException;

    void registerTabletModeChangedListener(ITabletModeChangedListener var1) throws RemoteException;

    int isMicMuted() throws RemoteException;

    void vibrate(int var1, long[] var2, int var3, IBinder var4) throws RemoteException;

    void cancelVibrate(int var1, IBinder var2) throws RemoteException;

    void setPointerIconType(int var1) throws RemoteException;

    void setCustomPointerIcon(PointerIcon var1) throws RemoteException;

    void requestPointerCapture(IBinder var1, boolean var2) throws RemoteException;

    InputMonitor monitorGestureInput(String var1, int var2) throws RemoteException;

    public abstract static class Stub extends Binder implements IInputManager {
        private static final String DESCRIPTOR = "android.hardware.input.IInputManager";
        static final int TRANSACTION_getInputDevice = 1;
        static final int TRANSACTION_getInputDeviceIds = 2;
        static final int TRANSACTION_isInputDeviceEnabled = 3;
        static final int TRANSACTION_enableInputDevice = 4;
        static final int TRANSACTION_disableInputDevice = 5;
        static final int TRANSACTION_hasKeys = 6;
        static final int TRANSACTION_tryPointerSpeed = 7;
        static final int TRANSACTION_injectInputEvent = 8;
        static final int TRANSACTION_getTouchCalibrationForInputDevice = 9;
        static final int TRANSACTION_setTouchCalibrationForInputDevice = 10;
        static final int TRANSACTION_getKeyboardLayouts = 11;
        static final int TRANSACTION_getKeyboardLayoutsForInputDevice = 12;
        static final int TRANSACTION_getKeyboardLayout = 13;
        static final int TRANSACTION_getCurrentKeyboardLayoutForInputDevice = 14;
        static final int TRANSACTION_setCurrentKeyboardLayoutForInputDevice = 15;
        static final int TRANSACTION_getEnabledKeyboardLayoutsForInputDevice = 16;
        static final int TRANSACTION_addKeyboardLayoutForInputDevice = 17;
        static final int TRANSACTION_removeKeyboardLayoutForInputDevice = 18;
        static final int TRANSACTION_registerInputDevicesChangedListener = 19;
        static final int TRANSACTION_isInTabletMode = 20;
        static final int TRANSACTION_registerTabletModeChangedListener = 21;
        static final int TRANSACTION_isMicMuted = 22;
        static final int TRANSACTION_vibrate = 23;
        static final int TRANSACTION_cancelVibrate = 24;
        static final int TRANSACTION_setPointerIconType = 25;
        static final int TRANSACTION_setCustomPointerIcon = 26;
        static final int TRANSACTION_requestPointerCapture = 27;
        static final int TRANSACTION_monitorGestureInput = 28;

        public Stub() {
            this.attachInterface(this, "android.hardware.input.IInputManager");
        }

        public static IInputManager asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            } else {
                IInterface iin = obj.queryLocalInterface("android.hardware.input.IInputManager");
                return (IInputManager) (iin != null && iin instanceof IInputManager ? (IInputManager) iin : new IInputManager.Stub.Proxy(obj));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch (transactionCode) {
                case 1:
                    return "getInputDevice";
                case 2:
                    return "getInputDeviceIds";
                case 3:
                    return "isInputDeviceEnabled";
                case 4:
                    return "enableInputDevice";
                case 5:
                    return "disableInputDevice";
                case 6:
                    return "hasKeys";
                case 7:
                    return "tryPointerSpeed";
                case 8:
                    return "injectInputEvent";
                case 9:
                    return "getTouchCalibrationForInputDevice";
                case 10:
                    return "setTouchCalibrationForInputDevice";
                case 11:
                    return "getKeyboardLayouts";
                case 12:
                    return "getKeyboardLayoutsForInputDevice";
                case 13:
                    return "getKeyboardLayout";
                case 14:
                    return "getCurrentKeyboardLayoutForInputDevice";
                case 15:
                    return "setCurrentKeyboardLayoutForInputDevice";
                case 16:
                    return "getEnabledKeyboardLayoutsForInputDevice";
                case 17:
                    return "addKeyboardLayoutForInputDevice";
                case 18:
                    return "removeKeyboardLayoutForInputDevice";
                case 19:
                    return "registerInputDevicesChangedListener";
                case 20:
                    return "isInTabletMode";
                case 21:
                    return "registerTabletModeChangedListener";
                case 22:
                    return "isMicMuted";
                case 23:
                    return "vibrate";
                case 24:
                    return "cancelVibrate";
                case 25:
                    return "setPointerIconType";
                case 26:
                    return "setCustomPointerIcon";
                case 27:
                    return "requestPointerCapture";
                case 28:
                    return "monitorGestureInput";
                default:
                    return null;
            }
        }

        public String getTransactionName(int transactionCode) {
            return getDefaultTransactionName(transactionCode);
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = "android.hardware.input.IInputManager";
            String _arg0;
            int _arg1;
            boolean _arg1;
            int _arg0;
            String _arg1;
            TouchCalibration _arg2;
            InputDeviceIdentifier _arg0;
            switch (code) {
                case 1:
                    data.enforceInterface(descriptor);
                    _arg0 = data.readInt();
                    InputDevice _result = this.getInputDevice(_arg0);
                    reply.writeNoException();
                    if (_result != null) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }

                    return true;
                case 2:
                    data.enforceInterface(descriptor);
                    int[] _result = this.getInputDeviceIds();
                    reply.writeNoException();
                    reply.writeIntArray(_result);
                    return true;
                case 3:
                    data.enforceInterface(descriptor);
                    _arg0 = data.readInt();
                    _arg1 = this.isInputDeviceEnabled(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_arg1 ? 1 : 0);
                    return true;
                case 4:
                    data.enforceInterface(descriptor);
                    _arg0 = data.readInt();
                    this.enableInputDevice(_arg0);
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface(descriptor);
                    _arg0 = data.readInt();
                    this.disableInputDevice(_arg0);
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface(descriptor);
                    _arg0 = data.readInt();
                    _arg1 = data.readInt();
                    int[] _arg2 = data.createIntArray();
                    int _arg3_length = data.readInt();
                    boolean[] _arg3;
                    if (_arg3_length < 0) {
                        _arg3 = null;
                    } else {
                        _arg3 = new boolean[_arg3_length];
                    }

                    boolean _result = this.hasKeys(_arg0, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    reply.writeInt(_result ? 1 : 0);
                    reply.writeBooleanArray(_arg3);
                    return true;
                case 7:
                    data.enforceInterface(descriptor);
                    _arg0 = data.readInt();
                    this.tryPointerSpeed(_arg0);
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface(descriptor);
                    InputEvent _arg0;
                    if (0 != data.readInt()) {
                        _arg0 = (InputEvent) InputEvent.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }

                    _arg1 = data.readInt();
                    boolean _result = this.injectInputEvent(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeInt(_result ? 1 : 0);
                    return true;
                case 9:
                    data.enforceInterface(descriptor);
                    _arg0 = data.readString();
                    _arg1 = data.readInt();
                    _arg2 = this.getTouchCalibrationForInputDevice(_arg0, _arg1);
                    reply.writeNoException();
                    if (_arg2 != null) {
                        reply.writeInt(1);
                        _arg2.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }

                    return true;
                case 10:
                    data.enforceInterface(descriptor);
                    _arg0 = data.readString();
                    _arg1 = data.readInt();
                    if (0 != data.readInt()) {
                        _arg2 = (TouchCalibration) TouchCalibration.CREATOR.createFromParcel(data);
                    } else {
                        _arg2 = null;
                    }

                    this.setTouchCalibrationForInputDevice(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                case 11:
                    data.enforceInterface(descriptor);
                    KeyboardLayout[] _result = this.getKeyboardLayouts();
                    reply.writeNoException();
                    reply.writeTypedArray(_result, 1);
                    return true;
                case 12:
                    data.enforceInterface(descriptor);
                    if (0 != data.readInt()) {
                        _arg0 = (InputDeviceIdentifier) InputDeviceIdentifier.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }

                    KeyboardLayout[] _result = this.getKeyboardLayoutsForInputDevice(_arg0);
                    reply.writeNoException();
                    reply.writeTypedArray(_result, 1);
                    return true;
                case 13:
                    data.enforceInterface(descriptor);
                    _arg0 = data.readString();
                    KeyboardLayout _result = this.getKeyboardLayout(_arg0);
                    reply.writeNoException();
                    if (_result != null) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }

                    return true;
                case 14:
                    data.enforceInterface(descriptor);
                    if (0 != data.readInt()) {
                        _arg0 = (InputDeviceIdentifier) InputDeviceIdentifier.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }

                    _arg1 = this.getCurrentKeyboardLayoutForInputDevice(_arg0);
                    reply.writeNoException();
                    reply.writeString(_arg1);
                    return true;
                case 15:
                    data.enforceInterface(descriptor);
                    if (0 != data.readInt()) {
                        _arg0 = (InputDeviceIdentifier) InputDeviceIdentifier.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }

                    _arg1 = data.readString();
                    this.setCurrentKeyboardLayoutForInputDevice(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                case 16:
                    data.enforceInterface(descriptor);
                    if (0 != data.readInt()) {
                        _arg0 = (InputDeviceIdentifier) InputDeviceIdentifier.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }

                    String[] _result = this.getEnabledKeyboardLayoutsForInputDevice(_arg0);
                    reply.writeNoException();
                    reply.writeStringArray(_result);
                    return true;
                case 17:
                    data.enforceInterface(descriptor);
                    if (0 != data.readInt()) {
                        _arg0 = (InputDeviceIdentifier) InputDeviceIdentifier.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }

                    _arg1 = data.readString();
                    this.addKeyboardLayoutForInputDevice(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                case 18:
                    data.enforceInterface(descriptor);
                    if (0 != data.readInt()) {
                        _arg0 = (InputDeviceIdentifier) InputDeviceIdentifier.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }

                    _arg1 = data.readString();
                    this.removeKeyboardLayoutForInputDevice(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                case 19:
                    data.enforceInterface(descriptor);
                    IInputDevicesChangedListener _arg0 = android.hardware.input.IInputDevicesChangedListener.Stub.asInterface(data.readStrongBinder());
                    this.registerInputDevicesChangedListener(_arg0);
                    reply.writeNoException();
                    return true;
                case 20:
                    data.enforceInterface(descriptor);
                    _arg0 = this.isInTabletMode();
                    reply.writeNoException();
                    reply.writeInt(_arg0);
                    return true;
                case 21:
                    data.enforceInterface(descriptor);
                    ITabletModeChangedListener _arg0 = android.hardware.input.ITabletModeChangedListener.Stub.asInterface(data.readStrongBinder());
                    this.registerTabletModeChangedListener(_arg0);
                    reply.writeNoException();
                    return true;
                case 22:
                    data.enforceInterface(descriptor);
                    _arg0 = this.isMicMuted();
                    reply.writeNoException();
                    reply.writeInt(_arg0);
                    return true;
                case 23:
                    data.enforceInterface(descriptor);
                    _arg0 = data.readInt();
                    long[] _arg1 = data.createLongArray();
                    int _arg2 = data.readInt();
                    IBinder _arg3 = data.readStrongBinder();
                    this.vibrate(_arg0, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    return true;
                case 24:
                    data.enforceInterface(descriptor);
                    _arg0 = data.readInt();
                    IBinder _arg1 = data.readStrongBinder();
                    this.cancelVibrate(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                case 25:
                    data.enforceInterface(descriptor);
                    _arg0 = data.readInt();
                    this.setPointerIconType(_arg0);
                    reply.writeNoException();
                    return true;
                case 26:
                    data.enforceInterface(descriptor);
                    PointerIcon _arg0;
                    if (0 != data.readInt()) {
                        _arg0 = (PointerIcon) PointerIcon.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }

                    this.setCustomPointerIcon(_arg0);
                    reply.writeNoException();
                    return true;
                case 27:
                    data.enforceInterface(descriptor);
                    IBinder _arg0 = data.readStrongBinder();
                    _arg1 = 0 != data.readInt();
                    this.requestPointerCapture(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                case 28:
                    data.enforceInterface(descriptor);
                    _arg0 = data.readString();
                    _arg1 = data.readInt();
                    InputMonitor _result = this.monitorGestureInput(_arg0, _arg1);
                    reply.writeNoException();
                    if (_result != null) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }

                    return true;
                case 1598968902:
                    reply.writeString(descriptor);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        public static boolean setDefaultImpl(IInputManager impl) {
            if (IInputManager.Stub.Proxy.sDefaultImpl == null && impl != null) {
                IInputManager.Stub.Proxy.sDefaultImpl = impl;
                return true;
            } else {
                return false;
            }
        }

        public static IInputManager getDefaultImpl() {
            return IInputManager.Stub.Proxy.sDefaultImpl;
        }

        private static class Proxy implements IInputManager {
            private IBinder mRemote;
            public static IInputManager sDefaultImpl;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.hardware.input.IInputManager";
            }

            public InputDevice getInputDevice(int deviceId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                InputDevice var5;
                try {
                    _data.writeInterfaceToken("android.hardware.input.IInputManager");
                    _data.writeInt(deviceId);
                    boolean _status = this.mRemote.transact(1, _data, _reply, 0);
                    if (_status || IInputManager.Stub.getDefaultImpl() == null) {
                        _reply.readException();
                        InputDevice _result;
                        if (0 != _reply.readInt()) {
                            _result = (InputDevice) InputDevice.CREATOR.createFromParcel(_reply);
                        } else {
                            _result = null;
                        }

                        return _result;
                    }

                    var5 = IInputManager.Stub.getDefaultImpl().getInputDevice(deviceId);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return var5;
            }

            public int[] getInputDeviceIds() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                int[] _result;
                try {
                    _data.writeInterfaceToken("android.hardware.input.IInputManager");
                    boolean _status = this.mRemote.transact(2, _data, _reply, 0);
                    if (!_status && IInputManager.Stub.getDefaultImpl() != null) {
                        int[] var4 = IInputManager.Stub.getDefaultImpl().getInputDeviceIds();
                        return var4;
                    }

                    _reply.readException();
                    _result = _reply.createIntArray();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public boolean isInputDeviceEnabled(int deviceId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                boolean _result;
                try {
                    _data.writeInterfaceToken("android.hardware.input.IInputManager");
                    _data.writeInt(deviceId);
                    boolean _status = this.mRemote.transact(3, _data, _reply, 0);
                    if (!_status && IInputManager.Stub.getDefaultImpl() != null) {
                        boolean var5 = IInputManager.Stub.getDefaultImpl().isInputDeviceEnabled(deviceId);
                        return var5;
                    }

                    _reply.readException();
                    _result = 0 != _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public void enableInputDevice(int deviceId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("android.hardware.input.IInputManager");
                    _data.writeInt(deviceId);
                    boolean _status = this.mRemote.transact(4, _data, _reply, 0);
                    if (_status || IInputManager.Stub.getDefaultImpl() == null) {
                        _reply.readException();
                        return;
                    }

                    IInputManager.Stub.getDefaultImpl().enableInputDevice(deviceId);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void disableInputDevice(int deviceId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("android.hardware.input.IInputManager");
                    _data.writeInt(deviceId);
                    boolean _status = this.mRemote.transact(5, _data, _reply, 0);
                    if (!_status && IInputManager.Stub.getDefaultImpl() != null) {
                        IInputManager.Stub.getDefaultImpl().disableInputDevice(deviceId);
                        return;
                    }

                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public boolean hasKeys(int deviceId, int sourceMask, int[] keyCodes, boolean[] keyExists) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                boolean var8;
                try {
                    _data.writeInterfaceToken("android.hardware.input.IInputManager");
                    _data.writeInt(deviceId);
                    _data.writeInt(sourceMask);
                    _data.writeIntArray(keyCodes);
                    if (keyExists == null) {
                        _data.writeInt(-1);
                    } else {
                        _data.writeInt(keyExists.length);
                    }

                    boolean _status = this.mRemote.transact(6, _data, _reply, 0);
                    if (_status || IInputManager.Stub.getDefaultImpl() == null) {
                        _reply.readException();
                        boolean _result = 0 != _reply.readInt();
                        _reply.readBooleanArray(keyExists);
                        return _result;
                    }

                    var8 = IInputManager.Stub.getDefaultImpl().hasKeys(deviceId, sourceMask, keyCodes, keyExists);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return var8;
            }

            public void tryPointerSpeed(int speed) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("android.hardware.input.IInputManager");
                    _data.writeInt(speed);
                    boolean _status = this.mRemote.transact(7, _data, _reply, 0);
                    if (!_status && IInputManager.Stub.getDefaultImpl() != null) {
                        IInputManager.Stub.getDefaultImpl().tryPointerSpeed(speed);
                        return;
                    }

                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public boolean injectInputEvent(InputEvent ev, int mode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                boolean _result;
                try {
                    _data.writeInterfaceToken("android.hardware.input.IInputManager");
                    if (ev != null) {
                        _data.writeInt(1);
                        ev.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }

                    _data.writeInt(mode);
                    boolean _status = this.mRemote.transact(8, _data, _reply, 0);
                    if (!_status && IInputManager.Stub.getDefaultImpl() != null) {
                        boolean var6 = IInputManager.Stub.getDefaultImpl().injectInputEvent(ev, mode);
                        return var6;
                    }

                    _reply.readException();
                    _result = 0 != _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public TouchCalibration getTouchCalibrationForInputDevice(String inputDeviceDescriptor, int rotation) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                TouchCalibration var6;
                try {
                    _data.writeInterfaceToken("android.hardware.input.IInputManager");
                    _data.writeString(inputDeviceDescriptor);
                    _data.writeInt(rotation);
                    boolean _status = this.mRemote.transact(9, _data, _reply, 0);
                    if (_status || IInputManager.Stub.getDefaultImpl() == null) {
                        _reply.readException();
                        TouchCalibration _result;
                        if (0 != _reply.readInt()) {
                            _result = (TouchCalibration) TouchCalibration.CREATOR.createFromParcel(_reply);
                        } else {
                            _result = null;
                        }

                        return _result;
                    }

                    var6 = IInputManager.Stub.getDefaultImpl().getTouchCalibrationForInputDevice(inputDeviceDescriptor, rotation);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return var6;
            }

            public void setTouchCalibrationForInputDevice(String inputDeviceDescriptor, int rotation, TouchCalibration calibration) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("android.hardware.input.IInputManager");
                    _data.writeString(inputDeviceDescriptor);
                    _data.writeInt(rotation);
                    if (calibration != null) {
                        _data.writeInt(1);
                        calibration.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }

                    boolean _status = this.mRemote.transact(10, _data, _reply, 0);
                    if (!_status && IInputManager.Stub.getDefaultImpl() != null) {
                        IInputManager.Stub.getDefaultImpl().setTouchCalibrationForInputDevice(inputDeviceDescriptor, rotation, calibration);
                        return;
                    }

                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public KeyboardLayout[] getKeyboardLayouts() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                KeyboardLayout[] var4;
                try {
                    _data.writeInterfaceToken("android.hardware.input.IInputManager");
                    boolean _status = this.mRemote.transact(11, _data, _reply, 0);
                    if (_status || IInputManager.Stub.getDefaultImpl() == null) {
                        _reply.readException();
                        KeyboardLayout[] _result = (KeyboardLayout[]) _reply.createTypedArray(KeyboardLayout.CREATOR);
                        return _result;
                    }

                    var4 = IInputManager.Stub.getDefaultImpl().getKeyboardLayouts();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return var4;
            }

            public KeyboardLayout[] getKeyboardLayoutsForInputDevice(InputDeviceIdentifier identifier) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                KeyboardLayout[] var5;
                try {
                    _data.writeInterfaceToken("android.hardware.input.IInputManager");
                    if (identifier != null) {
                        _data.writeInt(1);
                        identifier.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }

                    boolean _status = this.mRemote.transact(12, _data, _reply, 0);
                    if (_status || IInputManager.Stub.getDefaultImpl() == null) {
                        _reply.readException();
                        KeyboardLayout[] _result = (KeyboardLayout[]) _reply.createTypedArray(KeyboardLayout.CREATOR);
                        return _result;
                    }

                    var5 = IInputManager.Stub.getDefaultImpl().getKeyboardLayoutsForInputDevice(identifier);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return var5;
            }

            public KeyboardLayout getKeyboardLayout(String keyboardLayoutDescriptor) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                KeyboardLayout _result;
                try {
                    _data.writeInterfaceToken("android.hardware.input.IInputManager");
                    _data.writeString(keyboardLayoutDescriptor);
                    boolean _status = this.mRemote.transact(13, _data, _reply, 0);
                    if (!_status && IInputManager.Stub.getDefaultImpl() != null) {
                        KeyboardLayout var5 = IInputManager.Stub.getDefaultImpl().getKeyboardLayout(keyboardLayoutDescriptor);
                        return var5;
                    }

                    _reply.readException();
                    if (0 != _reply.readInt()) {
                        _result = (KeyboardLayout) KeyboardLayout.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public String getCurrentKeyboardLayoutForInputDevice(InputDeviceIdentifier identifier) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                String var5;
                try {
                    _data.writeInterfaceToken("android.hardware.input.IInputManager");
                    if (identifier != null) {
                        _data.writeInt(1);
                        identifier.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }

                    boolean _status = this.mRemote.transact(14, _data, _reply, 0);
                    if (_status || IInputManager.Stub.getDefaultImpl() == null) {
                        _reply.readException();
                        String _result = _reply.readString();
                        return _result;
                    }

                    var5 = IInputManager.Stub.getDefaultImpl().getCurrentKeyboardLayoutForInputDevice(identifier);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return var5;
            }

            public void setCurrentKeyboardLayoutForInputDevice(InputDeviceIdentifier identifier, String keyboardLayoutDescriptor) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("android.hardware.input.IInputManager");
                    if (identifier != null) {
                        _data.writeInt(1);
                        identifier.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }

                    _data.writeString(keyboardLayoutDescriptor);
                    boolean _status = this.mRemote.transact(15, _data, _reply, 0);
                    if (!_status && IInputManager.Stub.getDefaultImpl() != null) {
                        IInputManager.Stub.getDefaultImpl().setCurrentKeyboardLayoutForInputDevice(identifier, keyboardLayoutDescriptor);
                        return;
                    }

                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public String[] getEnabledKeyboardLayoutsForInputDevice(InputDeviceIdentifier identifier) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                String[] _result;
                try {
                    _data.writeInterfaceToken("android.hardware.input.IInputManager");
                    if (identifier != null) {
                        _data.writeInt(1);
                        identifier.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }

                    boolean _status = this.mRemote.transact(16, _data, _reply, 0);
                    if (!_status && IInputManager.Stub.getDefaultImpl() != null) {
                        String[] var5 = IInputManager.Stub.getDefaultImpl().getEnabledKeyboardLayoutsForInputDevice(identifier);
                        return var5;
                    }

                    _reply.readException();
                    _result = _reply.createStringArray();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public void addKeyboardLayoutForInputDevice(InputDeviceIdentifier identifier, String keyboardLayoutDescriptor) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("android.hardware.input.IInputManager");
                    if (identifier != null) {
                        _data.writeInt(1);
                        identifier.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }

                    _data.writeString(keyboardLayoutDescriptor);
                    boolean _status = this.mRemote.transact(17, _data, _reply, 0);
                    if (!_status && IInputManager.Stub.getDefaultImpl() != null) {
                        IInputManager.Stub.getDefaultImpl().addKeyboardLayoutForInputDevice(identifier, keyboardLayoutDescriptor);
                        return;
                    }

                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void removeKeyboardLayoutForInputDevice(InputDeviceIdentifier identifier, String keyboardLayoutDescriptor) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("android.hardware.input.IInputManager");
                    if (identifier != null) {
                        _data.writeInt(1);
                        identifier.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }

                    _data.writeString(keyboardLayoutDescriptor);
                    boolean _status = this.mRemote.transact(18, _data, _reply, 0);
                    if (_status || IInputManager.Stub.getDefaultImpl() == null) {
                        _reply.readException();
                        return;
                    }

                    IInputManager.Stub.getDefaultImpl().removeKeyboardLayoutForInputDevice(identifier, keyboardLayoutDescriptor);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void registerInputDevicesChangedListener(IInputDevicesChangedListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("android.hardware.input.IInputManager");
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = this.mRemote.transact(19, _data, _reply, 0);
                    if (!_status && IInputManager.Stub.getDefaultImpl() != null) {
                        IInputManager.Stub.getDefaultImpl().registerInputDevicesChangedListener(listener);
                        return;
                    }

                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public int isInTabletMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                int var4;
                try {
                    _data.writeInterfaceToken("android.hardware.input.IInputManager");
                    boolean _status = this.mRemote.transact(20, _data, _reply, 0);
                    if (_status || IInputManager.Stub.getDefaultImpl() == null) {
                        _reply.readException();
                        int _result = _reply.readInt();
                        return _result;
                    }

                    var4 = IInputManager.Stub.getDefaultImpl().isInTabletMode();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return var4;
            }

            public void registerTabletModeChangedListener(ITabletModeChangedListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("android.hardware.input.IInputManager");
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = this.mRemote.transact(21, _data, _reply, 0);
                    if (!_status && IInputManager.Stub.getDefaultImpl() != null) {
                        IInputManager.Stub.getDefaultImpl().registerTabletModeChangedListener(listener);
                        return;
                    }

                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public int isMicMuted() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                int var4;
                try {
                    _data.writeInterfaceToken("android.hardware.input.IInputManager");
                    boolean _status = this.mRemote.transact(22, _data, _reply, 0);
                    if (_status || IInputManager.Stub.getDefaultImpl() == null) {
                        _reply.readException();
                        int _result = _reply.readInt();
                        return _result;
                    }

                    var4 = IInputManager.Stub.getDefaultImpl().isMicMuted();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return var4;
            }

            public void vibrate(int deviceId, long[] pattern, int repeat, IBinder token) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("android.hardware.input.IInputManager");
                    _data.writeInt(deviceId);
                    _data.writeLongArray(pattern);
                    _data.writeInt(repeat);
                    _data.writeStrongBinder(token);
                    boolean _status = this.mRemote.transact(23, _data, _reply, 0);
                    if (!_status && IInputManager.Stub.getDefaultImpl() != null) {
                        IInputManager.Stub.getDefaultImpl().vibrate(deviceId, pattern, repeat, token);
                        return;
                    }

                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void cancelVibrate(int deviceId, IBinder token) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("android.hardware.input.IInputManager");
                    _data.writeInt(deviceId);
                    _data.writeStrongBinder(token);
                    boolean _status = this.mRemote.transact(24, _data, _reply, 0);
                    if (!_status && IInputManager.Stub.getDefaultImpl() != null) {
                        IInputManager.Stub.getDefaultImpl().cancelVibrate(deviceId, token);
                        return;
                    }

                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void setPointerIconType(int typeId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("android.hardware.input.IInputManager");
                    _data.writeInt(typeId);
                    boolean _status = this.mRemote.transact(25, _data, _reply, 0);
                    if (_status || IInputManager.Stub.getDefaultImpl() == null) {
                        _reply.readException();
                        return;
                    }

                    IInputManager.Stub.getDefaultImpl().setPointerIconType(typeId);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void setCustomPointerIcon(PointerIcon icon) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("android.hardware.input.IInputManager");
                    if (icon != null) {
                        _data.writeInt(1);
                        icon.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }

                    boolean _status = this.mRemote.transact(26, _data, _reply, 0);
                    if (_status || IInputManager.Stub.getDefaultImpl() == null) {
                        _reply.readException();
                        return;
                    }

                    IInputManager.Stub.getDefaultImpl().setCustomPointerIcon(icon);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void requestPointerCapture(IBinder windowToken, boolean enabled) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("android.hardware.input.IInputManager");
                    _data.writeStrongBinder(windowToken);
                    _data.writeInt(enabled ? 1 : 0);
                    boolean _status = this.mRemote.transact(27, _data, _reply, 0);
                    if (_status || IInputManager.Stub.getDefaultImpl() == null) {
                        _reply.readException();
                        return;
                    }

                    IInputManager.Stub.getDefaultImpl().requestPointerCapture(windowToken, enabled);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public InputMonitor monitorGestureInput(String name, int displayId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                InputMonitor _result;
                try {
                    _data.writeInterfaceToken("android.hardware.input.IInputManager");
                    _data.writeString(name);
                    _data.writeInt(displayId);
                    boolean _status = this.mRemote.transact(28, _data, _reply, 0);
                    if (!_status && IInputManager.Stub.getDefaultImpl() != null) {
                        InputMonitor var6 = IInputManager.Stub.getDefaultImpl().monitorGestureInput(name, displayId);
                        return var6;
                    }

                    _reply.readException();
                    if (0 != _reply.readInt()) {
                        _result = (InputMonitor) InputMonitor.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }
        }
    }

    public static class Default implements IInputManager {
        public Default() {
        }

        public InputDevice getInputDevice(int deviceId) throws RemoteException {
            return null;
        }

        public int[] getInputDeviceIds() throws RemoteException {
            return null;
        }

        public boolean isInputDeviceEnabled(int deviceId) throws RemoteException {
            return false;
        }

        public void enableInputDevice(int deviceId) throws RemoteException {
        }

        public void disableInputDevice(int deviceId) throws RemoteException {
        }

        public boolean hasKeys(int deviceId, int sourceMask, int[] keyCodes, boolean[] keyExists) throws RemoteException {
            return false;
        }

        public void tryPointerSpeed(int speed) throws RemoteException {
        }

        public boolean injectInputEvent(InputEvent ev, int mode) throws RemoteException {
            return false;
        }

        public TouchCalibration getTouchCalibrationForInputDevice(String inputDeviceDescriptor, int rotation) throws RemoteException {
            return null;
        }

        public void setTouchCalibrationForInputDevice(String inputDeviceDescriptor, int rotation, TouchCalibration calibration) throws RemoteException {
        }

        public KeyboardLayout[] getKeyboardLayouts() throws RemoteException {
            return null;
        }

        public KeyboardLayout[] getKeyboardLayoutsForInputDevice(InputDeviceIdentifier identifier) throws RemoteException {
            return null;
        }

        public KeyboardLayout getKeyboardLayout(String keyboardLayoutDescriptor) throws RemoteException {
            return null;
        }

        public String getCurrentKeyboardLayoutForInputDevice(InputDeviceIdentifier identifier) throws RemoteException {
            return null;
        }

        public void setCurrentKeyboardLayoutForInputDevice(InputDeviceIdentifier identifier, String keyboardLayoutDescriptor) throws RemoteException {
        }

        public String[] getEnabledKeyboardLayoutsForInputDevice(InputDeviceIdentifier identifier) throws RemoteException {
            return null;
        }

        public void addKeyboardLayoutForInputDevice(InputDeviceIdentifier identifier, String keyboardLayoutDescriptor) throws RemoteException {
        }

        public void removeKeyboardLayoutForInputDevice(InputDeviceIdentifier identifier, String keyboardLayoutDescriptor) throws RemoteException {
        }

        public void registerInputDevicesChangedListener(IInputDevicesChangedListener listener) throws RemoteException {
        }

        public int isInTabletMode() throws RemoteException {
            return 0;
        }

        public void registerTabletModeChangedListener(ITabletModeChangedListener listener) throws RemoteException {
        }

        public int isMicMuted() throws RemoteException {
            return 0;
        }

        public void vibrate(int deviceId, long[] pattern, int repeat, IBinder token) throws RemoteException {
        }

        public void cancelVibrate(int deviceId, IBinder token) throws RemoteException {
        }

        public void setPointerIconType(int typeId) throws RemoteException {
        }

        public void setCustomPointerIcon(PointerIcon icon) throws RemoteException {
        }

        public void requestPointerCapture(IBinder windowToken, boolean enabled) throws RemoteException {
        }

        public InputMonitor monitorGestureInput(String name, int displayId) throws RemoteException {
            return null;
        }

        public IBinder asBinder() {
            return null;
        }
    }
}
