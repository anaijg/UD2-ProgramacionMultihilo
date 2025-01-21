//Author : Daniel Hernandez Garcia
package ejercicios.ejercicio2;

import utilidades.Color;
import utilidades.Emoji;

public class Roedor_DanielH implements Runnable {
    private String nombre;
    private int tiempoEnComer;
    private Color color;
    private Emoji emoji;

    public Roedor_DanielH(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.color = color;
        this.emoji = emoji;
    }

    @Override
    public void run() {
        comer();
    }

    public void comer() {
        try {
            System.out.println(color.getCode() + "El roedor " + nombre + " " + emoji.getEmoji() + " está comiendo" + Color.RESET.getCode());
            Thread.sleep(tiempoEnComer * 1000);
            System.out.println(color.getCode() + "El roedor " + nombre + " " + emoji.getEmoji() + " ha terminado de comer y se va a echar una siesta" + Color.RESET.getCode());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Main {
    public static void main(String[] args) {
        Roedor_DanielH jerry = new Roedor_DanielH("Jerry", 5, Color.PURPLE, Emoji.CHIPMUNK);
        jerry.run();
        Roedor_DanielH mickey = new Roedor_DanielH("Mickey", 6, Color.RED, Emoji.HAMSTER);
        mickey.run();
        Roedor_DanielH pinky = new Roedor_DanielH("Pinky", 3, Color.CYAN, Emoji.MOUSE);
        pinky.run();
        Roedor_DanielH fievel = new Roedor_DanielH("Fievel", 4, Color.YELLOW, Emoji.RAT);
        fievel.run();
    }
}