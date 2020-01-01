//
// Created by lism on 2020/1/1.
//

#include <utils/Looper.h>

namespace android {
    Looper::Looper(bool allowNonCallbacks) : mAllowNonCallbacks(allowNonCallbacks) {

    }

    int Looper::pollOnce(int timeoutMillis, int *outFd, int *outEvents, void **outData) {
        int result = 0;
        for (;;) {
            result = pollInner(timeoutMillis);
        }
    }

    int Looper::pollInner(int timeoutMillis) {
        int result = POLL_WAKE;

        struct epoll_event eventItems[EPOLL_MAX_EVENTS];
        int eventCount = epoll_wait(mEpollFd.get(), eventItems, EPOLL_MAX_EVENTS, timeoutMillis);

        for (int i = 0; i < eventCount; i++) {
            int fd = eventItems[i].data.fd;
            uint32_t epollEvents = eventItems[i].events;

            if (fd = mWakeReadPipeFd) {
                if (epollEvents & EPOLLIN) {
                    awoken();
                }
            }
        }

        return result;
    }

    int Looper::awoken() {

    }
}