package ejemplos.sincronizacion.memoriacompartida;

public class Sumador extends Thread {
    private Contador contador;

    public Sumador(String name, Contador contador) {
        this.contador = contador;
        this.setName(name);
    }

    public void run() {
        contador.incrementa();
    }
}
