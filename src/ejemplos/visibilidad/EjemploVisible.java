package ejemplos.visibilidad;

/**
 * Clase EjemploVisibilidad
 * Tiene un atributo entero número que se inicializa en el constructor, y un getter.
 * Además, un método de instancia incrementar(int numero) que suma el número pasado por parámetro al atributo.
 * El atributo numero es visible entre hilos
 */

class EjemploVisibilidad{
    private volatile int numero;

    public EjemploVisibilidad(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public synchronized void incrementar(int numero_incremento) {
        this.numero += numero_incremento;
    }
}

