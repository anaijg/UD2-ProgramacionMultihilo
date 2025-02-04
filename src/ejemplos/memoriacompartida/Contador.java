package ejemplos.memoriacompartida;

/**
 * Clase contador:
 * - atributo privado entero valor, con un getter
 * - método de instancia incrementar(), que incrementa valor en una unidad
 */
public class Contador {
    // Atributo privado entero valor
    private int valor;

    // Getter para el atributo valor
    public int getValor() {
        return valor;
    }

    // Método de instancia incrementar(), que incrementa valor en una unidad
    public void incrementar() {
        valor++;
    }
}
