# Ejercicios programación multihilo

1. Haz un programa que dentro de un hilo muestre: nombre del hilo, su prioridad, su id y los hilos activos.
````java
   public class InfoHilo implements Runnable {
   @Override
   public void run() {
   // Obtenemos el hilo actual
   Thread hiloActual = Thread.currentThread();

        // Obtenemos el grupo de hilos principal
        ThreadGroup grupoRaiz = Thread.currentThread().getThreadGroup();
        while (grupoRaiz.getParent() != null) {
            grupoRaiz = grupoRaiz.getParent();
        }
        
        // Estimamos el número de hilos activos
        int hilosEstimados = grupoRaiz.activeCount();
        Thread[] listaHilos = new Thread[hilosEstimados];
        
        // Obtenemos todos los hilos activos
        int hilosReales = grupoRaiz.enumerate(listaHilos, true);
        
        // Mostramos la información del hilo actual
        System.out.println("=== Información del Hilo Actual ===");
        System.out.println("Nombre del hilo: " + hiloActual.getName());
        System.out.println("Prioridad del hilo: " + hiloActual.getPriority());
        System.out.println("ID del hilo: " + hiloActual.getId());
        
        // Mostramos el número total de hilos activos y sus nombres
        System.out.println("\n=== Hilos Activos (" + hilosReales + ") ===");
        for (int i = 0; i < hilosReales; i++) {
            System.out.println((i + 1) + ". " + listaHilos[i].getName());
        }
   }

   public static void main(String[] args) {
   // Creamos una instancia de nuestra clase
   InfoHilo infoHilo = new InfoHilo();

        // Creamos un nuevo hilo con un nombre personalizado
        Thread hilo = new Thread(infoHilo, "MiHiloPersonalizado");
        
        // Establecemos una prioridad personalizada (1-10)
        hilo.setPriority(Thread.MAX_PRIORITY); // 10 es la prioridad máxima
        
        // Iniciamos el hilo
        hilo.start();
        
        // Esperamos a que el hilo termine
        try {
            hilo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
   }
   }
   ````
2. Realiza una aplicación de consola que cuente hasta un número determinado (mostrando la secuencia por pantalla) utilizando dos hilos, de forma que cada uno de ellos cuente un rango de números
````java
public class ContadorHilos implements Runnable {
    private int inicio;
    private int fin;
    private String nombreHilo;

    public ContadorHilos(int inicio, int fin, String nombreHilo) {
        this.inicio = inicio;
        this.fin = fin;
        this.nombreHilo = nombreHilo;
    }

    @Override
    public void run() {
        for (int i = inicio; i <= fin; i++) {
            System.out.println(nombreHilo + " cuenta: " + i);
            try {
                // Pequeña pausa para mejor visualización
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Número hasta el que queremos contar
        int numeroFinal = 20;
        
        // Calculamos la mitad para dividir el trabajo entre los dos hilos
        int mitad = numeroFinal / 2;
        
        // Creamos las instancias de ContadorHilos
        ContadorHilos contador1 = new ContadorHilos(1, mitad, "Hilo 1");
        ContadorHilos contador2 = new ContadorHilos(mitad + 1, numeroFinal, "Hilo 2");
        
        // Creamos los objetos Thread pasando las instancias de Runnable
        Thread hilo1 = new Thread(contador1);
        Thread hilo2 = new Thread(contador2);
        
        // Iniciamos los hilos
        hilo1.start();
        hilo2.start();
        
        // Esperamos a que ambos hilos terminen
        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Conteo finalizado");
    }
}
````

3. Realiza una aplicación que simule una carrera de coches (de hasta 4 coches). Para cada coche se podrá configurar su velocidad y en la aplicación podremos configurar la distancia del circuito. Una vez lanzada la carrera se irá mostrando por pantalla (mediante barras de progreso, por ejemplo) el desarrollo de la misma (el avance de cada coche en el tiempo). Al final de la carrera se anunciará el coche ganador y los demás se detendrán mostrando cuánta distancia han recorrido [S. Faci] 



