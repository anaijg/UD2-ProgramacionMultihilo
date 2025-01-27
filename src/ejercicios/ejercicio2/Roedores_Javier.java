package ejercicios.ejercicio2;


import utilidades.Color;
import utilidades.Emoji;

public class Roedores_Javier implements Runnable {

    private String nombre;
    private int tiempoEnComer;
    private Color color;
    private Emoji emoji;

    public Roedores_Javier(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.color = color;
        this.emoji = emoji;
    }

    public void comer() {
        try {
            System.out.println(color.getCode() + nombre + " " + emoji.getEmoji() + " empieza a alimentarse." + Color.RESET.getCode());

            Thread.sleep(tiempoEnComer * 1000L);

            System.out.println(color.getCode() + nombre + " " + emoji.getEmoji() + " ha terminado de alimentarse." + Color.RESET.getCode());
        } catch (InterruptedException e) {
            System.err.println("El hilo de " + nombre + " fue interrumpido.");
            Thread.currentThread().interrupt();
        }
    }
    @Override
    public void run() {
        comer();
    }
}

class Main {
    public static void main(String[] args) {
        // Crear roedores
        Roedores_Javier fievel = new Roedores_Javier("Fievel", 4, Color.RED, Emoji.RAT);
        Roedores_Javier jerry = new Roedores_Javier("Jerry", 5, Color.YELLOW, Emoji.CHIPMUNK);
        Roedores_Javier pinky = new Roedores_Javier("Pinky", 3, Color.BLUE, Emoji.MOUSE);
        Roedores_Javier mickey = new Roedores_Javier("Mickey", 6, Color.GREEN, Emoji.HAMSTER);

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
