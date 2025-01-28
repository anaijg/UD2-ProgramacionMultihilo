package ejercicios.ejercicio1;

public class InfoHiloRobert implements Runnable {
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
         int hilosActivos = hiloActual.getThreadGroup().activeCount();
         Thread[] arrayHilosActivos = new Thread[hilosActivos];

        // Obtenemos todos los hilos activos
        int hilosReales = Thread.currentThread().getThreadGroup().enumerate(arrayHilosActivos, true);


        // Mostramos el número total de hilos activos y sus nombres
        System.out.println("\n=== Hilos Activos ===");
        for (int i = 0; i < hilosActivos; i++) {
            System.out.println((i + 1) + ". " + arrayHilosActivos[i].getName());
        }

    }

    public static void main(String[] args) {
        // Creamos una instancia de nuestra clase
        InfoHiloRobert task1 = new InfoHiloRobert();
        // Creamos un nuevo hilo con un nombre personalizado
        Thread hilo1 = new Thread(task1, "Nuevo hilo");
        // Establecemos una prioridad personalizada (1-10)
        hilo1.setPriority(5);
        // Iniciamos el hilo
        hilo1.start();
        // Esperamos a que el hilo termine
        try {
            hilo1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}