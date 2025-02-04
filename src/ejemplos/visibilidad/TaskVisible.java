package ejemplos.visibilidad;

import java.util.Random;

/**
 * Clase TaskVisible
 * Implementa run(), donde se crea un ejemploVisibilidad y se incrementa en cinco y muestra el nombre del hilo y el valor resultante.
 */

class TaskVisible extends Thread{
    @Override
    public void run() {
        EjemploVisible ejemplo = new EjemploVisible(0);
        ejemplo.incrementar(3);
        System.out.println(Thread.currentThread().getName() + ": " + ejemplo.getNumero());
    }
}