package ejemplos.memoriacompartida;

public class HilocontadorRunnable implements Runnable {
    // Constante de tipo Contador
    private final Contador contador;

    // Constructor que inicializa el contador
    public HilocontadorRunnable(Contador contador) {
        this.contador = contador;
    }

    // Sobrescribe el método run() llamando al método incrementar del contador
    @Override
    public void run() {
        contador.incrementar();
    }
}
