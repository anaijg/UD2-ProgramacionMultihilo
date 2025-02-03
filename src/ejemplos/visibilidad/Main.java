package ejemplos.visibilidad;

/**
 * En el main se crean dos hilos (workers) visibles y otros dos invisibles y se comprueba si hay diferencia en el resultado.
 *
 */
public class Main
{
    public static void main(String[] args)
    {
        EjemploVisible ejemploVisible = new EjemploVisible(0);
        EjemploInvisible ejemploInvisible = new EjemploInvisible(0);

        Thread worker1 = new Thread(new TaskVisible());
        Thread worker2 = new Thread(new TaskVisible());

        worker1.start();
        worker2.start();
    }
}