package ejemplos;

public class EjemploRunnable_Javier implements Runnable {

    @Override
    public void run() {
        System.out.println("hilo corriendo " + Thread.currentThread().getName());
    }
}

class Main {
    public static void main(String[] args) {
        EjemploRunnable_Javier task1 = new EjemploRunnable_Javier();
        Thread hilo1 = new Thread(task1);
        Thread hilo2 = new Thread(task1, "Hilo negro");

        hilo1.start();
        hilo2.start();

        System.out.println("El hilo principal es este: " + Thread.currentThread().getName());
    }
}
