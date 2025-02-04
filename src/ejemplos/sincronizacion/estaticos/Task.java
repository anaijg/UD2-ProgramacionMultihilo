package ejemplos.sincronizacion.estaticos;

public class Task implements Runnable{
    MiClase miClase = new MiClase();

    public Task(MiClase miClase) {
        this.miClase = miClase;
    }

    @Override
    public void run() {
        miClase.printNombre();
    }
}
