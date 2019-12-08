cmake_minimum_required(VERSION 3.8)

include_directories(../../../native/include)

add_library(inputflinger EventHub.h InputDispatcher.h InputManager.cpp InputManager.h InputReader.h InputListener.h)