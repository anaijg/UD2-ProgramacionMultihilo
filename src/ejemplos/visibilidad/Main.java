package ejemplos.visibilidad;

/**
 * En el main se crean dos hilos (workers) visibles y otros dos invisibles y se comprueba si hay diferencia en el resultado.
 *
 */
public class Main {
    public static void main(String[] args) {
        TaskVisible taskVisible1 = new TaskVisible();
        TaskVisible taskVisible2 = new TaskVisible();

        taskVisible1.start();
        taskVisible2.start();

        TaskInvisible taskInvisible1 = new TaskInvisible();
        TaskInvisible taskInvisible2 = new TaskInvisible();

        taskInvisible1.start();
        taskInvisible2.start();
    }
}

