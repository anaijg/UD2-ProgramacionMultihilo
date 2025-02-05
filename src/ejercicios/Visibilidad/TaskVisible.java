package ejercicios.Visibilidad;

import java.util.Random;

/**
 * Clase TaskVisible
 * Implementa run(), donde se crea un ejemploVisibilidad y se incrementa en cinco y muestra el nombre del hilo y el valor resultante.
 */

public class TaskVisible extends Thread {
    @Override
    public void run() {
        EjemploInvisible Visible = new EjemploInvisible();
        Visible.incrementar(5);
        System.out.println( Thread.currentThread().getName() + " ejemplo visible, valor numero: " + Visible.getValor());
    }
}