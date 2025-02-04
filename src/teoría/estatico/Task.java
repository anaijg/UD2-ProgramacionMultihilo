package teoría.estatico;

public class Task implements Runnable{
    @Override
    public void run() {
        MyClass.printNombre();
    }
}