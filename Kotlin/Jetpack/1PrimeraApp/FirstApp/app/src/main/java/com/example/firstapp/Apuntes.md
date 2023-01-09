# Jetpack Compose

### Algunos Aspectos Básicos de Compose
> __SetContent__: Se encarga de definir el diseño mediante funciones
___@composables___  

> __Container__: Un contenedor representa una sección de la IU en la que 
puedes modificar el aspecto como el borde o el color de fondo. Algunos
ejemplos de contenedores son ___Box, Surface, etc___  

> __Modifier__: Se usa un Modifier para aumentar o decorar
un elemento que admite composición. Un modificador que se puede usar
es el ___padding___, que agrega espacio alrededor del elemento
~~~
@Composable
fun Greeting(name: String) {
   Surface(color = Color.Magenta) {
       Text(text = "Hi, my name is $name!", modifier = Modifier.padding(24.dp))
   }
}
~~~  
