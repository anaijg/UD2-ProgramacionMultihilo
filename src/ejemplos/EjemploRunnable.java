package ejemplos;

public class EjemploRunnable implements Runnable{
    @Override
    public void run(){
        System.out.println("Hilo corriendo "+ Thread.currentThread().getName());
    }
}

class Main {
    public static void main(String[] args) {
        EjemploRunnable task1 = new EjemploRunnable();
        Thread hilo1 = new Thread(task1);
        Thread hilo2 = new Thread(task1, "Hilo negro");

        hilo1.start();
        hilo2.start();

        System.out.println("El hilo principal es este: " + Thread.currentThread().getName());
    }
}