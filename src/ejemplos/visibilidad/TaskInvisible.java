package ejemplos.visibilidad;

/**
 * Clase TaskInvisible
 * Implementa run(), donde se crea un ejemploVisibilidad y se incrementa en cinco, y muestra el nombre del hilo y el valor resultante.
 */

public class TaskInvisible extends Thread{
    @Override
    public void run() {
        EjemploInvisible prueba = new EjemploInvisible(0);
        prueba.incrementar(5);

        System.out.println( Thread.currentThread().getName() + " valor " + prueba.getValor());
    }
}