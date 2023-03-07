package com.carolina.understandinghandler

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dispMessage = findViewById<TextView>(R.id.textViewResponse)

        val handler = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(displayMessage: Message) {
                dispMessage.text = displayMessage.obj as String
            }
        }

        val name = findViewById<EditText>(R.id.editTextName)
        val submitButton = findViewById<Button>(R.id.buttonSubmit)


        submitButton.setOnClickListener {
            val msg = handler.obtainMessage()
            msg.obj = "Welcome ${name.text}!"
            handler.sendMessageDelayed(msg, 1000)
        }

    }

}