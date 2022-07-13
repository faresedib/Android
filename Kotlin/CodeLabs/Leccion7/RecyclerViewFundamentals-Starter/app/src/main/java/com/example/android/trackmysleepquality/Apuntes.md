
#RECYCLERVIEW
> Para trabajar con un RecyclerView se necesita lo siguiente:
>
+ Los datos a mostrar
+ Una instancia de RecyclerView en el archivo de diseño

+ Un diseño que representará cada uno de los elementos individuales del RecyclerView si to-dos
los elementos de la lista son iguales.Este diseño debe crearse separado del fragmento

+ Un layout manager que maneja la organización de los componentes, LinearLayout,etc.

+ Un viewHolder(titular de vista) que herede de viewHolder contiene la información de la vista que
se va a mostrar. También agregan información que RecyclerView utiliza para mover las vistas de forma
eficiente.

+ Un Adapter que conecta los datos al RecyclerView y adapta los datos para que se puedan mostrar en un
archivo ViewHolder. El RecyclerView usa el adapter para saber cómo mostrar los datos en pantalla

###DIFFUTIL

####Introducción de problema
>   En esta app para indicar a RecyclerView que un elemento de la lista ha cambiado y debe actualizarse,
    el código actual llama notifyDataSetChanged() al SleepNightAdapter. Sin embargo, notifyDataSetChanged()
    dice a RecyclerView que la lista completa es potencialmente inválida. Como resultado,
    RecyclerView vuelve a vincular y redibujar todos los elementos de la lista,
    incluidos los elementos que no están visibles en la pantalla. Esto es mucho trabajo innecesario.
    Para listas grandes o complejas, este proceso puede llevar tanto tiempo que la pantalla parpadea
    o tartamudea a medida que el usuario se desplaza por la lista.

####Solución
>   Para solucionar este problema, puede decir a RecyclerView exactamente qué ha cambiado.
    RecyclerView puede actualizar solo las vistas que cambiaron en la pantalla.
    
>   RecyclerView tiene una clase llamada DiffUtil que es para calcular las diferencias entre dos listas.
    DiffUtil toma una lista vieja y una lista nueva y averigua qué es diferente. Encuentra elementos
    que se agregaron, eliminaron o cambiaron. Luego, utiliza un algoritmo llamado algoritmo
    de diferencia de Eugene W. Myers para calcular la cantidad mínima de cambios que se deben realizar
    en la lista anterior para producir la nueva lista.

>   Una vez que DiffUtil descubra qué ha cambiado, RecyclerView puede usar esa información
    para actualizar solo los elementos que se cambiaron, agregaron, eliminaron o movieron,
    lo cual es mucho más eficiente que rehacer la lista completa.