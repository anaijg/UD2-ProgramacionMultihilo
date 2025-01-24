package ejercicios.ejercicio4;

import ejercicios.ejercicio2.Roedor_Aina;
import ejercicios.ejercicio3.Roedor_Aina_Espera;
import utilidades.Color;
import utilidades.Emoji;

public class Roedor_Aina_Clases implements Runnable {
    private String nombre;
    private int tiempoEnComer;
    private Color color;
    private Emoji emoji;

    public Roedor_Aina_Clases(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.color = color;
        this.emoji = emoji;
    }

    public void comer() {
        try {
            System.out.println(color.getCode() + nombre + emoji.getEmoji() + " empieza a comer");
            Thread.sleep(tiempoEnComer * (long) 1000);
            System.out.println(color.getCode() + nombre + " Ha terminado de comer en " + tiempoEnComer + " segundos" + emoji.getEmoji());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    public void esperar(){

    }

    @Override
    public void run() {
        comer();
    }
}
class MainRoedores_Aina {
    public static void main(String[] args) throws InterruptedException {
        esperar();
        //comer();
    }

    public static void comer() {
        Roedor_Aina_Clases Fievel = new Roedor_Aina_Clases("Fievel", 4, Color.BLACK, Emoji.RAT);
        Roedor_Aina_Clases Jerry = new Roedor_Aina_Clases("Jerry", 5, Color.RED, Emoji.CHIPMUNK);
        Roedor_Aina_Clases Pinky = new Roedor_Aina_Clases("Pinky", 3, Color.PURPLE, Emoji.MOUSE);
        Roedor_Aina_Clases Mickey = new Roedor_Aina_Clases("Mickey", 6, Color.WHITE, Emoji.HAMSTER);

        Thread hiloF = new Thread(Fievel);
        Thread hiloJ = new Thread(Jerry);
        Thread hiloP = new Thread(Pinky);
        Thread hiloM = new Thread(Mickey);

        hiloF.setPriority(8);
        hiloJ.setPriority(6);
        hiloP.setPriority(10);
        hiloM.setPriority(4);

        hiloF.start();
        hiloJ.start();
        hiloP.start();
        hiloM.start();
    }

    public static void esperar() throws InterruptedException {
        Roedor_Aina_Clases Fievel = new Roedor_Aina_Clases("Fievel", 4, Color.BLACK, Emoji.RAT);
        Roedor_Aina_Clases Jerry = new Roedor_Aina_Clases("Jerry", 5, Color.RED, Emoji.CHIPMUNK);
        Roedor_Aina_Clases Pinky = new Roedor_Aina_Clases("Pinky", 3, Color.PURPLE, Emoji.MOUSE);
        Roedor_Aina_Clases Mickey = new Roedor_Aina_Clases("Mickey", 6, Color.WHITE, Emoji.HAMSTER);
        Thread hiloF = new Thread(Fievel);
        Thread hiloJ = new Thread(Jerry);
        Thread hiloP = new Thread(Pinky);
        Thread hiloM = new Thread(Mickey);


        hiloF.start();
        hiloF.join();

        hiloJ.start();
        hiloF.join();

        hiloP.start();
        hiloF.join();

        hiloM.start();
        hiloF.join();

    }
}
