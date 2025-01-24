package ejercicios.ejercicio1;

public class InfoHilo implements Runnable {
    @Override
    public void run() {
        // Obtenemos el hilo actual
        Thread hiloActual = Thread.currentThread();
        // Mostramos la información del hilo actual
        System.out.println("\n === Información del Hilo Actual === \n");
        System.out.println("Nombre del hilo: " + hiloActual.getName());
        System.out.println("Prioridad del hilo: " + hiloActual.getPriority());
        System.out.println("ID del hilo: " + hiloActual.getId());

        int hilosActivos = hiloActual.getThreadGroup().activeCount();
        Thread[] arrayHilosActivos = new Thread[hilosActivos];
        // Contamos el número de hilos activos
        System.out.printf("\nNúmero de hilos activos: %d\n", hilosActivos);
        int hilosReales = Thread.currentThread().getThreadGroup().enumerate(arrayHilosActivos, true);
        for (int i = 0; i < hilosReales; i++) {
            System.out.println((i + 1) + ". " + arrayHilosActivos[i].getName());
        }

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
        // La línea hilo1.setPriority(10); establece la prioridad del hilo hilo1 al
        // valor máximo permitido, que es 10. En Java, los hilos pueden tener una
        // prioridad entre 1 (mínima) y 10 (máxima). La prioridad de un hilo puede
        // influir en el orden en que los hilos son programados para ejecución por
        // el sistema operativo, aunque no garantiza un orden específico.
        hilo1.setPriority(10);
        // Iniciamos el hilo con el metodo start()
        hilo1.start();
        // Esperamos a que el hilo termine
        try {
            // La línea hilo1.join(); en el código de Java hace que el hilo actual
            // espere a que el hilo hilo1 termine su ejecución antes de continuar.
            // Esto es útil cuando necesitas asegurarte de que un hilo específico haya
            // completado su tarea antes de proceder con la ejecución del código en el
            // hilo principal o en otro hilo.
            hilo1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}