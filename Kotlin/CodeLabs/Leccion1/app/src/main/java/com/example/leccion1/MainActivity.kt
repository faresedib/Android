package com.example.leccion1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val roll_button: Button = findViewById(R.id.roll_button)
        roll_button.setOnClickListener { rollDice() }

        val count_button: Button = findViewById(R.id.countUp_button)
        count_button.setOnClickListener { countUp() }
    }

    private fun rollDice() {
        val randomInt = (1..6).random()
        //Toast.makeText(this,"Boton Pulsado",Toast.LENGTH_SHORT).show()
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = randomInt.toString()
    }

    private fun countUp() {
        val resultText: TextView = findViewById(R.id.result_text)

        if (resultText.text == "Hello World!") {
            resultText.text = "1"
        } else {
            var count_up = resultText.text.toString().toInt()
            if (count_up < 6) count_up++
            resultText.text = count_up.toString()
        }

    }
}