package ejercicios.memoriaCompartida;

public class HiloContador extends Thread {
    private Contador contador;

    public HiloContador(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        contador.incrementar();
    }
}
