# CMakeList.txt: droid 的 CMake 项目，在此处包括源代码并定义
# 项目特定的逻辑。
#
cmake_minimum_required(VERSION 3.8)

project("droid")

if (NOT WORKSPACE)
    set(WORKSPACE ./)
endif ()

if (NOT AOSP)
    set(AOSP ${WORKSPACE}../aosp)
endif ()

include_directories(${AOSP}/system/core/include)
include_directories(${AOSP}/libnativehelper/include)
include_directories(native/include)

add_subdirectory(frameworks/base/services)
add_subdirectory(frameworks/native)
add_subdirectory(system/core/libutils)

# 将源代码添加到此项目的可执行文件。
#add_executable(droid "droid.cpp" "droid.h")
