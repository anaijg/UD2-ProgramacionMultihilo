package ejercicios.ejercicio6;

import java.util.Random;

public class Corredor implements Runnable {

    private int corredor;

    public Corredor(int corredor) {
        this.corredor = corredor;
    }

    @Override
    public void run() {
        Random generador = new Random();
        int numero = generador.nextInt(10);

        try {
            Thread.sleep(numero * 1000L);
            System.out.println("soy el corredor " + corredor + " corriendo...");
            System.out.println("Terminé");
        } catch (InterruptedException e) {
            System.out.println("Se ha roto el pie " + e.getMessage());
        }
    }
}
