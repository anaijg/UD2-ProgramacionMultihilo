package ejercicios.ejercicio2;

import utilidades.Color;
import utilidades.Emoji;

public class Roedor_Aina implements Runnable{
    private String nombre;
    private int tiempoEnComer;
    private Color color;
    private Emoji emoji;

    public Roedor_Aina(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.color = color;
        this.emoji = emoji;
    }

    public void comer(){
        try {
            System.out.println(color.getCode() + nombre + emoji.getEmoji() + " empieza a comer");
            Thread.sleep(tiempoEnComer * (long) 1000);
            System.out.println(color.getCode() + nombre + " Ha terminado de comer en " + tiempoEnComer + " segundos" + emoji.getEmoji());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    @Override
    public void run() {
        comer();
    }

    public static void main(String[] args) {
        Roedor_Aina Fievel = new Roedor_Aina("Fievel", 4, Color.BLACK, Emoji.RAT);
        Roedor_Aina Jerry = new Roedor_Aina("Jerry", 5, Color.RED, Emoji.CHIPMUNK);
        Roedor_Aina Pinky = new Roedor_Aina("Pinky", 3, Color.PURPLE, Emoji.MOUSE);
        Roedor_Aina Mickey = new Roedor_Aina("Mickey", 6, Color.WHITE, Emoji.HAMSTER);

        Thread hiloF = new Thread(Fievel);
        Thread hiloJ = new Thread(Jerry);
        Thread hiloP = new Thread(Pinky);
        Thread hiloM = new Thread(Mickey);

        hiloF.start();
        hiloJ.start();
        hiloP.start();
        hiloM.start();
    }
}
