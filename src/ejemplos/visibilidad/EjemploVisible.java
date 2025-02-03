package ejemplos.visibilidad;

/**
 * Clase EjemploVisible
 * Tiene un atributo entero número que se inicializa en el constructor, y un getter.
 * Además, un método de instancia incrementar(int numero) que suma el número pasado por parámetro al atributo.
 * El atributo numero es visible entre hilos
 */
public class EjemploVisible
{
    public int numero;

    public EjemploVisible(int numero)
    {
        this.numero = numero;
    }

    public int getNumero()
    {
        return this.numero;
    }

    public void incrementar(int numero)
    {
        this.numero += numero;
    }
}
