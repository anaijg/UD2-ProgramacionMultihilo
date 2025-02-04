package ejercicios.ejercicio3Bis;

import ejercicios.ejercicio2Bis.RoedorS;
import utilidades.Color;
import utilidades.Emoji;

public class RoedoresEdu implements Runnable{
    private String nombre;
    private int tiempoComer;
    private Color color;
    private Emoji emoji;

    public RoedoresEdu(String nombre, int tiempoComer, Color color, Emoji emoji) {
        this.nombre = nombre;
        this.tiempoComer = tiempoComer;
        this.color = color;
        this.emoji = emoji;
    }

    @Override
    public void run() {
        comer();

    }
    public void comer() {
        System.out.println(color.getCode() + nombre + emoji.getEmoji() + "Ha empezado a alimentarse ");

        try {
            Thread.sleep(tiempoComer * 1000L);


        } catch (InterruptedException e) {
            System.out.println("Error" + e.getMessage());
        }

        System.out.println(color.getCode() + nombre + emoji.getEmoji() + "Ha terminado de alimentarse ");


    }

    public static void main(String[] args) {
        RoedorS fievel = new RoedorS("Fievel", 4, Color.BLUE, Emoji.RAT);
        RoedorS jerry = new RoedorS("Jerry ", 5, Color.RED, Emoji.CHIPMUNK);
        RoedorS pinky = new RoedorS("Pinky ", 3, Color.GREEN, Emoji.MOUSE);
        RoedorS mickey = new RoedorS("Micky", 6, Color.BLACK, Emoji.HAMSTER);

        Thread hiloFievel = new Thread(fievel, "Fievel");
        Thread hiloJerry = new Thread(jerry, "Jerry");
        Thread hiloPinky = new Thread(pinky, "Pinky");
        Thread hiloMickey = new Thread(mickey, "Mickey");

        try {
            hiloFievel.start();
            hiloFievel.join();
            hiloJerry.start();
            hiloJerry.join();
            hiloPinky.start();
            hiloPinky.join();
            hiloMickey.start();
            hiloMickey.join();

        } catch (InterruptedException e) {
            System.out.println("Error " + e.getMessage());

        }


    }
}

