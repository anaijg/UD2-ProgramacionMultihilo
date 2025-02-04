package ejemplos.memoriacompartida;
public class MainContador {

    /**
     * Clase MainContador.
     * Contiene el main donde se crean un contador y dos hilos que trabajan con el mismo objeto.
     * Iniciamos ambos hilos, uno por uno y esperando que finalicen.
     * Se gestionan las excepciones de la siguiente forma:
     * - Se captura la excepción correspondiente al fallo de un join()
     * - Si alguno falla, se muestra el mensaje "Algo ha ido mal en algún join()". A continuación, se interrumpen los hilos que queden vivos.
     * - Finalmente, tanto si salta la excepción como si no, se muestra el valor del contador.
     */
    public static void main(String[] args) {
        Contador contador = new Contador();
        HiloContador task1 = new HiloContador(contador);
        HiloContador task2 = new HiloContador(contador);
        Thread hilo1 = new Thread(task1, "Hilo1");
        Thread hilo2 = new Thread(task2, "hilo2");

        hilo1.start();
        hilo2.start();
        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            System.out.println("algo ha ido mal en algún join " + e.getMessage());
            hilo1.interrupt();
            hilo2.interrupt();

        } finally {
            System.out.println(contador.getValue());
        }
    }
}