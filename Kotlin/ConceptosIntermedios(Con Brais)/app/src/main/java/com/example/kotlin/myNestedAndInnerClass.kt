package com.example.kotlin

class myNestedAndInnerClass {

    val uno = 1

    //Las clases anidades son clases dentro de otras clases
    class myNestedClass {
        //En esta clase sólo se pueden acceder a varibles y constantes definidas en su interior
        fun suma (num1: Int, num2: Int):Int{
            return num1 + num2
        }
    }

    //Clases Internas: van precedidas de la palabra reservada inner
    inner class myInnerClass {
        fun sumaUno(num: Int): Int {
            return num + uno
        }
    }

}