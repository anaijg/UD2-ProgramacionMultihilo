package ejemplos;

/**
 * dos formas de crear hilos:
 * 1) Implementando Runnable <- esta es la más (recomendada)
 * 2) Extendiendo Thread
 */

// Implementando Runnable
public class EjemploRunnableMiguel implements Runnable{

    @Override
    public void run() {
        // aquí dentro ponemos el código que ejecutara en el hilo
        System.out.println("Hilo corriendo " + Thread.currentThread().getName());
    }
}

// creo la clase main donde se ejecutan los hilos
class Main {
    public static void main(String[] args) {
        // Para lanzar un hilo, hacemos lo siguiente
        // 1) Creo un objeto de la clase que implementa Runnable
        EjemploRunnableMiguel task1 = new EjemploRunnableMiguel();
        // 2) Ahora creamos el objeto Thread pasándole en el constructor la tarea "task"
        Thread Hilo_1 = new Thread(task1);
        Thread Hilo_2 = new Thread(task1, "Hilo negro");
        // 3) Lanzamos el hilo con el método start()
        Hilo_1.start();
        Hilo_2.start();

        // Y siempre anda por detrás el hilo main
        System.out.println("El hilo principal es este: " + Thread.currentThread().getName());
    }
}