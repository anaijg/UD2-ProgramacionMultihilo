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
        HiloContador hiloContador1 = new HiloContador(contador);

        Thread hiloThread = new Thread(new HiloContadorRunnable(contador));
        Thread hiloThread1 = new Thread(new HiloContadorRunnable(contador));

        hiloContador.start();
        hiloContador1.start();

        hiloThread.start();
        hiloThread1.start();

        try{

            hiloContador.join();
            hiloContador1.join();
            hiloThread.join();
            hiloThread1.join();

        }catch (InterruptedException e){
            System.out.println("Algo ha ido mal en algún join()");
//            hiloContador.interrupt();
//            hiloContador1.interrupt();
//            hiloThread.interrupt();
//            hiloThread1.interrupt();
            //  LO SIGUIENTE HACE QUE DEPENDE DEL HILO QUE ENTRE POR LA EXCEPCION SE CIERRE(IMAGIN QUETIENES 800, NO PUEDES METER LS 800 . INTERRUPT)
            Thread.currentThread().interrupt();
        }finally {
            System.out.println("Valor final del contador: " + contador.getContador());
        }


    }
}