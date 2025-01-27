package ejercicios.ejercicio3;

import ejercicios.ejercicio2.RoedorSisa;
import utilidades.Color;
import utilidades.Emoji;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        RoedorSisa taskFievel = new RoedorSisa("Fievel", 4, Color.BLACK, Emoji.RAT);
        RoedorSisa taskJerry = new RoedorSisa("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK);
        RoedorSisa taskPinky = new RoedorSisa("Pinky", 3, Color.RED, Emoji.MOUSE);
        RoedorSisa taskMickey = new RoedorSisa("Mickey", 6, Color.YELLOW, Emoji.HAMSTER);
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
