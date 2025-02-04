package ejemplos.visibilidadIBM;

class TaskVisibleIBM implements Runnable
{
    @Override
    public void run()
    {
        EjemploVisibleIBM ejemplo = new EjemploVisibleIBM(0);
        ejemplo.incrementar(5);
        System.out.println(Thread.currentThread().getName() + " - Valor visible: " + ejemplo.getNumero());
    }
}
/**
 * Clase TaskVisible
 * Implementa run(), donde se crea un ejemploVisibilidad y se incrementa en cinco y muestra el nombre del hilo y el valor resultante.
 */
