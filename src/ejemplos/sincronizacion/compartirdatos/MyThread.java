package ejemplos.sincronizacion.compartirdatos;

public class MyThread extends Thread{
    private final Contador contador;

    public MyThread(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        contador.increment();
    }
}
