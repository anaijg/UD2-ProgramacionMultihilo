package ejercicios.ejemplo;

public class EjemploThreadSisa extends Thread{
    @Override
    public void run() {
        System.out.println("Hilo corriendo: " + Thread.currentThread().getName());
        Thread.currentThread().getName();
    }
}
class Main1{
    public static void main(String[] args) {
        EjemploThreadSisa hilo1 = new EjemploThreadSisa();
        hilo1.start();
        System.out.println("El hilo principal: " +
                Thread.currentThread().getName());
    }
}

