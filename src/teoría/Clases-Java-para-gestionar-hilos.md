# Clases Java para la gestión de hilos
## La interfaz `Runnable`
Cuando se ejecuta un programa Java se crea un proceso con un hilo principal (main) creado por la máquina virtual de Java (JVM).

Y desde un proceso se pueden crear tantos hilos como sean necesarios, que se ejecutarán en paralelo con el hilo principal.
![img.png](img.png)

Un hilo en Java es un **objeto** como cualquier otro, concretamente es una instancia de la clase `java.lang.Thread`.

## Cómo lanzar hilos
### Primera forma: implementando `Runnable`
La forma más habitual de crear un hilo es **creando una clase que implemente la interfaz `java.lang.Runnable`, que tiene un único método: `run()`.

````java
public class MyRunnable implements Runnable {
    public void run(){
        // código que queremos que se ejecute en cada hilo
    }
}
````
Para lanzar un hilo de esta forma: 
1. Creamos un objeto de la clase que implementa la interfaz `Runnable`. A este objeto se le suele llamar `task` (tarea).
2. Creamos un objeto de la clase `Thread` y en el constructor le pasamos el objeto `Runnable`.
3. Para que el hilo se ejecute se llama al método `start()` de la clase `Thread()`.

````java
public static void main(String[] args) {
    // primer hilo
    MyRunnable task1 = new MyRunnable();
    Thread hilo1 = new Thread(task1);
    hilo1.start();
    
    // segundo hilo
    MyRunnable task2 = new MyRunnable();
    Thread hilo2 = new Thread(task2);
    hilo2.start();
}
````
>**Ejemplo 1** EjemploRunnable.java

### Segunda forma: heredando de `Thread`
En este caso, creamos una clase que herede de `Thread`, que implícitamente implementa `run()`. 
````java
public class MyThread extends Thread {
    // propiedades, constructores, etc
    //...
    public void run(){
        // código que queremos que se ejecute en el hilo
    }
}
````
Para lanzar un hilo hay que crear un objeto de esa clase y llamar al método `start()` (¡ojo! no al método `run()`).
````java
    public static void main(String[] args) {
        // primer hilo
        MyThread hilo1 = new MyThread();
        hilo1.start();
        // segundo hilo
        MyThread hilo2 = new MyThread();
        hilo2.start();
        // ...
    }
````
>**Ejemplo2.** `EjemploThread.java`

### ¿Cuál de las dos formas elegir?
Ambos métodos son similares y el resultado es el mismo, pero el método preferido debería ser implementar `Runnable`, y pasarle la instancia al constructor de `Thread`, porque
- Cuando heredamos de la clase `Thread`, no estamos sobrescribiendo ninguno de sus métodos, sino un método de la interfaz `Runnable` (que `Thread` implementa internamente), con lo que no se cumple el principio IS-A ("es un") de la herencia.

- Cuando pasamos la instancia de `Runnable` al constructor de `Thread` estamos usando composición y no herencia, lo cual permite mucha más flexibilidad.

- Si heredamos de `Thread`, ya no podemos heredar de otras clases. Esto supone un gran problema cuando usamos librerías o
componentes gráficos, ya que Java no permite la herencia múltiple.  

- Desde Java 8 en adelante, la interfaz `Runnable` se puede representar con expresiones lambda

### ¿Cuándo termina un proceso?
En un proceso monohilo (sólo con el hilo que crea el `main`) el proceso sigue en ejecución (vivo) mientras el código que hayamos puesto en el `main` continúe ejecutándose.
![img_1.png](img_1.png)
Cuando un proceso tiene más hilos, el proceso no finaliza su ejecución hasta que el último de los hilos haya terminado. Puede suceder que el main-thread finalice y el proceso siga en ejecución.

# Métodos de la clase `Thread`

| Método                          | Descripción                                                                 |
|---------------------------------|-----------------------------------------------------------------------------|
| `start()`                       | Inicia la ejecución del hilo.                                               |
| `run()`                         | Contiene el código que se ejecutará en el hilo.                             |
| `sleep(long millis)`            | Hace que el hilo actual se duerma durante el tiempo especificado en milisegundos. |
| `join()`                        | Espera a que el hilo en el que se llama termine.                            |
| `interrupt()`                   | Interrumpe el hilo.                                                         |
| `isAlive()`                     | Devuelve `true` si el hilo está en ejecución.                               |
| `getName()`                     | Devuelve el nombre del hilo.                                                |
| `setName(String name)`          | Establece el nombre del hilo.                                               |
| `getPriority()`                 | Devuelve la prioridad del hilo.                                             |
| `setPriority(int priority)`     | Establece la prioridad del hilo.                                            |
| `getId()`                       | Devuelve el identificador único del hilo.                                   |
| `getState()`                    | Devuelve el estado del hilo.                                                |
| `currentThread()`               | Devuelve una referencia al hilo que se está ejecutando actualmente.         |
| `yield()`                       | Sugiere al planificador de hilos que ceda el uso del procesador a otros hilos. |
| `setDaemon(boolean on)`         | Marca el hilo como un hilo de demonio o no.                                 |
| `isDaemon()`                    | Devuelve `true` si el hilo es un hilo de demonio.                           |
| `checkAccess()`                 | Determina si el hilo actual tiene permiso para modificar el hilo.           |
| `interrupted()`                 | Verifica si el hilo actual ha sido interrumpido.                            |

