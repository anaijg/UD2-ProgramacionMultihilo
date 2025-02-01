package ejemplos.visibilidad;

import java.util.Random;

/**
 * Clase TaskInvisible
 * Implementa run(), donde se crea un ejemploVisibilidad y se incrementa en cinco, y muestra el nombre del hilo y el valor resultante.
 */

public class TaskInvisible extends Thread {
    @Override
    public void run() {
        EjemploInvisible Ejemplo = new EjemploInvisible();
        Ejemplo.incrementar(5);
        System.out.println( Thread.currentThread().getName() + ", ejemplo invisible " + Ejemplo.getValor());
    }
}
