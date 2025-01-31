package ejemplos.threadyrunnable;

public class MyRunnable implements Runnable{
    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        System.out.println("MyRunnable running");
    }
}

class Main {
    public static void main(String[] args) {
        // Para lanzar un hilo:
        // 1) Creamos un objeto de la clase que implementa la interfaz Runnable
        MyRunnable task1 = new MyRunnable();
        // 2) Creamos un objeto de la clase Thread y le pasamos el objeto Runnable
        Thread hilo1 = new Thread(task1, "Hilo 1");
        // 3) Para lanzar el hilo, se utiliza el método start()
        hilo1.start();

        MyRunnable task2 = new MyRunnable();
        Thread hilo2 = new Thread(task2);
        hilo2.start();

// aparte del hilo lanzado, tenemos el hilo principal siempre:
        System.out.println(Thread.currentThread().getName());

    }
}