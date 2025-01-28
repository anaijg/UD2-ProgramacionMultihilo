package ejercicios.ejercicio4_davidT;

import utilidades.Color;
import utilidades.Emoji;

import java.util.ArrayList;
import java.util.Scanner;

public class Roedor implements Runnable{
    private String nombre;
    private int tiempoEnComer;
    private Color color;
    private Emoji emoji;

    public Roedor(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.color = color;
        this.emoji = emoji;
    }

    public void comer(){
        try {
            //ASIGNO SEGUN EL TIEMPO LA PRIORIDAD CUANTO MAS TIEMPO MENOS PRIORIDAD TIENE
            int[] prioridades = {1,2,3,4,5,6,7,8,9,10};
            Thread.currentThread().setPriority(prioridades[tiempoEnComer-1]);
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

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // creamos los ratones
        Roedor taskFievel = new Roedor("Fievel", 4, Color.BLACK, Emoji.RAT);
        Roedor taskJerry = new Roedor("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK);
        Roedor taskPinky = new Roedor("Pinky", 3, Color.RED, Emoji.MOUSE);
        Roedor taskMickey = new Roedor("Mickey", 6, Color.YELLOW, Emoji.HAMSTER);
//        Thread hiloFievel = new Thread(taskFievel);
//        Thread hiloJerry = new Thread(taskJerry);
//        Thread hiloPinky = new Thread(taskPinky);
//        Thread hiloMickey = new Thread(taskMickey);

        ArrayList<Roedor> roedores = new ArrayList<Roedor>();

        roedores.add(taskFievel);
        roedores.add(taskJerry);
        roedores.add(taskPinky);
        roedores.add(taskMickey);

        menu(roedores);
    }

    public static void menu(ArrayList<Roedor> roedores){
        int num;
        System.out.println("----------MENU----------");
        System.out.println("1- Comer educadamente");
        System.out.println("2- Comer salvajemente");
        System.out.println("0 - Salir");

        num = sc.nextInt();

        switch (num){
            case 1:
                educados(roedores);
                break;
            case 2:
                salvajes(roedores);
                break;
            case 0:
                System.out.println("Saliendo ....");
                break;
        }

    }
    public static void educados(ArrayList<Roedor> roedores){

        // Crear una lista dinámica para los hilos
        ArrayList<Thread> hilos = new ArrayList<>();

        //Tengo a los roedores pero necesito meterlos en hilos
        for (Roedor roedor : roedores) {
            Thread hilo = new Thread(roedor);
            hilos.add(hilo);
        }
        //recorro cada hhilo y lo incio
        for (Thread hilo : hilos) {
            hilo.start();
            try{
                hilo.join();
            }catch (InterruptedException ex){
                System.out.println("Error de hilo");
            }
        }
        menu(roedores);

    }
    public static void salvajes(ArrayList<Roedor> roedores){
        ArrayList<Thread> hilos = new ArrayList<>();

        for (Roedor roedor : roedores) {
            Thread hilo = new Thread(roedor);
            hilos.add(hilo);
        }

        for (Thread hilo : hilos) {
            hilo.start();
        }
        menu(roedores);
    }
}
