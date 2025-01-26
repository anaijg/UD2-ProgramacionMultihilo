package ejercicios.ejercicio2;

import utilidades.Color;
import utilidades.Emoji;

public class Roedor_Erik implements Runnable {
    private String nombre;
    private int tiempoEnComer;
    private Color color;
    private Emoji emoji;

    // Constructor
    public Roedor_Erik(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.color = color;
        this.emoji = emoji;
    }

    public void comer() {
        try {
            System.out.println(color.getCode() + "El roedor " + nombre + " " + emoji.getEmoji() + " empieza a alimentarse...");
            Thread.sleep(tiempoEnComer * 1000L);
            System.out.println(color.getCode() + "El roedor " + nombre + " " + emoji.getEmoji() + " ha terminado de alimentarse.");
        } catch (InterruptedException e) {
            System.err.println("El hilo del roedor " + nombre + " fue interrumpido: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        comer();
    }

    public static void main(String[] args) {
        Roedor_Erik fievel = new Roedor_Erik("Fievel", 4, Color.BLACK, Emoji.RAT);
        Roedor_Erik jerry = new Roedor_Erik("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK);
        Roedor_Erik pinky = new Roedor_Erik("Pinky", 3, Color.RED, Emoji.MOUSE);
        Roedor_Erik mickey = new Roedor_Erik("Mickey", 6, Color.YELLOW, Emoji.HAMSTER);

        Thread hiloFievel = new Thread(fievel);
        Thread hiloJerry = new Thread(jerry);
        Thread hiloPinky = new Thread(pinky);
        Thread hiloMickey = new Thread(mickey);

        hiloFievel.start();
        hiloJerry.start();
        hiloPinky.start();
        hiloMickey.start();
    }
}

