cmake_minimum_required(VERSION 3.8)


include_directories(../../../../../aosp/libcore/include)

include_directories(../../../../native/services)


add_library(core com_android_server_input_InputManagerService.cpp)