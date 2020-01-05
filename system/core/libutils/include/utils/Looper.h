//
// Created by lism on 2020/1/5.
//

#ifndef ANDROID_LOOPER_H
#define ANDROID_LOOPER_H

#include <sys/epoll.h>

namespace android {
    struct Message {
        Message() : what(0) {}

        Message(int w) : what(w) {}

        int what;
    };

    class Looper : public RefBase {
    protected:
        virtual ~Looper();

    public:
        enum {
            POLL_WAKE = -1,
        };

        Looper(bool allowNonCallbacks);

        int pollOnce(int timeoutMillis, int *outFd, int *outEvents, void **outData);

        inline int pollOnce(int timeoutMillis) {

        }

        void wake();

    private:
        struct Request {
            int fd;
            int ident;
            int events;
            int seq;

            void *data;
        };

        struct Response {
            int events;
            Request request;
        };
        // immutable
        const bool mAllowNonCallbacks;

        android::base::unique_fd mEpollFd;
        android::base::unique_fd mWakeEventFd;

        int pollInner(int timeoutMillis);

        void awoken();
    };
}

#endif //ANDROID_LOOPER_H
