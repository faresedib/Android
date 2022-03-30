package com.example.kotlin

interface Game {//Una interfaz no puede contener constructor

    val juego: String
    fun play() //No hace falta indicar abstract porque por defecto todos los métodos lo son

    fun stream(){
        println("Estoy haciendo haciendo stream de mi juego")
    }
}