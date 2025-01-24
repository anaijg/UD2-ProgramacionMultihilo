package ejercicios.ejercicio3;

import utilidades.Color;
import utilidades.Emoji;

public class Roedor_Aina_Espera implements Runnable{
    private String nombre;
    private int tiempoEnComer;
    private Color color;
    private Emoji emoji;

    public Roedor_Aina_Espera(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
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

    public static void main(String[] args) throws InterruptedException {
        Roedor_Aina_Espera Fievel = new Roedor_Aina_Espera("Fievel", 4, Color.BLACK, Emoji.RAT);
        Roedor_Aina_Espera Jerry = new Roedor_Aina_Espera("Jerry", 5, Color.RED, Emoji.CHIPMUNK);
        Roedor_Aina_Espera Pinky = new Roedor_Aina_Espera("Pinky", 3, Color.PURPLE, Emoji.MOUSE);
        Roedor_Aina_Espera Mickey = new Roedor_Aina_Espera("Mickey", 6, Color.WHITE, Emoji.HAMSTER);

        Thread hiloF = new Thread(Fievel);
        Thread hiloJ = new Thread(Jerry);
        Thread hiloP = new Thread(Pinky);
        Thread hiloM = new Thread(Mickey);

        hiloF.start();
        hiloF.join();

        hiloJ.start();
        hiloJ.join();

        hiloP.start();
        hiloP.join();

        hiloM.start();
        hiloM.join();
    }
}
