#ifndef _RUNTIME_EVENT_HUB_H
#define _RUNTIME_EVENT_HUB_H

#include <input/Input.h>
#include <linux/input.h>
#include <input/InputDevice.h>

namespace android {
    struct RawEvent {
        nsecs_t when;
        int32_t deviceId;
        int32_t type;
        int32_t code;
        int32_t value;
    };

    class EventHubInterface : public virtual RefBase {
    protected:
        EventHubInterface() {}

        virtual ~EventHubInterface() {}

    public:
        enum {
            DEVICE_ADDED = 0x10000000,
            FIRST_SYNTHETIC_EVENT = DEVICE_ADDED,
        };

        virtual uint32_t getDeviceClasses(int32_t deviceId) const = 0;
        virtual InputDeviceIdentifier getDeviceIdentifier(int32_t deviceId) const = 0;
        virtual int32_t getDeviceControllerNumber(int32_t deviceId) const = 0;

        virtual size_t getEvents(int timeoutMillis, RawEvent *buffer, size_t bufferSize) = 0;
    };

    class EventHub : public EventHubInterface {
    public:
        EventHub();

        virtual size_t getEvents(int timeoutMillis, RawEvent *buffer, size_t bufferSize);

    protected:
        ~EventHub();

    private:
        struct Device {
            Device *next;
            int fd;
        };
    };

}; // namespace android

#endif