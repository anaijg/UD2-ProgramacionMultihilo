package Ejemplos;

public class EjemploRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("hilo corriendo " + Thread.currentThread().getName());
    }
}

class Main {
    public static void main(String[] args) {
        EjemploRunnable task1 = new EjemploRunnable();


    }
}
