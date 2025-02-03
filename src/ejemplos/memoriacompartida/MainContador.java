package ejemplos.memoriacompartida;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase MainContador.
 * Contiene el main donde se crean un contador y dos hilos que trabajan con el mismo objeto.
 * Iniciamos ambos hilos, uno por uno y esperando que finalicen.
 * Se gestionan las excepciones de la siguiente forma:
 * - Se captura la excepción correspondiente al fallo de un join()
 * - Si alguno falla, se muestra el mensaje "Algo ha ido mal en algún join()". A continuación, se interrumpen los hilos que queden vivos.
 * - Finalmente, tanto si salta la excepción como si no, se muestra el valor del contador.
 */

public class MainContador
{
    private static List<Thread> hilos = new ArrayList<>();

    public static void main(String[] args)
    {
        Contador contador = new Contador();
        hilos.add(new Thread(new HiloContador(contador)));
        hilos.add(new Thread(new HiloContador(contador)));

        try
        {
            // Lanzamos los hilos
            for(Thread hilo : hilos)
            {
                hilo.start();
                hilo.join();
            }
        }
        catch(InterruptedException e)
        {
            System.out.println("Algo ha ido mal en algún join()");
            DetenerHilos();
        }
        finally
        {
            System.out.println("El valor del contador es: " + contador.getValor());
        }
    }

    private static void DetenerHilos()
    {
        for(Thread hilo : hilos)
        {
            hilo.interrupt();
        }
    }
}
