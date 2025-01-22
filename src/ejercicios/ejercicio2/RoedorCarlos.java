package ejercicios.ejercicio2;

import utilidades.Color;
import utilidades.Emoji;

import javax.swing.plaf.TableHeaderUI;

public class Roedor implements Runnable {
    private String nombre; //nombre del ratón
    private int tiempoEnComer; //tiempo en segundos que tarda en comer
    private Color color; //color del ratón (utiliza el enum Color)
    private Emoji emoji; //el emoji que representa al ratón (utiliza el enum Emoji)

    // Constructor:
    public Roedor(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.color = color;
        this.emoji = emoji;
    }

    public void comer() {
        /*
        public void comer(): Este método consiste en lo siguiente:
Primero imprime un mensaje en que se muestre color, nombre y emoji del roedor indicando que el ratón empieza a alimentarse.

Después se detiene el tiempo esperando que el roedor termine de comer.

Imprime otro mensaje parecido al primero en el que se indica que el roedor ha terminado de comer.
         */
        Thread hilo = Thread.currentThread();

        System.out.println(color.getCode() + emoji.getEmoji() + nombre + "tarda " + tiempoEnComer + " segundos en alimentarse");

        try {
            Thread.sleep(tiempoEnComer * 1000L);
        } catch (InterruptedException e) {
            System.out.println(" le hemos fastidiado la comida");
        }


        System.out.println(emoji.getEmoji() + color.getCode() + nombre + " ha terminado de comer");


    }

    @Override
    public void run() {
        //llama al método comer()
        comer();
    }


    public static void main(String[] args) {

        Roedor fievel = new Roedor("Fievel", 4, Color.BLUE, Emoji.RAT);
        Roedor jerry = new Roedor("Jerry", 5, Color.RED, Emoji.CHIPMUNK);
        Roedor pinky = new Roedor("Pinky", 3, Color.GREEN, Emoji.MOUSE);
        Roedor mickey = new Roedor("Mickey", 6, Color.YELLOW, Emoji.HAMSTER);

        Thread hFievel = new Thread(fievel, "fievel");
        Thread hJerry = new Thread(jerry, "jerry");
        Thread hPinky = new Thread(pinky, "pinky");
        Thread hMickey = new Thread(mickey, "mickey");

        hFievel.start();
        hJerry.start();
        hPinky.start();
        hMickey.start();


    }
}
