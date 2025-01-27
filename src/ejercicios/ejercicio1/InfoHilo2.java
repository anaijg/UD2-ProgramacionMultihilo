package ejercicios.ejercicio1;

public class InfoHilo2 implements Runnable{
    @Override
    public void run() {
        Thread hiloActual = Thread.currentThread();

        System.out.println("====Hilo actual====");
        System.out.println("Nombre del hilo: " + hiloActual.getName());
        System.out.println("Prioridad del hilo: " + hiloActual.getPriority());
        System.out.println("ID del hilo: " + hiloActual.threadId());

        // Número de hilos activos:
        int numeroHilos = hiloActual.getThreadGroup().activeCount();
        Thread[] arrayHilosActivos = new Thread[numeroHilos];
        Thread.currentThread().getThreadGroup().enumerate(arrayHilosActivos, true);

        System.out.println("\n====Hilos activos====");
        for (int i = 0; i < arrayHilosActivos.length ; i++) {
            System.out.println(arrayHilosActivos[i].getName());
        }


    }

    public static void main(String[] args) {
        // Aquí se imprime el nombre del hilo principal:
        System.out.println("En el main imprimo Thread.currentThread " + Thread.currentThread().getName());

        // Aquí cremaos un objeto de la clase que implementa Runnable, este objeto (task1) no es el hilo en sí, sino la tarea o trabajo que ejecutará el hilo (las instrucciones que hemos declarado en el método run)
        InfoHilo2 task1 = new InfoHilo2();

        // Aquí si creamos un hilo y le damos un nombre (al tener varios constructores, es decir, esta sobrecargado, elegimos nombrar el hilo):
        Thread hilo1 = new Thread(task1, "Mi hilo favorito");

        // Asignar prioridad al hilo (min 1, max 10)
        hilo1.setPriority(8);

        // Iniciamos el hilo
        hilo1.start();

        // Esperamos a que termine
        try {
            hilo1.join();

        }catch (InterruptedException e) {
            System.out.println("Ha habido un error " + e.getMessage());
        }
    }
}



