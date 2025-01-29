package ejercicios.ejercicio1IBM;

public class Ej1IBM implements Runnable {
    @Override
    public void run() {
        // Obtenemos el hilo actual
        Thread hiloActual = Thread.currentThread();

        // Mostramos la información del hilo actual
        System.out.println("=== Información del Hilo Actual ===");
        System.out.println("Nombre del hilo: " + hiloActual.getName());
        System.out.println("Prioridad del hilo: " + hiloActual.getPriority());
        System.out.println("ID del hilo: " + hiloActual.getId());

        // Contamos el número de hilos activos
        int hilosActivos = Thread.activeCount();
        Thread[] arrayHilosActivos = new Thread[hilosActivos];

        // Obtenemos todos los hilos activos
        int hilosReales = Thread.enumerate(arrayHilosActivos);

        // Mostramos el número total de hilos activos y sus nombres
        System.out.println("\n=== Hilos Activos (" + hilosReales + ") ===");
        for (Thread hilo : arrayHilosActivos) {
            if (hilo != null) {
                System.out.println(hilo.getName());
            }
        }
    }

    public static void main(String[] args) {
        // Creamos una instancia de nuestra clase
        Ej1IBM infoHilo = new Ej1IBM();

        // Creamos un nuevo hilo con un nombre personalizado
        Thread miHilo = new Thread(infoHilo, "Hilo de Ismael");

        // Establecemos una prioridad personalizada (1-10)
        miHilo.setPriority(Thread.MAX_PRIORITY); // Prioridad máxima (10)

        // Iniciamos el hilo
        miHilo.start();

        // Esperamos a que el hilo termine
        try {
            miHilo.join();
        } catch (InterruptedException e) {
            System.out.println("El hilo fue interrumpido.");
        }
    }
}