package ejemplos.memoriacompartida;

/**
 * Clase contador:
 * - atributo privado entero valor, con un getter
 * - método de instancia incrementar(), que incrementa valor en una unidad
 */

class Contador {
    private int value = 0;

    public void increment() {
        value++;
    }

    public int getValue() {
        return value;
    }
}
