package teoría.noestatico;

public class MyClass {

    public synchronized void printNombre() {
        String nombre = Thread.currentThread().getName();
        System.out.println(nombre + " a la una");
        System.out.println(nombre + " a las dos");
        System.out.println(nombre + " y a las tres");
    }
}

