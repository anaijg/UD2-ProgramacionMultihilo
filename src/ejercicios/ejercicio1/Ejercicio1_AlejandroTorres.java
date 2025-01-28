package ejercicios.ejercicio1;

public class Ejercicio1_AlejandroTorres implements Runnable {
    @Override
    public void run() {

        Thread hiloActual = Thread.currentThread();

        // Mostramos la información del hilo actual
        System.out.println("=== Información del Hilo Actual ===");
        System.out.println("Nombre del hilo: " + hiloActual.getName());
        System.out.println("Prioridad del hilo: "+ hiloActual.getPriority()); // mayor prioridad: 10, menor prioridad: 1
        System.out.println("ID del hilo: "+ hiloActual.getId());


        // Contamos el número de hilos
        int hilosActivos = hiloActual.getThreadGroup().activeCount();
        Thread[] arrayHilosActivos = new Thread[hilosActivos];

        // Obtenemos todos los hilos
        int hilosReales = Thread.currentThread().getThreadGroup().enumerate(arrayHilosActivos, true);


        //Mostrar hilos
        System.out.println("\n=== Hilos Activos ===");
        for (int i = 0; i < hilosReales; i++) {
            System.out.println((i + 1)+ " " + arrayHilosActivos[i].getName());
        }

    }

    public static void main(String[] args) {
        System.out.println("En el main imprimo Thread.currentThread: " + Thread.currentThread().getName());

        Ejercicio1_AlejandroTorres task1 = new Ejercicio1_AlejandroTorres();


        Thread hilo1 = new Thread(task1, "Prueba hilo");


        hilo1.setPriority(Thread.MAX_PRIORITY);

        // Iniciamos el hilo
        hilo1.start();

        try {
            hilo1.join();
        } catch (InterruptedException e) {
            System.out.println("El hilo principal fue interrumpido.");
        }
    }
}