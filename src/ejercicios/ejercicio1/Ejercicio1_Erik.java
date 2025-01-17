package ejercicios.ejercicio1;

/**
 * 1. Haz un programa que dentro de un hilo muestre: nombre del hilo, su prioridad, y los hilos activos.
 * <p>
 * Lanza al menos 5 hilos con diferentes nombres y prioridades.
 * <p>
 * Añade lo necesario para que no empiece a ejecutarse un hilo hasta que no haya finalizado el anterior.
 */

public class Ejercicio1_Erik implements Runnable {

    @Override
    public void run() {
        System.out.printf("Hilo corriendo: %s\n", Thread.currentThread().getName());
    }
}

class Main {
    public static void main(String[] args) {
        Ejercicio1_Erik task = new Ejercicio1_Erik();
        Thread hilo1 = new Thread(task);
        Thread hilo2 = new Thread(task, "Hilo negro");
        hilo1.start();
        hilo2.start();
        System.out.printf("Hilo hilo1: %s\n", hilo1.getState());
        System.out.printf("El Main es este: %s\n", Thread.currentThread().getName());
    }
}