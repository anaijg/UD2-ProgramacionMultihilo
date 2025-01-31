package ejemplos.visibilidad;

import java.util.Random;

public class TaskVisible extends Thread {
    public TaskVisible(String name) {
        super(name);
    }

    @Override
    public void run() {
        EjemploVisible ejemploVisible = new EjemploVisible(5);
        ejemploVisible.incrementar(5);

        System.out.println(Thread.currentThread().getName() + ": " + ejemploVisible.getNumero());
    }
}
/**
 * Clase TaskVisible
 * Implementa run(), donde se crea un ejemploVisibilidad y se incrementa en cinco y muestra el nombre del hilo y el valor resultante.
 */
