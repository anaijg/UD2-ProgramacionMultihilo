package ejemplos.visibilidad;

public  class EjemploVisible {
    public int número;

    public int getEntero() {
        return número;
    }

    public EjemploVisible(int entero) {
        this.número = entero;
    }

    public synchronized void incrementar(int numero)
    {
        número += numero;
    }

    public static void main(String[] args) {

    }
}
/**
 * Clase EjemploVisible
 * Tiene un atributo entero número que se inicializa en el constructor, y un getter.
 * Además, un método de instancia incrementar(int numero) que suma el número pasado por parámetro al atributo.
 * El atributo numero es visible entre hilos
 */

