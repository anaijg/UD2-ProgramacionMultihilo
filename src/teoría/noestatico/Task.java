package teoría.noestatico;

public class Task implements Runnable{
    @Override
    public void run() {
        MyClass clase = new MyClass();
        clase.printNombre();
    }
}