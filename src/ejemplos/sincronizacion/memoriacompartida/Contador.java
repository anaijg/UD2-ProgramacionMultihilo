package ejemplos.sincronizacion.memoriacompartida;

public class Contador {
    private int c;

    public Contador(int c) {
        this.c = c;
    }

    public void incrementa() {
        this.c++;
    }

    public void decrementa() {
        this.c--;
    }

    public int valor() {
        return c;
    }
}
