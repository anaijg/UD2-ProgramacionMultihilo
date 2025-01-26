package ejercicios.ejercicio4;

import utilidades.Color;
import utilidades.Emoji;

import java.util.Scanner;

public class RoedorCarlos4 implements Runnable {
    private String nombre; //nombre del ratón
    private int tiempoEnComer; //tiempo en segundos que tarda en comer
    private Color color; //color del ratón (utiliza el enum Color)
    private Emoji emoji; //el emoji que representa al ratón (utiliza el enum Emoji)

    // Constructor:
    public RoedorCarlos4(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.color = color;
        this.emoji = emoji;
    }

    public void comer() {

        // Mostramos cada roedor con su color, emoji y el tiempo que tarda en comer (recuerda que comenzarán en orden aleatorio al no haberles dado prioridad)
        System.out.println(color.getCode() + emoji.getEmoji() + nombre + " tarda " + tiempoEnComer + " segundos en alimentarse");

        try {
            Thread.sleep(tiempoEnComer * 1000L);

        } catch (InterruptedException e) {
            System.out.println(" le hemos fastidiado la comida");
        }

        // Mostramos que ha terminado de comer el roedor que haya agotado su tiempo
        System.out.println(emoji.getEmoji() + color.getCode() + nombre + " ha terminado de comer");

    }

    @Override
    public void run() {
        //llama al método comer()
        comer();
    }


    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int opcion = 5;
        do {
            System.out.println("\nIntroduce una opción\n1. -> No esperan\n2. -> Esperan \n0. -> Salir");
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    noEsperan();
                    break;
                case 2:
                    esperan();
                    break;
                case 0:
                    System.out.println("Hasta pronto");
                    break;
                default:
                    System.out.println("Error, introduce una opción válida");
            }

        } while (opcion != 0);


    }


    public static void noEsperan() {

        // Creamos los objetos de tipo RoedorCarlos (las instrucciones que ejecutará):
        RoedorCarlos4 fievel = new RoedorCarlos4("Fievel", 4, Color.BLUE, Emoji.RAT);
        RoedorCarlos4 jerry = new RoedorCarlos4("Jerry", 5, Color.RED, Emoji.CHIPMUNK);
        RoedorCarlos4 pinky = new RoedorCarlos4("Pinky", 3, Color.GREEN, Emoji.MOUSE);
        RoedorCarlos4 mickey = new RoedorCarlos4("Mickey", 6, Color.YELLOW, Emoji.HAMSTER);


        // Creamos los hilos
        Thread hFievel = new Thread(fievel, "fievel");
        hFievel.setPriority(3);
        hFievel.start();

        Thread hJerry = new Thread(jerry, "jerry");
        hJerry.setPriority(2);
        hJerry.start();

        Thread hPinky = new Thread(pinky, "pinky");
        hPinky.setPriority(4);
        hPinky.start();

        Thread hMickey = new Thread(mickey, "mickey");
        hMickey.setPriority(1);
        hMickey.start();

    }

    public static void esperan() {

        // Creamos los objetos de tipo RoedorCarlos (las instrucciones que ejecutará):
        RoedorCarlos4 fievel = new RoedorCarlos4("Fievel", 4, Color.BLUE, Emoji.RAT);
        RoedorCarlos4 jerry = new RoedorCarlos4("Jerry", 5, Color.RED, Emoji.CHIPMUNK);
        RoedorCarlos4 pinky = new RoedorCarlos4("Pinky", 3, Color.GREEN, Emoji.MOUSE);
        RoedorCarlos4 mickey = new RoedorCarlos4("Mickey", 6, Color.YELLOW, Emoji.HAMSTER);

        // Creamos los hilos
        Thread hFievel = new Thread(fievel, "fievel");
        Thread hJerry = new Thread(jerry, "jerry");
        Thread hPinky = new Thread(pinky, "pinky");
        Thread hMickey = new Thread(mickey, "mickey");

        hPinky.setPriority(4);
        hFievel.setPriority(3);
        hJerry.setPriority(2);
        hMickey.setPriority(1);

        try {
            hPinky.start();
            hPinky.join();

            hFievel.start();
            hFievel.join();

            hJerry.start();
            hJerry.join();

            hMickey.start();
            hMickey.join();

        } catch (InterruptedException e) {
            System.out.println("Error al esperarse los hilos");
        }

    }
}
