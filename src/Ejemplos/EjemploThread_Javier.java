package Ejemplos;

public class EjemploThread_Javier extends Thread {
    @Override
    public void run() {
        System.out.println("hilo corriendo " + Thread.currentThread().getName());
    }
}

class Main2 {
    public static void main(String[] args) {
        EjemploThread_Javier hilo1 = new EjemploThread_Javier();
        hilo1.start();

        EjemploThread_Javier hilo2 = new EjemploThread_Javier();
        hilo2.start();

        System.out.println("Hilo principal: " + Thread.currentThread().getName());
    }
}
