package ejercicios.ejercicio2;


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
        try{
            System.out.println(color+" "+nombre+" "+ emoji.getSimbolo()+"empeinza a alimentarse");
            Thread.sleep(tiempoEnComer* 1000L);
            System.out.println(color+" "+nombre+ " "+emoji.getSimbolo()+"Ha terminado de comer ");
        }catch (InterruptedException e){
            System.out.println("El Roedor_Andre"+nombre+"fue intemrrupido mientras comia ");
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run() {
      comer();
    }

    public static void main(String[] args) {
        Roedor_Andre raton1 = new Roedor_Andre("Fievel", 4, Color.RED, Emoji.Raton_Alejandro);
        Roedor_Andre raton2 = new Roedor_Andre("Jerry", 5, Color.BLACK, Emoji.Raton_johan);
        Roedor_Andre raton3 = new Roedor_Andre("Pinky", 3, Color.WHITE, Emoji.Raton_Alejandro);
        Roedor_Andre raton4 = new Roedor_Andre("Mickey", 6, Color.CYAN, Emoji.Raton_johan);

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
