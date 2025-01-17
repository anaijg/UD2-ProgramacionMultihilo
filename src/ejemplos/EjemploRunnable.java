package ejemplos;

/**
 * dos formas de crear hilos
 * 1) Implementando Runnable <- la buena
 * 2) Extendiendo Thread
 */
public class EjemploRunnable implements Runnable{

    @Override
    public void run() {
        // aqui dentro ponemos el codigo que quieres que ejecute el hilo
        System.out.println("Hilo corriendo " + Thread.currentThread().getName());
    }
}

// creo la clase donde se ejecutan los hilos
class Main{
    public static void main(String[] args) {
        // Para lanzar un hilo
        // 1) Creo un objeto de la clase que implementa Runnable
        EjemploRunnable task1 = new EjemploRunnable();
        // 2) ahora si, creamos el objeto Thread pasandole en el constructor la task
        Thread hilo1 = new Thread(task1);
        Thread hilo2 = new Thread(task1, "Hilo negro");
        // 3) Lanzamos el hilo con el metodo start()
        hilo1.start();
        hilo2.start();

        // y siempre anda por detras el hilo main
        System.out.println("El hilo principal es este: " + Thread.currentThread().getName());
    }
}

