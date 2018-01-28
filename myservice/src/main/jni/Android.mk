LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE	:= jni 
LOCAL_CFLAGS	+= -std=c++14
LOCAL_SRC_FILES	:= jni.cpp
include $(BUILD_SHARED_LIBRARY)