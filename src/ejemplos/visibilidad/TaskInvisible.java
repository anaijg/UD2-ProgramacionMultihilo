package ejemplos.visibilidad;

import java.util.Random;

public class TaskInvisible extends Thread {
    public TaskInvisible(String name) {
        super(name);
    }

    @Override
    public void run() {
        EjemploInvisible ejemploInvisible = new EjemploInvisible(5);
        ejemploInvisible.incrementar(5);

        System.out.println(Thread.currentThread().getName() + ": " + ejemploInvisible.getNumero());
    }
}
/**
 * Clase TaskInvisible
 * Implementa run(), donde se crea un ejemploVisibilidad y se incrementa en cinco, y muestra el nombre del hilo y el valor resultante.
 */

