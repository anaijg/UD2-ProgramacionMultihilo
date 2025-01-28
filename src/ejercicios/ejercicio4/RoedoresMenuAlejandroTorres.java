package ejercicios.ejercicio4;

import utilidades.Color;
import utilidades.Emoji;

import java.util.*;

public class RoedoresMenuAlejandroTorres implements Runnable {
    private String nombre;
    private int tiempoEnComer;
    private Color color;
    private Emoji emoji;

    public RoedoresMenuAlejandroTorres(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.color = color;
        this.emoji = emoji;
    }

    public void comer() {
        try {
            System.out.println(color.getCode() + "El ratón " + nombre + emoji.getEmoji() + " ha empezado a alimentarse.");
            Thread.sleep(tiempoEnComer * 1000L);
            System.out.println(color.getCode() + "El ratón " + nombre + emoji.getEmoji() + " ha terminado de alimentarse.");
        } catch (InterruptedException e) {
            System.out.println("Interrupted exception del método sleep.");
            Thread.currentThread().interrupt();
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
        int opcion;

        do {
            System.out.println("\n=== Menú de Roedores ===");
            System.out.println("1. Roedores sin esperar");
            System.out.println("2. Roedores esperando turno");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    roedoresSinEsperar();
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
        } while (opcion != 0);
        scanner.close();
    }

    public static void roedoresSinEsperar() {
        RoedoresMenuAlejandroTorres taskFievel = new RoedoresMenuAlejandroTorres("Fievel", 4, Color.BLACK, Emoji.RAT);
        RoedoresMenuAlejandroTorres taskJerry = new RoedoresMenuAlejandroTorres("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK);
        RoedoresMenuAlejandroTorres taskPinky = new RoedoresMenuAlejandroTorres("Pinky", 3, Color.RED, Emoji.MOUSE);
        RoedoresMenuAlejandroTorres taskMickey = new RoedoresMenuAlejandroTorres("Mickey", 6, Color.YELLOW, Emoji.HAMSTER);

        Thread hiloFievel = new Thread(taskFievel);
        Thread hiloJerry = new Thread(taskJerry);
        Thread hiloPinky = new Thread(taskPinky);
        Thread hiloMickey = new Thread(taskMickey);


        hiloPinky.setPriority(Thread.MAX_PRIORITY);
        hiloFievel.setPriority(Thread.NORM_PRIORITY + 1);
        hiloJerry.setPriority(Thread.NORM_PRIORITY);
        hiloMickey.setPriority(Thread.MIN_PRIORITY);

        // Ordenar hilos por prioridad
        List<Thread> hilos = Arrays.asList(hiloPinky, hiloFievel, hiloJerry, hiloMickey);
        hilos.sort(Comparator.comparingInt(Thread::getPriority).reversed());


        for (Thread hilo : hilos) {
            hilo.start();
        }


        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                System.out.println("El hilo principal fue interrumpido.");
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void roedoresEsperandoTurno() {
        RoedoresMenuAlejandroTorres taskFievel = new RoedoresMenuAlejandroTorres("Fievel", 4, Color.BLACK, Emoji.RAT);
        RoedoresMenuAlejandroTorres taskJerry = new RoedoresMenuAlejandroTorres("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK);
        RoedoresMenuAlejandroTorres taskPinky = new RoedoresMenuAlejandroTorres("Pinky", 3, Color.RED, Emoji.MOUSE);
        RoedoresMenuAlejandroTorres taskMickey = new RoedoresMenuAlejandroTorres("Mickey", 6, Color.YELLOW, Emoji.HAMSTER);

        Thread hiloFievel = new Thread(taskFievel);
        Thread hiloJerry = new Thread(taskJerry);
        Thread hiloPinky = new Thread(taskPinky);
        Thread hiloMickey = new Thread(taskMickey);


        hiloPinky.setPriority(Thread.MAX_PRIORITY);
        hiloFievel.setPriority(Thread.NORM_PRIORITY + 1);
        hiloJerry.setPriority(Thread.NORM_PRIORITY);
        hiloMickey.setPriority(Thread.MIN_PRIORITY);


        List<Thread> hilos = Arrays.asList(hiloPinky, hiloFievel, hiloJerry, hiloMickey);
        hilos.sort(Comparator.comparingInt(Thread::getPriority).reversed());


        for (Thread hilo : hilos) {
            hilo.start();
            try {
                hilo.join();
            } catch (InterruptedException e) {
                System.out.println("El hilo principal fue interrumpido.");
                Thread.currentThread().interrupt();
            }
        }
    }
}
