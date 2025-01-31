package ejemplos.visibilidad;

/**
 * Clase EjemploVisibilidad
 * Tiene un atributo entero número que se inicializa en el constructor, y un getter.
 * Además, un método de instancia incrementar(int numero) que suma el número pasado por parámetro al atributo.
 * El atributo numero es invisible entre hilos
 */

public class EjemploInvisible {
    private int numero;

    public EjemploInvisible(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void incrementar(int numero){
        this.numero += numero;
    }
}

