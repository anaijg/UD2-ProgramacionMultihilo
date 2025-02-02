package ejemplos.visibilidad;


/**
 * Clase EjemploVisible
 * Tiene un atributo entero número que se inicializa en el constructor, y un getter.
 * Además, un método de instancia incrementar(int numero) que suma el número pasado por parámetro al atributo.
 * El atributo numero es visible entre hilos.
 */
public class EjemploVisible {
    // Atributo visible entre hilos
    private int numero;

    // Constructor que inicializa el atributo numero
    public EjemploVisible(int numero) {
        this.numero = numero;
    }

    // Método getter para obtener el valor de numero
    public int getNumero() {
        return numero;
    }

    // Método que incrementa el valor de numero de manera no atómica
    public void incrementar(int numero) {
        this.numero += numero;  // Esta operación no es atómica y puede generar problemas si se ejecutan varios hilos simultáneamente.
    }

    public static void main(String[] args) {
        // Crear un objeto de EjemploVisible con un valor inicial de 0
        EjemploVisible ejemplo = new EjemploVisible(0);

        // Crear dos hilos que incrementan el valor de numero
        Thread hilo1 = new Thread(() -> ejemplo.incrementar(5));
        Thread hilo2 = new Thread(() -> ejemplo.incrementar(10));

        // Iniciar los hilos
        hilo1.start();
        hilo2.start();

        try {
            // Esperar a que ambos hilos terminen
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            System.out.println("Algo ha ido mal en algún join()");
        }

        // Mostrar el valor final del contador
        System.out.println("Valor final del contador: " + ejemplo.getNumero());
    }
}

