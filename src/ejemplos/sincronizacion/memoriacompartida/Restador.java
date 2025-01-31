package ejemplos.sincronizacion.memoriacompartida;

public class Restador implements Runnable{
    private Contador contador;

    public Restador(String name, Contador contador) {
        this.contador = contador;

    }

    @Override
    public void run() {
        Thread.currentThread().setName("Restador");
        contador.decrementa();
    }
}
