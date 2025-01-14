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

**4. Renombrar los ficheros de los ejercicios**  

Renombra los archivos de los ejercicios para incluir tu nombre. Por ejemplo:  

Ejercicio1.java → Ejercicio1_Juan.java  
Ejercicio2.java → Ejercicio2_Juan.java  

Si usas la terminal, puedes hacerlo con:
````
mv Ejercicio1.java Ejercicio1_Juan.java
mv Ejercicio2.java Ejercicio2_Juan.java
````
**5. Hacer un commit en tu rama**  
Añade los archivos renombrados al índice:
````bash
git add .
````
Haz un commit con un mensaje descriptivo:
````bash
git commit -m "Renombrados los archivos de los ejercicios con mi nombre"
````
**6. Subir los cambios a tu repositorio remoto en tu rama**  
Haz un push de tu rama al repositorio remoto en GitHub:
````bash
git push origin juan
````
**7. Fusionar tu rama con master**  
Cambia a la rama master:
````bash
git checkout master
````
Fusiona tu trabajo de la rama juan con master:
````bash
git merge juan
````
Sube los cambios a la rama master en tu fork:
````bash
git push origin master
````
**8. Verificación**  

Asegúrate de que tanto tu rama personal como master están actualizadas en tu fork en GitHub.
Si todo está correcto, notifica al profesor que has finalizado el ejercicio.
