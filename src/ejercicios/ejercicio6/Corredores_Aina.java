package ejercicios.ejercicio6;

import java.util.Random;

public class Corredores_Aina extends Thread{
    private static final Random random = new Random();

    public Corredores_Aina(String name) {
        super(name);
    }

    @Override
    public void run() {

        try {
            System.out.println("Soy el corredor " + getName() + ", corriendo...");
            Thread.sleep(random.nextInt(2000) + 1000);
        } catch (InterruptedException e) {
            e.getMessage();
            Thread.currentThread().interrupt();
        }

        System.out.println("Terminé.");
    }
}
