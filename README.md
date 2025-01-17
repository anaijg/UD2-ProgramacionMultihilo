Vamos a trabajar con Git y GitHub para gestionar nuestro proyecto. Aquí están los pasos detallados para realizar la tarea:  

**1. Hacer un fork del repositorio original**  
    Accede al repositorio en GitHub, que se encuentra en la rama origin/master.
    Haz clic en el botón Fork en la parte superior derecha de la página.  
    El fork creará una copia del repositorio original en tu cuenta de GitHub.  
    
**2. Clonar el repositorio desde tu cuenta**  
Copia el enlace del fork desde tu cuenta (botón Code → Copiar la URL).  

En tu equipo, abre una terminal y escribe:
````bash
git clone <URL_del_fork>
````
Esto descargará el repositorio a tu equipo.

Cambia al directorio del repositorio clonado:
````bash
cd <nombre_del_repositorio>
````
**3. Crear una nueva rama con tu nombre**  

Crea una nueva rama que identifique tu trabajo personal (por ejemplo, si te llamas Juan):

````bash
git checkout -b juan
````
Esto crea y cambia automáticamente a la nueva rama juan.

Confirma que estás trabajando en tu rama:
````bash
git branch
````
La rama activa estará marcada con un asterisco *.


**4. Haz un push desde tu rama**

Si no funciona simplemente con `git push` haces esto.
````bash
git push upstream origin <nombre-de-tu-rama>
````
Con eso ya añades tu rama al repositorio  (si eres colaborador del repositorio)

**5. A partir de aquí, para subir los ejercicios trabajas desde tu rama en local haciendo push hacia tu rama en remoto.**

**4. Cuando trabajes en tu rama, renombra los ejercicios antes de subirlos para incluir tu nombre. Por ejemplo:  

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