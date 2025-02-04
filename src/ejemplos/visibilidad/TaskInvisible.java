package ejemplos.visibilidad;

import java.util.Random;

/**
 * Clase TaskInvisible
 * Implementa run(), donde se crea un ejemploVisibilidad y se incrementa en cinco, y muestra el nombre del hilo y el valor resultante.
 */

class TaskInvisible implements Runnable {
    private EjemploInvisibilidad ejemploInvisibilidad;

    public TaskInvisible(EjemploInvisibilidad ejemploInvisibilidad) {
        this.ejemploInvisibilidad = ejemploInvisibilidad;
    }

    @Override
    public void run() {
       ejemploInvisibilidad.incrementar(5);
        System.out.println(Thread.currentThread().getName() + " - Valor resultante invisibilidad: " +ejemploInvisibilidad.getNumero() );
    }
}

