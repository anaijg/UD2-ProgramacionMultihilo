package ejercicios.ejercicio2;

import utilidades.Color;
import utilidades.Emoji;

public class RoedorCarlos implements Runnable {
    private String nombre; //nombre del ratón
    private int tiempoEnComer; //tiempo en segundos que tarda en comer
    private Color color; //color del ratón (utiliza el enum Color)
    private Emoji emoji; //el emoji que representa al ratón (utiliza el enum Emoji)

    // Constructor:
    public RoedorCarlos(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.color = color;
        this.emoji = emoji;
    }

    public void comer() {

        // Mostramos cada roedor con su color, emoji y el tiempo que tarda en comer (recuerda que comenzarán en orden aleatorio al no haberles dado prioridad)
        System.out.println(color.getCode() + emoji.getEmoji() + nombre + " tarda " + tiempoEnComer + " segundos en alimentarse");

        try {
            Thread.sleep(tiempoEnComer * 1000L);
        } catch (InterruptedException e) {
            System.out.println(" le hemos fastidiado la comida");
        }

        // Mostramos que ha terminado de comer el roedor que haya agotado su tiempo
        System.out.println(emoji.getEmoji() + color.getCode() + nombre + " ha terminado de comer");

    }

    @Override
    public void run() {
        //llama al método comer()
        comer();
    }


    public static void main(String[] args) {

        // Creamos los objetos de tipo RoedorCarlos (las instrucciones que ejecutará):

        RoedorCarlos fievel = new RoedorCarlos("Fievel", 4, Color.BLUE, Emoji.RAT);
        RoedorCarlos jerry = new RoedorCarlos("Jerry", 5, Color.RED, Emoji.CHIPMUNK);
        RoedorCarlos pinky = new RoedorCarlos("Pinky", 3, Color.GREEN, Emoji.MOUSE);
        RoedorCarlos mickey = new RoedorCarlos("Mickey", 6, Color.YELLOW, Emoji.HAMSTER);


        // Creamos los hilos
        Thread hFievel = new Thread(fievel, "fievel");
        Thread hJerry = new Thread(jerry, "jerry");
        Thread hPinky = new Thread(pinky, "pinky");
        Thread hMickey = new Thread(mickey, "mickey");

        // Ejecutamos los hilos
        hFievel.start();
        hJerry.start();
        hPinky.start();
        hMickey.start();


    }
}
