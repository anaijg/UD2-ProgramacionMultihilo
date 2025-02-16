package ejemplos.visibilidad;

import java.util.Random;

/**
 * Clase TaskVisible
 * Implementa run(), donde se crea un ejemploVisibilidad y se incrementa en cinco y muestra el nombre del hilo y el valor resultante.
 */
public class TaskVisible implements Runnable {
    private final EjemploVisible ejemploVisible;

    public TaskVisible(EjemploVisible ejemploVisible) {
        this.ejemploVisible = ejemploVisible;
    }

    @Override
    public void run() {
        ejemploVisible.incrementar(5);
        System.out.println(Thread.currentThread().getName() + " - Valor del ejemplo visible: " + ejemploVisible.getNumero());
    }
}