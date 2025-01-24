package ejemplos;

public class EjemploThread extends Thread {
    @Override
    public void run() {
        System.out.printf("Hilo corriendo: %s\n", Thread.currentThread().getName());
    }
}

class MainThread {
    public static void main(String[] args) {
        EjemploThread hilo1 = new EjemploThread();
        hilo1.start();
        EjemploThread hilo2 = new EjemploThread();
        hilo2.start();

        System.out.printf("Hilo principal: %s\n", Thread.currentThread().getName());
    }
}
