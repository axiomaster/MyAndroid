cmake_minimum_required(VERSION 3.8)

include_directories(../../../native/include)

add_library(inputflinger reader/include/EventHub.h dispatcher/InputDispatcher.h InputManager.cpp InputManager.h reader/include/InputReader.h include/InputListener.h InputClassifier.h dispatcher/InputDispatcherFactory.cpp dispatcher/include/InputDispatcherFactory.h reader/include/InputReaderFactory.h reader/include/InputReaderThread.h reader/InputReaderThread.cpp reader/InputReaderFactory.cpp reader/InputReader.cpp ../../libs/input/Input.cpp reader/mapper/InputMapper.h)