package ejercicios.ejercicio3;

import utilidades.Color;
import utilidades.Emoji;

public class Roedores_Andre implements Runnable{
    String nombre;
    int tiempoEnComer;
    Color color;
    Emoji emoji;

    public Roedores_Andre(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.color = color;
        this.emoji = emoji;
    }


    public void comer (){
        System.out.println(color.getCode()+" "+ nombre +" "+ emoji.getEmoji() +"tarda "+tiempoEnComer+"s en comer");
        try{
            Thread.sleep(tiempoEnComer* 1000L);
        }catch (InterruptedException e){
            System.out.println("El Roedor"+nombre+"fue intemrrupido mientras comia ");
            Thread.currentThread().interrupt();
        }
        System.out.println(color.getCode()+" "+nombre+ " "+emoji.getEmoji()+"Ha terminado de comer ");
    }

    @Override
    public void run() {
        comer();
    }

    public static void main(String[] args) {
        Roedores_Andre raton1 = new Roedores_Andre("Fievel", 3, Color.RED, Emoji.RAT);
        Roedores_Andre raton2 = new Roedores_Andre("Jerry", 4, Color.GREEN, Emoji.MOUSE);
        Roedores_Andre raton3 = new Roedores_Andre("Pinky", 5, Color.WHITE, Emoji.HAMSTER);
        Roedores_Andre raton4 = new Roedores_Andre("Mickey", 6, Color.CYAN, Emoji.CHIPMUNK);

        Thread f1 = new Thread(raton1, "fievel");
        Thread f2 = new Thread(raton2, "Jerry");
        Thread f3 = new Thread(raton3, "Pinky");
        Thread f4 = new Thread(raton4, "Mickey");


        try{
            f1.start();
            f1.join();

            f2.start();
            f2.join();

            f3.start();
            f3.join();

            f4.start();
            f4.join();

        }catch (InterruptedException e){
            System.out.println("interrumpido");
            Thread.currentThread().interrupt();
        }

    }
}
