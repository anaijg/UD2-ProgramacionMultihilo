package ejemplos;

public class EjemploThread_DanielH implements Runnable {

    @Override
    public void run() {
        //aqui dentro ponemos el codigo que quieres que ejecute el hilo
        System.out.println("Hilo corriendo" + Thread.currentThread().getName());
    }
}

class Main2 {
    public static void main(String[] args) {
        EjemploThread_DanielH hilo1 = new EjemploThread_DanielH();
        Thread thread1 = new Thread(hilo1);
        thread1.start();
    }
}