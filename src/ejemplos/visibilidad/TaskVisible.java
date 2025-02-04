package ejemplos.visibilidad;

import java.util.Random;

/**
 * Clase TaskVisible
 * Implementa run(), donde se crea un ejemploVisibilidad y se incrementa en cinco y muestra el nombre del hilo y el valor resultante.
 */


class TaskVisible implements Runnable {

    private EjemploVisibilidad ejemploVisibilidad;

    public TaskVisible(EjemploVisibilidad ejemploVisibilidad) {
        this.ejemploVisibilidad = ejemploVisibilidad;
    }

    @Override
    public void run() {
        ejemploVisibilidad.incrementar(5);
        System.out.println(Thread.currentThread().getName()+ " - Valor resultante visible: " +ejemploVisibilidad.getNumero());
    }
}
