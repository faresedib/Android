package com.example.leccion1

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    //lateinit nos permite inicializar una variable no nula posteriormente sin hacer comprobaciones
    // de si es nulo o no, siempre son var,deben declararse siempre en el cuerpo de la clase,
    // deben tener getters ni setters personalizados y no pueden declarase con tipos primitivos

    lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImage = findViewById(R.id.dice_image)//Obtenemos la imagen

        val roll_button: Button = findViewById(R.id.roll_button)
        roll_button.setOnClickListener { rollDice() }

        /* val count_button: Button = findViewById(R.id.countUp_button)
         count_button.setOnClickListener { countUp() }*/
    }

    private fun rollDice() {
        val randomInt = (1..6).random()

        /*El uso de findViewById cada vez que se pulsa un botón puede resultar muy pesado en
        * dispositivos con pocos recursos por este método hace una llamada y siempre tiene que
        * buscar los recursos en la carpeta indicada por crearemos la View antes del onCreate
        * para que esto suceda una sóla vez

        * val diceImage: ImageView = findViewById(R.id.dice_image)*/

        val drawableResource =
            when (randomInt) {//Según el valor aleatorio mostramos una imagen u otra
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
        diceImage.setImageResource(drawableResource)//Establecemos la imagen
    }

    /*private fun countUp() {
        val resultText: TextView = findViewById(R.id.result_text)

        if (resultText.text == "Hello World!") {
            resultText.text = "1"
        } else {
            var count_up = resultText.text.toString().toInt()
            if (count_up < 6) count_up++
            resultText.text = count_up.toString()
        }

    }*/
}