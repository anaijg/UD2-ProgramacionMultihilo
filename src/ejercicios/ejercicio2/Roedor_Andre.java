package ejercicios.ejercicio2;


import utilidades.Color;
import utilidades.Emoji;

public class Roedor_Andre implements Runnable {
    String nombre;
    int tiempoEnComer;
    Color color;
    Emoji emoji;

    public Roedor_Andre(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
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
        Roedor_Andre raton1 = new Roedor_Andre("Fievel", 4, Color.RED, Emoji.RAT);
        Roedor_Andre raton2 = new Roedor_Andre("Jerry", 5, Color.GREEN, Emoji.MOUSE);
        Roedor_Andre raton3 = new Roedor_Andre("Pinky", 3, Color.WHITE, Emoji.HAMSTER);
        Roedor_Andre raton4 = new Roedor_Andre("Mickey", 6, Color.CYAN, Emoji.CHIPMUNK);

       Thread f1 = new Thread(raton1, "fievel");
       Thread f2 = new Thread(raton2, "Jerry");
       Thread f3 = new Thread(raton3, "Pinky");
       Thread f4 = new Thread(raton4, "Mickey");
        f1.start();
        f2.start();
        f3.start();
        f4.start();


    }
}
