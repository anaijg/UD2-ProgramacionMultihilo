package ejemplos.visibilidad;

import java.util.Random;

/**
 * Clase TaskVisible
 * Implementa run(), donde se crea un ejemploVisibilidad y se incrementa en cinco y muestra el nombre del hilo y el valor resultante.
 */
public class TaskVisible implements Runnable {
    @Override
    public void run() {
        // Crear una instancia de EjemploVisibilidad con un valor inicial aleatorio
        Random rand = new Random();
        int valorInicial = rand.nextInt(100); // Número aleatorio entre 0 y 99
        EjemploVisibilidad ejemplo = new EjemploVisibilidad(valorInicial);

        // Incrementar el valor de numero en 5
        ejemplo.incrementar(5);

        // Mostrar el nombre del hilo y el valor resultante de numero
        System.out.println("Hilo: " + Thread.currentThread().getName() + ", Valor resultante: " + ejemplo.getNumero());
    }
}
