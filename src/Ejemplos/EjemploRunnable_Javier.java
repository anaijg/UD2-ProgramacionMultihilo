package Ejemplos;

public class EjemploRunnable_Javier implements Runnable {

    @Override
    public void run() {
        System.out.println("hilo corriendo " + Thread.currentThread().getName());
    }
}

class Main {
    public static void main(String[] args) {
        EjemploRunnable_Javier task1 = new EjemploRunnable_Javier();


    }
}
