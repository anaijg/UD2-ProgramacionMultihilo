package ejemplos.visibilidad;

/**
 * Clase EjememploInvisible
 * Tiene un atributo entero número que se inicializa en el constructor, y un getter.
 * Además, un método de instancia incrementar(int numero) que suma el número pasado por parámetro al atributo.
 * El atributo numero es invisible entre hilos
 */

public class EjemploInvisible {
    private int número;

    public EjemploInvisible(int numero) {
        this.número = numero;
    }

    public int getNumero() {
        return número;
    }

    public void incrementar(int cantidad) {
        número += cantidad;
    }
}