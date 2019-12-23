// IInputManager.aidl
package android.hardware.input;

// Declare any non-default types here with import statements

interface IInputManager {
    InputDevice getInputDevice(int deviceId);
}
