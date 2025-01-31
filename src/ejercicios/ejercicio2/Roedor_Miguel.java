package ejercicios.ejercicio2;

import utilidades.Color;
import utilidades.Emoji;

import static ejercicios.ejercicio2.Roedor_Miguel.ANSI_RESET;

public class Roedor_Miguel implements Runnable {
    private final String nombre;
    private final int tiempoEnComer;
    private final Color color;
    private final Emoji emoji;

    public static final String ANSI_RESET = "\u001B[0m";

    public Roedor_Miguel(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.color = color;
        this.emoji = emoji;
    }

    public void comer() {
        try {
            System.out.println(color.getCode() + "El ratón " + nombre + emoji.getEmoji() + " ha empezado a alimentarse.");
            Thread.sleep(tiempoEnComer * 1000L);
            System.out.println(color.getCode() + "El ratón " + nombre + emoji.getEmoji() + " ha terminado de alimentarse un total de "+ tiempoEnComer + " segundos.");
        } catch (InterruptedException e) {
            System.out.println("Interrupted exception del método sleep.");
            Thread.currentThread().interrupt();
            return;
        }
    }

    @Override
    public void run() {
        this.comer();
    }
}

class MainRoedores {
    public static void main(String[] args) {
        // Creamos los roedores
        Roedor_Miguel fievel = new Roedor_Miguel("Fievel", 4, Color.CYAN, Emoji.RAT);
        Roedor_Miguel jerry = new Roedor_Miguel("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK);
        Roedor_Miguel pinky = new Roedor_Miguel("Pinky", 3, Color.RED, Emoji.MOUSE);
        Roedor_Miguel mickey = new Roedor_Miguel("Mickey", 6, Color.YELLOW, Emoji.HAMSTER);

        // Creamos los hilos
        Thread hiloFievel = new Thread(fievel);
        Thread hiloJerry = new Thread(jerry);
        Thread hiloPinky = new Thread(pinky);
        Thread hiloMickey = new Thread(mickey);

        // Iniciamos los hilos
        hiloFievel.start();
        hiloJerry.start();
        hiloPinky.start();
        hiloMickey.start();

        // Esperamos a que terminen
        try {
            hiloFievel.join();
            hiloJerry.join();
            hiloPinky.join();
            hiloMickey.join();
        } catch (InterruptedException e) {
            System.out.println(ANSI_RESET + "El hilo principal fue interrumpido.");
            Thread.currentThread().interrupt();
        }

        System.out.println(ANSI_RESET + "\nTodos los roedores han terminado de comer.");
    }
}
