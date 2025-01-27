package ejercicios.ejercicio3;

import utilidades.Color;
import utilidades.Emoji;

import java.util.concurrent.Semaphore;

public class Roedor implements Runnable {
    private String nombre;
    private int tiempoEnComer;
    private Color color;
    private Emoji emoji;
    private Semaphore semaforo;

    public Roedor(String nombre, int tiempoEnComer, Color color, Emoji emoji, Semaphore semaforo) {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.color = color;
        this.emoji = emoji;
        this.semaforo = semaforo;
    }

    public void comer() {
        try {
            semaforo.acquire();
            System.out.println(color.getCode() + "El ratón " + nombre + emoji.getEmoji() + " ha empezado a alimentarse.");
            Thread.sleep(tiempoEnComer * (long) 1000);
            System.out.println(color.getCode() + "El ratón " + nombre + emoji.getEmoji() + " ha terminado de alimentarse.");
            semaforo.release();
        } catch (InterruptedException e) {
            System.out.println("Interrupted exception del método sleep.");
            /* Clean up whatever needs to be handled before interrupting  */
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run() {
        this.comer();
    }
}

class MainRoedores {
    public static void main(String[] args) {
        // Creamos un semáforo con un solo permiso para que solo un roedor pueda comer a la vez
        Semaphore semaforo = new Semaphore(1);

        // creamos los ratones
        Roedor taskFievel = new Roedor("Fievel", 4, Color.BLACK, Emoji.RAT, semaforo);
        Roedor taskJerry = new Roedor("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK, semaforo);
        Roedor taskPinky = new Roedor("Pinky", 3, Color.RED, Emoji.MOUSE, semaforo);
        Roedor taskMickey = new Roedor("Mickey", 6, Color.YELLOW, Emoji.HAMSTER, semaforo);

        Thread hiloFievel = new Thread(taskFievel);
        Thread hiloJerry = new Thread(taskJerry);
        Thread hiloPinky = new Thread(taskPinky);
        Thread hiloMickey = new Thread(taskMickey);

        hiloFievel.start();
        hiloJerry.start();
        hiloPinky.start();
        hiloMickey.start();
    }
}
