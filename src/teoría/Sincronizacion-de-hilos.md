# Sincronización de hilos.

Trabajar concurrentemente con datos compartidos desde múltiples hilos puede causar un comportamiento inesperado o erróneo. Afortunadamente, Java proporciona un mecanismo para controlar el acceso de múltiples hilos a un recurso compartido de cualquier tipo. Este mecanismo se conoce como **sincronización de hilos**.
## Términos y conceptos importantes

Antes de empezar a usar la sincronización en nuestro código, introduzcamos algunos términos y conceptos que vamos a utilizar.  

1) **Sección crítica**

Una sección crítica es una región de código que accede a recursos compartidos y que no debe ser ejecutada por más de un hilo al mismo tiempo. Un recurso compartido puede ser una variable, un archivo, un puerto de entrada/salida, una base de datos o cualquier otro elemento.

Veamos un ejemplo. Una clase tiene un **atributo estático** llamado counter:
````java
public static long counter = 0;
````
Dos hilos incrementan el atributo (aumentándolo en 1) 10 000 000 veces de manera concurrente. El valor final esperado debería ser 20 000 000, pero, como hemos discutido en temas anteriores, el resultado a menudo es incorrecto, por ejemplo, 10 999 843.

Esto sucede porque, en algunas ocasiones, un hilo no ve los cambios en los datos compartidos realizados por otro hilo, y otras veces un hilo puede ver un valor intermedio de la **operación no atómica**. Estos son problemas de visibilidad y atomicidad con los que lidiamos al trabajar con datos compartidos.

Por esta razón, incrementar un valor mediante múltiples hilos es una **sección crítica**. Por supuesto, este ejemplo es muy simple, pero una sección crítica puede ser mucho más compleja.  

2) **Monitor**

El monitor es un mecanismo especial para controlar el **acceso concurrente** a un objeto. En Java, cada objeto tiene un monitor implícito asociado. Un hilo puede adquirir un monitor y, mientras lo tenga, otros hilos no podrán adquirirlo. Estos deberán esperar hasta que el dueño (el hilo que adquirió el monitor) lo libere.

Así, un hilo puede quedar bloqueado por el **monitor** de un objeto y esperar hasta que sea liberado. Este mecanismo permite a los programadores proteger las **secciones críticas** para evitar que sean accedidas simultáneamente por múltiples hilos.  

## La palabra clave `synchronized`

La forma más "clásica" y sencilla de proteger el código del acceso concurrente de múltiples hilos es utilizando la palabra clave `synchronized`.

Se usa en dos formas diferentes:  

- **Métodos sincronizados** (pueden ser estáticos o de instancia).  

- **Bloques o sentencias sincronizadas** (dentro de un método estático o de instancia).

Un método o bloque sincronizado necesita un objeto para bloquear los hilos. El monitor asociado con este objeto controla el acceso concurrente a la sección crítica especificada. Solo un hilo puede ejecutar el código dentro de un método o bloque sincronizado al mismo tiempo. Otros hilos quedarán bloqueados hasta que el hilo que está dentro del método o bloque sincronizado salga de él.  

## Métodos estáticos sincronizados

Cuando sincronizamos métodos estáticos con la palabra clave `synchronized`, el monitor es la propia clase. Solo un hilo puede ejecutar el cuerpo de un método estático sincronizado a la vez. Esto se puede resumir como: *"un hilo por clase"*.

Aquí hay un ejemplo de una clase con un método estático sincronizado llamado `doSomething`:
````java
public class MiClase {

    public static synchronized void printNombre() {
        String nombre = Thread.currentThread().getName();
        System.out.println(nombre + " a la una");
        System.out.println(nombre + " a las dos");
        System.out.println(nombre + " y a las tres");
    }
}

````
El método `printNombre` está declarado como `synchronized`, por lo que solo un hilo puede invocarlo a la vez. El método está sincronizado sobre el objeto de la clase `MiClase` al que pertenece el método estático. Java crea un objeto especial único para cada clase. Para obtenerlo, se usa el nombre de la clase seguido de `.class`. En este caso, sería `MiClase.class`.

Como la forma de crear hilos con `Runnable` nos gusta, vamos a crear una clase `Task` que ejecute el método estático `printName()` de la clase `MiClase`.
````java
public class Task implements Runnable{
    @Override
    public void run() {
        MiClase.printNombre();
    }
}
````
>**Nota:** esta clase te la puedes ahorrar si haces que mi clase extienda `Thread` o utilizando lambdas al crear hilos.
Si llamamos al método desde dos hilos concurrentemente, 
````java
public class Main {
    public static void main(String[] args) {
        // Creación del primer hilo
        Thread hilo1 = new Thread(new Task(), "Hilo 1");

        // Creación del segundo hilo
        Thread hilo2 = new Thread(new Task(), "Hilo 2");

        // Inicio de los hilos
        hilo1.start();
        hilo2.start();

        // Espera a que ambos hilos finalicen antes de terminar el main
        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            /* Clean up whatever needs to be handled before interrupting  */
            Thread.currentThread().interrupt();
        }
    }
}
````


