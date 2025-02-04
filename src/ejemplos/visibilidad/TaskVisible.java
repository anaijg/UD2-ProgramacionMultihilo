package ejemplos.visibilidad;



/**
 * Clase TaskVisible
 * Implementa run(), donde se crea un ejemploVisibilidad y se incrementa en cinco y muestra el nombre del hilo y el valor resultante.
 */


public class TaskVisible extends Thread{
    @Override
    public void run() {
        EjemploVisible prueba = new EjemploVisible(0);
        prueba.incrementar(5);
        System.out.println( Thread.currentThread().getName() + "valor " + prueba.getValor());
    }
}