package ejemplos.sincronizacionHilos;

public class MiClase {
    /**
     * Método sincronizado, por tanto solamente puede ser llamado por un hilo a la vez
     * Se sincroniza sobre un objeto MiClase, ya que es la clase que lo contiene
     *
     */
    private String nombre;

    public MiClase(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public synchronized void printNombre() {
        String nombre = Thread.currentThread().getName();

        System.out.println(nombre + " a la una (" + this.getNombre() + ")");
        System.out.println(nombre + " a las dos (" + this.getNombre() + ")");
        System.out.println(nombre + " y a las tres (" + this.getNombre() + ")");
    }
}
