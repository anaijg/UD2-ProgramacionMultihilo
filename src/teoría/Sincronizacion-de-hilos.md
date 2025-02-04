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
class SomeClass {
    public static synchronized void doSomething() {
        String threadName = Thread.currentThread().getName();
        System.out.println(String.format("%s entró al método", threadName));
        System.out.println(String.format("%s salió del método", threadName));
    }
}
````
El método `doSomething` está declarado como sincronizado, por lo que solo un hilo puede invocarlo a la vez. El método está sincronizado sobre el objeto de la clase `SomeClass` al que pertenece el método estático. Java crea un objeto especial único para cada clase. Para obtenerlo, se usa el nombre de la clase seguido de `.class`. En este caso, sería `SomeClass.class`.

Si llamamos al método desde dos hilos concurrentemente, el resultado siempre será algo similar a:
````scss
Thread-0 entró al método
Thread-0 salió del método
Thread-1 entró al método
Thread-1 salió del método
````
Es imposible que más de un hilo ejecute el código dentro del método al mismo tiempo.
## Métodos de instancia sincronizados

Los métodos de instancia se sincronizan en la propia instancia (objeto). El monitor es el objeto this, es decir, la instancia que posee el método. Si tenemos dos instancias de una clase, cada instancia tiene su propio monitor para la sincronización.

Solo un hilo puede ejecutar código en un **método de instancia sincronizado** de una instancia particular. Pero diferentes hilos pueden ejecutar métodos de diferentes instancias al mismo tiempo. Esto se resume como: *"un hilo por instancia"*.

Ejemplo de una clase con un método de instancia sincronizado llamado `doSomething`:
````java
class SomeClass {
private String name;

    public SomeClass(String name) {
        this.name = name;
    }

    public synchronized void doSomething() {
        String threadName = Thread.currentThread().getName();
        System.out.println(String.format("%s entró al método de %s", threadName, name));
        System.out.println(String.format("%s salió del método de %s", threadName, name));
    }
}
````
Clase para crear hilos que ejecutan `doSomething`:
````java
class MyThread extends Thread {
    private SomeClass someClass;

    public MyThread(SomeClass someClass) {
        this.someClass = someClass;
    }

    @Override
    public void run() {
        someClass.doSomething();
    }
}
````
Creación de dos instancias y tres hilos:
````java
SomeClass instance1 = new SomeClass("instancia-1");
SomeClass instance2 = new SomeClass("instancia-2");

MyThread first = new MyThread(instance1);
MyThread second = new MyThread(instance1);
MyThread third = new MyThread(instance2);

first.start();
second.start();
third.start();
````
Posible salida:
````scsº
Thread-0 entró al método de instancia-1
Thread-2 entró al método de instancia-2
Thread-0 salió del método de instancia-1
Thread-1 entró al método de instancia-1
Thread-2 salió del método de instancia-2
Thread-1 salió del método de instancia-1
````
Como puedes ver, nunca hay más de un hilo ejecutando `doSomething` en instancia-1 al mismo tiempo.
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
