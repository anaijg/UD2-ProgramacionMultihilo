public class Ejercicio1_Gonzalo implements Runnable {

    @Override
    public void run() {
        Thread hiloActual = Thread.currentThread();

        System.out.println("=== Información del Hilo Actual ===");
        System.out.println("Nombre del hilo: " + hiloActual.getName());
        System.out.println("Prioridad del hilo: " + hiloActual.getPriority());
        System.out.println("ID del hilo: " + hiloActual.getId());

        ThreadGroup grupoActual = hiloActual.getThreadGroup();
        int hilosActivos = grupoActual.activeCount();

        Thread[] arrayHilosActivos = new Thread[hilosActivos];
        int hilosReales = grupoActual.enumerate(arrayHilosActivos, true);

        System.out.println("\n=== Hilos Activos ===");
        System.out.println("Número de hilos activos: " + hilosReales);
        for (Thread hilo : arrayHilosActivos) {
            if (hilo != null) {
                System.out.println("- " + hilo.getName());
            }
        }
    }

    public static void main(String[] args) {
        Ejercicio1_Gonzalo tarea = new Ejercicio1_Gonzalo();

        Thread hiloPersonalizado = new Thread(tarea, "HiloPersonalizado");

        hiloPersonalizado.setPriority(Thread.NORM_PRIORITY + 2); // Prioridad alta

        hiloPersonalizado.start();

        try {
            hiloPersonalizado.join();
        } catch (InterruptedException e) {
            System.out.println("El hilo principal fue interrumpido.");
        }

        System.out.println("El hilo ha terminado.");
    }
}
