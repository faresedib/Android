package com.example.kotlin

//Para heredar de otra clased
//En esta línea hacemos una llamada al contructor del padre, como un super() en JAVA

class Developer(nombre: String,edad:Int,val language:String) : Persona(nombre, edad){

    override fun work() {//Override es necesario para sobreescribir
        println("Estoy desarrollando apps")
    }

    fun sayLanguage() {
        println("Estoy desarrollando apps en $language")
    }
}