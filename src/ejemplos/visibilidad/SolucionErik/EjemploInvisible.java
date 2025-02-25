package ejemplos.visibilidad.SolucionErik;

/**
 * Clase EjememploInvisible
 * Tiene un atributo entero número que se inicializa en el constructor, y un getter.
 * Además, un método de instancia incrementar(int numero) que suma el número pasado por parámetro al atributo.
 * El atributo numero es invisible entre hilos
 */

class EjemploInvisible {
    private int valor;

    public EjemploInvisible() {
        valor = 0;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void incrementar(int valor) {
        this.valor += valor;
    }
}
