package ejercicios.Visibilidad;

/**
 * Clase EjemploVisible Tiene un atributo entero número que se inicializa en el constructor, y un getter.
 * Además, un método de instancia incrementar(int numero) que suma el número pasado por parámetro al atributo.
 * El atributo numero es visible entre hilos
 */

class EjemploVisible {
    private volatile int valor;

    public EjemploVisible() {
        valor = 0;
    }

    public int getValor() {
        return valor;
    }

    public void incrementar(int valor) {
        this.valor += valor;
    }
}