package ejemplos.visibilidad;

/**
 * En el main se crean dos hilos (workers) visibles y otros dos invisibles y se comprueba si hay diferencia en el resultado.
 *
 */
class Main {
    public static void main(String[] args) {
        TaskInvisible task = new TaskInvisible();
        Thread hilo1Invisible = new Thread(task.runnableInvisible, "hilo invisible 1");
        Thread hilo2Invisible = new Thread(task.runnableInvisible, "hilo invisible 2");

        Thread hilo1Visible = new Thread(task.runnableVisible, "hilo visible 1");
        Thread hilo2Visible = new Thread(task.runnableVisible, "hilo visible 2");

        hilo1Invisible.start();
        hilo2Invisible.start();
        hilo1Visible.start();
        hilo2Visible.start();

    }
}
