package com.example.daniwebimplicitintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindUrlButton()
    }

    private fun bindUrlButton(){
        val urlTextInput = findViewById<EditText>(R.id.editText_url) //get TextEdit object
        val button = findViewById<Button>(R.id.button) //get Button object

        //Not including data field because url data must be updated on each button press.
        val urlIntent = Intent().apply {
            action = Intent.ACTION_VIEW
        }

        button.setOnClickListener {
            urlIntent.data = Uri.parse(urlTextInput.text.toString()) //Updates the text data.
            startActivity(urlIntent)
        }
    }
}