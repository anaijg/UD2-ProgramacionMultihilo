package Ejemplo.Sincronizacion.CompartirDatos;

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
