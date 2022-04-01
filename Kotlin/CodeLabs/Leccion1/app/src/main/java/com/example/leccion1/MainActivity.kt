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
    lateinit var diceImage2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImage = findViewById(R.id.dice_image)//Obtenemos la imagen
        diceImage2 = findViewById(R.id.dice_image2)

        val roll_button: Button = findViewById(R.id.roll_button)
        roll_button.setOnClickListener { rollDice() }

    }

    private fun rollDice() {
        diceImage.setImageResource(getRandomDiceImage())//Establecemos la imagen
        diceImage2.setImageResource(getRandomDiceImage())
    }

    private fun getRandomDiceImage(): Int {
        val randomInt = (1..6).random()
        return when (randomInt) {//Según el valor aleatorio mostramos una imagen u otra
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}