package ejemplos;

public class EjemploRunnable implements Runnable{
@Override
    public void run(){
    System.out.println("Hilo corriente " +Thread.currentThread().getName());
}
}

class Main {
    public static void main(String[] args) {
        EjemploRunnable task1 = new EjemploRunnable();
        // 2) Ahora si, creamos el objeto Thread pasándole en el constructor la "task"
        Thread hilo1 = new Thread(task1);
        Thread hilo2 = new Thread(task1,"Hilo negro");
        // 3) Lanzamos el hilo con el método start()
        hilo1.start();
        hilo2.start();

        // y siempre anda por detrás el hilo main
        System.out.println("El hilo principal es este: " +Thread.currentThread().getName());
    }
}
