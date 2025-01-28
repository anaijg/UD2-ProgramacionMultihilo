package ejercicios.ejemplo.sincronizacion.compartirdatos;

public class Contador {
    private int value = 0;

    public void incrementar() {
        value++;
    }
    public void decrementar() {
        value--;
    }

    public int getValue() {
        return value;
    }

}
