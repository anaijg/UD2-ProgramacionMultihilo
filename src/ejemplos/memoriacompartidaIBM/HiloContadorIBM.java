package ejemplos.memoriacompartidaIBM;

public class HiloContadorIBM extends Thread implements Runnable
{
    private final ContadorIBM contadorIBM;

    public HiloContadorIBM(ContadorIBM contadorIBM)
    {
        this.contadorIBM = contadorIBM;
    }

    @Override
    public void run()
    {
        contadorIBM.incrementar();
    }
}
/**
 * Clase Hilocontador, que hereda de Thread
 * tiene una constante de tipo Contador que se inicializa con un Contador pasado en el constructor.
 * Sobreescribe el méto-do run() llamando al método incrementar del contador.
 * NOTA: hacer también este ejemplo con Runnable
 */

