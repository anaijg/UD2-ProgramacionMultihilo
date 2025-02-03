package ejemplos.memoriacompartida;

/**
 * Clase MainContador.
 * Contiene el main donde se crean un contador y dos hilos que trabajan con el mismo objeto.
 * Iniciamos ambos hilos, uno por uno y esperando que finalicen.
 * Se gestionan las excepciones de la siguiente forma:
 * - Se captura la excepción correspondiente al fallo de un join()
 * - Si alguno falla, se muestra el mensaje "Algo ha ido mal en algún join()". A continuación, se interrumpen los hilos que queden vivos.
 * - Finalmente, tanto si salta la excepción como si no, se muestra el valor del contador.
 */

public class MainContador {
    public static void main(String[] args) {
        // Crear un contador
        Contador contador = new Contador();

        // Crear dos hilos que trabajarán con el mismo contador
        Runnable task1 = new HiloContador(contador);
        Runnable task2 = new HiloContador(contador);

        Thread hilo1 = new Thread(task1);
        Thread hilo2 = new Thread(task2);

        hilo1.start();
        hilo2.start();

        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            System.out.println("Algo ha ido mal en algún.");
            if (hilo1.isAlive()) hilo1.interrupt();
            if (hilo2.isAlive()) hilo2.interrupt();
        }

        System.out.println("Valor final del contador: " + contador.getValor());
    }
}