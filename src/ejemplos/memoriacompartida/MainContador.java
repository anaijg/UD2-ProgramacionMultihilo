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


class MainContador {
    public static void main(String[] args) {
        Contador contador = new Contador(0);

        HiloContador hiloContador = new HiloContador(contador);
        Thread hiloThread = new Thread(new HiloContadorRunnable(contador));

        hiloContador.start();
        hiloThread.start();

        try{
            hiloContador.join();
            hiloThread.join();
        }catch (InterruptedException e){
            System.out.println("Algo ha ido mal en algún join()");
            hiloContador.interrupt();
            hiloThread.interrupt();
        }

        System.out.println("Valor final del contador: " + contador.getContador());

    }
}