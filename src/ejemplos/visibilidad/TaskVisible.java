package ejemplos.visibilidad;

import java.util.Random;

/**
 * Clase TaskVisible
 * Implementa run(), donde se crea un ejemploVisibilidad y se incrementa en cinco y muestra el nombre del hilo y el valor resultante.
 */

class TaskVisible {


    Runnable runnable = () -> {
        EjemploVisible ejemploVisible = new EjemploVisible(5);
        System.out.println(Thread.currentThread().getName()+ " " + ejemploVisible.getNumero());
    };
}