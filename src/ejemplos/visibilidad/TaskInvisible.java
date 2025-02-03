package ejemplos.visibilidad;



public class TaskInvisible implements Runnable {


    @Override
    public void run() {
        // Crear un valor aleatorio para incrementar ejemploVisibilidad
       EjemploInvisible ejemploInvisible = new EjemploInvisible(0);

       ejemploInvisible.incrementar(5);

        // Mostrar el nombre del hilo y el valor resultante
        System.out.println(Thread.currentThread().getName() + " incrementó el valor en " + ejemploInvisible.getNumero() + " .");
    }
}
