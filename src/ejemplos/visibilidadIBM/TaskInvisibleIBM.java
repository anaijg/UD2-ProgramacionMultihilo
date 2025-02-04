package ejemplos.visibilidadIBM;

class TaskInvisibleIBM implements Runnable
{
    private final EjemploInvisibleIBM ejemplo;

    public TaskInvisibleIBM(EjemploInvisibleIBM ejemplo) {
        this.ejemplo = ejemplo;
    }

    @Override
    public void run() {
        ejemplo.incrementar(5);
        System.out.println(Thread.currentThread().getName() + " - Valor invisible: " + ejemplo.getNumero());
    }
}
/**
 * Clase TaskInvisible
 * Implementa run(), donde se crea un ejemploVisibilidad y se incrementa en cinco, y muestra el nombre del hilo y el valor resultante.
 */