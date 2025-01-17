package ejemplos;

/**
 * Dos formas de crear hilos:
 * 1) Implemntando RUnnable <-La buena
 * 2) Extendiendo Thread
 */
public class EjemploRunnable_Andre implements Runnable {
    @Override
    public void run() {
        // aqui dentro ponemos el codigo que quieres que ejecute el programa el hilo
        System.out.println("Hilo corriendo"+ Thread.currentThread().getName());
    }
       // creo la clase donde se ejecutan los hilos

    class Main {
        public static void main(String[] args) {
//        Para lanzar un hlo:
//        1)Creo un objeto de la clase que implementa
//        Runnanble
        EjemploRunnable_Andre task = new EjemploRunnable_Andre();
//        Ahora si, creamos el objeto Thread pasándole en el contructor la "task"
        Thread hilo1 = new Thread(task);
        Thread hilo2 = new Thread(task,"Hilo negro");
//        3) Lanzamos el hilo con el metood start()
        hilo1.start();
        hilo2.start();

//        Y SIEMPRE ANDA POR DETRÁS EL HILO MAIN
        System.out.println("El Hilo principal   es este :"+Thread.currentThread().getName());
        }
    }
}
