package ejercicios.Visibilidad;

/**
 * En el main se crean dos hilos (workers) visibles y otros dos invisibles y se comprueba si hay diferencia en el resultado.
 *
 */
public class Main {
    public static void main(String[] args) {
        TaskVisible Visible1 = new TaskVisible();
        TaskVisible Visible2 = new TaskVisible();

        Visible1.start();
        Visible2.start();

        TaskInvisible Invisible1 = new TaskInvisible();
        TaskInvisible Invisible2 = new TaskInvisible();

        Invisible1.start();
        Invisible2.start();
    }
}