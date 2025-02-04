package ejemplos.visibilidad;

import ejemplos.memoriacompartida.Contador;

import java.util.Random;

/**
 * Clase TaskVisible
 * Implementa run(), donde se crea un ejemploVisibilidad y se incrementa en cinco y muestra el nombre del hilo y el valor resultante.
 */
public class TaskVisible implements Runnable{
    EjemploVisible ejemploVisible;

    public TaskVisible(EjemploVisible ejemploVisible) {
        this.ejemploVisible = ejemploVisible;
    }
    @Override
    public void run() {
        ejemploVisible.incrementar(5);
        System.out.println("El nombre del hilo es: " + Thread.currentThread().getName() + " y su valor es: " + ejemploVisible.getNumero());
    }

}