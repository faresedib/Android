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
        setListeners()

    }

    //Cambiamos el color de las BoxTextView
    private fun makeColored(view: View) {
        when (view.id) {

            // Boxes using Color class colors for the background
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)
            R.id.box_three_text -> view.setBackgroundResource(R.drawable.image_one)
            R.id.box_four_text -> view.setBackgroundColor(Color.MAGENTA)
            R.id.box_five_text -> view.setBackgroundColor(Color.BLUE)

            R.id.red_button -> findViewById<TextView>(
                R.id.box_three_text).setBackgroundResource(R.color.my_red)

            R.id.yellow_button -> findViewById<TextView>(
                R.id.box_four_text).setBackgroundResource(R.color.my_yellow)

            R.id.green_button -> findViewById<TextView>(
                R.id.box_five_text).setBackgroundResource(R.color.my_green)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    private fun setListeners() {//Establecemos los oyentes de cada vista

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
                boxFourText, boxFiveText, rootConstraintLayout,
                redButton,yellowButton,greenButton
            )

        //Establecemos el oyente a cada vista a partir de makeColored()
        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }
}