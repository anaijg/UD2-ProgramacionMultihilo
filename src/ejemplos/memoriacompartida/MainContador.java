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
        Contador contador = new Contador(0);
        // Cada hilo incrementa el contador 1000 veces (ajustable según necesidades).
        Thread hilo1 = new Thread(() -> {
            for(int i = 0; i < 1000; i++) {
                contador.incrementar();
            }
        });

        Thread hilo2 = new Thread(() -> {
            for(int i = 0; i < 1000; i++) {
                contador.incrementar();
            }
        });

        boolean error = false;

        try {
            // Iniciamos ambos hilos
            hilo1.start();
            hilo2.start();

            // Esperamos a que terminen ambos
            hilo1.join();
            hilo2.join();

        } catch (InterruptedException e) {
            error = true;
            System.out.println("Algo ha ido mal en algún join()");

            // Interrumpimos los hilos si están vivos
            if(hilo1.isAlive()) hilo1.interrupt();
            if(hilo2.isAlive()) hilo2.interrupt();

        } finally {
            // Mostramos el valor final siempre
            System.out.println("Valor final del contador: " + contador.getValor());
        }
    }



}