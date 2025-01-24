package ejercicios.ejercicio2;

import utilidades.Color;
import utilidades.Emoji;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ejercicio2_Dgomezjunquer{

    public static List<Roedor> roedorList = new ArrayList<>(Arrays.asList(
            new Roedor("Fievel", 4, Color.BLACK, Emoji.RAT),
            new Roedor("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK),
            new Roedor("Pinky", 3, Color.RED, Emoji.MOUSE),
            new Roedor("Mickey", 6, Color.YELLOW, Emoji.HAMSTER)
    ));

    public static void main(String[] args) {
        // creamos los ratones
        List<Thread> ratones = new ArrayList<>();

        for (Roedor roedor : roedorList) {
            ratones.add(new Thread(roedor));
        }

        for (Thread raton : ratones) {
            raton.start();
        }
    }
}
