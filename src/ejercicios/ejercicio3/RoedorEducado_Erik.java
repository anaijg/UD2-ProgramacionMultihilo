package ejercicios.ejercicio3;

import ejercicios.ejercicio2.Roedor_Erik;
import utilidades.Color;
import utilidades.Emoji;

public class RoedorEducado_Erik implements Runnable {
    private String nombre;
    private int tiempoEnComer;
    private Color color;
    private Emoji emoji;

    // Constructor
    public RoedorEducado_Erik(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
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

    public static void main(String[] args) throws InterruptedException {
        RoedorEducado_Erik fievel = new RoedorEducado_Erik("Fievel", 4, Color.BLACK, Emoji.RAT);
        RoedorEducado_Erik jerry = new RoedorEducado_Erik("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK);
        RoedorEducado_Erik pinky = new RoedorEducado_Erik("Pinky", 3, Color.RED, Emoji.MOUSE);
        RoedorEducado_Erik mickey = new RoedorEducado_Erik("Mickey", 6, Color.YELLOW, Emoji.HAMSTER);

        Thread hiloFievel = new Thread(fievel);
        Thread hiloJerry = new Thread(jerry);
        Thread hiloPinky = new Thread(pinky);
        Thread hiloMickey = new Thread(mickey);

        hiloFievel.start();
        hiloFievel.join();
        hiloJerry.start();
        hiloJerry.join();
        hiloPinky.start();
        hiloPinky.join();
        hiloMickey.start();
        hiloMickey.join();
    }
}


