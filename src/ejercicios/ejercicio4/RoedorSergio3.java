package ejercicios.ejercicio4;

import ejercicios.ejercicio3.RoedorSergio2;
import utilidades.Color;
import utilidades.Emoji;

import java.util.Scanner;

public class RoedorSergio3 implements Runnable{
    private String nombre;
    private int tiempoEnComer;
    private Color color;
    private Emoji emoji;

    public RoedorSergio3(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.color = color;
        this.emoji = emoji;
    }

    public void comer() {
        try {
            System.out.println(color.getCode() + "El ratón " + nombre + emoji.getEmoji() + " ha empezado a alimentarse.");
            Thread.sleep(tiempoEnComer * 1000L); // Multiplicamos por 1000 para convertir a milisegundos
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

    // Establecemos la prioridad en base al tiempo de comer usando setPriority
    public void asignarPrioridad(Thread hilo) {
        if (tiempoEnComer == 3) {
            hilo.setPriority(Thread.MAX_PRIORITY); // Máxima prioridad (10) para Pinky
        } else if (tiempoEnComer == 4) {
            hilo.setPriority(Thread.NORM_PRIORITY + 1); // Prioridad alta (6) para Fievel
        } else if (tiempoEnComer == 5) {
            hilo.setPriority(Thread.NORM_PRIORITY); // Prioridad normal (5) para Jerry
        } else {
            hilo.setPriority(Thread.MIN_PRIORITY); // Mínima prioridad (1) para Mickey
        }
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);


        // Menú interactivo
        int opcion = -1;  // Usamos -1 como valor inicial para asegurarnos de que se entre al menú al menos una vez
        do {
            System.out.println("\nElija una opción:");
            System.out.println("1. Los roedores no esperan a que finalice el anterior.");
            System.out.println("2. Los roedores esperan a que finalice el anterior.");
            System.out.println("0. Salir.");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    iniciarRoedoresSinEsperar();
                    break;
                case 2:
                    iniciarRoedoresEsperando();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    public static void iniciarRoedoresSinEsperar() {
        // Crear nuevos ratones
        RoedorSergio3 taskFievel = new RoedorSergio3("Fievel", 4, Color.BLACK, Emoji.RAT);
        RoedorSergio3 taskJerry = new RoedorSergio3("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK);
        RoedorSergio3 taskPinky = new RoedorSergio3("Pinky", 3, Color.RED, Emoji.MOUSE);
        RoedorSergio3 taskMickey = new RoedorSergio3("Mickey", 6, Color.YELLOW, Emoji.HAMSTER);

        // Crear nuevos hilos
        Thread hiloFievel = new Thread(taskFievel);
        Thread hiloJerry = new Thread(taskJerry);
        Thread hiloPinky = new Thread(taskPinky);
        Thread hiloMickey = new Thread(taskMickey);

        // Asignar prioridades usando el método asignarPrioridad
        taskFievel.asignarPrioridad(hiloFievel);
        taskJerry.asignarPrioridad(hiloJerry);
        taskPinky.asignarPrioridad(hiloPinky);
        taskMickey.asignarPrioridad(hiloMickey);

        hiloMickey.start();
        hiloFievel.start();
        hiloPinky.start();
        hiloJerry.start();

        // Esperar a que todos los hilos terminen antes de continuar
        try {
            hiloMickey.join();
            hiloFievel.join();
            hiloPinky.join();
            hiloJerry.join();
        } catch (InterruptedException e) {
            System.out.println("Error al esperar a que los hilos terminen.");
        }
    }

    public static void iniciarRoedoresEsperando() {
        // Crear nuevos ratones
        RoedorSergio3 taskFievel = new RoedorSergio3("Fievel", 4, Color.BLACK, Emoji.RAT);
        RoedorSergio3 taskJerry = new RoedorSergio3("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK);
        RoedorSergio3 taskPinky = new RoedorSergio3("Pinky", 3, Color.RED, Emoji.MOUSE);
        RoedorSergio3 taskMickey = new RoedorSergio3("Mickey", 6, Color.YELLOW, Emoji.HAMSTER);

        // Crear nuevos hilos
        Thread hiloFievel = new Thread(taskFievel);
        Thread hiloJerry = new Thread(taskJerry);
        Thread hiloPinky = new Thread(taskPinky);
        Thread hiloMickey = new Thread(taskMickey);

        // Asignar prioridades usando el método asignarPrioridad
        taskFievel.asignarPrioridad(hiloFievel);
        taskJerry.asignarPrioridad(hiloJerry);
        taskPinky.asignarPrioridad(hiloPinky);
        taskMickey.asignarPrioridad(hiloMickey);

        try {
            hiloPinky.start();
            hiloPinky.join();

            hiloFievel.start();
            hiloFievel.join();

            hiloJerry.start();
            hiloJerry.join();

            hiloMickey.start();
            hiloMickey.join();
        } catch (InterruptedException e) {
            System.out.println("Error al iniciar los hilos con espera.");
        }
    }
}
