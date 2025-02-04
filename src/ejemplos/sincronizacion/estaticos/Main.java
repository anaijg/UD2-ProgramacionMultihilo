package ejemplos.sincronizacion.estaticos;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MiClase miClase = new MiClase();
        // Creación del primer hilo
        Thread hilo1 = new Thread(new Task(miClase), "Hilo 1");

        // Creación del segundo hilo
        Thread hilo2 = new Thread(new Task(miClase), "Hilo 2");
        Thread hilo3 = new Thread(new Task(miClase), "Hilo 3");

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

