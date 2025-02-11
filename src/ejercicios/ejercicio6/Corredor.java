package ejercicios.ejercicio6;

import java.util.Random;

public class Corredor implements Runnable{
    private int dorsal;

    public Corredor() {}
    public Corredor(int dorsal) {
        this.dorsal = dorsal;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    @Override
    public void run() {
        try{
            Random randomNumbers = new Random();
            int tiempoEnComer = randomNumbers.nextInt(11);
            System.out.println("Soy el corredor  "+ dorsal+ " corriendo...");
            Thread.sleep(tiempoEnComer * (long) 1000);
            System.out.println("Terminé.");
        }catch (InterruptedException e) {
            System.out.println("Interrupted exception del método sleep.");
            /* Clean up whatever needs to be handled before interrupting  */
            Thread.currentThread().interrupt();
        }
    }
}
