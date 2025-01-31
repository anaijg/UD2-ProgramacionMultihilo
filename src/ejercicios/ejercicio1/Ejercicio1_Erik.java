package ejercicios.ejercicio1;

/**
 * 1. Haz un programa que dentro de un hilo muestre: nombre del hilo, su prioridad, y los hilos activos.
 * <p>
 * Lanza al menos 5 hilos con diferentes nombres y prioridades.
 * <p>
 * Añade lo necesario para que no empiece a ejecutarse un hilo hasta que no haya finalizado el anterior.
 */

public class Ejercicio1_Erik implements Runnable {

    @Override
    public void run() {
        // Obtenemos el hilo actual
        Thread hiloActual = Thread.currentThread();
        // Mostramos la información del hilo actual
        System.out.println("=== Información del Hilo Actual ===");
        System.out.printf("Nombre del hilo: %s\n", hiloActual.getName());
        System.out.printf("Prioridad del hilo: %d\n", hiloActual.getPriority());
        System.out.printf("ID del hilo: %d\n", hiloActual.threadId());


        // Contamos el número de hilos activos
        ThreadGroup grupoActual = Thread.currentThread().getThreadGroup();

        int hilosActivos = grupoActual.activeCount();
        Thread[] arrayHilosActivos = new Thread[hilosActivos];

        // Obtenemos todos los hilos activos
        int hilosReales = grupoActual.enumerate(arrayHilosActivos, true);


        // Mostramos el número total de hilos activos y sus nombres
        System.out.printf("\n=== Hilos Activos (%d) ===\n", hilosReales);
        for (int i = 0; i < hilosReales; i++) {
            System.out.println((i+1) +  ". " + arrayHilosActivos[i].getName());
        }
    }

    public static void main(String[] args) {
        // Creamos una instancia de nuestra clase
        Ejercicio1_Erik infoHilo = new Ejercicio1_Erik();
        // Creamos un nuevo hilo con un nombre personalizado
        Thread nuevoHilo = new Thread(infoHilo);
        // Establecemos una prioridad personalizada (1-10)
        nuevoHilo.setPriority(Thread.MAX_PRIORITY);
        // Iniciamos el hilo
        nuevoHilo.start();
        // Esperamos a que el hilo termine

    }
}