el resultado será algo similar a:
````text
Hilo 1 a la una 
Hilo 1 a las dos
Hilo 1 y a las tres
Hilo 2 a la una
Hilo 2 a las dos
Hilo 2 y a las tres
````
Es imposible que más de un hilo ejecute el código dentro del método al mismo tiempo.  
>**Nota:** trata de ejecutar el mismo código eliminando la palabra `syncronized` de la declaración del método, y observa la diferencia con el resultado. Lo mismo respecto a `join()`, elimínalo y observa el resultado.

## Métodos de instancia sincronizados

Los métodos de instancia se sincronizan en la propia instancia (objeto). El **monitor** es el objeto `this`, es decir, la instancia que posee el método. Si tenemos dos instancias de una clase, cada instancia tiene su propio monitor para la sincronización.

Solo un hilo puede ejecutar código en un **método de instancia sincronizado** de una instancia particular. Pero diferentes hilos pueden ejecutar métodos de diferentes instancias al mismo tiempo. Esto se resume como: *"un hilo por instancia"*.

Ejemplo de una clase con un método de instancia sincronizado llamado `doSomething`:
````java
public class MiClase {
    /**
     * Método sincronizado, por tanto solamente puede ser llamado por un hilo a la vez
     * Se sincroniza sobre un objeto MiClase, ya que es la clase que lo contiene
     *
     */
    private String nombre;

    public MiClase(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public synchronized void printNombre() {
        String nombre = Thread.currentThread().getName();

        System.out.println(nombre + " a la una (" + this.getNombre() + ")");
        System.out.println(nombre + " a las dos (" + this.getNombre() + ")");
        System.out.println(nombre + " y a las tres (" + this.getNombre() + ")");
    }
}

````
Clase para crear hilos que ejecutan `MiClase`:
````java
public class Task implements Runnable{
    private MiClase miClase;

    public Task(MiClase miClase) {
        this.miClase = miClase;
    }

    @Override
    public void run() {
        this.miClase.printNombre();
    }
}
````
Creación de dos instancias y tres hilos:
````java
public class Main {
    public static void main(String[] args) {
        // Creamos dos objetos de MiClase
        MiClase instancia1 = new MiClase("Instancia 1");
        MiClase instancia2 = new MiClase("Instancia 2");

        // Creación del primer hilo
        Thread hilo1 = new Thread(new Task(instancia1), "Hilo 1");

        // Creación del segundo hilo
        Thread hilo2 = new Thread(new Task(instancia1), "Hilo 2");

        // Creación del terceer hilo con el otro objeto
        Thread hilo3 = new Thread(new Task(instancia2), "Hilo 3");

        // Inicio de los hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();

        // Espera a que ambos hilos finalicen antes de terminar el main
        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            /* Clean up whatever needs to be handled before interrupting  */
            Thread.currentThread().interrupt();
        }
    }
}
````
Posible salida:
````text
Hilo 1 a la una (Instancia 1)
Hilo 3 a la una (Instancia 2)
Hilo 1 a las dos (Instancia 1)
Hilo 3 a las dos (Instancia 2)
Hilo 3 y a las tres (Instancia 2)
Hilo 1 y a las tres (Instancia 1)
Hilo 2 a la una (Instancia 1)
Hilo 2 a las dos (Instancia 1)
Hilo 2 y a las tres (Instancia 1)
````
Como puedes ver, nunca hay más de un hilo ejecutando `printNombre()` en instancia-1 al mismo tiempo.  

## Bloques sincronizados

A veces es necesario sincronizar solo una parte del método, lo cual es posible mediante bloques sincronizados (`synchronized`). Estos deben especificar un objeto para bloquear los hilos.

Ejemplo de una clase con métodos con bloques sincronizados:
````java
class SomeClass {
    public static void staticMethod() {
        // Código sin sincronizar
        ...
        synchronized (SomeClass.class) { // Sincronización sobre la clase
            // Código sincronizado
            ...
        }
    }

    public void instanceMethod() {
        // Código sin sincronizar
        ...
        synchronized (this) { // Sincronización sobre la instancia actual
            // Código sincronizado
            ...
        }
    }
}
````
En `staticMethod()`, el bloque `synchronized` usa `SomeClass.class`, lo que significa que solo un hilo puede ejecutar el código en este bloque.
En `instanceMethod()`, el bloque `synchronized` usa `this`, lo que significa que solo un hilo puede ejecutar el bloque dentro de una instancia específica.

Los bloques sincronizados son más flexibles que los métodos sincronizados, ya que permiten sincronizar solo partes específicas del código.

## Conclusión

Hemos cubierto la palabra clave `synchronized`, el mecanismo básico de sincronización de hilos en Java. Permite controlar el acceso a secciones críticas, asegurando que solo un hilo procese un fragmento de código protegido a la vez.

## Resumen:

- **Métodos estáticos sincronizados**: Un hilo por clase (`SomeClass.class` como monitor).
- **Métodos de instancia sincronizados:** Un hilo por instancia (`this` como monitor).
- **Bloques sincronizados:** Más flexibles, permiten definir límites de sincronización y especificar un monitor.

Usar synchronized correctamente es clave para evitar problemas de concurrencia en Java. 🚀
