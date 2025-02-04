package ejemplos.visibilidad;

/**
 * Clase EjemploVisibilidad
 * Tiene un atributo entero número que se inicializa en el constructor, y un getter.
 * Además, un método de instancia incrementar(int numero) que suma el número pasado por parámetro al atributo.
 * El atributo numero es invisible entre hilos
 */


public class EjemploVisible {
    private volatile int valor;

    public EjemploVisible(int valor) {
        this.valor = valor;
    }

    public void incrementar(int valor){
        this.valor += valor;
    }

    public int getValor() {
        return valor;
    }


}