package ejercicios.ejercicio1;

public class InfoHilo implements Runnable {
    @Override
    public void run() {
        // Obtenemos el hilo actual

        Thread hiloActual = Thread.currentThread();

        // Mostramos la información del hilo actual

        System.out.println("=== Información del Hilo Actual ===");
        System.out.println("Nombre del hilo: " + hiloActual.getName()) ;
        System.out.println("Prioridad del hilo: " + hiloActual.getPriority());
        System.out.println("ID del hilo: " + hiloActual.getId());


        // Contamos el n&uacute;mero de hilos activos
        int hilosActivos = hiloActual.getThreadGroup().activeCount();
        Thread[] arrayHilosActivos = new Thread[hilosActivos];


        // Obtenemos todos los hilos activos
        int hilosReales = Thread.currentThread().getThreadGroup()
                .enumerate(arrayHilosActivos, true);


        // Mostramos el número total de hilos activos y sus nombres
        System.out.println("\n=== Hilos Activos ===");
        System.out.println("Número total de hilos activos: " + hilosReales);

        for (int i = 0; i < hilosReales; i++) {
            System.out.println("Hilo " + i + ": " + arrayHilosActivos[i].getName());
        }
    }

    public static void main(String[] args) {

        System.out.println("Imprimo el main thread: " + Thread.currentThread().getName());
        // Creamos una instancia de nuestra clase
        InfoHilo task1 = new InfoHilo();

        // Creamos un nuevo hilo con un nombre personalizado
        Thread hilo1 = new Thread(task1, "Mi hilo favorito");

        // Establecemos una prioridad personalizada (1-10)
        hilo1.setPriority(10);

        // Iniciamos el hilo
        hilo1.start();

        // Esperamos a que el hilo termine


    }
}