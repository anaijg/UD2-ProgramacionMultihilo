package ejemplos.visibilidad;

/**
 * En el main se crean dos hilos (workers) visibles y otros dos invisibles y se comprueba si hay diferencia en el resultado.
 *
 */

public class Main {
    public static void main(String[] args) {

        TaskInvisible taskInvisible = new TaskInvisible();
        TaskVisible taskVisible = new TaskVisible();
        Thread hilo1 = new Thread(taskInvisible.runnable, "Hilo1");
        Thread hilo2 = new Thread(taskVisible.runnable, "Hilo2");

        try {
            hilo1.start();
            hilo2.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
