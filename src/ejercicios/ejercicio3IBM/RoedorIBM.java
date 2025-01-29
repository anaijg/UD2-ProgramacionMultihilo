package ejercicios.ejercicio3IBM;

import utilidades.Color;
import utilidades.Emoji;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RoedorIBM implements Runnable
{
    private String nombre;
    private int tiempoEnComer;
    private Color color;
    private Emoji emoji;

    private static final Lock lock = new ReentrantLock();
    private static final Condition turno = lock.newCondition();
    private static RoedorIBM roedorActual = null;

    public RoedorIBM(String nombre, int tiempoEnComer, Color color, Emoji emoji)
    {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.color = color;
        this.emoji = emoji;

    }

    public void comer(){
        lock.lock();
        try
        {
            roedorActual=this;

            System.out.println(color.getCode() + "El ratón " + nombre + emoji.getEmoji() + " ha empezado a alimentarse.");

            Thread.sleep(tiempoEnComer * (long) 1000);

            System.out.println(color.getCode() + "El ratón " + nombre + emoji.getEmoji() + " ha terminado de alimentarse.");

            roedorActual=null;
            lock.unlock();

        }
        catch (InterruptedException e)
        {
            System.out.println("Interrupted exception del método sleep.");
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run()
    {
        this.comer();
    }
}

class MainRoedores
{
    public static void main(String[] args)
    {
        RoedorIBM taskFievel = new RoedorIBM("Fievel", 4, Color.BLACK, Emoji.RAT);
        RoedorIBM taskJerry = new RoedorIBM("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK);
        RoedorIBM taskPinky = new RoedorIBM("Pinky", 3, Color.RED, Emoji.MOUSE);
        RoedorIBM taskMickey = new RoedorIBM("Mickey", 6, Color.YELLOW, Emoji.HAMSTER);

        Thread hiloFievel = new Thread(taskFievel);
        Thread hiloJerry = new Thread(taskJerry);
        Thread hiloPinky = new Thread(taskPinky);
        Thread hiloMickey = new Thread(taskMickey);

        hiloFievel.start();
        hiloJerry.start();
        hiloPinky.start();
        hiloMickey.start();

    }
}
