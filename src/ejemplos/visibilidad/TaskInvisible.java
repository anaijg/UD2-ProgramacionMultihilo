package ejemplos.visibilidad;

import java.util.Random;

/**
 * Clase TaskInvisible
 * Implementa run(), donde se crea un ejemploVisibilidad y se incrementa en cinco, y muestra el nombre del hilo y el valor resultante.
 */

class TaskInvisible {

    Runnable runnable = () -> {
        EjemploInvisible ejemploInvisible = new EjemploInvisible(5);
        System.out.println(Thread.currentThread().getName() + " " + ejemploInvisible.getNumero());
    };

    /**
     * Clase TaskVisible
     * Implementa run(), donde se crea un ejemploVisibilidad y se incrementa en cinco y muestra el nombre del hilo y el valor resultante.
     */

    Runnable runnable2 = () -> {
        EjemploVisible ejemploVisible = new EjemploVisible();
        ejemploVisible.incrementar(5);
        System.out.println(Thread.currentThread().getName() + " " + ejemploVisible.getNumero());
    };
}

