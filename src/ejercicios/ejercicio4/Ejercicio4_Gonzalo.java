package ejercicios.ejercicio4;

import utilidades.Color;
import utilidades.Emoji;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;

public class Ejercicio4_Gonzalo {
    private static final Semaphore semaforo = new Semaphore(1);

    public static void main(String[] args) {
        PriorityBlockingQueue<RunnableRoedor> roedores = new PriorityBlockingQueue<>();
    
        roedores.add(new RunnableRoedor("Fievel", 4, Color.YELLOW, Emoji.RAT));
        roedores.add(new RunnableRoedor("Jerry", 5, Color.BLUE, Emoji.CHIPMUNK));
        roedores.add(new RunnableRoedor("Pinky", 3, Color.CYAN, Emoji.MOUSE));
        roedores.add(new RunnableRoedor("Mickey", 6, Color.GREEN, Emoji.HAMSTER));
    
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
    
        do {
            mostrarMenu();
            System.out.print("Elija una opción: ");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
    
                switch (opcion) {
                    case 1:
                        comerSinEsperar(roedores);
                        break;
                    case 2:
                        comerConEspera(roedores);
                        break;
                    case 0:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next();
            }
        } while (opcion != 0);
    
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú ---");
        System.out.println("1. Comer SIN esperar al turno");
        System.out.println("2. Comer esperando al turno");
        System.out.println("0. Salir");
    }

public static void comerSinEsperar(PriorityBlockingQueue<RunnableRoedor> roedores) {
    System.out.println("\nLos roedores comerán SIN esperar su turno:");

    List<Thread> threads = new ArrayList<>();

    for (RunnableRoedor roedor : roedores) {
        Thread thread = new Thread(roedor);
        threads.add(thread);
        thread.start();
    }

    for (Thread thread : threads) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            System.out.println("Un hilo fue interrumpido.");
        }
    }
}

public static void comerConEspera(PriorityBlockingQueue<RunnableRoedor> roedores) {
    System.out.println("\nLos roedores comerán esperando su turno:");

    List<Thread> threads = new ArrayList<>();

    for (RunnableRoedor roedor : roedores) {
        Thread thread = new Thread(() -> {
            try {
                semaforo.acquire();
                roedor.run();
            } catch (InterruptedException e) {
                System.out.println(roedor.getNombre() + " fue interrumpido.");
            } finally {
                semaforo.release();
            }
        });
        threads.add(thread);
        thread.start();
    }
    for (Thread thread : threads) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            System.out.println("Un hilo fue interrumpido.");
        }
    }
}

}

class RunnableRoedor implements Runnable, Comparable<RunnableRoedor> {
    private String nombre;
    private int tiempoEnComer;
    private Color color;
    private Emoji emoji;

    public RunnableRoedor(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.color = color;
        this.emoji = emoji;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        System.out.println(
                color.getCode() + nombre + " " + emoji.getEmoji() + " ha comenzado a comer." + Color.RESET.getCode());
        try {
            Thread.sleep(tiempoEnComer * 1000);
        } catch (InterruptedException e) {
            System.out.println(nombre + " fue interrumpido mientras comía.");
        }
        System.out.println(
                color.getCode() + nombre + " " + emoji.getEmoji() + " ha terminado de comer." + Color.RESET.getCode());
    }

    @Override
    public int compareTo(RunnableRoedor otro) {
        return Integer.compare(this.tiempoEnComer, otro.tiempoEnComer);
    }
}