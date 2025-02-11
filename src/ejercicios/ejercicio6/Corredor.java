package ejercicios.ejercicio6;

public class Corredor extends Thread {
    private int numDorsal;
    private int tiempoAleatorio;
    private Thread previousRunner;

    public Corredor(int numDorsal, int tiempoAleatorio, Thread previousRunner) {
        this.numDorsal = numDorsal;
        this.tiempoAleatorio = tiempoAleatorio;
        this.previousRunner = previousRunner;
    }

    @Override
    public void run() {
        try {
            if (previousRunner != null) {
                previousRunner.join();
            }
            System.out.println("Soy el corredor " + numDorsal + ", corriendo...");
            Thread.sleep(tiempoAleatorio);
            System.out.println("Terminé.");
        } catch (InterruptedException e) {
            System.out.println("El corredor " + numDorsal + " fue interrumpido.");
        }
    }
}