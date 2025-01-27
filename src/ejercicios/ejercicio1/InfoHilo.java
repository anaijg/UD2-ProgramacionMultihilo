package ejercicios.ejercicio1;

public class InfoHilo implements Runnable {
    @Override
    public void run() {
        Thread hiloActual = Thread.currentThread();

        System.out.println("=== Información del Hilo Actual ===");
        System.out.println("Nombre del hilo: " + hiloActual.getName());
        System.out.println("Prioridad del hilo: " + hiloActual.getPriority());
        System.out.println("ID del hilo: " + hiloActual.getId());

        int hilosActivos = Thread.activeCount();
        Thread[] arrayHilosActivos = new Thread[hilosActivos];

        int hilosReales = Thread.currentThread().getThreadGroup().enumerate(arrayHilosActivos, true);

        System.out.println("\n=== Hilos Activos (" + hilosReales + ") ===");
        for (Thread hilo : arrayHilosActivos) {
            if (hilo != null) {
                System.out.println(" - " + hilo.getName());
            }
        }
    }

    public static void main(String[] args) {
        InfoHilo tarea = new InfoHilo();

        Thread miHilo = new Thread(tarea, "MiHiloPersonalizado");

        miHilo.setPriority(Thread.MAX_PRIORITY);

        miHilo.start();

        try {
            miHilo.join();
        } catch (InterruptedException e) {
            System.out.println("El hilo principal fue interrumpido.");
        }
    }
}
