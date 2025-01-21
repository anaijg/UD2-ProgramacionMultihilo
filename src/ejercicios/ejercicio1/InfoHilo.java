package ejercicios.ejercicio1;

public class InfoHilo implements Runnable {
    @Override
    public void run() {
        // Obtenemos el hilo actual
        Thread hiloActual = Thread.currentThread();
        // Mostramos la información del hilo actual
        System.out.println("\n === Información del Hilo Actual === \n");
        System.out.println("Nombre del hilo: ");
        System.out.println("Prioridad del hilo: ");
        System.out.println("ID del hilo: ");


        // Contamos el número de hilos activos
        //int hilosActivos =
        //Thread[] arrayHilosActivos = ;

        // Obtenemos todos los hilos activos
        //int hilosReales = Thread.currentThread().getThreadGroup().enumerate(arrayHilosActivos, true);


        // Mostramos el número total de hilos activos y sus nombres
        System.out.println("\n=== Hilos Activos ===");

    }

    public static void main(String[] args) {
        // Creamos una instancia de nuestra clase
        System.out.println(Thread.currentThread());
        // Creamos un nuevo hilo con un nombre personalizado
         InfoHilo task1 = new InfoHilo();
        // Establecemos una prioridad personalizada (1-10)
        Thread hilo1 = new Thread(task1, "Hilo 1");
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