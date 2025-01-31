package ejercicios.ejercicio3;

import utilidades.Color;
import utilidades.Emoji;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

import static ejercicios.ejercicio3.Roedor_Miguel_Menu.ANSI_RESET;

public class Roedor_Miguel_Menu implements Runnable {
    private static final Semaphore Uno_a_Uno = new Semaphore(1); // Controla que solo un roedor coma a la vez
    private final String nombre;
    private final int tiempoEnComer;
    private final Color color;
    private final Emoji emoji;
    private final boolean sincronizado; // Define si deben comer sincronizados o no


    public static final String ANSI_RESET = "\u001B[0m";

    public Roedor_Miguel_Menu (String nombre, int tiempoEnComer, Color color, Emoji emoji, boolean sincronizado) {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.color = color;
        this.emoji = emoji;
        this.sincronizado = sincronizado;
    }

    public void comer() {
        try {
            if (sincronizado) {
                Uno_a_Uno.acquire(); // Si el modo es sincronizado, espera turno
            }

            System.out.println(color.getCode() + "El ratón " + nombre + emoji.getEmoji() + " ha empezado a alimentarse.");
            Thread.sleep(tiempoEnComer * 1000L);
            System.out.println(color.getCode() + "El ratón " + nombre + emoji.getEmoji() + " hha terminado de alimentarse un total de "+ tiempoEnComer + " segundos.");

        } catch (InterruptedException e) {
            System.out.println(ANSI_RESET + "El hilo fue interrumpido.");
            Thread.currentThread().interrupt();
        } finally {
            if (sincronizado) {
                Uno_a_Uno.release(); // Libera el permiso para el siguiente si el modo es sincronizado
            }
        }
    }

    @Override
    public void run() {
        this.comer();
    }
}

class MainRoedores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecciona el modo de alimentación:");
        System.out.println("1. Todos los roedores comen a la vez (paralelo)");
        System.out.println("2. Los roedores comen uno por uno (sincronizado)");
        System.out.print("Elige una opción (1 o 2): ");

        int opcion = scanner.nextInt();
        boolean sincronizado = (opcion == 2); // Si elige 2, se sincroniza

        // Creación de los roedores con el modo seleccionado
        ejercicios.ejercicio3.Roedor_Miguel_Menu fievel = new Roedor_Miguel_Menu("Fievel", 4, Color.CYAN, Emoji.RAT, sincronizado);
        ejercicios.ejercicio3.Roedor_Miguel_Menu jerry = new Roedor_Miguel_Menu("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK, sincronizado);
        ejercicios.ejercicio3.Roedor_Miguel_Menu pinky = new Roedor_Miguel_Menu("Pinky", 3, Color.RED, Emoji.MOUSE, sincronizado);
        ejercicios.ejercicio3.Roedor_Miguel_Menu mickey = new Roedor_Miguel_Menu("Mickey", 6, Color.YELLOW, Emoji.HAMSTER, sincronizado);

        Thread hiloFievel = new Thread(fievel);
        Thread hiloJerry = new Thread(jerry);
        Thread hiloPinky = new Thread(pinky);
        Thread hiloMickey = new Thread(mickey);

        // Iniciar hilos
        hiloFievel.start();
        hiloJerry.start();
        hiloPinky.start();
        hiloMickey.start();

        // Esperar a que todos los hilos terminen
        try {
            hiloFievel.join();
            hiloJerry.join();
            hiloPinky.join();
            hiloMickey.join();
        } catch (InterruptedException e) {
            System.out.println(ANSI_RESET + "El hilo principal fue interrumpido.");
            Thread.currentThread().interrupt();
        }

        System.out.println(ANSI_RESET + "\nTodos los roedores han terminado de comer.");
        scanner.close();
    }
}

