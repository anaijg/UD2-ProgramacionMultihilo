package ejercicios.ejercicio4;

import ejercicios.ejercicio2.RoedorSisa;
import utilidades.Color;
import utilidades.Emoji;

import java.util.Scanner;

public class MainRoedores {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("<--------- MENU -------->");
            System.out.println("1. Los roedores no esperan a que finalice el anterior para empezar.");
            System.out.println("2. Los roedores esperan a que finalice el anterior para empezar.");
            System.out.println("0. Salir.");
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

        scanner.close();
    }

    public static void roedoresNoEsperan() {
        RoedorSisa taskFievel = new RoedorSisa("Fievel", 4, Color.BLACK, Emoji.RAT);
        RoedorSisa taskJerry = new RoedorSisa("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK);
        RoedorSisa taskPinky = new RoedorSisa("Pinky", 3, Color.RED, Emoji.MOUSE);
        RoedorSisa taskMickey = new RoedorSisa("Mickey", 6, Color.YELLOW, Emoji.HAMSTER);

        Thread hiloFievel = new Thread(taskFievel);
        Thread hiloJerry = new Thread(taskJerry);
        Thread hiloPinky = new Thread(taskPinky);
        Thread hiloMickey = new Thread(taskMickey);

        hiloFievel.setPriority(4);
        hiloPinky.setPriority(5);
        hiloJerry.setPriority(3);
        hiloMickey.setPriority(6);

        hiloFievel.start();
        hiloJerry.start();
        hiloPinky.start();
        hiloMickey.start();
    }

    public static void roedoresEsperan() throws InterruptedException {
        RoedorSisa taskFievel = new RoedorSisa("Fievel", 4, Color.BLACK, Emoji.RAT);
        RoedorSisa taskJerry = new RoedorSisa("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK);
        RoedorSisa taskPinky = new RoedorSisa("Pinky", 3, Color.RED, Emoji.MOUSE);
        RoedorSisa taskMickey = new RoedorSisa("Mickey", 6, Color.YELLOW, Emoji.HAMSTER);

        Thread hiloFievel = new Thread(taskFievel);
        Thread hiloJerry = new Thread(taskJerry);
        Thread hiloPinky = new Thread(taskPinky);
        Thread hiloMickey = new Thread(taskMickey);

        hiloFievel.setPriority(Thread.MAX_PRIORITY);
        hiloPinky.setPriority(Thread.NORM_PRIORITY + 1);
        hiloJerry.setPriority(Thread.NORM_PRIORITY);
        hiloMickey.setPriority(Thread.MIN_PRIORITY);

        hiloFievel.start();
        hiloFievel.join();

        hiloPinky.start();
        hiloPinky.join();

        hiloJerry.start();
        hiloJerry.join();

        hiloMickey.start();
        hiloMickey.join();
    }
}