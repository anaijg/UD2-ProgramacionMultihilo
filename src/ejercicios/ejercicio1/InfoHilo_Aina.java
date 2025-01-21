package ejercicios.ejercicio1;

public class InfoHilo_Aina implements Runnable {
    @Override
    public void run() {
        // Obtenemos el hilo actual
        //Aquí se refiere al hilo que estamos ejecutando a partir de la clase

        Thread hiloActual = Thread.currentThread();

        // Mostramos la información del hilo actual
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

        //Aquí nos referimos al hilo de main
        System.out.println("En el main imprimo Thread.currentThread -> " + Thread.currentThread().getName());

        // Creamos una instancia de nuestra clase
        // 1) Creamos un objeto de la clase que implementa Runable
        InfoHilo_Aina task1 = new InfoHilo_Aina();

        // Creamos un nuevo hilo con un nombre personalizado
        // Creamos un hilo y le pasamos en el constructor la task
        Thread hilo1 = new Thread(task1, "Mi hilo favorito");
        hilo1.start();

        // Establecemos una prioridad personalizada (1-10)

        // Iniciamos el hilo

        // Esperamos a que el hilo termine

    }
}
