package ejercicios.ejercicio3_davidT;
import ejercicios.ejercicio3_davidT.entity.RoedorEntity;
import utilidades.Color;
import utilidades.Emoji;

public class Roedor implements Runnable{
    private final ejercicios.ejercicio4_davidT.entity.RoedorEntity roe ;

    public Roedor(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
        this.roe = new ejercicios.ejercicio4_davidT.entity.RoedorEntity(nombre, tiempoEnComer, color, emoji);
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
        ejercicios.ejercicio4_davidT.Roedor taskFievel = new ejercicios.ejercicio4_davidT.Roedor("Fievel", 4, Color.BLACK, Emoji.RAT);
        ejercicios.ejercicio4_davidT.Roedor taskJerry = new ejercicios.ejercicio4_davidT.Roedor("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK);
        ejercicios.ejercicio4_davidT.Roedor taskPinky = new ejercicios.ejercicio4_davidT.Roedor("Pinky", 3, Color.RED, Emoji.MOUSE);
        ejercicios.ejercicio4_davidT.Roedor taskMickey = new ejercicios.ejercicio4_davidT.Roedor("Mickey", 6, Color.YELLOW, Emoji.HAMSTER);
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
