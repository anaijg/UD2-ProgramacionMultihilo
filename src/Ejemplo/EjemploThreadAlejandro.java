package Ejemplo;

public class EjemploThreadAlejandro extends Thread{
    @Override
    public void run() {
        //Aqui dentro ponemos el codigo que quieres que ejecute el hilo
        System.out.println("Hilo corriendo " + Thread.currentThread().getName());
    }
}


class Main{
    public static void main(String[] args) {
        EjemploThreadAlejandro hilo1 = new EjemploThreadAlejandro();
        hilo1.start();

        EjemploThreadAlejandro hilo2 = new EjemploThreadAlejandro();
        hilo2.start();

        System.out.println("hilo principal " + Thread.currentThread().getName());
    }
}
