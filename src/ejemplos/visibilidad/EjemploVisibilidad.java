package ejemplos.visibilidad;

public class EjemploVisibilidad {
    private int numero;

    public EjemploVisibilidad(int numeroInicial) {
        this.numero = numeroInicial;
    }

    public int getNumero() {
        return numero;
    }

    public void incrementar(int numero) {
        this.numero += numero;
    }
}

