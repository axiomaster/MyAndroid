cmake_minimum_required(VERSION 3.8)

set(WORKSPACE ../../../../..)
set(AOSP ${WORKSPACE}../)

include_directories(../../../../../../aosp/libnativehelper/include)
include_directories(../../../../../../aosp/libnativehelper/include_jni)

include_directories(../../../../native/services)


add_library(core com_android_server_input_InputManagerService.cpp ../../../core/jni/android_os_MessageQueue.h)