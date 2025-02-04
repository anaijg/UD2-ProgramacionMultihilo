package ejercicios.ejercicio1Bis;

public class InfoHilo implements Runnable{

    @Override
    public void run() {


        System.out.println("=== Información del Hilo Actual ===");
        System.out.println("Nombre del hilo: " + Thread.currentThread().getName());
        System.out.println("Prioridad del hilo: " + Thread.currentThread().getPriority());
        System.out.println("ID del hilo: " + Thread.currentThread().threadId());
        System.out.println("\n");


        System.out.println(" === Hilos Activos === (" + Thread.activeCount() + ")");
        Thread[] arrayHilos = new Thread[Thread.activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(arrayHilos, true);
        for (int i = 0; i < arrayHilos.length; i++) {
            System.out.println((i + 1) + ". " +  arrayHilos[i].getName());

        }

    }

    public static void main(String[] args) {
        InfoHilo Task1 = new InfoHilo();
        Thread hilo1 = new Thread(Task1, "Hilo1");
        hilo1.setPriority(10);
        hilo1.start();
        try {
            hilo1.join();
        } catch (InterruptedException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}

