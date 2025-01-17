package ejemplos;

public class EjemploRunnable_DanielH implements Runnable {

    @Override
    public void run() {
        System.out.println("Hilo corriendo" + Thread.currentThread().getName());

    }


}

//creo la clase donde se ejecutan los hilos
class Main {
    public static void main(String[] args) {
        //Para lanzar un hilo
        //1)Creo un objeto de la clase que implementa Runnable
        EjemploRunnable_DanielH task1 = new EjemploRunnable_DanielH();
        //2)Ahora si , creamos el objeto Thread pasando por el constructor la tarea
        Thread hilo1 = new Thread(task1);
        Thread hilo2 = new Thread(task1, "Hilo 2");
        //3)Ejecutamos el hilo con el metodo Start()
        hilo1.start();
        hilo2.start();

        System.out.println("El main es este: " + Thread.currentThread().getName());
    }
}