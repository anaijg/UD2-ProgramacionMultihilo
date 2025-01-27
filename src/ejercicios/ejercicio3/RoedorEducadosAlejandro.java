package ejercicios.ejercicio3;

import utilidades.Color;
import utilidades.Emoji;

public class RoedorEducadosAlejandro implements Runnable{
    private String nombre;
    private int tiempoEnComer;
    private Color color;
    private Emoji emoji;

    public RoedorEducadosAlejandro(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.color = color;
        this.emoji = emoji;
    }

    public void comer(){
        try {
            System.out.println(color.getCode() + "El ratón " + nombre + emoji.getEmoji() + " ha empezado a alimentarse.");
            Thread.sleep(tiempoEnComer * (long) 1000);
            System.out.println(color.getCode() + "El ratón " + nombre + emoji.getEmoji() + " ha terminado de alimentarse.");
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
        RoedorEducadosAlejandro taskFievel = new RoedorEducadosAlejandro("Fievel", 4, Color.BLACK, Emoji.RAT);
        RoedorEducadosAlejandro taskJerry = new RoedorEducadosAlejandro("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK);
        RoedorEducadosAlejandro taskPinky = new RoedorEducadosAlejandro("Pinky", 3, Color.RED, Emoji.MOUSE);
        RoedorEducadosAlejandro taskMickey = new RoedorEducadosAlejandro("Mickey", 6, Color.YELLOW, Emoji.HAMSTER);
        Thread hiloFievel = new Thread(taskFievel);
        Thread hiloJerry = new Thread(taskJerry);
        Thread hiloPinky = new Thread(taskPinky);
        Thread hiloMickey = new Thread(taskMickey);

        hiloFievel.start();
        try {
            hiloFievel.join();
        } catch (InterruptedException e) {
            System.out.println("Hilo Fievel interrumpido");
        }

        hiloJerry.start();
        try {
            hiloJerry.join();
        } catch (InterruptedException e) {
            System.out.println("Hilo Jerry interrumpido");
        }

        hiloPinky.start();
        try {
            hiloPinky.join();
        } catch (InterruptedException e) {
            System.out.println("Hilo pinky interrumpido");
        }

        hiloMickey.start();
        try {
            hiloMickey.join();
        } catch (InterruptedException e) {
            System.out.println("Hilo Mickey interrumpido");
        }

    }
}
