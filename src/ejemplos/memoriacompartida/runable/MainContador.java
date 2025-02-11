package ejemplos.memoriacompartida.runable;


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

       Contador contador1 = new Contador();

       HiloContador task1 = new HiloContador(contador1);
       HiloContador task2 = new HiloContador(contador1);

       Thread hilo1 = new Thread(task1);
       Thread hilo2 = new Thread(task2);

        hilo1.start();
        try {
            hilo1.join();
        } catch (InterruptedException e) {
            System.out.println("Algo ha salido mal en un join()");
            if (Thread.currentThread().isAlive()) {
                Thread.currentThread().interrupt();
            }
        } finally {
            System.out.println("Valor del contador: " + contador1.getValor());
        }

        hilo2.start();
        try {
            hilo2.join();
        } catch (InterruptedException e) {
            System.out.println("Algo ha salido mal en un join()");
            if (Thread.currentThread().isAlive()) {
                Thread.currentThread().interrupt();
            }

        }finally {
            System.out.println("Valor del contador: " + contador1.getValor());
        }


    }
}
