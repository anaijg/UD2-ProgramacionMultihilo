package ejercicios.ejercicio4IBM;

import utilidades.Color;
import utilidades.Emoji;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RoedorIBM implements Runnable
{
    private String nombre;
    private int tiempoEnComer;
    private Color color;
    private Emoji emoji;
    private int prioridad;

    private static final Lock lock = new ReentrantLock();
    private static final Condition turno = lock.newCondition();
    private static RoedorIBM roedorActual = null;

    public RoedorIBM(String nombre, int tiempoEnComer, Color color, Emoji emoji, int prioridad)
    {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.color = color;
        this.emoji = emoji;
        this.prioridad = prioridad;
    }

    public void comer(boolean esperarTurno)
    {
        if (esperarTurno)
        {
            lock.lock();
            try {
                while (roedorActual != null && roedorActual.getPrioridad() < this.prioridad)
                {
                    turno.await();
                }

                roedorActual = this;

                System.out.println(color.getCode() + "El ratón " + nombre + emoji.getEmoji() + " ha empezado a alimentarse.");
                Thread.sleep(tiempoEnComer * 1000L);
                System.out.println(color.getCode() + "El ratón " + nombre + emoji.getEmoji() + " ha terminado de alimentarse.");

                roedorActual = null;
                turno.signalAll();
            }
            catch (InterruptedException e)
            {
                System.out.println("Interrupted exception del método sleep.");
                Thread.currentThread().interrupt();
            }
            finally
            {
                lock.unlock(); // Desbloqueamos el acceso
            }
        }
        else
        {
            try
            {
                System.out.println(color.getCode() + "El ratón " + nombre + emoji.getEmoji() + " ha empezado a alimentarse.");
                Thread.sleep(tiempoEnComer * 1000L);
                System.out.println(color.getCode() + "El ratón " + nombre + emoji.getEmoji() + " ha terminado de alimentarse.");
            }
            catch (InterruptedException e)
            {
                System.out.println("Interrupted exception del método sleep.");
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public void run()
    {
    }

    public int getPrioridad()
    {
        return prioridad;
    }
}

class MainRoedores
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do
        {
            System.out.println("=== Menú de Roedores ===");
            System.out.println("1. Roedores comiendo a la vez (sin esperar turno)");
            System.out.println("2. Roedores esperando turno (por prioridad)");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion)
            {
                case 1:
                    roedoresComiendoALaVez();
                    break;
                case 2:
                    roedoresEsperandoTurno();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
        while (opcion != 0);

        scanner.close();
    }
    public static void roedoresComiendoALaVez()
    {
        RoedorIBM taskFievel = new RoedorIBM("Fievel", 4, Color.BLACK, Emoji.RAT, 4); // Menor prioridad
        RoedorIBM taskJerry = new RoedorIBM("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK, 3);
        RoedorIBM taskPinky = new RoedorIBM("Pinky", 3, Color.RED, Emoji.MOUSE, 1); // Mayor prioridad
        RoedorIBM taskMickey = new RoedorIBM("Mickey", 6, Color.YELLOW, Emoji.HAMSTER, 2);

        Thread hiloFievel = new Thread(() -> taskFievel.comer(false));
        Thread hiloJerry = new Thread(() -> taskJerry.comer(false));
        Thread hiloPinky = new Thread(() -> taskPinky.comer(false));
        Thread hiloMickey = new Thread(() -> taskMickey.comer(false));

        hiloFievel.start();
        hiloJerry.start();
        hiloPinky.start();
        hiloMickey.start();

        try
        {
            hiloFievel.join();
            hiloJerry.join();
            hiloPinky.join();
            hiloMickey.join();
        }
        catch (InterruptedException e)
        {
            System.out.println("Los hilos fueron interrumpidos.");
        }
    }
    public static void roedoresEsperandoTurno()
    {
        RoedorIBM taskFievel = new RoedorIBM("Fievel", 4, Color.BLACK, Emoji.RAT, 4);
        RoedorIBM taskJerry = new RoedorIBM("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK, 3);
        RoedorIBM taskPinky = new RoedorIBM("Pinky", 3, Color.RED, Emoji.MOUSE, 1);
        RoedorIBM taskMickey = new RoedorIBM("Mickey", 6, Color.YELLOW, Emoji.HAMSTER, 2);

        Thread hiloFievel = new Thread(() -> taskFievel.comer(true));
        Thread hiloJerry = new Thread(() -> taskJerry.comer(true));
        Thread hiloPinky = new Thread(() -> taskPinky.comer(true));
        Thread hiloMickey = new Thread(() -> taskMickey.comer(true));


        hiloFievel.start();
        hiloJerry.start();
        hiloPinky.start();
        hiloMickey.start();

        try
        {
            hiloFievel.join();
            hiloJerry.join();
            hiloPinky.join();
            hiloMickey.join();
        }
        catch (InterruptedException e)
        {
            System.out.println("Los hilos fueron interrumpidos.");
        }
    }
}