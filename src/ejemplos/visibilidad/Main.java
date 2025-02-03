package ejemplos.visibilidad;

/**
 * En el main se crean dos hilos (workers) visibles y otros dos invisibles y se comprueba si hay diferencia en el resultado.
 *
 */

public class Main {
    public static void main(String[] args) {

        EjemploVisible ejemploVisible = new EjemploVisible(0);

        Thread visibleTD1 = new Thread(new TaskVisible(ejemploVisible), "WorkerVisible-1");
        Thread visibleTD2 = new Thread(new TaskVisible(ejemploVisible), "WorkerVisible-2");

        visibleTD1.start();
        visibleTD2.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread invisibleThread1 = new Thread(new TaskInvisible(), "WorkerInvisible-1");
        Thread invisibleThread2 = new Thread(new TaskInvisible(), "WorkerInvisible-2");

        invisibleThread1.start();
        invisibleThread2.start();

        try {
            visibleTD1.join();
            visibleTD2.join();
            invisibleThread1.join();
            invisibleThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Valor final de EjemploVisible: " + ejemploVisible.getNumero());
    }
}