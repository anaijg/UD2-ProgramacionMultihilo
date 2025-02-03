package ejemplos.visibilidad;


public class TaskVisible implements Runnable {
    private final EjemploVisible ejemploVisible;// Variable compartida entre hilos

    public TaskVisible(EjemploVisible ejemploVisible) {
        this.ejemploVisible = ejemploVisible;
    }

    @Override
    public void run() {
        ejemploVisible.incrementar(5);

        // Mostrar el nombre del hilo y el valor resultante
        System.out.println(Thread.currentThread().getName() + " incrementó el valor en " + ejemploVisible.getNumero() + " .");
    }
}

