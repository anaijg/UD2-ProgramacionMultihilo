package ejemplos.sincronizacion.compartirdatos;

import org.w3c.dom.css.Counter;

public class MyThread extends Thread{
    private final Contador contador;

    public MyThread(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        contador.incrementar();
    }
}
