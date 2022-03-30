package com.example.kotlin

//Con open indicamos que se puede heredar de esta clase
open class Persona(nombre: String, edad: Int) : Work(), Game {

    //Las clases y funciones por defecto son final por lo que tendremos que desabilitar esto

    open fun work() {//En este caso la palabra open indica que lo podemos sobreescribir la función
        println("Estoy trabajando")
    }

    override fun goToWork() {
        println("Estoy yendo al trabajo")
    }

    override val juego: String
        get() = "Fortnite"

    override fun play() {
        println("Esta persona esta jugando al $juego")
    }
}