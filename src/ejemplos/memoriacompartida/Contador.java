package ejemplos.memoriacompartida;

/**
 * Clase contador:
 * - atributo privado entero valor, con un getter
 * - método de instancia incrementar(), que incrementa valor en una unidad
 */

class Contador {
    private int contador;

    public Contador(int contador) {
        this.contador = contador;
    }

    public int getContador() {
        return contador;
    }

    public int incrementar(){
        return this.contador++;
    }
}