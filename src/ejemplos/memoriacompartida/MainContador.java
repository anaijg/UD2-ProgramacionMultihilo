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
        Contador contador = new Contador();
        HiloContador hilo = new HiloContador(contador);
        HiloContador hilo2 = new HiloContador(contador);
        hilo.start();
        hilo2.start();
        try{
            hilo.join();
            hilo2.join();
        } catch (InterruptedException e) {
            System.out.println("Algo ha ido mal en algún join()");
            if (hilo.isAlive()) {
                hilo.interrupt();
            }
            if (hilo2.isAlive()) {
                hilo2.interrupt();
            }
        }finally {
            System.out.println(contador.getValor());
        }
    }
}