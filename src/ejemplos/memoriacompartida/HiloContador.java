package ejemplos.memoriacompartida;

/**
 * Clase Hilocontador, que hereda de Thread
 * tiene una constante de tipo Contador que se inicializa con un Contador pasado en el constructor.
 * Sobreescribe el méto-do run() llamando al método incrementar del contador.
 * NOTA: hacer también este ejemplo con Runnable
 */

class HiloContador extends Thread {
    Contador contador;

    public HiloContador(Contador contador) {
        this.contador = contador;
    }
    @Override
    public void run() {
        contador.incrementar();
    }
}

class HiloContadorRunnable implements Runnable {
    Contador contador1;

    public HiloContadorRunnable(Contador contador1) {
        this.contador1 = contador1;
    }
    @Override
    public void run() {
        contador1.incrementar();
    }
}