package ejemplos.sincronizacion.estaticos;

public class MiClase {

    public synchronized void printNombre() {
        String nombre = Thread.currentThread().getName();
        System.out.println(nombre + " a la una");
        System.out.println(nombre + " a las dos");
        System.out.println(nombre + " y a las tres");
    }
}