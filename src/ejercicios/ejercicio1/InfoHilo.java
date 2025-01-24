package ejercicios.ejercicio1;

public class InfoHilo implements Runnable {
    @Override
    public void run() {
        // Obtenemos el hilo actual
        Thread currentThread = Thread.currentThread();

        // Mostramos la información del hilo actual
        System.out.println("=== Información del Hilo Actual ===");
        System.out.println("Nombre del hilo: " + currentThread.getName());
        System.out.println("Prioridad del hilo: " + currentThread.getPriority());
        System.out.println("ID del hilo: " + currentThread.getId());

        // Contamos el número de hilos activos
        int hilosActivos = Thread.activeCount();
        Thread[] arrayHilosActivos = new Thread[hilosActivos];

        // Obtenemos todos los hilos activos
        int hilosReales = Thread.currentThread().getThreadGroup().enumerate(arrayHilosActivos, true);

        // Mostramos el número total de hilos activos y sus nombres
        System.out.println("\n=== Hilos Activos (" + hilosReales + ") ===");
        for (int i = 0; i < hilosReales; i++) {
            System.out.println((i + 1) + ". " + arrayHilosActivos[i].getName());
        }
    }

    public static void main(String[] args) {
        // Creamos una instancia de nuestra clase
        InfoHilo infoHilo = new InfoHilo();

        // Creamos un nuevo hilo con un nombre personalizado
        Thread thread = new Thread(infoHilo, "MiHiloPersonalizado");

        // Establecemos una prioridad personalizada (1-10)
        thread.setPriority(3);

        // Iniciamos el hilo
        thread.start();

        // Esperamos a que el hilo termine
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}