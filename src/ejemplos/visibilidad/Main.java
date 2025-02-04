package ejemplos.visibilidad;

/**
 * En el main se crean dos hilos (workers) visibles y otros dos invisibles y se comprueba si hay diferencia en el resultado.
 *
 */
public class Main{
    public static void main(String[] args) {

        EjemploInvisible ejemploInvisible = new EjemploInvisible(0);
        EjemploVisible ejemploVisible = new EjemploVisible(0);

        Thread hiloInvisible1 = new Thread(new TaskInvisible(ejemploInvisible),"hilo Invisible 1");
        Thread hiloInvisible2 = new Thread(new TaskInvisible(ejemploInvisible),"hilo Invisible 2");

        Thread hiloVisible1 = new Thread(new TaskVisible(ejemploVisible), "Hilo visible 1");
        Thread hiloVisible2 = new Thread(new TaskVisible(ejemploVisible), "Hilo visible 2");

        hiloInvisible1.start();
        try {
            hiloInvisible1.join();
        } catch (InterruptedException e) {
            System.out.println("Error al esperar los hilos invisibles.");
        }

        hiloInvisible2.start();
        try {
            hiloInvisible2.join();
        } catch (InterruptedException e) {
            System.out.println("Error al esperar los hilos invisibles.");
        }

        hiloVisible1.start();
        try {
            hiloVisible1.join();
        } catch (InterruptedException e) {
            System.out.println("Error al esperar los hilos visibles.");
        }

        hiloVisible2.start();
        try {
            hiloVisible2.join();
        } catch (InterruptedException e) {
            System.out.println("Error al esperar los hilos visibles.");
        }

    }
}