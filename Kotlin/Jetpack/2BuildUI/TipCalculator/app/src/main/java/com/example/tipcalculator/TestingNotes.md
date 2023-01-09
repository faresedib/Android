# Pruebas Automáticas

__En el contexto de un software, las pruebas son un método estructurado para verificar el software 
a fin de garantizar que funcione correctamente__. Las pruebas automatizadas son códigos reales que
comprueban que otro fragmento del código que escribiste funcione correctamente.

Probar el software es beneficioso porque te permite eliminar errores antes de publicar el código.
Las pruebas también proporcionan una manera de verificar continuamente el código existente
a medida que se introducen cambios. Es esencial para tener una experiencia del usuario positiva.

A medida que te familiarices con el desarrollo y las pruebas de apps para Android,
deberías escribir una prueba de manera periódica junto al código de tu app.
Si creas una prueba cada vez que creas una función nueva en tu app, se reducirá la carga
de trabajo más adelante cuando la app crezca. También es una forma conveniente de asegurarte
de que tu app funciona de manera correcta sin invertir demasiado tiempo en probarla manualmente.

Las pruebas automatizadas son una parte esencial del desarrollo de software, y el desarrollo
de Android no es la excepción. Por lo tanto, este es el momento indicado para hablar del tema.

## Por qué son importantes la pruebas automatizadas

Al principio, puede parecer que no necesitas hacer pruebas en tu app. Sin embargo, las apps de
todos los tamaños y complejidades necesitan pruebas.

Para ampliar tu base de código, debes probar la funcionalidad preexistente a medida que agregas
nuevas partes, lo cual solo es posible si tienes pruebas preexistentes. A medida que tu app crece,
las pruebas manuales requieren mucho más esfuerzo que las pruebas automatizadas. Además, una vez
que comienzas a trabajar en apps en producción, las pruebas se vuelven esenciales cuando tienes 
una base de usuarios de mayor tamaño. Por ejemplo, debes tener en cuenta muchos tipos diferentes 
de dispositivos que ejecutan varias versiones de Android.

Más info en este enlace:

[Pruebas automatizadas](https://developer.android.com/codelabs/basic-android-kotlin-compose-write-automated-tests?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-2-pathway-3%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-write-automated-tests#2)

## Tipos de pruebas automatizadas

### Pruebas locales

__Las pruebas locales son un tipo de prueba automatizada que prueban directamente un fragmento
pequeño de código para garantizar que funcione correctamente__. Con las pruebas locales, 
puedes probar funciones, clases y propiedades. Las pruebas locales se ejecutan en una máquina
virtual Java, lo que significa que se ejecutan en un entorno de desarrollo sin necesidad de un
dispositivo o emulador. Es una forma sofisticada de decir que las pruebas locales se ejecutan
en tu computadora. Además, tienen una sobrecarga muy baja en términos de recursos informáticos, 
por lo que pueden ejecutarse rápido incluso con recursos limitados. Android Studio está listo para
ejecutar pruebas de unidades de forma automática. 

Más info en este enlace:

[Pruebas locales](https://developer.android.com/codelabs/basic-android-kotlin-compose-write-automated-tests?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-2-pathway-3%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-write-automated-tests#3)


### Pruebas de instrumentación

__En el contexto del desarrollo de Android, una prueba de instrumentación es una prueba de IU. 
Las pruebas de instrumentación te permiten probar partes de una app que dependen de Android, 
así como las API y los servicios de su plataforma.__

A diferencia de las pruebas locales, las pruebas de IU inician una app o parte de ella, simulan
las interacciones del usuario y comprueban si la app reaccionó adecuadamente. A lo largo de este
curso, las pruebas de IU se ejecutan en un dispositivo físico o emulador.

más información en este enlace:

[Pruebas de Instrumentación](https://developer.android.com/codelabs/basic-android-kotlin-compose-write-automated-tests?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-2-pathway-3%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-write-automated-tests#4)





