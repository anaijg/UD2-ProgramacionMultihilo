//Author: Daniel Hernández Garcia
package ejercicios.ejercicio1;

public class InfoHilo_DanielH implements Runnable {
    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        System.out.println("=== Información del Hilo Actual ===");
        System.out.println("Nombre del hilo: " + currentThread.getName());
        System.out.println("Prioridad del hilo: " + currentThread.getPriority());
        System.out.println("ID del hilo: " + currentThread.getId());

        int activeThreads = Thread.activeCount();
        Thread[] activeThreadArray = new Thread[activeThreads];
        int realActiveThreads = Thread.currentThread().getThreadGroup().enumerate(activeThreadArray, true);

        System.out.println("\n=== Hilos Activos (" + realActiveThreads + ") ===");
        for (int i = 0; i < realActiveThreads; i++) {
            System.out.println((i + 1) + ". " + activeThreadArray[i].getName());
        }
    }

    public static void main(String[] args) {
        InfoHilo_DanielH infoHilo = new InfoHilo_DanielH();
        Thread thread = new Thread(infoHilo, "MiHiloPersonalizado");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}