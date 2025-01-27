package ejercicios.ejercicio4;

import ejercicios.ejercicio2.Roedor;
import ejercicios.ejercicio3.MalditosRoedoresMain;
import utilidades.Color;
import utilidades.Emoji;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class SiempreHuboClases extends Thread  {
    private String nombre;
    private int tiempoEnComer;
    private Emoji emoji;
    private Color color;
    private static final Semaphore semáforo = new Semaphore(1);

    public SiempreHuboClases(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.color = color;
        this.emoji = emoji;
    }

    @Override
    public void run() {
        try {
            semáforo.acquire();
            System.out.println(color.getCode() + "El ráton " + nombre + emoji.getEmoji() + " ha empezado a alimentarse.");
            Thread.sleep(tiempoEnComer * 2000L);
            System.out.println(color.getCode() + "El ráton " + nombre + emoji.getEmoji() + " ha terminado de alimentarse.");
            semáforo.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class RoedoresMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Roedores no esperan a que finalice el anterior para empezar");
            System.out.println("2. Roedores esperan a que finalice el anterior para empezar");
            System.out.println("0. Salir");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    roedoresNoEsperan();
                    break;
                case 2:
                    roedoresEsperan();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (option != 0);
    }

    public static void roedoresNoEsperan() {
        Roedor taskFievel = new Roedor("Fievel", 4, Color.BLACK, Emoji.RAT);
        Roedor taskJerry = new Roedor("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK);
        Roedor taskPinky = new Roedor("Pinky", 3, Color.RED, Emoji.MOUSE);
        Roedor taskMickey = new Roedor("Mickey", 6, Color.YELLOW, Emoji.HAMSTER);
        Thread hiloFievel = new Thread(taskFievel);
        Thread hiloJerry = new Thread(taskJerry);
        Thread hiloPinky = new Thread(taskPinky);
        Thread hiloMickey = new Thread(taskMickey);

        hiloFievel.start();
        hiloJerry.start();
        hiloPinky.start();
        hiloMickey.start();
    }

    public static void roedoresEsperan() {
        MalditosRoedoresMain taskFievel = new MalditosRoedoresMain("Fievel", 4, Color.BLACK, Emoji.RAT);
        MalditosRoedoresMain taskJerry = new MalditosRoedoresMain("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK);
        MalditosRoedoresMain taskPinky = new MalditosRoedoresMain("Pinky", 3, Color.RED, Emoji.MOUSE);
        MalditosRoedoresMain taskMickey = new MalditosRoedoresMain("Mickey", 6, Color.YELLOW, Emoji.HAMSTER);

        taskFievel.setPriority(Thread.MAX_PRIORITY);
        taskPinky.setPriority(Thread.NORM_PRIORITY + 1);
        taskJerry.setPriority(Thread.NORM_PRIORITY);
        taskMickey.setPriority(Thread.MIN_PRIORITY);

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
