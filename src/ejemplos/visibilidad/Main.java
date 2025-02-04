package ejemplos.visibilidad;

/**
 * En el main se crean dos hilos (workers) visibles y otros dos invisibles y se comprueba si hay diferencia en el resultado.
 *
 */

public class Main {
    public static void main(String[] args) {
        TaskVisible hilo1 = new TaskVisible();
        TaskVisible hilo2 = new TaskVisible();

        TaskInvisible hilo3 = new TaskInvisible();
        TaskInvisible hilo4 = new TaskInvisible();

        System.out.println("Hilos con visivibilidad");
        hilo1.start();
        try {
            hilo1.join();
        } catch (InterruptedException e) {
            System.out.println("Error " + e.getMessage());
        }

        hilo2.start();
        try {
            hilo2.join();
        } catch (InterruptedException e) {
            System.out.println("Error " + e.getMessage());
        }

        System.out.println("\nHilos sin invisibilidad");
        hilo3.start();
        try {
            hilo3.join();
        } catch (InterruptedException e) {
            System.out.println("Error" + e.getMessage());

        }

        hilo4.start();
        try {
            hilo4.join();
        } catch (InterruptedException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}