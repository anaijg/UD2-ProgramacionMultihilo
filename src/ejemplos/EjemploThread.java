package ejemplos;

public class EjemploThread extends Thread {
    @Override
    public void run() {
        // aqui dentro ponemos el codigo que quieres que ejecute el programa el hilo
        System.out.println("Hilo corriendo"+ Thread.currentThread().getName());
    }
    class Main2{
        public static void main(String[] args) {
//
            EjemploThread hilo1 = new EjemploThread();
            hilo1.start();
            EjemploThread hilo2 = new EjemploThread();
            hilo2.start();

            System.out.println("Hilo principal: "+ Thread.currentThread().getName());
        }
    }
}