package ejercicios.ejercicio4;

import utilidades.Color;
import utilidades.Emoji;
import java.util.Scanner;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;

import static ejercicios.ejercicio4.Roedor_Miguel_Clases.ANSI_RESET;

public class Roedor_Miguel_Clases implements Runnable, Comparable<Roedor_Miguel_Clases> {
    private static final Semaphore semaforo = new Semaphore(1); // Para el modo sincronizado
    private final String nombre;
    private final int tiempoEnComer;
    private final Color color;
    private final Emoji emoji;

    public static final String ANSI_RESET = "\u001B[0m";


    public Roedor_Miguel_Clases(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.color = color;
        this.emoji = emoji;
    }

    public void comer(boolean sincronizado) {
        try {
            if (sincronizado) {
                semaforo.acquire(); // Espera su turno si el modo es sincronizado
            }

            System.out.println(color.getCode() + "El ratón " + nombre + emoji.getEmoji() + " ha empezado a alimentarse.");
            Thread.sleep(tiempoEnComer * 1000L);
            System.out.println(color.getCode() + "El ratón " + nombre + emoji.getEmoji() + " ha terminado de alimentarse un total de " + tiempoEnComer + " segundos.");

        } catch (InterruptedException e) {
            System.out.println(ANSI_RESET + "El hilo fue interrumpido.");
            Thread.currentThread().interrupt();
        } finally {
            if (sincronizado) {
                semaforo.release();
            }
        }
    }

    @Override
    public void run() {
        this.comer(false); // Por defecto en modo libre
    }

    @Override
    public int compareTo(Roedor_Miguel_Clases otro) {
        return Integer.compare(this.tiempoEnComer, otro.tiempoEnComer); // Ordena por tiempo (menos tiempo = más prioridad)
    }
}

class MainRoedores {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println(ANSI_RESET + "\n📌 Selecciona el modo de alimentación:");
            System.out.println("1. Todos los roedores comen a la vez (sin esperar)");
            System.out.println("2. Los roedores comen de acuerdo a su prioridad (esperan turno)");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();
            if (opcion == 0) {
                System.out.println("Saliendo del programa...");
                break;
            } else if (opcion == 1) {
                comerEnParalelo();
            } else if (opcion == 2) {
                comerConPrioridad();
            } else {
                System.out.println("⚠ Opción no válida. Inténtalo de nuevo.");
            }
        }
        scanner.close();
    }

    public static void comerEnParalelo() {
        System.out.println("\n🐭 Modo libre: Todos los roedores comen al mismo tiempo.");

        Roedor_Miguel_Clases[] roedores = {
                new Roedor_Miguel_Clases("Fievel", 4, Color.CYAN, Emoji.RAT),
                new Roedor_Miguel_Clases("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK),
                new Roedor_Miguel_Clases("Pinky", 3, Color.RED, Emoji.MOUSE),
                new Roedor_Miguel_Clases("Mickey", 6, Color.YELLOW, Emoji.HAMSTER)
        };

        Thread[] hilos = new Thread[roedores.length];
        for (int i = 0; i < roedores.length; i++) {
            hilos[i] = new Thread(roedores[i]);
            hilos[i].start();
        }

        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                System.out.println(ANSI_RESET + "Error en la ejecución.");
            }
        }

        System.out.println(ANSI_RESET + "\nTodos los roedores han terminado de comer.");
    }

    public static void comerConPrioridad() {
        System.out.println("\n🐭 Modo sincronizado: Comen en orden de prioridad (menos tiempo primero).");

        PriorityBlockingQueue<Roedor_Miguel_Clases> colaPrioridad = new PriorityBlockingQueue<>();
        colaPrioridad.add(new Roedor_Miguel_Clases("Fievel", 4, Color.CYAN, Emoji.RAT));
        colaPrioridad.add(new Roedor_Miguel_Clases("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK));
        colaPrioridad.add(new Roedor_Miguel_Clases("Pinky", 3, Color.RED, Emoji.MOUSE));
        colaPrioridad.add(new Roedor_Miguel_Clases("Mickey", 6, Color.YELLOW, Emoji.HAMSTER));

        while (!colaPrioridad.isEmpty()) {
            Roedor_Miguel_Clases roedor = colaPrioridad.poll(); // Toma el de mayor prioridad
            if (roedor != null) {
                roedor.comer(true); // Modo sincronizado
            }
        }

        System.out.println(ANSI_RESET + "\nTodos los roedores han terminado de comer.");
    }
}
