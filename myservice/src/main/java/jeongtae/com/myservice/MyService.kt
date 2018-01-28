package jeongtae.com.myservice

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.util.Log
import java.lang.System.loadLibrary
import java.util.*

/**
 * Created by Administrator on 2018-01-28.
 */
class MyService : Service(){

    val PLUS = "+"
    val MINUS = "-"
    val MULTIPLE = "X"
    val DIVIDE = "/"



    override fun onBind(intent: Intent?): IBinder {
        val binder = object : iCalc.Stub() {
            override fun execute(input: String?): String {
                Log.d("[TEST_SERVICE]" , "input : ${input}")

                var statement = input

                statement = statement!!.replace(PLUS, " ${PLUS} ")
                statement = statement!!.replace(MINUS, " ${MINUS} ")
                statement = statement!!.replace(MULTIPLE, " ${MULTIPLE} ")
                statement = statement!!.replace(DIVIDE, " ${DIVIDE} ")

                var stn = StringTokenizer(statement, " ")

                Log.d("[TEST_SERVICE]" , "input : ${statement}")

                var arg1 = stn.nextToken().toInt()

                while (stn.hasMoreTokens()) {
                    var op = stn.nextToken()
                    var arg2 = stn.nextToken().toInt()

                    if (op.equals(PLUS)) {
                        arg1 = JNI.plus(arg1,arg2)
                    }
                    else if (op.equals(MINUS)) {
                        arg1 = JNI.minus(arg1,arg2)
                    }
                    else if (op.equals(MULTIPLE)) {
                        arg1 = JNI.multiple(arg1,arg2)
                    }
                    else if (op.equals(DIVIDE)) {
                        arg1 = JNI.divide(arg1,arg2)
                    }
                    else {
                        Log.e("[TEST_SERVICE]", "error")
                        return "N/A"
                    }
                }



                return "${input} = $arg1"
            }
        }


        return binder
    }


//    companion object {
//        init {
//            System.loadLibrary("jni")
//        }
//        external fun plus(arg1 :Int, arg2 :Int) : Int
//        external fun minus(arg1 :Int, arg2 :Int) : Int
//        external fun multiple(arg1 :Int, arg2 :Int) : Int
//        external fun divide(arg1 :Int, arg2 :Int) : Int
//
//
//
//    }

}