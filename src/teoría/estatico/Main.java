package teoría.estatico;

public class Main {
    public static void main(String[] args) {
        // Creación del primer hilo
        //Thread hilo1 = new Thread(new Task(), "Hilo 1");
        Task task = new Task();
        Thread hilo1 = new Thread(task, "Hilo 1");
        Thread hilo2 = new Thread(task, "Hilo 2");

        // Creación del segundo hilo
        Thread hilo3 = new Thread(new Task(), "Hilo 3");

        // Inicio de los hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();
        /*
        // Espera a que ambos hilos finalicen antes de terminar el main
        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            /* Clean up whatever needs to be handled before interrupting
            Thread.currentThread().interrupt();
        }
        */
    }
}