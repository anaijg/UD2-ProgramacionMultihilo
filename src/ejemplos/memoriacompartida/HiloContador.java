package ejemplos.memoriacompartida;

public class HiloContador implements Runnable {
    private final Contador contador;

    public HiloContador(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        synchronized (contador) {
            contador.incrementar();
            System.out.println("Valor del contador: " + contador.getValor());
        }
    }

    public static void main(String[] args) {
        Contador contador = new Contador();
        Thread hilo1 = new Thread(new HiloContador(contador));
        Thread hilo2 = new Thread(new HiloContador(contador));
        Thread hilo3 = new Thread(new HiloContador(contador));

        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}