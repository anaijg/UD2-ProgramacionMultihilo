package ejercicios.ejercicio3;

import utilidades.Color;
import utilidades.Emoji;

public class RoedorCarlos3 implements Runnable {

    private String nombre; //nombre del ratón
    private int tiempoEnComer; //tiempo en segundos que tarda en comer
    private Color color; //color del ratón (utiliza el enum Color)
    private Emoji emoji; //el emoji que representa al ratón (utiliza el enum Emoji)

    // Constructor:
    public RoedorCarlos3(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
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

        RoedorCarlos3 fievel = new RoedorCarlos3("Fievel", 4, Color.BLUE, Emoji.RAT);
        RoedorCarlos3 jerry = new RoedorCarlos3("Jerry", 5, Color.RED, Emoji.CHIPMUNK);
        RoedorCarlos3 pinky = new RoedorCarlos3("Pinky", 3, Color.GREEN, Emoji.MOUSE);
        RoedorCarlos3 mickey = new RoedorCarlos3("Mickey", 6, Color.YELLOW, Emoji.HAMSTER);


        // Creamos los hilos
        Thread hFievel = new Thread(fievel, "fievel");
        Thread hJerry = new Thread(jerry, "jerry");
        Thread hPinky = new Thread(pinky, "pinky");
        Thread hMickey = new Thread(mickey, "mickey");

        // Ejecutamos los hilos
        try {
            hPinky.start();
            hPinky.join();

            hFievel.start();
            hFievel.join();

            hJerry.start();
            hJerry.join();

            hMickey.start();
            hMickey.join();
        } catch (InterruptedException e) {
            System.out.println("Estos ratones ya ni se esperan su turno");
        }



    }
}
