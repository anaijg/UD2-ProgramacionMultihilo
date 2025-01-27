package ejercicios.ejercicio4;

import utilidades.Color;
import utilidades.Emoji;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class RoedorSiempreHuboCLasesAlejandro implements Runnable{
    private String nombre;
    private int tiempoEnComer;
    private Color color;
    private Emoji emoji;

    public RoedorSiempreHuboCLasesAlejandro(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
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
            /* Clean up whatever needs to be handled before interrupting  */
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run() {
        this.comer();
    }
}

class MainRoedores{
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int opcion;

        // Mostrar menú al principio
        do {
            System.out.println("Menú roedores:\n1- Los roedores esperan los unos a los otros para comer\n2- Los roedores no se esperan para comer\n0- Salir");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    roedoresEsperan();
                    break;
                case 2:
                    roedoresNoEsperan();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida. Seleccione 1, 2 o 0 para salir");
                    break;
            }
        } while (opcion != 0); // El menú se repite hasta que el usuario seleccione 0

        teclado.close();
    }

    public static void roedoresEsperan(){

        RoedorSiempreHuboCLasesAlejandro taskFievel = new RoedorSiempreHuboCLasesAlejandro("Fievel", 4, Color.BLACK, Emoji.RAT);
        RoedorSiempreHuboCLasesAlejandro taskJerry = new RoedorSiempreHuboCLasesAlejandro("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK);
        RoedorSiempreHuboCLasesAlejandro taskPinky = new RoedorSiempreHuboCLasesAlejandro("Pinky", 3, Color.RED, Emoji.MOUSE);
        RoedorSiempreHuboCLasesAlejandro taskMickey = new RoedorSiempreHuboCLasesAlejandro("Mickey", 6, Color.YELLOW, Emoji.HAMSTER);
        Thread hiloFievel = new Thread(taskFievel);
        Thread hiloJerry = new Thread(taskJerry);
        Thread hiloPinky = new Thread(taskPinky);
        Thread hiloMickey = new Thread(taskMickey);

        hiloFievel.setPriority(8);
        hiloJerry.setPriority(6);
        hiloPinky.setPriority(10);
        hiloMickey.setPriority(4);

        hiloFievel.start();
        try {
            hiloFievel.join();
        } catch (InterruptedException e) {
            System.out.println("Hilo Fievel interrumpido");
        }

        hiloJerry.start();
        try {
            hiloJerry.join();
        } catch (InterruptedException e) {
            System.out.println("Hilo Jerry interrumpido");
        }

        hiloPinky.start();
        try {
            hiloPinky.join();
        } catch (InterruptedException e) {
            System.out.println("Hilo pinky interrumpido");
        }

        hiloMickey.start();
        try {
            hiloMickey.join();
        } catch (InterruptedException e) {
            System.out.println("Hilo Mickey interrumpido");
        }
    }

    public static void roedoresNoEsperan (){
        RoedorSiempreHuboCLasesAlejandro taskFievel = new RoedorSiempreHuboCLasesAlejandro("Fievel", 4, Color.BLACK, Emoji.RAT);
        RoedorSiempreHuboCLasesAlejandro taskJerry = new RoedorSiempreHuboCLasesAlejandro("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK);
        RoedorSiempreHuboCLasesAlejandro taskPinky = new RoedorSiempreHuboCLasesAlejandro("Pinky", 3, Color.RED, Emoji.MOUSE);
        RoedorSiempreHuboCLasesAlejandro taskMickey = new RoedorSiempreHuboCLasesAlejandro("Mickey", 6, Color.YELLOW, Emoji.HAMSTER);
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
        try {
            hiloFievel.join();
            hiloJerry.join();
            hiloPinky.join();
            hiloMickey.join();
        } catch (InterruptedException e) {
            System.out.println("Error al esperar los hilos: " + e.getMessage());
        }
    }
}
