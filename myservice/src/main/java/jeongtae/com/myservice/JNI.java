package jeongtae.com.myservice;

/**
 * Created by Administrator on 2018-01-28.
 */

public class JNI {

    static {
        System.loadLibrary("jni");

    }

    static native int plus(int arg1, int arg2);
    static native int minus(int arg1, int arg2);
    static native int multiple(int arg1, int arg2);
    static native int divide(int arg1, int arg2);

}
