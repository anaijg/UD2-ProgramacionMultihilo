package ejemplos.visibilidad;

/**
 * Clase EjemploVisible
 * Tiene un atributo entero número que se inicializa en el constructor, y un getter.
 * Además, un método de instancia incrementar(int numero) que suma el número pasado por parámetro al atributo.
 * El atributo numero es visible entre hilos
 */

public class EjemploVisible {
    private volatile int número;

    public EjemploVisible(int numero) {
        this.número = numero;
    }

    public int getNumero() {
        return número;
    }

    public void incrementar(int cantidad) {
        número += cantidad;
    }
}