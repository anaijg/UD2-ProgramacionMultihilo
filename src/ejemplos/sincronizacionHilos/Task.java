package ejemplos.sincronizacionHilos;

public class Task implements Runnable{
    private MiClase miClase;

    public Task(MiClase miClase) {
        this.miClase = miClase;
    }

    @Override
    public void run() {
        this.miClase.printNombre();
    }
}