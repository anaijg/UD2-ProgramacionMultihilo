package ejercicios.ejercicio4;

import utilidades.Color;
import utilidades.Emoji;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Roedor implements Runnable {
    private String nombre;
    private int tiempoEnComer;
    private Color color;
    private Emoji emoji;
    private Semaphore semaphore;

    public Roedor(String nombre, int tiempoEnComer, Color color, Emoji emoji, Semaphore semaphore) {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.color = color;
        this.emoji = emoji;
        this.semaphore = semaphore;
    }

    public void comer() {
        try {
            if (semaphore != null) semaphore.acquire(); // Intentar adquirir el permiso si existe
            System.out.println(color.getCode() + "El ratón " + nombre + emoji.getEmoji() + " ha empezado a alimentarse.");
            Thread.sleep(tiempoEnComer * (long) 1000);
            System.out.println(color.getCode() + "El ratón " + nombre + emoji.getEmoji() + " ha terminado de alimentarse.");
        } catch (InterruptedException e) {
            System.out.println("Interrupted exception del método sleep.");
            Thread.currentThread().interrupt();
        } finally {
            if (semaphore != null) semaphore.release(); // Liberar el permiso si existe
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
        int option;

        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Los roedores esperan su turno para comer.");
            System.out.println("2. Los roedores no esperan su turno y comen simultáneamente.");
            System.out.println("0. Salir.");
            System.out.print("Elija una opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1 -> roedoresEsperan();
                case 2 -> roedoresNoEsperan();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (option != 0);

        scanner.close();
    }

    private static void roedoresEsperan() {
        // Crear un semáforo para sincronizar el acceso
        Semaphore semaphore = new Semaphore(1);

        // Crear los roedores con sus prioridades
        Thread[] roedores = crearHilosRoedores(semaphore);

        // Iniciar los hilos
        iniciarHilos(roedores);
    }

    private static void roedoresNoEsperan() {
        // Crear los roedores sin semáforo (sin sincronización)
        Thread[] roedores = crearHilosRoedores(null);

        // Iniciar los hilos
        iniciarHilos(roedores);
    }

    private static Thread[] crearHilosRoedores(Semaphore semaphore) {
        // Crear los ratones
        Roedor taskFievel = new Roedor("Fievel", 4, Color.BLACK, Emoji.RAT, semaphore);
        Roedor taskJerry = new Roedor("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK, semaphore);
        Roedor taskPinky = new Roedor("Pinky", 3, Color.RED, Emoji.MOUSE, semaphore);
        Roedor taskMickey = new Roedor("Mickey", 6, Color.YELLOW, Emoji.HAMSTER, semaphore);

        // Crear hilos con prioridades según el tiempo en comer
        Thread hiloFievel = new Thread(taskFievel);
        Thread hiloJerry = new Thread(taskJerry);
        Thread hiloPinky = new Thread(taskPinky);
        Thread hiloMickey = new Thread(taskMickey);

        // Asignar prioridades (menor tiempo, mayor prioridad)
        hiloPinky.setPriority(Thread.MAX_PRIORITY); // 3 segundos -> mayor prioridad
        hiloFievel.setPriority(Thread.NORM_PRIORITY); // 4 segundos -> prioridad media
        hiloJerry.setPriority(Thread.NORM_PRIORITY - 1); // 5 segundos -> menos prioridad
        hiloMickey.setPriority(Thread.MIN_PRIORITY); // 6 segundos -> menor prioridad

        return new Thread[]{hiloPinky, hiloFievel, hiloJerry, hiloMickey};
    }

    private static void iniciarHilos(Thread[] hilos) {
        for (Thread hilo : hilos) {
            hilo.start();
        }

        // Esperar a que todos los hilos terminen
        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                System.out.println("Error esperando a los hilos.");
            }
        }
    }
}
