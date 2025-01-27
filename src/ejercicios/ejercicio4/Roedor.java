package ejercicios.ejercicio4;

import utilidades.Color;
import utilidades.Emoji;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Roedor implements Runnable {
    private String nombre;
    private int tiempoEnComer;
    private Color color;
    private Emoji emoji;
    private Semaphore semaforo;

    public Roedor(String nombre, int tiempoEnComer, Color color, Emoji emoji, Semaphore semaforo) {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.color = color;
        this.emoji = emoji;
        this.semaforo = semaforo;
    }

    public void comer() {
        try {
            semaforo.acquire();
            System.out.println(color.getCode() + "El ratón " + nombre + emoji.getEmoji() + " ha empezado a alimentarse.");
            Thread.sleep(tiempoEnComer * (long) 1000);
            System.out.println(color.getCode() + "El ratón " + nombre + emoji.getEmoji() + " ha terminado de alimentarse.");
            semaforo.release();
        } catch (InterruptedException e) {
            System.out.println("Interrupted exception del método sleep.");
            /* Clean up whatever needs to be handled before interrupting  */
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run() {
        this.comer();
    }
}

class MainRoedores {
    private static Semaphore semaforo = new Semaphore(1);
    private static PriorityQueue<Thread> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(Thread::getPriority).reversed());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Elige una opción:");
            System.out.println("1. Roedores comen sin esperar su turno");
            System.out.println("2. Roedores comen esperando su turno");
            System.out.println("0. Salir");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    roedoresComenSinEsperar();
                    break;
                case 2:
                    roedoresComenEsperando();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    public static void roedoresComenSinEsperar() {
        // creamos los ratones
        Roedor taskFievel = new Roedor("Fievel", 4, Color.BLACK, Emoji.RAT, new Semaphore(0));
        Roedor taskJerry = new Roedor("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK, new Semaphore(0));
        Roedor taskPinky = new Roedor("Pinky", 3, Color.RED, Emoji.MOUSE, new Semaphore(0));
        Roedor taskMickey = new Roedor("Mickey", 6, Color.YELLOW, Emoji.HAMSTER, new Semaphore(0));

        Thread hiloFievel = new Thread(taskFievel);
        Thread hiloJerry = new Thread(taskJerry);
        Thread hiloPinky = new Thread(taskPinky);
        Thread hiloMickey = new Thread(taskMickey);

        // Asignamos prioridades (cuanto menos tarde en comer, más prioridad tiene)
        hiloFievel.setPriority(7);
        hiloJerry.setPriority(5);
        hiloPinky.setPriority(8);
        hiloMickey.setPriority(3);

        // Añadimos los hilos a la cola de prioridad
        colaPrioridad.add(hiloPinky);
        colaPrioridad.add(hiloFievel);
        colaPrioridad.add(hiloJerry);
        colaPrioridad.add(hiloMickey);

        // Iniciamos los hilos
        while (!colaPrioridad.isEmpty()) {
            Thread hilo = colaPrioridad.poll();
            hilo.start();
            try {
                hilo.join();
            } catch (InterruptedException e) {
                System.out.println("Interrupted exception del método join.");
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void roedoresComenEsperando() {
        // creamos los ratones
        Roedor taskFievel = new Roedor("Fievel", 4, Color.BLACK, Emoji.RAT, semaforo);
        Roedor taskJerry = new Roedor("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK, semaforo);
        Roedor taskPinky = new Roedor("Pinky", 3, Color.RED, Emoji.MOUSE, semaforo);
        Roedor taskMickey = new Roedor("Mickey", 6, Color.YELLOW, Emoji.HAMSTER, semaforo);

        Thread hiloFievel = new Thread(taskFievel);
        Thread hiloJerry = new Thread(taskJerry);
        Thread hiloPinky = new Thread(taskPinky);
        Thread hiloMickey = new Thread(taskMickey);

        // Asignamos prioridades (cuanto menos tarde en comer, más prioridad tiene)
        hiloFievel.setPriority(7);
        hiloJerry.setPriority(5);
        hiloPinky.setPriority(8);
        hiloMickey.setPriority(3);

        // Añadimos los hilos a la cola de prioridad
        colaPrioridad.add(hiloPinky);
        colaPrioridad.add(hiloFievel);
        colaPrioridad.add(hiloJerry);
        colaPrioridad.add(hiloMickey);

        // Iniciamos los hilos
        while (!colaPrioridad.isEmpty()) {
            Thread hilo = colaPrioridad.poll();
            hilo.start();
            try {
                hilo.join();
            } catch (InterruptedException e) {
                System.out.println("Interrupted exception del método join.");
                Thread.currentThread().interrupt();
            }
        }
    }
}
