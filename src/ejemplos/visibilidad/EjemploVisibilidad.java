package ejemplos.visibilidad;

/**
 * Clase EjemploVisibilidad
 * Tiene un atributo entero número que se inicializa en el constructor, y un getter.
 * Además, un método de instancia incrementar(int numero) que suma el número pasado por parámetro al atributo.
 * El atributo numero es visible entre hilos
 */
public class EjemploVisibilidad {
    private volatile int numero; // Atributo entero numero visible entre hilos

    // Constructor que inicializa el atributo numero
    public EjemploVisibilidad(int numero) {
        this.numero = numero;
    }

    // Getter para obtener el valor del atributo numero
    public int getNumero() {
        return numero;
    }

    // Método de instancia que suma el número pasado por parámetro al atributo numero
    public void incrementar(int numero) {
        this.numero += numero;
    }
}
