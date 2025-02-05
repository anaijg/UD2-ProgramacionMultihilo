package ejercicios.memoriaCompartida;

class Contador {
    private int valor;

    public Contador() {
        this.valor = 0;
    }

    public int getValor() {
        return valor;
    }

    public void incrementar() {
        this.valor++;
    }
}
