package com.example.colomyviews

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setListeners()

    }

    //Cambiamos el color de las BoxTextView
     fun makeColored(view: View) {
        when ((1..8).random()) {

            // Boxes using Color class colors for the background
            1 -> view.setBackgroundColor(Color.DKGRAY)
            2 -> view.setBackgroundColor(Color.GRAY)
            3 -> view.setBackgroundResource(R.drawable.image_one)
            4 -> view.setBackgroundColor(Color.MAGENTA)
            5 -> view.setBackgroundColor(Color.BLUE)

            6 -> view.setBackgroundResource(R.color.my_red)
            7 -> view.setBackgroundResource(R.color.my_yellow)
            8 -> view.setBackgroundResource(R.color.my_green)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    /*private fun setListeners() {//Establecemos los oyentes de cada vista

        //Obtenemos cada una de las vistas incluido el layout padre
        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
        val boxFourText = findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text)
        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)
        val redButton = findViewById<Button>(R.id.red_button)
        val greenButton = findViewById<Button>(R.id.green_button)
        val yellowButton = findViewById<Button>(R.id.yellow_button)

        //Creamos una lista con cada una de las vistas para
        val clickableViews: List<View> =
            listOf(
                boxOneText, boxTwoText, boxThreeText,
                boxFourText, boxFiveText, rootConstraintLayout
            )

        //Establecemos el oyente a cada vista a partir de makeColored()
        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }*/
}