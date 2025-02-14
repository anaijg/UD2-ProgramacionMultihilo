package ejemplos.visibilidad;

/**
 * Clase TaskVisible
 * Implementa run(), donde se crea un ejemploVisibilidad y se incrementa en cinco y muestra el nombre del hilo y el valor resultante.
 */
public class TaskVisibleAlejandro implements Runnable{
    EjemploVisibleAlejandro ejemploVisibleAlejandro;

    public TaskVisibleAlejandro(EjemploVisibleAlejandro ejemploVisibleAlejandro) {
        this.ejemploVisibleAlejandro = ejemploVisibleAlejandro;
    }

    @Override
    public void run() {
        ejemploVisibleAlejandro.incrementar(5);
        System.out.println("El nombre del hilo es: " + Thread.currentThread().getName() + " y su valor es: " + ejemploVisibleAlejandro.getValor());
    }
}