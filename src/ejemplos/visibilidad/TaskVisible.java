package ejemplos.visibilidad;


/**
 * Clase TaskVisible
 * Implementa run(), donde se crea un ejemploVisibilidad y se incrementa en cinco y muestra el nombre del hilo y el valor resultante.
 */

public class TaskVisible implements Runnable {
    private final EjemploVisible ejemplo;

    public TaskVisible(EjemploVisible ejemplo) {
        this.ejemplo = ejemplo;
    }

    @Override
    public void run() {
        ejemplo.incrementar(5);
        System.out.println(Thread.currentThread().getName() + " - Valor: " + ejemplo.getNumero());
    }
}