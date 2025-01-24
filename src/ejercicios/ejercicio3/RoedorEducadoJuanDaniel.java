package ejercicios.ejercicio3;

import utilidades.Color;
import utilidades.Emoji;

public class RoedorEducadoJuanDaniel implements Runnable{
    private String nombre;
    private int tiempoEnComer;
    private Color color;
    private Emoji emoji;

    public RoedorEducadoJuanDaniel(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
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
    public static void main(String[] args) throws InterruptedException {
        // creamos los ratones
        RoedorEducadoJuanDaniel taskFievel = new RoedorEducadoJuanDaniel("Fievel", 4, Color.BLACK, Emoji.RAT);
        RoedorEducadoJuanDaniel taskJerry = new RoedorEducadoJuanDaniel("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK);
        RoedorEducadoJuanDaniel taskPinky = new RoedorEducadoJuanDaniel("Pinky", 3, Color.RED, Emoji.MOUSE);
        RoedorEducadoJuanDaniel taskMickey = new RoedorEducadoJuanDaniel("Mickey", 6, Color.YELLOW, Emoji.HAMSTER);
        Thread hiloFievel = new Thread(taskFievel);
        Thread hiloJerry = new Thread(taskJerry);
        Thread hiloPinky = new Thread(taskPinky);
        Thread hiloMickey = new Thread(taskMickey);


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
