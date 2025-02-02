package ejemplos;

public class EjemploThreadMiguel extends Thread{

    @Override
    public void run() {
        // aquí dentro ponemos el código que ejecutara en el hilo
        System.out.println("Hilo corriendo " + Thread.currentThread().getName());
    }
}

class MainEjemploThreadMiguel {
    public static void main(String[] args) {
        EjemploThreadMiguel Hilo1 = new EjemploThreadMiguel();
        Hilo1.start();

        EjemploThreadMiguel Hilo2 = new EjemploThreadMiguel();
        Hilo2.start();

        System.out.println("Hilo principal " + Thread.currentThread().getName());
    }
}
