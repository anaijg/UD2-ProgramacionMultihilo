package ejemplos.visibilidad;

public class Main {
    public static void main(String[] args) {
        EjemploVisible ejemploVisible = new EjemploVisible(0);

        Thread visibleWorker1 = new Thread(new TaskVisible(ejemploVisible));
        Thread visibleWorker2 = new Thread(new TaskVisible(ejemploVisible));

        Thread invisibleWorker1 = new Thread(new TaskInvisible());
        Thread invisibleWorker2 = new Thread(new TaskInvisible());

        visibleWorker1.start();
        visibleWorker2.start();
        invisibleWorker1.start();
        invisibleWorker2.start();

        try {
            visibleWorker1.join();
            visibleWorker2.join();
            invisibleWorker1.join();
            invisibleWorker2.join();
        } catch (InterruptedException e) {
            System.out.println("Algo ha ido mal en algún join()");
        }

        System.out.println("Valor final del ejemplo visible: " + ejemploVisible.getNumero());
    }
}