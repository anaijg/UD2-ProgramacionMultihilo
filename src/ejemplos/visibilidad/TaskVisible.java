package ejemplos.visibilidad;

public class TaskVisible implements Runnable {

    private Visibilidad visibilidad;

    public TaskVisible(Visibilidad visibilidad) {
        this.visibilidad = visibilidad;
    }

    @Override
    public void run() {
        visibilidad.incrementar(5);

        System.out.println(Thread.currentThread().getName() + " incrementó en: 5");
        System.out.println(Thread.currentThread().getName() + " valor final: " + visibilidad.getEntero());
    }

    public static void main(String[] args) {
        Visibilidad visibilidad = new Visibilidad();

        TaskVisible task1 = new TaskVisible(visibilidad);
        TaskVisible task2 = new TaskVisible(visibilidad);

        Thread hilo1 = new Thread(task1, "Hilo-1");
        Thread hilo2 = new Thread(task2, "Hilo-2");

        hilo1.start();
        hilo2.start();

        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Valor final de entero para el hilo principal: " + visibilidad.getEntero());
    }
}


/**
 * Clase TaskVisible
 * Implementa run(), donde se crea un ejemploVisibilidad y se incrementa en cinco y muestra el nombre del hilo y el valor resultante.
 */
