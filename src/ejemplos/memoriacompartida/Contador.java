package ejemplos.memoriacompartida;

public class Contador {
    private int contador;

    public Contador(int contador) {
        this.contador = contador;
    }

    public synchronized int getContador() {
        return contador;
    }
    public synchronized void incrementar() {
         contador++;
    }
}
/**
 * Clase contador:
 * - atributo privado entero valor, con un getter
 * - método de instancia incrementar(), que incrementa valor en una unidad
 */

