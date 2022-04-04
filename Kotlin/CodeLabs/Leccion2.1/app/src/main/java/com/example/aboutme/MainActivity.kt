package com.example.aboutme

import android.annotation.SuppressLint
import android.content.Context
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Añadimos los oyentes a las vistas
        findViewById<Button>(R.id.done_button).setOnClickListener { addNickname(it) }
        findViewById<TextView>(R.id.nickname_text).setOnClickListener { updateNickname(it) }

    }

    private fun clickHandlerFunction(viewThatIsClicked: View) {

    }

    private fun addNickname(view: View) {
        val edit_text: EditText = findViewById(R.id.nickname_edit)
        val text: TextView = findViewById(R.id.nickname_text)

        text.text = edit_text.text.toString()//Establecemos el texto en el TextView
        edit_text.visibility = View.GONE //Ocultamos el editText
        view.visibility = View.GONE //Ocultamos el editText
        text.visibility = View.VISIBLE //Ocultamos el editText

        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }


    private fun updateNickname(view: View) {
        val edit_text = findViewById<EditText>(R.id.nickname_edit)
        val done_button = findViewById<Button>(R.id.done_button)

        edit_text.visibility = View.VISIBLE
        done_button.visibility = View.VISIBLE
        view.visibility = View.GONE

        edit_text.requestFocus()//Establecemos el foco en el editText

        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(edit_text, 0)
    }
}