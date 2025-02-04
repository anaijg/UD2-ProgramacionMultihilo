package ejemplos.sincronizacion.estaticos;

public class Task implements Runnable{
    @Override
    public void run() {
        MiClase.printNombre();
    }
}
