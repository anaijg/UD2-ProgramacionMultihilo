package ejercicios.ejercicio2;

public class Ejercicio2_Roedor_Gonzalo implements Runnable {
    private String nombre;
    private int tiempoEnComer;
    private Ejercicio2_Color_Gonzalo color;
    private Ejercicio2_Emoji_Gonzalo emoji;

    public Ejercicio2_Roedor_Gonzalo(String nombre, int tiempoEnComer, Ejercicio2_Color_Gonzalo color, Ejercicio2_Emoji_Gonzalo emoji) {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.color = color;
        this.emoji = emoji;
    }

    public void comer() {
        System.out.println(color + " " + nombre + " (" + emoji + ") ha comenzado a comer.");

        try {
            Thread.sleep(tiempoEnComer * 1000);
        } catch (InterruptedException e) {
            System.out.println("El roedor " + nombre + " fue interrumpido mientras comía.");
        }

        System.out.println(color + " " + nombre + " (" + emoji + ") ha terminado de comer.");
    }

    @Override
    public void run() {
        comer();
    }

    public static void main(String[] args) {
        Ejercicio2_Roedor_Gonzalo fievel = new Ejercicio2_Roedor_Gonzalo("Fievel", 4, Ejercicio2_Color_Gonzalo.GRIS, Ejercicio2_Emoji_Gonzalo.RATA);
        Ejercicio2_Roedor_Gonzalo jerry = new Ejercicio2_Roedor_Gonzalo("Jerry", 5, Ejercicio2_Color_Gonzalo.MARRON, Ejercicio2_Emoji_Gonzalo.ARDILLA);
        Ejercicio2_Roedor_Gonzalo pinky = new Ejercicio2_Roedor_Gonzalo("Pinky", 3, Ejercicio2_Color_Gonzalo.BLANCO, Ejercicio2_Emoji_Gonzalo.RATON);
        Ejercicio2_Roedor_Gonzalo mickey = new Ejercicio2_Roedor_Gonzalo("Mickey", 6, Ejercicio2_Color_Gonzalo.AMARILLO, Ejercicio2_Emoji_Gonzalo.HAMSTER);

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
