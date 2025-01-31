package ejemplos.visibilidad;

import java.util.Random;

/**
 * Clase TaskVisible
 * Implementa run(), donde se crea un ejemploVisibilidad y se incrementa en cinco y muestra el nombre del hilo y el valor resultante.
 */
public class TaskVisible extends Thread{
    @Override
    public void run() {
        EjemploVisible ejemploVisible = new EjemploVisible(0);

        ejemploVisible.incrementar(5);
        String nombre = Thread.currentThread().getName();
        System.out.println("Nombre del hilo: " + nombre);
        System.out.println("Numero resultante: " + ejemploVisible.getNumero());
    }
}
