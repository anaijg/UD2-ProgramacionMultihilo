package ejemplos.visibilidad;

import java.util.Random;

/**
 * Clase TaskVisible
 * Implementa run(), donde se crea un ejemploVisibilidad y se incrementa en cinco y muestra el nombre del hilo y el valor resultante.
 */
public class TaskVisible implements Runnable {

    public TaskVisible(EjemploVisible ejemploVisible) {
    }

    @Override
    public void run() {
        EjemploInvisible ejemplo = new EjemploInvisible(0);
        ejemplo.incrementar(5);
        System.out.println(Thread.currentThread().getName() + " - Valor del ejemplo: " + ejemplo.getNumero());
    }
}