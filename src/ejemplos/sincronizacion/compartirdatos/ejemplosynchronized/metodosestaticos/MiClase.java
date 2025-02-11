package ejemplos.sincronizacion.compartirdatos.ejemplosynchronized.metodosestaticos;

public class MiClase {
    public static synchronized void printNombre() {
        String nombre = Thread.currentThread().getName();
        System.out.println(nombre + " a la una");
        System.out.println(nombre + " a las dos");
        System.out.println(nombre + " y a las tres");
    }
}
