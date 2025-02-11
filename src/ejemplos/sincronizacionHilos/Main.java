package ejemplos.sincronizacionHilos;

public class Main {
    public static void main(String[] args) {
        // Creamos dos objetos de MiClase
        MiClase instancia1 = new MiClase("Instancia 1");
        MiClase instancia2 = new MiClase("Instancia 2");

        // Creación del primer hilo
        Thread hilo1 = new Thread(new Task(instancia1), "Hilo 1");

        // Creación del segundo hilo
        Thread hilo2 = new Thread(new Task(instancia1), "Hilo 2");

        // Creación del terceer hilo con el otro objeto
        Thread hilo3 = new Thread(new Task(instancia2), "Hilo 3");

        // Inicio de los hilos
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
            /* Clean up whatever needs to be handled before interrupting  */
            Thread.currentThread().interrupt();
        }
    }
}