# Constructores de la clase `Thread`

| Constructor                     | Descripción                                                                 |
|---------------------------------|-----------------------------------------------------------------------------|
| `Thread()`                      | Crea un nuevo hilo sin especificar un objetivo (`Runnable`) ni un nombre.   |
| `Thread(Runnable target)`       | Crea un nuevo hilo con el objetivo especificado (`Runnable`).               |
| `Thread(String name)`           | Crea un nuevo hilo con el nombre especificado.                              |
| `Thread(Runnable target, String name)` | Crea un nuevo hilo con el objetivo (`Runnable`) y el nombre especificados. |

> Ejemplo: 
````java
public class EjemploThread implements Runnable {
    private String name;

    public EjemploThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        // Get the name of the current thread
        String threadName = Thread.currentThread().getName();
        // Print the name of the thread and a message
        System.out.println("[" + threadName + "] " + "Inside the thread");
        // Print the priority of the current thread
        System.out.println("[" + threadName + "] " + "Priority: "
                + Thread.currentThread().getPriority());
        // Suggest to the thread scheduler to yield the processor to other threads
        Thread.yield();
        // Print the ID of the current thread
        System.out.println("[" + threadName + "] " + "Id: "
                + Thread.currentThread().getId());
        // Print the name of the thread group to which the current thread belongs
        System.out.println("[" + threadName + "] " + "ThreadGroup: "
                + Thread.currentThread().getThreadGroup().getName());
        // Print the number of active threads in the thread group
        System.out.println("[" + threadName + "] " + "ThreadGroup count: "
                + Thread.currentThread().getThreadGroup().activeCount());
    }

    public static void main(String[] args) {
        // Using different constructors of Thread class

        // Constructor: Thread()
        Thread hilo1 = new Thread(new EjemploThread("Hilo1"));
        hilo1.setName("Hilo1");
        hilo1.start();

        // Constructor: Thread(Runnable target)
        Thread hilo2 = new Thread(new EjemploThread("Hilo2"));
        hilo2.setName("Hilo2");
        hilo2.start();

        // Constructor: Thread(String name)
        Thread hilo3 = new Thread(new EjemploThread("Hilo3"), "Hilo3");
        hilo3.start();

        // Constructor: Thread(Runnable target, String name)
        Thread hilo4 = new Thread(new EjemploThread("Hilo4"), "Hilo4");
        hilo4.start();
    }
}
````
A partir del ejemplo anterior vemos que: 
- Tenemos que ayudarnos del método estático `Thread.currentThread()` para saber qué
hilo está ejecutándose en cada momento.  
  

- Los threads se ejecutan en paralelo y no de forma secuencial. La JVM y/o el sistema operativo determinan el
orden en el que se ejecutan. Este orden no tiene porqué ser el mismo en el que se lanzaron ni cada vez que se ejecutan.

## Cómo pausar un hilo
Un thread puede pausar su propia ejecución llamando al método estático `Thread.sleep()` recibiendo como parámetro el número de milisegundos que debe estar pausado antes de volver a ponerse como listo para ejecución. 
>Ejemplo. A continuación tenemos un ejemplo de un thread que se pausa durante 3 segundos (3000ms) llamando al método sleep()
````java
 try {
    Thread.sleep(3000L);
 } catch (InterruptedException e) {
    e.printStackTrace();
 }
````
### Simulación de sistemas reales
El método `sleep()` se puede utilizar para simular períodos de tiempo y acelerar las simulaciones.  

Por ejemplo, podemos hacer un ajuste para que cada hora real se reduzca a un segundo. De esta forma podremos simular un día completo en tan solo 24 segundos.  

También es interesante su uso para utilizar **períodos de tiempo aleatorios en la ejecución de cada hilo**, permitiendo así
una simulación realista de los eventos en un sistema real.  


En Java podemos generar números aleatorios en el rango de los enteros, long, float y double.
Tenemos tres métodos básicos para hacerlo
1. **Usando la clase `java.util.Random`**
   1. Importar la clase `java.util.Random`  
   2. Crear una instancia de la clase `Random`, por ejemplo  

        `Random rand = new Random()`
   3. Llamar a alguno de los métodos del objeto:
      - `nextInt(limitesuperior)` genera números aleatorios en el rango `0` a `límitesuperior-1`.
      - `nextFloat()` genera un `float` entre `0.0` y `1.0`.
      - `nextDouble()` genera un `double` entre `0.0` y `1.0`.  
  
    
