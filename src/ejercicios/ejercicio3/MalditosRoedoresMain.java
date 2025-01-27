package ejercicios.ejercicio3;

import ejercicios.ejercicio2.Roedor;
import utilidades.Color;
import utilidades.Emoji;

import java.util.concurrent.Semaphore;

public class MalditosRoedoresMain extends Thread {
    private String nombre;
    private int tiempoEnComer;
    private Emoji emoji;
    private Color color;
    private static final Semaphore semáforo = new Semaphore(1);

    public MalditosRoedoresMain(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.color = color;
        this.emoji = emoji;
    }

    @Override
    public void run() {
        try{
            //Adquirir permiso/acquire() : Si el número de permisos disponibles es mayor que cero entonces permitirá el acceso a un hilo y decrementa el número de permisos en 1 unidad, en caso de ser igual a 0 pondrá al cliente(hilo) en espera hasta que haya un permiso disponible para este.
            semáforo.acquire();

            // Empieza a alimentarse
            System.out.println(color.getCode() +"El ráton" +nombre+emoji.getEmoji()+"ha empezado a alimentarse.");
            Thread.sleep(2000);

            // Termina de alimentarse
            System.out.println(color.getCode() +"El ráton"+nombre+emoji.getEmoji()+"ha termiando de alimentarse");

            // Libera los otros roedores para que ellos puedan comer
            semáforo.release();


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }





}

 class RoedoresMain{
    public static void main(String[] args) {
// creamos los ratones
        MalditosRoedoresMain taskFievel = new MalditosRoedoresMain("Fievel", 4, Color.BLACK, Emoji.RAT);
        MalditosRoedoresMain taskJerry = new MalditosRoedoresMain("Jerry",5, Color.GREEN, Emoji.CHIPMUNK);
        MalditosRoedoresMain taskPinky = new MalditosRoedoresMain("Pinky",3, Color.RED, Emoji.MOUSE);
        MalditosRoedoresMain taskMickey = new MalditosRoedoresMain("Mickey",6,Color.YELLOW, Emoji.HAMSTER);



        try {
            taskFievel.start();
            taskFievel.join();
            taskJerry.start();
            taskJerry.join();
            taskPinky.start();
            taskPinky.join();
            taskMickey.start();
            taskMickey.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
