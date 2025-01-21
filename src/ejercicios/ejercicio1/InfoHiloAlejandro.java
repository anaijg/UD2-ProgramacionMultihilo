package ejercicios.ejercicio1;

public class InfoHiloAlejandro implements Runnable {
    @Override
    public void run() {
        // Obtenemos el hilo actual

        // Mostramos la información del hilo actual
        Thread hiloActual = Thread.currentThread();
        System.out.println("=== Información del Hilo Actual ===");
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
        System.out.println("En el main imprimo Thread.currentThread" + Thread.currentThread());
        // Creamos una instancia de nuestra clase
        //1) creamos el objeto tipo Runnable
        InfoHiloAlejandro task1 = new InfoHiloAlejandro();

        // Creamos un nuevo hilo con un nombre personalizado
        //2) Creamos un hilo y le pasamos en el constructor la task
        Thread hilo1 = new Thread(task1, "Mi hilo favorito");
        hilo1.start();
        // Establecemos una prioridad personalizada (1-10)

        // Iniciamos el hilo

        // Esperamos a que el hilo termine

    }
}