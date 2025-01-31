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
    public static void main(String[] args) throws InterruptedException {
        Contador contador = new Contador(0);
        HiloContador hilo1 = new HiloContador(contador);
        HiloContador hilo2 = new HiloContador(contador);

        hilo1.start();
        hilo2.start();

        hilo1.join();
        hilo2.join();

        System.out.println("El valor del contador es: " + contador.getValue());
    }

}

