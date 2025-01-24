package ejemplos;

import ejercicios.ejercicio1.Ejercicio1_Erik;

public class EjemploRunnable implements Runnable {

    @Override
    public void run() {
        System.out.printf("Hilo corriendo: %s\n", Thread.currentThread().getName());
    }
}
class MainRunnable {
    public static void main(String[] args) {
        EjemploRunnable task = new EjemploRunnable();
        Thread hilo1 = new Thread(task);
        Thread hilo2 = new Thread(task, "Hilo negro");
        hilo1.start();
        hilo2.start();
        System.out.printf("Hilo hilo1: %s\n", hilo1.getState());
        System.out.printf("El Main es este: %s\n", Thread.currentThread().getName());
    }
}