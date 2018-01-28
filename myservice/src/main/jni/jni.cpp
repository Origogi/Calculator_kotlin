//
// Created by Administrator on 2018-01-28.
//

#include <jeongtae_com_myservice_JNI.h>

/*
 * Class:     jeongtae_com_myservice_JNI
 * Method:    plus
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_jeongtae_com_myservice_JNI_plus (JNIEnv * env, jclass cls, jint arg1, jint arg2){

    return arg1+arg2;
}

/*
 * Class:     jeongtae_com_myservice_JNI
 * Method:    minus
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_jeongtae_com_myservice_JNI_minus(JNIEnv * env, jclass cls, jint arg1, jint arg2){

    return arg1-arg2;
}

/*
 * Class:     jeongtae_com_myservice_JNI
 * Method:    multiple
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_jeongtae_com_myservice_JNI_multiple (JNIEnv * env, jclass cls, jint arg1, jint arg2){

    return arg1* arg2;
}

/*
 * Class:     jeongtae_com_myservice_JNI
 * Method:    divide
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_jeongtae_com_myservice_JNI_divide  (JNIEnv * env, jclass cls, jint arg1, jint arg2){

  return arg1/arg2;
}