package ejemplos.visibilidad;

/** * En el main se crean dos hilos (workers) visibles y otros dos invisibles y se comprueba si hay diferencia en el resultado. * */

public class Main {
    public static void main(String[] args) {
        // Crear dos hilos visibles
        Thread visibleWorker1 = new Thread(new TaskVisible(), "Visible 1");
        Thread visibleWorker2 = new Thread(new TaskVisible(), "Visible 2");

        // Crear dos hilos invisibles
        Thread invisibleWorker1 = new Thread(new TaskInvisible(), "Invisible 1");
        Thread invisibleWorker2 = new Thread(new TaskInvisible(), "Invisible 2");

        // Iniciar los hilos visibles
        visibleWorker1.start();
        visibleWorker2.start();

        // Iniciar los hilos invisibles
        invisibleWorker1.start();
        invisibleWorker2.start();

        // Esperar a que los hilos terminen
        try {
            visibleWorker1.join();
            visibleWorker2.join();
            invisibleWorker1.join();
            invisibleWorker2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Resultado
        System.out.println("Ejecución completa. Comprobar los resultados.");
    }
}
