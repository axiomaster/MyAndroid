/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package android.hardware.input;

public interface IInputManager extends android.os.IInterface {
    /**
     * Default implementation for IInputManager.
     */
    public static class Default implements android.hardware.input.IInputManager {
        @Override
        public android.view.InputDevice getInputDevice(int deviceId) throws android.os.RemoteException {
            return null;
        }

        @Override
        public android.os.IBinder asBinder() {
            return null;
        }
    }

    /**
     * Local-side IPC implementation stub class.
     */
    public static abstract class Stub extends android.os.Binder implements android.hardware.input.IInputManager {
        private static final java.lang.String DESCRIPTOR = "android.hardware.input.IInputManager";

        /**
         * Construct the stub at attach it to the interface.
         */
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        /**
         * Cast an IBinder object into an android.hardware.input.IInputManager interface,
         * generating a proxy if needed.
         */
        public static android.hardware.input.IInputManager asInterface(android.os.IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof android.hardware.input.IInputManager))) {
                return ((android.hardware.input.IInputManager) iin);
            }
            return new android.hardware.input.IInputManager.Stub.Proxy(obj);
        }

        @Override
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override
        public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException {
            java.lang.String descriptor = DESCRIPTOR;
            switch (code) {
                case INTERFACE_TRANSACTION: {
                    reply.writeString(descriptor);
                    return true;
                }
                case TRANSACTION_getInputDevice: {
                    data.enforceInterface(descriptor);
                    int _arg0;
                    _arg0 = data.readInt();
                    android.view.InputDevice _result = this.getInputDevice(_arg0);
                    reply.writeNoException();
                    if ((_result != null)) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }

        private static class Proxy implements android.hardware.input.IInputManager {
            private android.os.IBinder mRemote;

            Proxy(android.os.IBinder remote) {
                mRemote = remote;
            }

            @Override
            public android.os.IBinder asBinder() {
                return mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            @Override
            public android.view.InputDevice getInputDevice(int deviceId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                android.view.InputDevice _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(deviceId);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getInputDevice, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        return getDefaultImpl().getInputDevice(deviceId);
                    }
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        _result = android.view.InputDevice.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            public static android.hardware.input.IInputManager sDefaultImpl;
        }

        static final int TRANSACTION_getInputDevice = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);

        public static boolean setDefaultImpl(android.hardware.input.IInputManager impl) {
            if (Stub.Proxy.sDefaultImpl == null && impl != null) {
                Stub.Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static android.hardware.input.IInputManager getDefaultImpl() {
            return Stub.Proxy.sDefaultImpl;
        }
    }

    public android.view.InputDevice getInputDevice(int deviceId) throws android.os.RemoteException;
}
