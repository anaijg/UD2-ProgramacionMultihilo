package ejemplos.threadyrunnable;

public class EjemploThread implements Runnable {
    private String name;

    public EjemploThread(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        // Get the name of the current thread

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

        // Using different constructors of Thread class
        // Constructor: Thread()
        Thread hilo1 = new Thread(new EjemploThread("Hilo1"));
        hilo1.setPriority(1);
        hilo1.start();


        // Constructor: Thread(Runnable target)
        Thread hilo2 = new Thread(new EjemploThread("Hilo2"));
        hilo2.setPriority(5);
        hilo2.start();

        // Constructor: Thread(String name)
        Thread hilo3 = new Thread(new EjemploThread("Hilo3"), "Hilo3");
        hilo3.setPriority(10);
        hilo3.start();

        // Constructor: Thread(Runnable target, String name)
        Thread hilo4 = new Thread(new EjemploThread("Hilo4"), "Hilo4");
        hilo4.setPriority(5);
        hilo4.start();
    }
}