package ejemplos.memoriacompartida;

/**
 * Clase Hilocontador, que hereda de Thread
 * tiene una constante de tipo Contador que se inicializa con un Contador pasado en el constructor.
 * Sobreescribe el méto-do run() llamando al método incrementar del contador.
 * NOTA: hacer también este ejemplo con Runnable
 */

public class HiloContadorAlejandro extends Thread{
    private final ContadorAlejandro contadorAlejandro;

    public HiloContadorAlejandro(ContadorAlejandro contadorAlejandro) {
        this.contadorAlejandro = contadorAlejandro;
    }

    @Override
    public void run() {
        contadorAlejandro.incrementar();
    }
}