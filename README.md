## GlobalLogic Pool

# Sistema de creación de usuarios.

# Arquitectura

Los siguientes diagramas muestran el comportamiento del sistema y como los diferentes componentes que lo integran interactúan entre si para llevar a cabo el alta de un usuario.

### Diagrama de Secuencia 

![Diagrama de Secuencia](https://user-images.githubusercontent.com/90643475/225077199-d102979d-4c62-488d-a075-625504da4843.svg)


### Diagrama de Componentes


![Diagrama de Componentes](https://user-images.githubusercontent.com/90643475/225077212-5fe7c255-2751-4b99-8dd1-a62fea966b87.svg)


# Pre-requisitos

Para importar el proyecto se deben cumplir los siguientes requisitos:

1) Gradle *(Opcional)*
  > Ya que el IDE descarga un wrapper de la libreria Gradle esta sección es opcional.
2) Java 1.8
3) Spring STS 4.13.0
4) Base de datos MySql v8.0.32

# Importar

La importación del proyecto puede llevarse a cabo mediante el IDE que tengamos instalado o bien atrevés de la consola:

* **IDE**

Una vez dentro del IDE seleccionar *Importar -> Proyecto Gradle existente*

![image](https://user-images.githubusercontent.com/90643475/225083918-599174d6-0002-4ae9-bd41-6e95632b68ba.png)

Selecciona tu repositorio y luego *Finalizar*.

* **Consola**

Una vez dentro de tu repositorio, ejecuta:

```
./gradlew build
```

