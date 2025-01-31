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
        var contador = new Contador();
        HiloContador task1 = new HiloContador(contador);
        HiloContador task2 = new HiloContador(contador);

        try {
            task1.start();
            task1.join();
            task2.start();
            task2.join();

            System.out.println("Contador en: " + contador.getValor());

        } catch (InterruptedException e){
            System.out.println("Algo ha ido mal en algún join()");
            ThreadGroup grupoActual = Thread.currentThread().getThreadGroup();
            int hilosActivos = grupoActual.activeCount();
            Thread[] arrayHilosActivos = new Thread[hilosActivos];

            for (int i = 0; i < hilosActivos; i++) {
                arrayHilosActivos[i].interrupt();
            }
        }
    }
}
