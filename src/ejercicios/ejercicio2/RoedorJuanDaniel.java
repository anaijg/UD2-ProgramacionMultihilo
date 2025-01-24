package ejercicios.ejercicio2;

import utilidades.Color;
import utilidades.Emoji;

public class RoedorJuanDaniel implements Runnable{
    private String nombre;
    private int tiempoEnComer;
    private Color color;
    private Emoji emoji;

    public RoedorJuanDaniel(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
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
        RoedorJuanDaniel taskFievel = new RoedorJuanDaniel("Fievel", 4, Color.BLACK, Emoji.RAT);
        RoedorJuanDaniel taskJerry = new RoedorJuanDaniel("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK);
        RoedorJuanDaniel taskPinky = new RoedorJuanDaniel("Pinky", 3, Color.RED, Emoji.MOUSE);
        RoedorJuanDaniel taskMickey = new RoedorJuanDaniel("Mickey", 6, Color.YELLOW, Emoji.HAMSTER);
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
