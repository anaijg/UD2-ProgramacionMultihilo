package ejemplos.visibilidadIBM;

public class Main {
    public static void main(String[] args) {
        Thread hilo1 = new Thread(new TaskVisibleIBM());
        Thread hilo2 = new Thread(new TaskVisibleIBM());

        EjemploInvisibleIBM ejemploInvisible = new EjemploInvisibleIBM(0);
        Thread hilo3 = new Thread(new TaskInvisibleIBM(ejemploInvisible));
        Thread hilo4 = new Thread(new TaskInvisibleIBM(ejemploInvisible));

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
    }
}
/**
 * En el main se crean dos hilos (workers) visibles y otros dos invisibles y se comprueba si hay diferencia en el resultado.
 *
 */
