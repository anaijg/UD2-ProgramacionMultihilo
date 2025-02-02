package ejemplos.visibilidad;

import java.util.Random;

public class TaskVisible implements Runnable {

    private static int ejemploVisibilidad = 0; // Variable compartida entre hilos

    @Override
    public void run() {
        // Crear un valor aleatorio para incrementar ejemploVisibilidad
        Random random = new Random();
        int incremento = random.nextInt(5) + 1; // Incremento aleatorio entre 1 y 5

        // Incrementar de forma sincronizada (hilo visible)
        synchronized (TaskVisible.class) {
            ejemploVisibilidad += incremento;
        }

        // Mostrar el nombre del hilo y el valor resultante
        System.out.println(Thread.currentThread().getName() + " incrementó el valor en " + incremento + ". Valor final: " + ejemploVisibilidad);
    }

    public static void main(String[] args) throws InterruptedException {
        // Crear hilos visibles
        Thread hilo1 = new Thread(new TaskVisible(), "Hilo 1");
        Thread hilo2 = new Thread(new TaskVisible(), "Hilo 2");

        // Iniciar los hilos
        hilo1.start();
        hilo2.start();

        // Esperar que los hilos terminen
        hilo1.join();
        hilo2.join();

        // Imprimir el valor final de ejemploVisibilidad después de que todos los hilos hayan terminado
        System.out.println("Valor final de ejemploVisibilidad: " + ejemploVisibilidad);
    }
}

