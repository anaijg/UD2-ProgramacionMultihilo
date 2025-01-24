package ejercicios.ejercicio1;

public class InfoHilo implements Runnable {
    @Override
    public void run() {
        // Obtenemos el hilo actual; se refiere al hilo que estamos ejecutando a partir de la clase InfoHilo
        Thread hilo_actual = Thread.currentThread();



        // Mostramos la información del hilo actual
        System.out.println("=== Información del Hilo Actual ===");
        System.out.println("Nombre del hilo: "+hilo_actual.getName());
        System.out.println("Prioridad del hilo: "+hilo_actual.getPriority());
        System.out.println("ID del hilo: "+hilo_actual.getId());


        // Contamos el número de hilos activos
        int hiloActivos = hilo_actual.getThreadGroup().activeCount();

        //Thread[] arrayHilosActivos = ;
        Thread[] arrayHilosActivos = new Thread[hiloActivos];
        for (int i = 0; i < hiloActivos ; i++) {

        }

        // Obtenemos todos los hilos activos
        System.out.println("\n== Hilos Activos ===");
        int hilosReales = Thread.currentThread().getThreadGroup().enumerate(arrayHilosActivos, true);


        // Mostramos el número total de hilos activos y sus nombres
        System.out.println("\n=== Hilos Activos ===");
        for (int i = 0; i < hilosReales ; i++) {
            System.out.println((i+1) +""+arrayHilosActivos[i].getName());
        }

    }

    public static void main(String[] args) {
        System.out.println("En el main imprimo Thread.currentThread: "+ Thread.currentThread().getName());
        // Creamos una instancia de nuestra clase
        InfoHilo task1 = new InfoHilo();
        // Creamos un nuevo hilo con un nombre personalizado
        //2) Creamos un nuevo hilo con un nombre personalizado
        Thread hilo1 = new Thread(task1,"Mi hilo favorito");

        // Establecemos una prioridad personalizada (1-10)
        hilo1.setPriority(8);

        // Iniciamos el hilo
        hilo1.start();
        // Esperamos a que el hilo termine


    }
}