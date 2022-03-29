package com.example.aprendekotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //variablesYConstantes()
        //tiposDatos()
        //sentenciaIf()
        //sentenciaWhen()
        //myArrays()
        //myMaps()
        //myLoops()
        //nullSafety()

        clases()
    }

    fun clases() {
        val fares = MyDeveloper("Fares",32, arrayOf(MyDeveloper.Language.JAVA,
            MyDeveloper.Language.KOTLIN))
        println("-----------------------------------")
        fares.code()

        val yelena = MyDeveloper("Yelena",28,
            arrayOf(MyDeveloper.Language.C,MyDeveloper.Language.JAVASCRIPT), arrayOf(fares))
        yelena.code()
        println("${yelena.friends?.first()?.nombre} es amigo de ${yelena.nombre}")
    }


    //Aquí vamos ha hablar de ejecución segura contra nulos
    private fun nullSafety() {

        /*Con el signo de interrogación indicamos que puede tener valor nulo y evitamos problemas
        * de ejecución, como un nullpointerexception*/
        var nullSafe: String? = "Fares nullSafety"
        nullSafe = null
        println(nullSafe)

        /*if (nullSafe != null) {
            println(nullSafe!!)//La doble exclamación obliga a que la variable sea null
        } else {
            println(nullSafe)
        }*/

        // Con esto le decimos que si es null el programa continue con normalidad y no imprima
        println(nullSafe?.length)

        nullSafe.let {//Este let se ejecuta cuando nullSafe no es null
            println(it)
        } ?: run{//Esto se ejecuta cuando es null
            println(nullSafe)
        }
    }


    //Este método trabajaremos con los bucles for y while
    private fun myLoops() {

        //Bucles
        val myArray = listOf<String>("Fares", "Endong", "20", "Developer")
        val myMap = mutableMapOf(1 to "Fares Endong", 2 to "fares endong")

        //Recorremos el array
        println("---------------------- MI ARRAY ---------------------------")
        for (myString in myArray) {
            println(myString)
        }

        /*Aquí se introduce un concepto nuevo, interpolar que consiste en acceder a una variable o
        * constante dentro de un string a través de llaves {} y el símbolo $ */
        println("--------------------- MI MAP -------------------------")
        for (myStr in myMap) {
            println("${myStr.key} = ${myStr.value}")
            //println(myStr)  Esto imprime igualmente el array
        }

        //Otra forma de implementar un bucle es la siguiente

        /* for (x in 0..10) {//Esto imprime once veces
            println(x)
        }*/

        /*for(x in 0 until 10){//Esto no tiene en cuenta el último número
            println(x)
        }*/

        for (x in 0 until 10 step 2) {//Con step variamos el incremento
            println(x)//Esto imprime de dos en dos
        }

        for (y in 10 downTo 0 step 2) {//Con downTo hacemos que el recorrido sea hacia atrás
            println(y)//Esto imprime de dos en dos
        }

        //También se puede crear arrays de un rango determinado
        val arrayM = (0..20)

        //--------------- WHILE ---------------------------

        var z = 0
        while (z < 10) {
            println(z)
            z++
        }


    }


    //En este método veremos otros tipos de colecciones
    private fun myMaps() {
        println("----------------------------MAPS-------------------------------")

        /* mapOf devuelve un map vacío. Es importante tener en cuentea que este mapa ahora mismo
        * es inmutable. Para ello más adelante crearemos un mapa mutable*/

        var myMap: Map<Int, String> = mapOf()
        println(myMap)

        //Inicializamos un map con elementos
        myMap = mutableMapOf(1 to "Fares Endong", 2 to "fares endong")
        println(myMap)

        myMap[3] = "Ana"
        myMap.put(4, "Sara")//Esto también sirve para modificar datos del map
        println(myMap)

        //Acceso a datos
        println(myMap[1]) //Imprime Fares Endong

        //Eliminar datos
        myMap.remove(3)
        println(myMap)

    }


    //Aquí veremos el uso básico de un array
    private fun myArrays() {

        val nombre = "Fares"
        val apellido = "Endong"
        val age = "20"

        //Añadir datos de uno en uno
        var myArray = arrayListOf<String>()
        myArray.add(nombre)
        myArray.add(apellido)
        myArray.add(age)

        //Añadir varios a la vez
        myArray.addAll(listOf("Hola", "Caracola"))

        //Accedemos a los datos
        println(myArray[0])
        println(myArray[1])
        println(myArray[2])

        println("-------------------------- ARRAYS ------------------------")
        println(myArray)

        //Eliminamos datos
        myArray.removeAt(4)
        myArray.removeAt(3)

        //Imprimimos el array con un foreach
        myArray.forEach {
            println(it) //it hace referencia a cada uno de los elementos encontrados
        }

    }

    //Aquí vamos a hablar de variables constantes
    private fun variablesYConstantes() {

        //  --------------------- Varibales ---------------------------------
        var myVar = "Hola mi primer programa en kotlin"
        println(myVar)

        /*No se puede asignar un int a una variable string
        myVar = 1 */

        var myVar2 = 1
        println(myVar2)

        var myVar3 = myVar2
        println(myVar3 + 4)

        // --------------------------- Contantes ------------------------------------
        //Una constantes no puede actualizar su valor

        val myConst = "Mi primera constante"
        println(myConst)

        val myConst2 = myConst
        println(myConst2)
    }


    //Aquí declararemos los tipos de datos en kotlin
    private fun tiposDatos() {

        //Strings
        println("------------------- TIPOS DE DATOS ------------------------------\n")
        println("-------------------STRINGS-------------------------------\n")
        var myString: String = " Mi primer String Caracola"
        var myString2 = "Mi segundo string"
        var myString3 = myString + " " + myString2
        println(myString3)

        //ENTEROS (Byte, Short, Int, Long)
        println("-------------------ENTEROS-------------------------------\n")
        val myInt = 1
        var myInt2 = 2
        val myInt3 = myInt + myInt2
        println("Mi entero" + myInt3)

        //Decimales(Float,Double) por defecto kotlin interpreta los decimales como double
        println("---------------------DECIMALES---------------------------------\n")
        var myDouble = 1.99
        var myFloat: Float = 2.9f
        val myDecimal = (myDouble + myFloat).toBigDecimal().setScale(2, RoundingMode.HALF_UP)
        println("Resultado decimales = " + myDecimal)

        //Booleanos(Bool)
        println("---------------------Booleano--------------------------\n")
        var myBool = true
        var myBool2 = false
        println(myBool == myBool2)
        println(myBool && myBool2)//Imprimirá falso porque uno de los dos es falso

    }

    //Aquí mostramos el uso del condicional if
    private fun sentenciaIf() {

        val myNumer = 99

        if (myNumer < 10 || myNumer == 10) {
            //El símbolo $ se utiliza para concaternar varibales en un string
            println("$myNumer es menor o igual que 10 \n")
        } else if (myNumer > 50 && myNumer < 100) {
            println("$myNumer es mucho mayor que 10 pero menor que 100")
        } else println("$myNumer es un numero muy grande\n\n")
    }


    //Aquí hablaremos de la sentencia when, es como un equivalesnte al switch de java
    private fun sentenciaWhen() {
        val country = "Camerún"

        //When con Sting
        when (country) {
            "Guinea Ecuatorial", "España", "México" -> println("Tu idioma es el español")
            "Camerún", "Francia", "Gabón" -> println("Tu idioma es el francés")
            else -> println("No conocemos tu idioma")
        }
        println("-------------------------------\n")

        val usuario = 34

        when (usuario) {
            //La palabra reservada "in" es para especificar un rango
            in 0..3 -> println("El usuario es un bebé")
            in 4..12 -> println("El usuario es un niño")
            in 12..17 -> println("El usuario es un adolescente")
            else -> println("😨😭")
        }
    }
}