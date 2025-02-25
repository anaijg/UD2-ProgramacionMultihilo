//Author : Daniel Hernandez Garcia
package ejercicios.ejercicio3.ratonesEducadosDani;

import utilidades.Color;
import utilidades.Emoji;

public class RoedorEj3_DanielH {

    public static void main(String[] args) {
        Roedor_DanielH jerry = new Roedor_DanielH("Jerry", 5, Color.PURPLE, Emoji.CHIPMUNK);
        jerry.run();
        Roedor_DanielH mickey = new Roedor_DanielH("Mickey", 6, Color.RED, Emoji.HAMSTER);
        mickey.run();
        Roedor_DanielH pinky = new Roedor_DanielH("Pinky", 3, Color.CYAN, Emoji.MOUSE);
        pinky.run();
        Roedor_DanielH fievel = new Roedor_DanielH("Fievel", 4, Color.YELLOW, Emoji.RAT);
        fievel.run();
    }
}
