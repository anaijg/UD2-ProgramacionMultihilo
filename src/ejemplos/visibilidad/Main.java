package ejemplos.visibilidad;

/**
 * En el main se crean dos hilos (workers) visibles y otros dos invisibles y se comprueba si hay diferencia en el resultado.
 *
 */
class Main {
    public static void main(String[] args) {
        TaskInvisible task = new TaskInvisible();
        Thread hilo1 = new Thread(task.runnable, "hilo1");
        Thread hilo2 = new Thread(task.runnable2, "hilo2");

        hilo1.start();
        hilo2.start();
    }
}
