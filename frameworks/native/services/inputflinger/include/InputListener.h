//
// Created by shimi on 19/12/8.
//

#ifndef DROID_INPUTLISTENER_H
#define DROID_INPUTLISTENER_H

#include <utils/RefBase.h>

namespace android {
    class InputListenerInterface;

    struct NotifyArgs {
        virtual void notify(const sp <InputListenerInterface> &listener) const = 0;
    };

    struct NotifyKeyArgs : public NotifyArgs {
        inline NotifyKeyArgs(const NotifyKeyArgs &other);

        virtual void notify(const sp <InputListenerInterface> &listener) const;
    };

    class InputListenerInterface : public virtual RefBase {
    protected:
        InputListenerInterface() {}

        virtual ~InputListenerInterface() {}

    public:

        virtual void notifyKey(const NotifyKeyArgs *args) = 0;
    };

    class QueuedInputListener : public InputListenerInterface {
    public :
        explicit QueuedInputListener(const sp <InputListenerInterface> &innerListener);

        virtual void notifyKey(const NotifyKeyArgs *args);

        void flush();

    private:
        sp <InputListenerInterface> mInnerListener;
        std::vector<NotifyArgs *> mArgsQueue;
    };
};

#endif //DROID_INPUTLISTENER_H
