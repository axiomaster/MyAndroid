cmake_minimum_required(VERSION 3.8)

include_directories(../../../native/include)
include_directories(../../include)

add_library(inputflinger reader/include/EventHub.h dispatcher/InputDispatcher.h InputManager.cpp InputManager.h reader/include/InputReader.h
        include/InputListener.h InputClassifier.h dispatcher/InputDispatcherFactory.cpp dispatcher/include/InputDispatcherFactory.h
        reader/include/InputReaderFactory.h reader/include/InputReaderThread.h reader/InputReaderThread.cpp reader/InputReaderFactory.cpp
        reader/InputReader.cpp ../../libs/input/Input.cpp reader/mapper/InputMapper.h dispatcher/include/InputDispatcherThread.h
        reader/include/InputDevice.h reader/EventHub.cpp ../../include/android/input.h reader/mapper/KeyboardInputMapper.cpp
        reader/mapper/KeyboardInputMapper.h reader/InputDevice.cpp InputListener.cpp dispatcher/include/InputDispatcherInterface.h
        dispatcher/include/InputDispatcherPolicyInterface.h dispatcher/InputDispatcher.cpp dispatcher/Entry.h dispatcher/Queue.h ../../include/input/InputWindow.h ../../include/input/InputApplication.h ../../include/input/InputTransport.h dispatcher/Connection.h ../../include/android/looper.h ../../libs/input/InputTransport.cpp)