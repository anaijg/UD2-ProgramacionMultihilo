package ejemplos.sincronizacion.noestaticos;

public class Main {
    public static void main(String[] args) {
        MiClase miClase = new MiClase();
        // Creación del primer hilo
        Thread hilo1 = new Thread(new Task(miClase), "Hilo 1");

        // Creación del segundo hilo
        Thread hilo2 = new Thread(new Task(miClase), "Hilo 2");

        // Inicio de los hilos
        hilo1.start();
        hilo2.start();

        // Espera a que ambos hilos finalicen antes de terminar el main
        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            /* Clean up whatever needs to be handled before interrupting  */
            Thread.currentThread().interrupt();
        }
    }
}
