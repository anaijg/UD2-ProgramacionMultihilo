package ejemplos.sincronizacion.estaticos;

public class Task implements Runnable{
    MiClase miClase;

    public Task(MiClase miClase) {
        this.miClase = miClase;
    }

    @Override
    public void run() {
        miClase.printNombre();
    }
}
