package ejemplos.visibilidad;

public class Main {
    public static void main(String[] args) {

        TaskInvisible task1 = new TaskInvisible("Hilo invisible 1");
        TaskInvisible task2 = new TaskInvisible("Hilo invisible 2");

        TaskVisible taskv1 = new TaskVisible("Hilo visible 1");
        TaskVisible taskv2 = new TaskVisible("Hilo visible 2");

        task1.start();
        task2.start();

        taskv1.start();
        taskv2.start();
    }
}
/**
 * En el main se crean dos hilos (workers) visibles y otros dos invisibles y se comprueba si hay diferencia en el resultado.
 *
 */
