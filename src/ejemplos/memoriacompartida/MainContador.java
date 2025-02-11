package ejemplos.memoriacompartida;

<<<<<<< HEAD
public class MainContador {
    public static void main(String[] args) {
        Contador contador = new Contador(0);

        HiloContador hilo1 = new HiloContador(contador);
        Thread hilo2 = new Thread(new HiloContadorRunnable(contador));

=======
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
        HiloContador hilo1 = new HiloContador(contador);
        HiloContador hilo2 = new HiloContador(contador);
>>>>>>> 865f23b6138826c046e8e08e71ee506ada731236
        hilo1.start();
        hilo2.start();

        try {
            hilo1.join();
            hilo2.join();
<<<<<<< HEAD
        } catch (InterruptedException e) {
            System.out.println("Algo ha ido mal en algún join()");
            hilo1.interrupt();
            hilo2.interrupt();
        }

        System.out.println("Valor final del contador: " + contador.getValor());
    }
}
=======
        } catch (InterruptedException e){
            System.out.println("Vamos mal");
            Thread.currentThread().interrupt();
        } finally {
            System.out.println("Valor final del contador: " + contador.getValor());
        }
    }
}
>>>>>>> 865f23b6138826c046e8e08e71ee506ada731236
