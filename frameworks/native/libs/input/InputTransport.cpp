//
// Created by lism on 2019/12/29.
//

#include <input/InputTransport.h>
#include <bits/socket.h>
#include <sys/socket.h>

namespace android {
    InputChannel::InputChannel(const std::string &name, int fd) : mName(name) {
        setFd(fd);
    }

    void InputChannel::setFd(int fd) {
        mFd = fd;
        if (mFd > 0) {
            int result = fcntl(mFd, F_SETFL, O_NONBLOCK);
        }
    }

    status_t InputChannel::openInputChannelPair(const std::string &name, sp<InputChannel> &outServerChannel, sp<InputChannel> &outClientChannel) {
        int sockets[2];

        if (socketpair(AF_UNIX, SOCK_SEQPACKET, 0, sockets)) {
        }

        return OK;
    }
}
