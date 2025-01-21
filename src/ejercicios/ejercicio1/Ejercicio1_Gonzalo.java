public class Ejercicio1_Gonzalo implements Runnable {

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
        ThreadGroup grupoActual = hiloActual.getThreadGroup();
        int hilosActivos = grupoActual.activeCount();

        // Creamos un array para almacenar los hilos activos
        Thread[] arrayHilosActivos = new Thread[hilosActivos];
        int hilosReales = grupoActual.enumerate(arrayHilosActivos, true);

        // Mostramos el número total de hilos activos y sus nombres
        System.out.println("\n=== Hilos Activos ===");
        System.out.println("Número de hilos activos: " + hilosReales);
        for (Thread hilo : arrayHilosActivos) {
            if (hilo != null) {
                System.out.println("- " + hilo.getName());
            }
        }
    }

    public static void main(String[] args) {
        // Creamos una instancia de nuestra clase
        Ejercicio1_Gonzalo tarea = new Ejercicio1_Gonzalo();

        // Creamos un nuevo hilo con un nombre personalizado
        Thread hiloPersonalizado = new Thread(tarea, "HiloPersonalizado");

        // Establecemos una prioridad personalizada (1-10)
        hiloPersonalizado.setPriority(Thread.NORM_PRIORITY + 2); // Prioridad alta

        // Iniciamos el hilo
        hiloPersonalizado.start();

        // Esperamos a que el hilo termine
        try {
            hiloPersonalizado.join();
        } catch (InterruptedException e) {
            System.out.println("El hilo principal fue interrumpido.");
        }

        System.out.println("El hilo ha terminado.");
    }
}
