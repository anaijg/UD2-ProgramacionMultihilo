package ejercicios.ejercicio4Bis;

import ejercicios.ejercicio2Bis.RoedorS;
import utilidades.Color;
import utilidades.Emoji;

import java.util.Scanner;

public class Roedores implements Runnable {
    private String nombre;
    private int tiempoComer;
    private Color color;
    private Emoji emoji;

    public Roedores(String nombre, int tiempoComer, Color color, Emoji emoji) {
        this.nombre = nombre;
        this.tiempoComer = tiempoComer;
        this.color = color;
        this.emoji = emoji;
    }

    @Override
    public void run() {
        comer();

    }

    public void comer() {
        System.out.println(color.getCode() + nombre + emoji.getEmoji() + "Ha empezado a alimentarse ");

        try {
            Thread.sleep(tiempoComer * 1000L);


        } catch (InterruptedException e) {
            System.out.println("Error" + e.getMessage());
        }

        System.out.println(color.getCode() + nombre + emoji.getEmoji() + "Ha terminado de alimentarse ");


    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion = -1;
        do {
            System.out.println("1.Los ratones esperan\n2. Los ratones no esperan\n0.Salir");
            opcion = teclado.nextInt();teclado.nextLine();
            switch (opcion) {
                case 0:
                    System.out.println("ciao");
                    break;
                case 1: esperan();
                break;
                case 2: noEsperan();
                break;
                default:
            }



        } while (opcion != 0);

    }

    public static void esperan() {
        RoedorS fievel = new RoedorS("Fievel", 4, Color.BLUE, Emoji.RAT);
        RoedorS jerry = new RoedorS("Jerry ", 5, Color.RED, Emoji.CHIPMUNK);
        RoedorS pinky = new RoedorS("Pinky ", 3, Color.GREEN, Emoji.MOUSE);
        RoedorS mickey = new RoedorS("Micky", 6, Color.BLACK, Emoji.HAMSTER);

        Thread hiloFievel = new Thread(fievel, "Fievel");
        Thread hiloJerry = new Thread(jerry, "Jerry");
        Thread hiloPinky = new Thread(pinky, "Pinky");
        Thread hiloMickey = new Thread(mickey, "Mickey");

        hiloPinky.setPriority(4);
        hiloFievel.setPriority(3);
        hiloJerry.setPriority(2);
        hiloMickey.setPriority(1);

        try {
            hiloPinky.start();
            hiloPinky.join();
            hiloFievel.start();
            hiloFievel.join();
            hiloJerry.start();
            hiloJerry.join();
            hiloMickey.start();
            hiloMickey.join();

        } catch (InterruptedException e) {
            System.out.println("Error " + e.getMessage());

        }

    }

    public static void noEsperan() {
        RoedorS fievel = new RoedorS("Fievel", 4, Color.BLUE, Emoji.RAT);
        RoedorS jerry = new RoedorS("Jerry ", 5, Color.RED, Emoji.CHIPMUNK);
        RoedorS pinky = new RoedorS("Pinky ", 3, Color.GREEN, Emoji.MOUSE);
        RoedorS mickey = new RoedorS("Micky", 6, Color.BLACK, Emoji.HAMSTER);

        Thread hiloFievel = new Thread(fievel, "Fievel");
        Thread hiloJerry = new Thread(jerry, "Jerry");
        Thread hiloPinky = new Thread(pinky, "Pinky");
        Thread hiloMickey = new Thread(mickey, "Mickey");

        hiloPinky.setPriority(4);
        hiloFievel.setPriority(3);
        hiloJerry.setPriority(2);
        hiloMickey.setPriority(1);


        hiloPinky.start();
        hiloFievel.start();
        hiloJerry.start();
        hiloMickey.start();


    }
}



