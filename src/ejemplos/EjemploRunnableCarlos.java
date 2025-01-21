package ejemplos;

/**
 * dos formas de crear hilos:
 * 1) Implementando Runnable <- esta es la (recomendada)
 * 2) Extendiendo Thread
 */
public class EjemploRunnableCarlos implements Runnable{

    @Override
    public void run() {
        // aquí dentro ponemos el código que quieres que ejecute el hilo
        System.out.println("Hilo corriendo " + Thread.currentThread().getName());
    }
}

// creo la clase donde se ejecutan los hilos
class Main {
    public static void main(String[] args) {
        // Para lanzar un hilo:
        // 1) Creo un objeto de la clase que implementa Runnable
        EjemploRunnableCarlos task1 = new EjemploRunnableCarlos();
        // 2) Ahora si, creamos el objeto Thread pasándole en el constructor la tarea "task"
        Thread hilo1 = new Thread(task1);
        Thread hilo2 = new Thread(task1, "hilo negro");
        // 3) Lanzamos el hilo con el método start()
        hilo1.start();
        hilo2.start();

        // Y siempre anda por detrás el hilo main
        System.out.println("El hilo principal es este: " + Thread.currentThread().getName());
    }
}


