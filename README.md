# Proy-Tec_JEE

Proyecto para realizar una API-REST con un sistema C.R.U.D. que maneje una base de datos creada en MySQL.

El sistema requiere por tanto el uso de 4 verbos:
  - GET: Devuelve una instancia de la clase o un Array de instancias en formato Json.
    - Parámetros:
        - ninguno: Devuelve un array con todas las instancias. Si no existe ninguna, se devuelve un código 404.
        - ind: Valor numérico del índice de la instancia. Si el índice no se encuentra se devuelve un código 404.
        - Alguno de los atributos de la clase: Devuelve aquellas instancias cuyos valores en sus atributos sean iguales a los indicados.             Si no encuentra ninguna coincidencia se devuelve un código 404.
        - from: Devuelve todas las instancias con índice mayor o igual al valor indicado. Si no encuentra ninguna coincidencia se                 devuelve un código 404.
        - to: Devuelve todas las instancias con índice menor o igual al valor indicado. Si no encuentra ninguna coincidencia se devuelve             un código 404.
        - sort: Devuelve todas las instancias ordenadas ascendentemente por el nombre del atributo indicado como valor. Si el nombre del             atributo no es válido se devuelve un código 400.
  - POST: Añade una instancia de la clase.
    - Parámetros:
        - Si falta algún parámetro de tipo cadena se tomará como cadena vacía, si falta el parámetro numérico se tomará como cero.
        - El valor numérico debe ser siempre positivo. Si el valor numérico es negativo se devuelve un código 400.
  - PUT: Edita los atributos de una determinada instancia de la clase.
    - Parámetros:
        - ind: valor numérico del índice de la instancia; lista de pares con los nombres de los atributos de la clase y sus nuevos                 valores, todos son opcionales. Si el índice no se encuentra se devuelve un código 404. Si el atributo de valor numérico es               negativo se devuelve un código 400.
  - DELETE: Borra una instancia de la clase.
    - Parámetros:
        - ind: Valor numérico del índice de la instancia. Si el índice no se encuentra se devuelve un código 404.

También se requiere que el sistema solicite una APIKEY para acceder a la API y gestione los permisos sobre la misma, generando un error 401 si no se indica ninguna APIKEY o si se indica una errónea. Se usará ABC123 para tener permiso solamente sobre el verbo GET y 123ABC para tener permiso sobre todos los verbos.

Además, se gestiona un error 503 para cualquier excepción inesperada.

En este repositorio se incluye también una carpeta con los archivos generados de las pruebas realizadas en Postman.

### Pre-requisitos 📋

Se requiere tener Eclipse con Hibernate configurado de manera interna, MySQL y MAMP (o programas similares como WAMP). Se requiere también tener un servidor definido en Eclipse.

## Autores ✒️

* **Sebastián Bravo Guzmán** - [sbg0006](https://github.com/sbg0006)
* **José Luis Delgado Arce** - [JLDelgado6](https://github.com/JLDelgado6)
* **Manuel Pérez Rodríguez** - [manuelsperod](https://github.com/manuelsperod)
