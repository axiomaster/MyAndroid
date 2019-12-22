#ifndef _RUNTIME_EVENT_HUB_H
#define _RUNTIME_EVENT_HUB_H

#include <input/Input.h>

namespace android
{
struct RawEvent
{
    nsecs_t when;
    int32_t deviceId;
    int32_t type;
    int32_t code;
    int32_t value;
};

class EventHubInterface : public virtual RefBase
{
protected:
    EventHubInterface() {}
    virtual ~EventHubInterface() {}

public:
};

class EventHub : public EventHubInterface
{
public:
    EventHub();

protected:
    ~EventHub();

private:
    struct Device
    {
        Device *next;
        int fd;
    };
};

}; // namespace android

#endif