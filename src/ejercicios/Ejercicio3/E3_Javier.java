package ejercicios.Ejercicio3;

import ejercicios.ejercicio2.Roedores_Javier;
import utilidades.Color;
import utilidades.Emoji;

public class E3_Javier {

    public static void main(String[] args) {

        Roedores_Javier fievel = new Roedores_Javier("Fievel", 4, Color.RED, Emoji.RAT);
        Roedores_Javier jerry = new Roedores_Javier("Jerry", 5, Color.YELLOW, Emoji.CHIPMUNK);
        Roedores_Javier pinky = new Roedores_Javier("Pinky", 3, Color.BLUE, Emoji.MOUSE);
        Roedores_Javier mickey = new Roedores_Javier("Mickey", 6, Color.GREEN, Emoji.HAMSTER);

        Thread hiloFievel = new Thread(fievel);
        Thread hiloJerry = new Thread(jerry);
        Thread hiloPinky = new Thread(pinky);
        Thread hiloMickey = new Thread(mickey);

        try {

            hiloFievel.start();
            hiloFievel.join();

            hiloJerry.start();
            hiloJerry.join();

            hiloPinky.start();
            hiloPinky.join();

            hiloMickey.start();
            hiloMickey.join();

        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
