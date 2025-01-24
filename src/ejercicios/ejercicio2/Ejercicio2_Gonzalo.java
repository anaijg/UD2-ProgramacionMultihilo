package ejercicios.ejercicio2;

import utilidades.Color;
import utilidades.Emoji;

public class Ejercicio2_Gonzalo implements Runnable {
    private String nombre;
    private int tiempoEnComer; 
    private Color color;
    private Emoji emoji;

    public Ejercicio2_Gonzalo(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.color = color;
        this.emoji = emoji;
    }

    public void comer() {
        System.out.println(color.getCode() + nombre + " " + emoji.getEmoji() + " ha comenzado a comer." + Color.RESET.getCode());
        try {
            Thread.sleep(tiempoEnComer * 1000); 
        } catch (InterruptedException e) {
            System.out.println("El roedor " + nombre + " fue interrumpido mientras comía.");
        }
        System.out.println(color.getCode() + nombre + " " + emoji.getEmoji() + " ha terminado de comer." + Color.RESET.getCode());
    }

    @Override
    public void run() {
        comer();
    }

    public static void main(String[] args) {
        Ejercicio2_Gonzalo fievel = new Ejercicio2_Gonzalo("Fievel", 4, Color.YELLOW, Emoji.RAT);
        Ejercicio2_Gonzalo jerry = new Ejercicio2_Gonzalo("Jerry", 5, Color.BLUE, Emoji.CHIPMUNK);
        Ejercicio2_Gonzalo pinky = new Ejercicio2_Gonzalo("Pinky", 3, Color.CYAN, Emoji.MOUSE);
        Ejercicio2_Gonzalo mickey = new Ejercicio2_Gonzalo("Mickey", 6, Color.GREEN, Emoji.HAMSTER);

        Thread hiloFievel = new Thread(fievel);
        Thread hiloJerry = new Thread(jerry);
        Thread hiloPinky = new Thread(pinky);
        Thread hiloMickey = new Thread(mickey);

        hiloFievel.start();
        hiloJerry.start();
        hiloPinky.start();
        hiloMickey.start();

        try {
            hiloFievel.join();
            hiloJerry.join();
            hiloPinky.join();
            hiloMickey.join();
        } catch (InterruptedException e) {
            System.out.println("El hilo principal fue interrumpido.");
        }

        System.out.println("Todos los roedores han terminado de comer.");
    }
}

