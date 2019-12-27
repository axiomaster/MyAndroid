package com.android.server.input;

import android.hardware.input.IInputDevicesChangedListener;
import android.hardware.input.IInputManager;
import android.hardware.input.ITabletModeChangedListener;
import android.hardware.input.InputDeviceIdentifier;
import android.hardware.input.KeyboardLayout;
import android.hardware.input.TouchCalibration;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.Display;
import android.view.InputChannel;
import android.view.InputDevice;
import android.view.InputEvent;
import android.view.InputMonitor;
import android.view.PointerIcon;

public class InputManagerService extends IInputManager.Stub {

    private final long mPtr;

    private static native void nativeRegisterInputChannel(long ptr, InputChannel inputChannel, int displayId);

    @Override
    public InputDevice getInputDevice(int var1) throws RemoteException {
        return null;
    }

    @Override
    public int[] getInputDeviceIds() throws RemoteException {
        return new int[0];
    }

    @Override
    public boolean isInputDeviceEnabled(int var1) throws RemoteException {
        return false;
    }

    @Override
    public void enableInputDevice(int var1) throws RemoteException {

    }

    @Override
    public void disableInputDevice(int var1) throws RemoteException {

    }

    @Override
    public boolean hasKeys(int var1, int var2, int[] var3, boolean[] var4) throws RemoteException {
        return false;
    }

    @Override
    public void tryPointerSpeed(int var1) throws RemoteException {

    }

    @Override
    public boolean injectInputEvent(InputEvent var1, int var2) throws RemoteException {
        return false;
    }

    @Override
    public TouchCalibration getTouchCalibrationForInputDevice(String var1, int var2) throws RemoteException {
        return null;
    }

    @Override
    public void setTouchCalibrationForInputDevice(String var1, int var2, TouchCalibration var3) throws RemoteException {

    }

    @Override
    public KeyboardLayout[] getKeyboardLayouts() throws RemoteException {
        return new KeyboardLayout[0];
    }

    @Override
    public KeyboardLayout[] getKeyboardLayoutsForInputDevice(InputDeviceIdentifier var1) throws RemoteException {
        return new KeyboardLayout[0];
    }

    @Override
    public KeyboardLayout getKeyboardLayout(String var1) throws RemoteException {
        return null;
    }

    @Override
    public String getCurrentKeyboardLayoutForInputDevice(InputDeviceIdentifier var1) throws RemoteException {
        return null;
    }

    @Override
    public void setCurrentKeyboardLayoutForInputDevice(InputDeviceIdentifier var1, String var2) throws RemoteException {

    }

    @Override
    public String[] getEnabledKeyboardLayoutsForInputDevice(InputDeviceIdentifier var1) throws RemoteException {
        return new String[0];
    }

    @Override
    public void addKeyboardLayoutForInputDevice(InputDeviceIdentifier var1, String var2) throws RemoteException {

    }

    @Override
    public void removeKeyboardLayoutForInputDevice(InputDeviceIdentifier var1, String var2) throws RemoteException {

    }

    @Override
    public void registerInputDevicesChangedListener(IInputDevicesChangedListener var1) throws RemoteException {

    }

    @Override
    public int isInTabletMode() throws RemoteException {
        return 0;
    }

    @Override
    public void registerTabletModeChangedListener(ITabletModeChangedListener var1) throws RemoteException {

    }

    @Override
    public int isMicMuted() throws RemoteException {
        return 0;
    }

    @Override
    public void vibrate(int var1, long[] var2, int var3, IBinder var4) throws RemoteException {

    }

    @Override
    public void cancelVibrate(int var1, IBinder var2) throws RemoteException {

    }

    @Override
    public void setPointerIconType(int var1) throws RemoteException {

    }

    @Override
    public void setCustomPointerIcon(PointerIcon var1) throws RemoteException {

    }

    @Override
    public void requestPointerCapture(IBinder var1, boolean var2) throws RemoteException {

    }

    @Override
    public InputMonitor monitorGestureInput(String var1, int var2) throws RemoteException {
        return null;
    }

    public void registerInputChannel(InputChannel inputChannel, IBinder token) {
        inputChannel.setToken(token);
        nativeRegisterInputChannel(mPtr, inputChannel, Display.INVALID_DISPLAY);
    }

    public void unregisterInputChannel(InputChannel inputChannel) {

    }
}
