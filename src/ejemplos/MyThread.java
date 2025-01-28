package ejemplos;

public class MyThread extends Thread{
    private final Contador contador;
    //final -> se usa para no que la cosa que cambie de valor

    public MyThread(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run(){
        contador.incrementar();
    }

}
