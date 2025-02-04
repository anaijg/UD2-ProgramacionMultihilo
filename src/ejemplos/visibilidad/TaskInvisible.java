package ejemplos.visibilidad;

import java.util.Random;

public class TaskInvisible implements Runnable {

    private Visibilidad visibilidad;

    public TaskInvisible(Visibilidad visibilidad) {
        this.visibilidad = visibilidad;
    }

    @Override
    public void run() {
        Random rand = new Random();
        int incremento = rand.nextInt(6) + 5;

        visibilidad.incrementar(incremento);

        System.out.println(Thread.currentThread().getName() + " incrementó en: " + incremento);
        System.out.println(Thread.currentThread().getName() + " valor final: " + visibilidad.getEntero());
    }

    public static void main(String[] args) {
        Visibilidad visibilidad = new Visibilidad();

        TaskInvisible task1 = new TaskInvisible(visibilidad);
        TaskInvisible task2 = new TaskInvisible(visibilidad);

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
 * Clase TaskInvisible
 * Implementa run(), donde se crea un ejemploVisibilidad y se incrementa en cinco, y muestra el nombre del hilo y el valor resultante.
 */

