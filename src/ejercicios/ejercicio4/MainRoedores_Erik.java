package ejercicios.ejercicio4;

import ejercicios.ejercicio2.Roedor_Erik;
import utilidades.Color;
import utilidades.Emoji;

import java.util.Scanner;

public class MainRoedores_Erik {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Los roedores NO esperan (ejecución concurrente)");
            System.out.println("2. Los roedores esperan (ejecución secuencial)");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    roedoresNoEsperan();
                    break;
                case 2:
                    roedoresEsperan();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    public static void roedoresNoEsperan() {
        // Crear instancias de roedores
        Roedor_Erik fievel = new Roedor_Erik("Fievel", 4, Color.BLACK, Emoji.RAT);
        Roedor_Erik jerry = new Roedor_Erik("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK);
        Roedor_Erik pinky = new Roedor_Erik("Pinky", 3, Color.RED, Emoji.MOUSE);
        Roedor_Erik mickey = new Roedor_Erik("Mickey", 6, Color.YELLOW, Emoji.HAMSTER);

        // Crear hilos para los roedores
        Thread hiloFievel = new Thread(fievel);
        Thread hiloJerry = new Thread(jerry);
        Thread hiloPinky = new Thread(pinky);
        Thread hiloMickey = new Thread(mickey);

        // Iniciar los hilos de forma concurrente
        System.out.println("\nLos roedores empiezan a comer de forma concurrente:");
        hiloFievel.start();
        hiloJerry.start();
        hiloPinky.start();
        hiloMickey.start();
    }

    public static void roedoresEsperan() {
        // Crear instancias de roedores
        RoedorEducado_Erik fievel = new RoedorEducado_Erik("Fievel", 4, Color.RED, Emoji.RAT);
        RoedorEducado_Erik jerry = new RoedorEducado_Erik("Jerry", 5, Color.YELLOW, Emoji.CHIPMUNK);
        RoedorEducado_Erik pinky = new RoedorEducado_Erik("Pinky", 3, Color.BLUE, Emoji.MOUSE);
        RoedorEducado_Erik mickey = new RoedorEducado_Erik("Mickey", 6, Color.GREEN, Emoji.HAMSTER);

        // Crear hilos para los roedores
        Thread hiloFievel = new Thread(fievel);
        Thread hiloJerry = new Thread(jerry);
        Thread hiloPinky = new Thread(pinky);
        Thread hiloMickey = new Thread(mickey);

        // Iniciar los hilos de forma secuencial
        System.out.println("\nLos roedores empiezan a comer de forma secuencial:");
        try {
            hiloFievel.start();
            hiloFievel.join();

            hiloJerry.start();
            hiloJerry.join();

            hiloPinky.start();
            hiloPinky.join();

            hiloMickey.start();
            hiloMickey.join();
        } catch (InterruptedException e) {
            System.err.println("Se interrumpió la ejecución: " + e.getMessage());
        }
    }
}

class RoedorEducado_Erik implements Runnable {
    private String nombre;
    private int tiempoEnComer;
    private Color color;
    private Emoji emoji;

    // Constructor
    public RoedorEducado_Erik(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.color = color;
        this.emoji = emoji;
    }

    public void comer() {
        try {
            System.out.println(color.getCode() + "El roedor " + nombre + " " + emoji.getEmoji() + " empieza a alimentarse...");
            Thread.sleep(tiempoEnComer * 1000L);
            System.out.println(color.getCode() + "El roedor " + nombre + " " + emoji.getEmoji() + " ha terminado de alimentarse.");
        } catch (InterruptedException e) {
            System.err.println("El hilo del roedor " + nombre + " fue interrumpido: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        comer();
    }
}
