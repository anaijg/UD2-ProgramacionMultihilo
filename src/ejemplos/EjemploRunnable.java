package ejemplos;

public class EjemploRunnable implements Runnable {

    @Override
    public void run() {
        // Print the name of the thread and a message
        System.out.println("Nombre del hilo: [" + Thread.currentThread().getName() + "]");
        // Print the priority of the current thread
        System.out.println( "  Prioridad del hilo [ " + Thread.currentThread().getName() + "] : [" + Thread.currentThread().getPriority() + "]");
        // Print the name of the thread group to which the current thread belongs
        System.out.println("Grupo al que pertenece el hilo ["+ Thread.currentThread().getName() + "] : " + Thread.currentThread().getThreadGroup().getName());
        // Hilos activos
        System.out.println("Hilos activos: " + Thread.activeCount());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        // 1) Creamos un objeto de la clase que implementa Runnable
        EjemploRunnable task = new EjemploRunnable();
        // 2) Creamos un objeto Thread (un hilo pasándole el objeto Runnable en el constructor)
        // Thread tiene un constructor sobrecargado, así que podemos crear hilos de  varias formas
        // Constructor: Thread(Runnable target)
        Thread hilo1 = new Thread(task);
        hilo1.start();

        // Constructor: Thread(Runnable target, String name)
        Thread hilo2 = new Thread(task, "Hilo 2");
        // Constructor: Thread(String name)
        hilo2.setPriority(5);
        hilo2.start();

        // Y, ojo, que el hilo main anda siempre por detrás
        System.out.println(Thread.currentThread().getName());
    }
}