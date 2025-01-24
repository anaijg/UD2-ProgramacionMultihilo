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
        Roedor_Andre raton1 = new Roedor_Andre("Fievel", 4, Color.Gris, Emoji.Raton_Alejandro);
        Roedor_Andre raton2 = new Roedor_Andre("Jerry", 5, Color.Marroncito, Emoji.Raton_johan);
        Roedor_Andre raton3 = new Roedor_Andre("Pinky", 3, Color.Blanco, Emoji.Raton_Alejandro);
        Roedor_Andre raton4 = new Roedor_Andre("Mickey", 6, Color.Negro, Emoji.Raton_johan);

        Thread hilo1 = new Thread(raton1);
        Thread hilo2 = new Thread(raton2);
        Thread hilo3 = new Thread(raton3);
        Thread hilo4 = new Thread(raton4);
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
    }
}
