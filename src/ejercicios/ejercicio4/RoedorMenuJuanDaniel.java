package ejercicios.ejercicio4;

import utilidades.Color;
import utilidades.Emoji;

import java.util.Scanner;

public class RoedorMenuJuanDaniel implements Runnable{
    private String nombre;
    private int tiempoEnComer;
    private Color color;
    private Emoji emoji;

    public RoedorMenuJuanDaniel(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
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
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException {
        // creamos los ratones
        menu();



    }
    public static void espera() throws InterruptedException {
        RoedorMenuJuanDaniel taskFievel = new RoedorMenuJuanDaniel("Fievel", 4, Color.BLACK, Emoji.RAT);
        RoedorMenuJuanDaniel taskJerry = new RoedorMenuJuanDaniel("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK);
        RoedorMenuJuanDaniel taskPinky = new RoedorMenuJuanDaniel("Pinky", 3, Color.RED, Emoji.MOUSE);
        RoedorMenuJuanDaniel taskMickey = new RoedorMenuJuanDaniel("Mickey", 6, Color.YELLOW, Emoji.HAMSTER);


        Thread hiloFievel = new Thread(taskFievel);
        Thread hiloJerry = new Thread(taskJerry);
        Thread hiloPinky = new Thread(taskPinky);
        Thread hiloMickey = new Thread(taskMickey);

        hiloFievel.start();
        hiloFievel.join();

        hiloJerry.start();
        hiloJerry.join();

        hiloPinky.start();
        hiloPinky.join();

        hiloMickey.start();
        hiloMickey.join();
    }

    public static void noEspera(){
        RoedorMenuJuanDaniel taskFievel = new RoedorMenuJuanDaniel("Fievel", 4, Color.BLACK, Emoji.RAT);
        RoedorMenuJuanDaniel taskJerry = new RoedorMenuJuanDaniel("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK);
        RoedorMenuJuanDaniel taskPinky = new RoedorMenuJuanDaniel("Pinky", 3, Color.RED, Emoji.MOUSE);
        RoedorMenuJuanDaniel taskMickey = new RoedorMenuJuanDaniel("Mickey", 6, Color.YELLOW, Emoji.HAMSTER);

        Thread hiloFievel = new Thread(taskFievel);
        Thread hiloJerry = new Thread(taskJerry);
        Thread hiloPinky = new Thread(taskPinky);
        Thread hiloMickey = new Thread(taskMickey);

        // Asignar prioridades
        hiloFievel.setPriority(Thread.MAX_PRIORITY); // Prioridad 10
        hiloJerry.setPriority(8);                   // Prioridad 8
        hiloPinky.setPriority(6);                   // Prioridad 6
        hiloMickey.setPriority(Thread.MIN_PRIORITY);

        hiloFievel.start();

        hiloJerry.start();

        hiloPinky.start();

        hiloMickey.start();

    }

    public static void menu() throws InterruptedException {
        int numero;
        do {
            System.out.println("1: Espera\n2: No espera\n0: Salir");
            numero = teclado.nextInt();
            switch (numero){
                case 1 -> espera();
                case 2 -> noEspera();
            }
        }while (numero != 0 );
    }
}
