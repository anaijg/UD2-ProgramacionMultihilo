package ejemplos.memoriacompartidaIBM;

public class MainContadorIBM
{
    public static void main(String[] args)
    {
            ContadorIBM contadorIBM = new ContadorIBM();
            HiloContadorIBM hilo1 = new HiloContadorIBM(contadorIBM);
            HiloContadorIBM hilo2 = new HiloContadorIBM(contadorIBM);

            hilo1.start();
            hilo2.start();

            try
            {
                hilo1.join();
                hilo2.join();

            }
            catch (InterruptedException e)
            {
                System.out.println("Algo ha ido mal en algun join()");
            }
            finally {
                System.out.println("Valor final del contador:"+ contadorIBM.getValor());
            }
    }
}
/**
 * Clase MainContador.
 * Contiene el main donde se crean un contador y dos hilos que trabajan con el mismo objeto.
 * Iniciamos ambos hilos, uno por uno y esperando que finalicen.
 * Se gestionan las excepciones de la siguiente forma:
 * - Se captura la excepción correspondiente al fallo de un join()
 * - Si alguno falla, se muestra el mensaje "Algo ha ido mal en algún join()". A continuación, se interrumpen los hilos que queden vivos.
 * - Finalmente, tanto si salta la excepción como si no, se muestra el valor del contador.
 */
