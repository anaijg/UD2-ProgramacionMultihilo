package ejemplos.memoriacompartida.temporalCarlos;



/**
 * Clase Hilocontador, que hereda de Thread
 * tiene una constante de tipo Contador que se inicializa con un Contador pasado en el constructor.
 * Sobreescribe el méto-do run() llamando al método incrementar del contador.
 * NOTA: hacer también este ejemplo con Runnable
 */

class HiloContador implements Runnable {

    private final Contador contador;

    HiloContador(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        contador.increment();
    }
}

