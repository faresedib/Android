# Nuveos conceptos aprendidos

### Spacer  
Spacer toma un elemento Modifier como parámetro, es un elemento
compable que agrega un espacio entre otros elementos.  

Los elementos de componibilidad no tienen estado de forma predeterminada,
lo que significa que no tienen un valor y el sistema los puede recuperar
en cualquier momento, lo que hace que se restablezca el valor. 
Sin embargo, __Compose__ proporciona una forma conveniente de evitarlo.
Las funciones de componibilidad pueden __almacenar un objeto en la memoria__
con el elemento ___remember___ que admite composición y requiere que se le
pase una función.

`var result by remember {mutableStateOf(1)}`