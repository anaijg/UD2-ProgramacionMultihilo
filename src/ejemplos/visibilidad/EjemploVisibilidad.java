package ejemplos.visibilidad;

/**
 * Clase EjememploInvisible
 * Tiene un atributo entero número que se inicializa en el constructor, y un getter.
 * Además, un método de instancia incrementar(int numero) que suma el número pasado por parámetro al atributo.
 * El atributo numero es invisible entre hilos
 */
public class EjemploVisibilidad {
    private int numero;

    public EjemploVisibilidad(int numeroInicial) {
        this.numero = numeroInicial;
    }

    public int getNumero() {
        return numero;
    }

    public void incrementar(int numero) {
        this.numero += numero;
    }
}