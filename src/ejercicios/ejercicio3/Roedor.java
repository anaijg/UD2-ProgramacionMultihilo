package ejercicios.ejercicio3;

import utilidades.Color;
import utilidades.Emoji;
import java.util.concurrent.Semaphore;

public class Roedor implements Runnable {
    private String nombre;
    private int tiempoEnComer;
    private Color color;
    private Emoji emoji;
    private Semaphore semaphore;

    public Roedor(String nombre, int tiempoEnComer, Color color, Emoji emoji, Semaphore semaphore) {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.color = color;
        this.emoji = emoji;
        this.semaphore = semaphore;
    }

    public void comer() {
        try {
            semaphore.acquire(); // Intentar adquirir el permiso para comer
            System.out.println(color.getCode() + "El ratón " + nombre + emoji.getEmoji() + " ha empezado a alimentarse.");
            Thread.sleep(tiempoEnComer * (long) 1000);
            System.out.println(color.getCode() + "El ratón " + nombre + emoji.getEmoji() + " ha terminado de alimentarse.");
        } catch (InterruptedException e) {
            System.out.println("Interrupted exception del método sleep.");
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release(); // Liberar el permiso para que otro roedor pueda comer
        }
    }

    @Override
    public void run() {
        this.comer();
    }
}

class MainRoedores {
    public static void main(String[] args) {
        // Crear un semáforo que permita solo 1 hilo (roedor) a la vez
        Semaphore semaphore = new Semaphore(1);

        // Crear los ratones
        Roedor taskFievel = new Roedor("Fievel", 4, Color.BLACK, Emoji.RAT, semaphore);
        Roedor taskJerry = new Roedor("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK, semaphore);
        Roedor taskPinky = new Roedor("Pinky", 3, Color.RED, Emoji.MOUSE, semaphore);
        Roedor taskMickey = new Roedor("Mickey", 6, Color.YELLOW, Emoji.HAMSTER, semaphore);

        // Crear hilos para los roedores
        Thread hiloFievel = new Thread(taskFievel);
        Thread hiloJerry = new Thread(taskJerry);
        Thread hiloPinky = new Thread(taskPinky);
        Thread hiloMickey = new Thread(taskMickey);

        // Iniciar hilos
        hiloFievel.start();
        hiloJerry.start();
        hiloPinky.start();
        hiloMickey.start();
    }
}
