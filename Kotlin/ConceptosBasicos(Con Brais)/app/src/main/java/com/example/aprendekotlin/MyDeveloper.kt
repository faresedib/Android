package com.example.aprendekotlin

//Las propiedades de una clase se declaran entre paréntesis
/* ahora mismo estas propiedades no se pueden utilizar fuera de la clase, para que se puedan
* utilizar es necesario declararlas como constantes o variables */
class MyDeveloper(var nombre: String,
                  var edad: Int,
                  var languages:Array<Language>,
                  var friends: Array<MyDeveloper>? = null) {//Por defecto null

    enum class Language{//Con esto nos aseguramos de que los programadores no metan otros lenguajes
        KOTLIN,
        SWIFT,
        JAVA,
        JAVASCRIPT,
        C
    }

    fun code() {
        for (language in languages) {
            println("Estoy programando en $language")
        }
    }

    //Función simple
    fun decirHola() {
        println("Hola caracola")
    }

    //Funciones con parámetros de entrada
    fun sayMyNombreAndEdad(nombre: String, edad: Int) {
        println("Hola mi nombre es $nombre y mi edad es $edad")
    }

    //Funciones con valores de retorno
    fun sumTwoNumbers(firstNumber: Int, secondNumber: Int) : Int {
        val sum = firstNumber + secondNumber
        return sum
    }
}