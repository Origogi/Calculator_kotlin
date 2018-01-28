package jeongtae.com.calc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import android.content.ComponentName
import android.content.Context
import android.content.ServiceConnection
import android.os.IBinder
import android.content.Intent
import jeongtae.com.myservice.iCalc


class MainActivity : AppCompatActivity() {

    val listener = ButtonClickListenerImpl()
    lateinit var conn : ServiceConnection
    var icalc : iCalc? = null
    var isConnect = false
    var intentAction = "jeongtae.com.myservice.MyService"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buttonZero.setOnClickListener(listener)
        buttonOne.setOnClickListener(listener)
        buttonTwo.setOnClickListener(listener)
        buttonThree.setOnClickListener(listener)
        buttonFour.setOnClickListener(listener)
        buttonFive.setOnClickListener(listener)
        buttonSix.setOnClickListener(listener)
        buttonSeven.setOnClickListener(listener)
        buttonEight.setOnClickListener(listener)
        buttonNine.setOnClickListener(listener)
        buttonDiv.setOnClickListener(listener)
        buttonPlus.setOnClickListener(listener)
        buttonMul.setOnClickListener(listener)
        buttonMinus.setOnClickListener(listener)
        buttonEqual.setOnClickListener(listener)
        buttonDEL.setOnClickListener(listener)
        buttonBasket.isEnabled = false
        buttonPercent.isEnabled = false
        buttonAC.isEnabled = false
        buttonComma.isEnabled = false


        conn = object : ServiceConnection {
            override fun onServiceDisconnected(name: ComponentName?) {
                Log.d("[TEST]" , "Disconnect : ${name.toString()}")
                icalc = null
            }

            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                Log.d("[TEST]" , "Connect : ${name.toString()}")

                icalc = iCalc.Stub.asInterface(service)
                isConnect = true;
            }

        }

        val intent = Intent(intentAction)
        intent.setPackage("jeongtae.com.myservice")
        bindService(intent, conn, Context.BIND_AUTO_CREATE)
    }

    inner class ButtonClickListenerImpl : View.OnClickListener {
        override fun onClick(v: View?) {

            val button : Button= v as Button

            Log.d("[TEST]", "Button ${button!!.text}" )

            val input : String = button!!.text as String
            if (button == buttonEqual) {
                if (!isConnect) {
                    Log.e("[TEST]", "Service disconnected!!" )
                    return
                }

                val result = icalc?.execute(textViewInput.text.toString())
                textViewInput.text = ""
                Log.d("[TEST]", "Result : ${result}")
                textViewResult.text = result
            }
            else if (button == buttonDEL) {
                if (textViewInput.text.length ==0) {
                    return
                }
                textViewInput.text = textViewInput.text.substring(0, textViewInput.text.length -1)
            }
            else {
                textViewInput.text = "${textViewInput.text}${button!!.text}"
            }

        }

    }

}
