package ejemplos.memoriacompartida;

public class Contador {
    private int valor;

    public Contador(int valorInicial) {
        this.valor = valorInicial;
    }

    public int getValor() {
        return valor;
    }

    public void incrementar() {
        valor++;
    }
}