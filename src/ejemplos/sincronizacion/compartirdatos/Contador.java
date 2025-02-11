package ejemplos.sincronizacion.compartirdatos;

public class Contador {
    private int valor;

    public void incrementar() {
        valor++;
    }
    public void decrementar() {
        valor--;
    }

    public int getValor() {
        return valor;
    }
}
