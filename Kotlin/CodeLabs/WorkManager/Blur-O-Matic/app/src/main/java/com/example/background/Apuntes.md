# WorkManager  

___Como siempre en primer lugar en cada proyecto de los codelabas es
necesario tener cuidado con las versiones de las cosas___  

> __WorkManager__ es parte de Android Jetpack y un componente de
la arquitectura para trabajos en segundo plano que requieren 
una ejecución tanto oportunista como garantizada.  
> La ejecución oportunista implica que WorkManager realizará el
trabajo en segundo plano tan pronto como sea posible.  
> La ejecución garantizada implica que WorkManager se encargará
de la lógica a los efectos de iniciar tu trabajo en diferentes 
situaciones, incluso si sales de la app.

> Para trabajar con WorkManager lo primeros que debemos hacer es
> agregar las de pendencias.  
~~~
dependencies {
    // WorkManager dependency
    implementation "androidx.work:work-runtime-ktx:$versions.work"
}
~~~  

### Aspectos Básicos de WorkManager  
> Existen algunas clases de WorkManager que debes conocer:  
</br>
+ __Worker__: Aquí es donde colocas el código del trabajo real que deseas
realizar en segundo plano. Extenderás esta clase y anularás 
el método ___doWork()___  
</br>
+ __WorkRequest__: Esta clase representa una solicitud para realizar algunos
trabajos. Como parte de la creación de tu ___WorkRequest___, pasarás el ___Worker___. Cuando hagas la ___WorkRequest___, también podrás
especificar elementos como ___Constraints___ sobre el momento en que
se debe ejecutar el Worker.  
</br>
+ __WorkManager__: Esta clase programa tu ___WorkRequest___ y la ejecuta.
Programa ___WorkRequests___ de manera que se distribuya la carga sobre los recursos del sistema, respetando las restricciones que hayas especificado.