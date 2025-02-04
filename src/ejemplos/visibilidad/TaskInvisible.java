package ejemplos.visibilidad;

import java.util.Random;

/**
 * Clase TaskInvisible
 * Implementa run(), donde se crea un ejemploVisibilidad y se incrementa en cinco, y muestra el nombre del hilo y el valor resultante.
 */

class TaskInvisible extends Thread{
    @Override
    public void run() {
        EjemploInvisible ejemplo = new EjemploInvisible(0);
        ejemplo.incrementar(3);
        System.out.println(Thread.currentThread().getName() + ": " + ejemplo.getNumero());
    }
}
