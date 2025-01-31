package ejemplos.memoriacompartida;

/**
 * Clase contador:
 * - atributo privado entero valor, con un getter
 * - método de instancia incrementar(), que incrementa valor en una unidad
 */
public class Contador {
    private int value = 0;

    public Contador(int value) {
        this.value = value;
    }

    public void incremetar(){
        value++;
    }

    public int getValue(){
        return value;
    }

}


