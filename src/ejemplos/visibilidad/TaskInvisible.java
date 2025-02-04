package ejemplos.visibilidad;

import java.util.Random;

/**
 * Clase TaskInvisible
 * Implementa run(), donde se crea un ejemploVisibilidad y se incrementa en cinco, y muestra el nombre del hilo y el valor resultante.
 */

class TaskInvisible implements Runnable {
    @Override
    public void run() {
        EjemploVisibilidad ejemplo = new EjemploVisibilidad(0);
        ejemplo.incrementar(5);
        System.out.println(Thread.currentThread().getName() + " - Valor resultante: " + ejemplo.getNumero());
    }
}