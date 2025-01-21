Vamos a trabajar con Git y GitHub para gestionar nuestro proyecto. Aquí están los pasos detallados para realizar la tarea:  

**1. Clonar el repositorio en tu equipo local**  

En tu equipo, abre una terminal, ubícate (cd) en la carpeta `IdeaProjects` y escribe:
````bash
git clone <URL_del_repositorio>
````
Esto descargará el repositorio a tu equipo, y ya puedes abrir el proyecto desde `Intellij IDEA`.

**3. Crear una nueva rama con tu nombre**  

Crea una nueva rama que identifique tu trabajo personal (por ejemplo, si te llamas Juan):

````bash
git checkout -b juan
````
Esto crea y cambia automáticamente a la nueva rama juan, haciendo una copia completa del repositorio

Confirma que estás trabajando en tu rama:
````bash
git branch
````
La rama activa estará marcada con un asterisco *.

**4. A partir de aquí, para subir los ejercicios trabajas desde tu rama en local haciendo push hacia tu rama en remoto.**
A partir de aquí, trabaja siempre en tu rama. Cuando finalices, confirma los cambios y añádelos a tu rama en el repositorio remoto con `git push`.  

Si no funciona simplemente con `git push` haces esto.
````bash
git push upstream origin <nombre-de-tu-rama>
````
Con eso ya añades tu rama al repositorio  (si eres colaborador del repositorio)

**5. Cuando trabajes en tu rama, renombra los ejercicios antes de subirlos para incluir tu nombre.**
Por ejemplo:  

Ejercicio1.java → Ejercicio1_Juan.java  
Ejercicio2.java → Ejercicio2_Juan.java  

**5. Hacer un commit en tu rama**  
Añade los archivos renombrados al índice:
````bash
git add .
````
Haz un commit con un mensaje descriptivo:
````bash
git commit -m "Renombrados los archivos de los ejercicios con mi nombre"
````
>Recuerda de vez en cuando cambiar a la la rama master y hacer un pull.

# Comandos git que pueden ser útiles para añadir los cambios que haya en la rama master a tu rama (ficheros nuevos o modificados).

## Descargar los cambios que haya habido en la rama master
Para actualizar los cambios de la rama master del repositorio remoto en tu repositorio local, sigue estos pasos:  
1. Cambia a la rama master en tu repositorio local:
````bash
git checkout master
````
Descarga los últimos cambios del repositorio remoto:  
````bash
git pull origin master
````
Esto actualizará tu rama master local con los últimos cambios de la rama master del repositorio remoto.

## Comparar las diferencias entre dos ramas 
Para ver las diferencias entre dos ramas en Git, puedes usar el comando git diff. Aquí tienes un ejemplo de cómo hacerlo:
````bash
git diff <branch1> <branch2>
````
Reemplaza `<branch1>` y `<branch2>` con los nombres de las ramas que deseas comparar. Este comando te mostrará las diferencias entre los archivos en las dos ramas especificadas.
Esto solamente te indica las diferencias en ficheros que están presentes en ambas ramas, pero no si se han añadido ficheros en una rama que no están en la otra. 
## Incluir un fichero que está en una rama a otra rama (por ejemplo, de la rama master a la rama que lleva tu nombre)
```bash
git checkout <target-branch>
git checkout <source-branch> -- <file-path>
git commit -m "Merged specific file from <source-branch> to <target-branch>"
````
-  Reemplaza `<target-branch>` con el nombre de la rama de destino, `<source-branch>` con el nombre de la rama de origen y `<file-path>` con la ruta del fichero que deseas mergear. `<file-path>` también puede ser la ruta a un paquete, con lo que llevarás a la rama destino el paquete y todas las clases que contiene. 

## Mostrar el listado de ficheros de una rama
````bash
git ls-tree -r <branch-name> --name-only
````
