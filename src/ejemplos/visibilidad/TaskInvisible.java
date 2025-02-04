package ejemplos.visibilidad;

import java.util.Random;

/**
 * Clase TaskInvisible
 * Implementa run(), donde se crea un ejemploVisibilidad y se incrementa en cinco, y muestra el nombre del hilo y el valor resultante.
 */

class TaskInvisible {

    Runnable runnableInvisible = () -> {
        EjemploInvisible ejemploInvisible = new EjemploInvisible(5);
        System.out.println(Thread.currentThread().getName() + " " + ejemploInvisible.getNumero());
    };

    /**
     * Clase TaskVisible
     * Implementa run(), donde se crea un ejemploVisibilidad y se incrementa en cinco y muestra el nombre del hilo y el valor resultante.
     */

    Runnable runnableVisible = () -> {
        EjemploVisible ejemploVisible = new EjemploVisible();
        ejemploVisible.incrementar(5);
        System.out.println(Thread.currentThread().getName() + " " + ejemploVisible.getNumero());
    };
}

