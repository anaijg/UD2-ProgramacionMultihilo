package ejemplos.memoriacompartida;

/**
 * Clase Hilocontador, que hereda de Thread
 * tiene una constante de tipo Contador que se inicializa con un Contador pasado en el constructor.
 * Sobreescribe el método run() llamando al método incrementar del contador.
 */
public class Hilocontador extends Thread {
    // Constante de tipo Contador
    private final Contador contador;

    // Constructor que inicializa el contador
    public Hilocontador(Contador contador) {
        this.contador = contador;
    }

    // Sobrescribe el método run() llamando al método incrementar del contador
    @Override
    public void run() {
        contador.incrementar();
    }
}