2. **Usando `Math.random`**
Usar la fórmula
      `Math.random()*(max-min)+min`  
para generar valores entre min y max, ambos inclusive [min, max].  

El valor devuelto por `Math.random()` está en el rango [0, 1].   
Para generar números entre `0` y un límite superior (`50`)  
      `Math.random()*50`  
Para generar números entre `1` y un límite superior (`50`)
      `Math.random()*49+1`  
Para generar números en un rango predeterminado [200, 500]  
      `Math.random()*300+200`

3. **Usar `ThreadLocalRandom`**  
La clase `java.util.Random` no tiene buen rendimiento en entornos multihilo.

Para evitar esa limitación, Java introdujo la clase `java.util.concurrent.ThreadLocalRandom` para generar números aleatorios en entornos multihilo.  

Si llamamos al método `ThreadLocalRandom.current()` nos devolverá la instancia de `ThreadLocalRandom` para el hilo actual. A partir de aquí podemos generar valores aleatorios llamando a los métodos de la clase con la instancia obtenida.  

- Para generar valores enteros sin límite:
````java
      int unboundedRandomValue = ThreadLocalRandom.current().nextInt();
````
- Para generar valores enteros en un rango dato, es decir, con un límite superior e inferior [0, 100[:  
````java
      int boundedRandomValue = ThreadLocalRandom.current().nextInt(0, 100);
````
Al igual que con Random, `0` está incluido en el rango mientras que `100` no.  

También podemos generar otros tipos de datos como `Long` y `Double` llamando a los métodos `nextLong()` y `nextDouble()` de forma similar a los ejemplos anteriores.  

La clase `ThreadLocalRandom` hereda de `Random`, por lo que comparten muchos métodos.

>**Ejemplo 3.** `SimulacionRestaurante.java`
> Este ejemplo simula un restaurante donde:
>
>Cada camarero es un hilo independiente que atiende varias mesas.  
>Para cada mesa, el camarero realiza tres actividades con tiempos aleatorios:
>
>- Atender la mesa (1-5 segundos)
>- Esperar que la cocina prepare el pedido (2-8 segundos)
>- Entregar el pedido (1-3 segundos)

## Gestión de la prioridad de los hilos
Los hilos heredan la prioridad del padre en Java, pero este valor puede ser cambiado con el método `setPriority()` y con
 `getPriority()` podemos saber la prioridad de un hilo.  

El valor de la prioridad varía entre `1` y `10`. **Cuanto más alto es el valor, mayor es la prioridad**. La clase `Thread` define las siguientes constantes:
- `MIN_PRIORITY` (valor 1) 
- `MAX_PRIORITY` (valor 10) 
- y `NORM_PRIORITY` (valor 5). 
  
El planificador elige el hilo en función de su prioridad. Si dos hilos tienen la misma prioridad realiza un *round-robin*, es decir de forma cíclica va alternando los hilos. 

El hilo de mayor prioridad seguirá funcionando hasta que ceda el control por alguna de las siguientes razones:
- Cede el control llamando al método `yield()`.
- Deja de ser ejecutable (por muerte o por bloqueo)
- Aparece un hilo de mayor prioridad, por ejemplo si se encontraba en estado dormido por una operación de E/S o bien es desbloqueado por otro con los métodos `notifyAll()` / `notify()`.
````java
class PrioridadHilo extends Thread {
    private int c = 0;
    private boolean stopHilo = false;
    
    public long getContador () {
            return c;
    }
    
    public long pararHilo() {
      stopHilo = true;
    }
    
    @Override
    public void run() {
      while (!stopHilo) c++;
    }
}
public class MainPrioridadHilo {
  public static void main(String args[]) {
      PrioridadHilo h1 = new PrioridadHilo();
      PrioridadHilo h2 = new PrioridadHilo();
      PrioridadHilo h3 = new PrioridadHilo();  
      
      h1.setPriority(Thread.NORM_PRIORITY);
      h2.setPriority(Thread.MAX_PRIORITY);
      h3.setPriority(Thread.MIN_PRIORITY);
      
      h1.start();
      h2.start();
      h3.start();
      
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {}
      
      h1.pararHilo();
      h2.pararHilo();
      h3.pararHilo();
      System.out.println("h2 (Prio. Máx: "+h2.getContador());
      System.out.println("h1 (Prio. Normal: "+h1.getContador());
      System.out.println("h3 (Prio. Mínima: "+h3.getContador());
    }
 }
````