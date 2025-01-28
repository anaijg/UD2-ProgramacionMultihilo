package ejemplos.sincronizacion.compartirdatos;

public class Contador {
    private int valor;

    public void increment(){
        valor++;
    }
    public void decrement(){
        valor--;
    }

    public int getValor() {
        return valor;
    }
}
