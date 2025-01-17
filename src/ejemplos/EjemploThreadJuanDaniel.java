package ejemplos;

public class EjemploThreadJuanDaniel extends Thread{

    @Override
    public void run() {
        // aqui dentro ponemos el codigo que quieres que ejecute el hilo
        System.out.println("Hilo corriendo " + Thread.currentThread().getName());
    }
}

class Main2{
    public static void main(String[] args) {
        EjemploThreadJuanDaniel hilo1 = new EjemploThreadJuanDaniel();
        hilo1.start();

        EjemploThreadJuanDaniel hilo2 = new EjemploThreadJuanDaniel();
        hilo2.start();

        System.out.println("Hilo principal " + Thread.currentThread().getName());
    }
}
