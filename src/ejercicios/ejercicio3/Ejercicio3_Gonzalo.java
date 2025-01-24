package ejercicios.ejercicio3;

import utilidades.Color;
import utilidades.Emoji;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ejercicio3_Gonzalo implements Runnable {
    private String nombre;
    private int tiempoEnComer;
    private Color color;
    private Emoji emoji;
    private static final Lock lock = new ReentrantLock();

    public Ejercicio3_Gonzalo(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.color = color;
        this.emoji = emoji;
    }

    public void comer() {
        lock.lock(); 
        try {
            System.out.println(color.getCode() + nombre + " " + emoji.getEmoji() + " ha comenzado a comer." + Color.RESET.getCode());
            Thread.sleep(tiempoEnComer * 1000); 
            System.out.println(color.getCode() + nombre + " " + emoji.getEmoji() + " ha terminado de comer." + Color.RESET.getCode());
        } catch (InterruptedException e) {
            System.out.println("El roedor " + nombre + " fue interrumpido mientras comía.");
        } finally {
            lock.unlock(); 
        }
    }

    @Override
    public void run() {
        comer();
    }

    public static void main(String[] args) {
        Ejercicio3_Gonzalo fievel = new Ejercicio3_Gonzalo("Fievel", 4, Color.YELLOW, Emoji.RAT);
        Ejercicio3_Gonzalo jerry = new Ejercicio3_Gonzalo("Jerry", 5, Color.BLUE, Emoji.CHIPMUNK);
        Ejercicio3_Gonzalo pinky = new Ejercicio3_Gonzalo("Pinky", 3, Color.CYAN, Emoji.MOUSE);
        Ejercicio3_Gonzalo mickey = new Ejercicio3_Gonzalo("Mickey", 6, Color.GREEN, Emoji.HAMSTER);

        Thread hiloFievel = new Thread(fievel);
        Thread hiloJerry = new Thread(jerry);
        Thread hiloPinky = new Thread(pinky);
        Thread hiloMickey = new Thread(mickey);

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
            System.out.println("El hilo principal fue interrumpido.");
        }

        System.out.println("Todos los roedores han terminado de comer.");
    }
}