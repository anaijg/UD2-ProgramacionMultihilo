package ejemplos.visibilidad;

/**
 * Clase TaskInvisible
 * Implementa run(), donde se crea un ejemploVisibilidad y se incrementa en cinco, y muestra el nombre del hilo y el valor resultante.
 */

public class TaskInvisible extends Thread{
    @Override
    public void run() {
        EjemploInvisible ejemploInvisible = new EjemploInvisible(0);

        ejemploInvisible.incrementar(5);
        String nombre = Thread.currentThread().getName();
        System.out.println("Nombre del hilo: " + nombre);
        System.out.println("Numero resultante: " + ejemploInvisible.getNumero());
    }
}
