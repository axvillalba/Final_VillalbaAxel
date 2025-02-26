# **Inventario de Medicamentos - Trabajo Final de Programación II**

Este proyecto corresponde al trabajo final de la materia **Programación II** de la carrera **TUP** de la **UTN**. En él, se desarrolla una aplicación que inventaria medicamentos psicofarmacos de una farmacia, permitiendo realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre los productos almacenados en una colección. A lo largo de este proyecto, se implementan diversos conceptos de la programación orientada a objetos, manejo de archivos con serialización y deserialización, y la gestión de colecciones.

## **Objetivo del Proyecto**

El principal objetivo de este proyecto es desarrollar una aplicación que permita inventariar medicamentos psicofarmacos de forma eficiente, asegurando que las operaciones CRUD sean intuitivas y que la persistencia de los datos esté asegurada mediante la serialización de objetos en un archivo. La aplicación simula un sistema de gestión de medicamentos en una farmacia, con opciones para crear, modificar, eliminar, listar y consultar los productos almacenados.

El trabajo busca consolidar los conocimientos adquiridos en la materia **Programación II**, aplicando los conceptos de:
- **Programación Orientada a Objetos (POO)**: Utilización de clases, objetos, herencia y polimorfismo.
- **Manejo de colecciones**: Listas.
- **Manejo de excepciones**: Control de errores mediante `try-catch`.
- **Serialización y deserialización**: Persistencia de datos en archivos.

## **Características del Sistema**

La aplicación permite a los usuarios realizar las siguientes acciones:

1. **Crear Medicamento**: Añadir nuevos medicamentos al sistema con detalles como el código, monodroga, precio, dosis y cantidad.
2. **Modificar Medicamento**: Actualizar los detalles de un medicamento existente.
3. **Eliminar Medicamento**: Eliminar un medicamento del sistema.
4. **Listar Medicamentos**: Mostrar todos los medicamentos almacenados.
5. **Consultar Medicamento**: Buscar un medicamento específico por su código y mostrar sus detalles.

### **Flujo de Operaciones**

El programa comienza cargando los datos de medicamentos desde un archivo de almacenamiento utilizando la técnica de serialización. Luego, muestra un menú interactivo donde el usuario puede seleccionar diferentes opciones de gestión (crear, modificar, eliminar, listar o consultar medicamentos). Después de finalizar, el programa guarda los cambios realizados en el archivo, sobrescribiendo el archivo anterior con la nueva información.

## **Implementación Técnica**

### **Clases Principales**

- **Farmaco**: Clase base que representa un medicamento con propiedades comunes (código, monodroga, precio, dosis, cantidad).
- **Antidepresivo, Ansiolitico, Antiepileptico**: Clases derivadas de `Farmaco`, que representan tipos específicos de medicamentos, con atributos adicionales que caracterizan cada tipo.
- **FarmaciaGestion**: Clase encargada de gestionar las operaciones CRUD (agregar, modificar, eliminar, listar) sobre los medicamentos.
- **TipoReceta, ClasificacionAntiepileptico, TipoAntidepresivo**: Enumeraciones que definen tipos de recetas y clasificaciones para los medicamentos.

### **Persistencia de Datos**

El sistema utiliza **serialización** para guardar los medicamentos en un archivo binario llamado `farmacos.txt`. Al inicio de la ejecución del programa, los datos se deserializan desde este archivo para que el programa los cargue en la memoria. Los cambios realizados en los medicamentos se serializan nuevamente al archivo al finalizar el programa, garantizando que la información persista entre ejecuciones.

### **Validación de Entrada de Usuario**

Se ha implementado un sistema robusto de validación para garantizar que los usuarios introduzcan datos válidos. Esto incluye la validación de opciones en el menú y la verificación de que los códigos de medicamentos sean únicos.

**Ejemplo de validaciones implementadas**:
- Comprobación de que un código de medicamento no se repita antes de permitir su creación.
- Validación de tipos de datos correctos cuando se introducen valores como precios, dosis y cantidades.

### **Manejo de Excepciones**

Para manejar errores introducidos por el usuario o problemas de entrada/salida, se ha implementado un sistema de manejo de excepciones utilizando bloques `try-catch`. Esto asegura que el programa no se rompa ante entradas no válidas o problemas con la lectura/escritura de archivos.

## **Instrucciones para Ejecutar el Proyecto**

### **Requisitos**

- **Java 8 o superior**.
- **IDE recomendado**: NetBeans o cualquier otro editor compatible con Java.

### **Pasos para ejecutar el programa**

1. **Clonar el repositorio**:

   ```bash
   git clone https://github.com/axvillalba/Final_VillalbaAxel.git


## **Imagenes del programa**
![Inicio y Crear](https://github.com/axvillalba/Final_VillalbaAxel/blob/master/screenshots/1.jpg)
![Listar](https://github.com/axvillalba/Final_VillalbaAxel/blob/master/screenshots/2.jpg)
![Eliminar](https://github.com/axvillalba/Final_VillalbaAxel/blob/master/screenshots/3.jpg)
![Modificar](https://github.com/axvillalba/Final_VillalbaAxel/blob/master/screenshots/4.jpg)
![Final](https://github.com/axvillalba/Final_VillalbaAxel/blob/master/screenshots/5.png)
![archivo .txt](https://github.com/axvillalba/Final_VillalbaAxel/blob/master/screenshots/5.jpg)
