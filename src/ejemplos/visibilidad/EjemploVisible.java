package ejemplos.visibilidad;

public class EjemploVisible {
    private volatile int numero;

    public EjemploVisible(int numeroInicial) {
        this.numero = numeroInicial;
    }

    public int getNumero() {
        return numero;
    }

    public synchronized void incrementar(int numero) {
        this.numero += numero;
    }
}

