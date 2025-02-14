package ejercicios.ejercicio4;

import ejercicios.ejercicio2.Roedor;
import utilidades.Color;
import utilidades.Emoji;

import java.util.Scanner;

public class EsperarComerRoeddores_Xaviervl implements Runnable {
    private String nombre;
    private int tiempoEnComer;
    private Color color;
    private Emoji emoji;

    public EsperarComerRoeddores_Xaviervl(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.color = color;
        this.emoji = emoji;
    }

    public void comer(){
        try {
            System.out.println(color.getCode() + "El ratón " + nombre + emoji.getEmoji() + " ha empezado a alimentarse.");
            Thread.sleep(tiempoEnComer * (long) 1000);
            System.out.println(color.getCode() + "El ratón " + nombre + emoji.getEmoji() + " ha terminado de alimentarse.");
        } catch (InterruptedException e) {
            System.out.println("Interrupted exception del método sleep.");
            Thread.currentThread().interrupt();
        }
    }
    public void esperar(){

    }

    @Override
    public void run() {
        comer();
    }
}

class MainRoedores{
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int opciones;
        System.out.println("\t MENÚ");
        System.out.println("=================================================");
        System.out.println("Opción 1: Los roedores no esperan");
        System.out.println("Opción 2: Los roedores  esperan");
        System.out.println("Opción 0: Salir");

        do {
            opciones = scanner.nextInt();

            switch (opciones) {
                case 1:
                    comer();
                    break;
                case 2:
                    esperar();
                    break;
                case 0:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Elija una dde las opciones disponibles");
                    System.out.println("\t MENÚ");
                    System.out.println("=================================================");
                    System.out.println("Opción 1: Los roedores no esperan");
                    System.out.println("Opción 2: Los roedores  esperan");
                    System.out.println("Opción 0: Salir");
            }
        } while (opciones != 0);

        scanner.close();
}
    public static void comer(){
        Roedor taskFievel = new Roedor("Fievel", 4, Color.BLACK, Emoji.RAT);
        Roedor taskJerry = new Roedor("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK);
        Roedor taskPinky = new Roedor("Pinky", 3, Color.RED, Emoji.MOUSE);
        Roedor taskMickey = new Roedor("Mickey", 6, Color.YELLOW, Emoji.HAMSTER);

        Thread hiloFievel = new Thread(taskFievel);
        Thread hiloJerry = new Thread(taskJerry);
        Thread hiloPinky = new Thread(taskPinky);
        Thread hiloMickey = new Thread(taskMickey);

        hiloFievel.setPriority(8);
        hiloJerry.setPriority(6);
        hiloPinky.setPriority(10);
        hiloMickey.setPriority(4);

        hiloFievel.start();
        hiloJerry.start();
        hiloPinky.start();
        hiloMickey.start();
    }
    public static void esperar() throws InterruptedException {
        Roedor Fievel = new Roedor("Fievel", 4, Color.BLACK, Emoji.RAT);
        Roedor Jerry = new Roedor("Jerry", 5, Color.RED, Emoji.CHIPMUNK);
        Roedor Pinky = new Roedor("Pinky", 3, Color.PURPLE, Emoji.MOUSE);
        Roedor Mickey = new Roedor("Mickey", 6, Color.WHITE, Emoji.HAMSTER);

        Thread hiloFievel = new Thread(Fievel);
        Thread hiloJerry = new Thread(Jerry);
        Thread hiloPinky = new Thread(Pinky);
        Thread hiloMickey = new Thread(Mickey);

        hiloFievel.start();
        hiloFievel.join();

        hiloJerry.start();
        hiloJerry.join();

        hiloPinky.start();
        hiloPinky.join();

        hiloMickey.start();
        hiloMickey.join();
    }
}