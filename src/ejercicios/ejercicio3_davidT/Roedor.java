package ejercicios.ejercicio3;

import ejercicios.ejercicio3.entity.RoedorEntity;
import utilidades.Color;
import utilidades.Emoji;

public class Roedor implements Runnable{
    private final RoedorEntity roe ;

    public Roedor(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
        this.roe = new RoedorEntity(nombre, tiempoEnComer, color, emoji);
    }


    public void comer(){
        try {
            System.out.println(roe.getColor() + "El ratón " + roe.getNombre() + roe.getEmoji() + " ha empezado a alimentarse.");
            Thread.sleep(roe.getTiempoEnComer() * (long) 1000);
            System.out.println(roe.getColor() + "El ratón " + roe.getNombre() + roe.getEmoji() + " ha terminado de alimentarse.");
        } catch (InterruptedException e) {
            System.out.println("Interrupted exception del método sleep.");
            /* Clean up whatever needs to be handled before interrupting  */
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run() {
        comer();
    }
}

class MainRoedores{
    public static void main(String[] args) {
        // creamos los ratones
        Roedor taskFievel = new Roedor("Fievel", 4, Color.BLACK, Emoji.RAT);
        Roedor taskJerry = new Roedor("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK);
        Roedor taskPinky = new Roedor("Pinky", 3, Color.RED, Emoji.MOUSE);
        Roedor taskMickey = new Roedor("Mickey", 6, Color.YELLOW, Emoji.HAMSTER);
        Thread hiloFievel = new Thread(taskFievel);
        Thread hiloJerry = new Thread(taskJerry);
        Thread hiloPinky = new Thread(taskPinky);
        Thread hiloMickey = new Thread(taskMickey);

        try{
            hiloFievel.start();
            hiloFievel.join();
            hiloJerry.start();
            hiloJerry.join();
            hiloPinky.start();
            hiloPinky.join();
            hiloMickey.start();
            hiloMickey.join();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
