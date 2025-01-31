package ejemplos.visibilidad;

public class EjemploVisible {

    private volatile int numero;

    public EjemploVisible(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void incrementar(int numero){
        this.numero += numero;
    }
}
/**
 * Clase EjemploVisibilidad
 * Tiene un atributo entero número que se inicializa en el constructor, y un getter.
 * Además, un método de instancia incrementar(int numero) que suma el número pasado por parámetro al atributo.
 * El atributo numero es visible entre hilos
 */

