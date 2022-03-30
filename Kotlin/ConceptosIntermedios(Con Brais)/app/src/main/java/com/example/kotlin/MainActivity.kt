package com.example.kotlin

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // enumClases()//Clases enum
        // clasesInternasAnidadas()
        // classInheritance()
        interfaces()
    }

    private fun interfaces() {
        val toper = Persona("Toper",21)
        toper.play()
        toper.stream()
    }

    // ------------------------------- Herencia de clases -------------------
    private fun classInheritance() {
        println("-------------------- ------------------------------")
        val programmer = Developer("Fares",22,"Kotlin")
        programmer.work()
        programmer.sayLanguage()

        val leti = Persona("Leti",16)
        leti.work()
        leti.goToWork()
    }


    //-------------------------------- Clases internas y anidadas -------------------------
    private fun clasesInternasAnidadas() {

        //Clases Anidadas
        val myNestedClass = myNestedAndInnerClass.myNestedClass()
        val suma = myNestedClass.suma(4, 2)
        println("-------------- -----------------------")
        println("El resultado de la suma es $suma")

        //Clases Internas
        val myInnerClass = myNestedAndInnerClass().myInnerClass()
        val sumar = myInnerClass.sumaUno(11)
        println("El resultado de sumar mas uno es $sumar")
    }


    //------------------------------ Clases Enum -------------------------
    private fun enumClases() {
        var userDirection: Direction? = null

        //Asigación de valores
        userDirection = Direction.NORTH

        println("-------------------Propiedades del enum -----------------------------------")
        //el método name hace referencia al valor en String de la constante
        println("Propiedad name =  ${userDirection.name}")

        //ordinal hace referencia a la posición que ocupa en la clase enum
        println("Propiedad ordinal = ${userDirection.ordinal}")

        println("---------------- Funciones ---------------------")
        println("Description: ${userDirection.description()}  valor: ${userDirection.dir}")
    }

    enum class Direction(val dir: Int) {
        NORTH(1), SOUTH(-1), WEST(-1), EAST(1);

        fun description(): String {
            return when (this) {
                NORTH -> "La dirección es Norte"
                SOUTH -> "La dirección es Sur"
                else -> "No sabemos la dirección"//Si no especificamos el else nos lo exigirá
            }
        }
    }
    //-------------------------------------------------------------------


    fun showMessage(view: View) {
        Snackbar.make(view, "Añadido con Éxito", Snackbar.LENGTH_SHORT).show()
    }
}