package ejemplos.memoriacompartida;

/**
 * Clase contador:
 * - atributo privado entero valor, con un getter
 * - método de instancia incrementar(), que incrementa valor en una unidad
 */
public class Contador
{
    private int valor;

    public int getValor()
    {
        return this.valor;
    }

    public void incrementar()
    {
        this.valor++;
    }

    public Contador(int contador)
    {
        this.valor = contador;
    }

    public Contador()
    {
        this.valor = 0;
    }
}