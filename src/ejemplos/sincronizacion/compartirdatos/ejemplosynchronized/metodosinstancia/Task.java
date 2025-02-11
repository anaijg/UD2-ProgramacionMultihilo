package ejemplos.sincronizacion.compartirdatos.ejemplosynchronized.metodosinstancia;

public class Task implements Runnable {

    private MiClase miClase;

    public Task(MiClase miclase) {
        this.miClase = miclase;
    }

    @Override
    public void run() {
        this.miClase.printNombre();
    }
}
