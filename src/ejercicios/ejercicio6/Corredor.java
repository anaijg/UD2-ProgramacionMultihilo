package ejercicios.ejercicio6;

import java.util.Random;

public class Corredor extends Thread{
    public Corredor(String name) {
        super(name);

    }

    Random random = new Random();
    @Override
    public void run() {
        try {
            System.out.println("soy el corredor "+getName() + ", corriendo...");
            Thread.sleep(random.nextInt(2000));
            System.out.println("termine");
        } catch (InterruptedException e) {
            System.out.println("Error " + e.getMessage());;
        }
    }
}
