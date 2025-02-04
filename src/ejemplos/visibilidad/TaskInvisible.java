package ejemplos.visibilidad;

import java.util.Random;

/**
 * Clase TaskInvisible
 * Implementa run(), donde se crea un ejemploVisibilidad y se incrementa en cinco, y muestra el nombre del hilo y el valor resultante.
 */
public class TaskInvisible implements Runnable
{
    private EjemploInvisible ejemploInvisible;
    public TaskInvisible(EjemploInvisible ej)
    {
        this.ejemploInvisible = ej;
    }
    @Override
    public void run()
    {
        ejemploInvisible.incrementar(5);
        System.out.println(Thread.currentThread().getName() + " - " + ejemploInvisible.getNumero());
    }
}