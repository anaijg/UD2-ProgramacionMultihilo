package ejemplos.sincronizacion.compartirdatos.ejemplosynchronized.metodosinstancia;

public class Main {
    public static void main(String[] args) {
        // Creamos dos objetos de MiClase
        MiClase instancia1 = new MiClase("Instancia 1");
        MiClase instancia2 = new MiClase("Instancia 2");

        // Creamos el primer hilo

        Thread hilo1 = new Thread(new Task(instancia1), "hilo 1");

        // Creamos el segundo hilo
        Thread hilo2 = new Thread(new Task(instancia1), "hilo 2");

        // Creamos un tercer hilo con el otro objeto (instancia2)

        Thread hilo3 = new Thread(new Task(instancia2), "hilo 3");

        // Iniciamos los hilos

        hilo1.start();
        hilo2.start();
        hilo3.start();


        // Espera a que ambos hilos finalicen antes de terminar el main

        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
