package ejercicios.ejercicio4;

import ejercicios.ejercicio2.Roedor_DanielH;
import utilidades.Color;
import utilidades.Emoji;

import java.util.*;

public class Ejercicio4_DanielH {

    private static Scanner sc = new Scanner(System.in);

    private static void waitFood() throws InterruptedException {
        Roedor_DanielH jerry = new Roedor_DanielH("Jerry", 5, Color.PURPLE, Emoji.CHIPMUNK);
        Roedor_DanielH mickey = new Roedor_DanielH("Mickey", 6, Color.RED, Emoji.HAMSTER);
        Roedor_DanielH pinky = new Roedor_DanielH("Pinky", 3, Color.CYAN, Emoji.MOUSE);
        Roedor_DanielH fievel = new Roedor_DanielH("Fievel", 4, Color.YELLOW, Emoji.RAT);

        Thread taskJerry = new Thread(jerry);
        Thread taskMickey = new Thread(mickey);
        Thread taskPinky = new Thread(pinky);
        Thread taskFievel = new Thread(fievel);
        //Prioridades
        taskJerry.setPriority(1);
        taskMickey.setPriority(4);
        taskPinky.setPriority(2);
        taskFievel.setPriority(3);
        //Lista de los hilos que va a ser ordenada
        List<Thread> tasks = Arrays.asList(taskJerry, taskMickey, taskPinky, taskFievel);
        tasks.sort(Comparator.comparingInt(Thread::getPriority));

        for (Thread task : tasks) {
            task.start();
            task.join();
        }
    }

    private static void noWaitFood() {
        Roedor_DanielH jerry = new Roedor_DanielH("Jerry", 5, Color.PURPLE, Emoji.CHIPMUNK);
        Roedor_DanielH mickey = new Roedor_DanielH("Mickey", 6, Color.RED, Emoji.HAMSTER);
        Roedor_DanielH pinky = new Roedor_DanielH("Pinky", 3, Color.CYAN, Emoji.MOUSE);
        Roedor_DanielH fievel = new Roedor_DanielH("Fievel", 4, Color.YELLOW, Emoji.RAT);

        Thread taskJerry = new Thread(jerry);
        Thread taskMickey = new Thread(mickey);
        Thread taskPinky = new Thread(pinky);
        Thread taskFievel = new Thread(fievel);
        taskJerry.start();
        taskMickey.start();
        taskPinky.start();
        taskFievel.start();
    }

    private static void procesarOpcionMenuRoedores(int numOpcion) throws InterruptedException {
        switch (numOpcion) {
            case 0 -> sc.close();
            case 1 -> waitFood();
            case 2 -> noWaitFood();
            default ->
                    System.out.println(Color.RED.getCode() + "El numero indicado no es el correcto por favor vuelva a elegir :)" + Color.RESET.getCode());

        }
    }

    private static void mostrarMenuRoedores() {
        System.out.println(Color.YELLOW.getCode() + "------------------------------------" + Color.RESET.getCode());
        System.out.println(Color.PURPLE.getCode() + "Menu Roedores" + Emoji.MOUSE.getEmoji() + Color.RESET.getCode());
        System.out.println(Color.CYAN.getCode() + "1. Esperar a que el roedor termine de comer" + Color.RESET.getCode());
        System.out.println(Color.BLUE.getCode() + "2. No esperar a que el roedor termine de comer" + Color.RESET.getCode());
        System.out.println(Color.BLUE.getCode() + "0. Salir del programa" + Color.RESET.getCode());
        System.out.println(Color.YELLOW.getCode() + "------------------------------------" + Color.RESET.getCode());
    }

    public static void main(String[] args) throws InterruptedException {
        int numOpcion;
        do {
            mostrarMenuRoedores();
            numOpcion = sc.nextInt();
            procesarOpcionMenuRoedores(numOpcion);
        } while (numOpcion != 0);
    }
}