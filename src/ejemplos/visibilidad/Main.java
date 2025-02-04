package ejemplos.visibilidad;

/**
 * En el main se crean dos hilos (workers) visibles y otros dos invisibles y se comprueba si hay diferencia en el resultado.
 *
 */
public class Main
{
    public static void main(String[] args)
    {
        EjemploVisible ejVisible = new EjemploVisible(0);
        EjemploInvisible ejInvisible = new EjemploInvisible(0);

        Thread worker1Visible = new Thread(new TaskVisible(ejVisible));
        Thread worker2Visible = new Thread(new TaskVisible(ejVisible));
        Thread worker1Invisible = new Thread(new TaskInvisible(ejInvisible));
        Thread worker2Invisible = new Thread(new TaskInvisible(ejInvisible));

        worker1Visible.start();
        worker2Visible.start();
        worker1Invisible.start();
        worker2Invisible.start();
    }
}