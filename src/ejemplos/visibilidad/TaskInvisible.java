package ejemplos.visibilidad;

/**
 * Clase TaskInvisible
 * Implementa run(), donde se crea un ejemploVisibilidad y se incrementa en cinco, y muestra el nombre del hilo y el valor resultante.
 */

public class TaskInvisible implements Runnable {
    @Override
    public void run() {
        EjemploInvisible ejemplo = new EjemploInvisible(0);
        ejemplo.incrementar(5);
        System.out.println(Thread.currentThread().getName() + " - Valor: " + ejemplo.getNumero());
    }
}