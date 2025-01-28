package ejercicios.ejercicio2;

import utilidades.Color;
import utilidades.Emoji;

public class RoedorRobert implements Runnable{
    private String nombre;
    private int tiempoEnComer;
    private Color color;
    private Emoji emoji;

    public RoedorRobert(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.color = color;
        this.emoji = emoji;
    }

    public void comer(){
        try {
            System.out.println(color.getCode() + "El ratón " + nombre + emoji.getEmoji() + " ha empezado a alimentarse.");
            Thread.sleep(tiempoEnComer * (long) 1000);
            System.out.println(color.getCode() + "El ratón " + nombre + emoji.getEmoji() + " ha terminado de zampar.");
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

class MainRoedores{
    public static void main(String[] args) {
        // creamos los ratones
        RoedorRobert taskFievel = new RoedorRobert("Fievel", 4, Color.BLACK, Emoji.RAT);
        RoedorRobert taskJerry = new RoedorRobert("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK);
        RoedorRobert taskPinky = new RoedorRobert("Pinky", 3, Color.RED, Emoji.MOUSE);
        RoedorRobert taskMickey = new RoedorRobert("Mickey", 6, Color.YELLOW, Emoji.HAMSTER);
        // creamos los hilos
        Thread hiloFievel = new Thread(taskFievel);
        Thread hiloJerry = new Thread(taskJerry);
        Thread hiloPinky = new Thread(taskPinky);
        Thread hiloMickey = new Thread(taskMickey);

        try {
            hiloMickey.start();
            hiloFievel.start();
            hiloPinky.start();
            hiloJerry.start();

            hiloPinky.join();
            hiloFievel.join();
            hiloJerry.join();
            hiloMickey.join();

        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception al lanzar el join() para el roedor " + hiloFievel.getName());
        }

    }
}
