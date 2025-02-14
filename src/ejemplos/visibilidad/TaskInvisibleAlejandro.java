package ejemplos.visibilidad;

/**
 * Clase TaskInvisible
 * Implementa run(), donde se crea un ejemploVisibilidad y se incrementa en cinco, y muestra el nombre del hilo y el valor resultante.
 */
public class TaskInvisibleAlejandro implements Runnable{
    EjemploInvisibleAlejandro ejemploInvisibleAlejandro;

    public TaskInvisibleAlejandro(EjemploInvisibleAlejandro ejemploInvisibleAlejandro) {
        this.ejemploInvisibleAlejandro = ejemploInvisibleAlejandro;
    }

    @Override
    public void run() {
        ejemploInvisibleAlejandro.incrementar(5);
        System.out.println("El nombre del hilo es: " + Thread.currentThread().getName() + " y su valor es: " + ejemploInvisibleAlejandro.getValor());
    }

}
