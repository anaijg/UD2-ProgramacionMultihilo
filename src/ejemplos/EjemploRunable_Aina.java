package ejemplos;

/**
 * Dos formas de crear hilos:
 * 1) Implementando Runable <- la recomendable
 * 2) Extendiendo Thread
 */
public class EjemploRunable_Aina implements Runnable{


    @Override
    public void run() {
        // Aquí dentro ponemos el código que queremos que ejecute el hilo
        System.out.println("Hilo corriendo " + Thread.currentThread().getName());
    }
}

// Creo la clase donde se ejecutan los hilos
class Main {
    public static void main(String[] args) {
        // Para lanzar un hilo
        // 1) Creo un objeto de la clase que implementa Runable
        EjemploRunable_Aina task1 = new EjemploRunable_Aina();
        // 2) Ahora sí, creamos el objeto Thread pasandole en el constructor la "task"
        // Constructor con un parametro
        Thread hilo1 = new Thread(task1);
        // Otro constructor añadiendole un nombre
        Thread hilo2 = new Thread(task1, "Hilo negro");

        // 3) Lanzamos el hilo con el metodo start()
        hilo1.start();
        hilo2.start();

        // Siempre anda por detrás el hilo main
        System.out.println("El hilo principal es este: " + Thread.currentThread().getName());

    }
}
