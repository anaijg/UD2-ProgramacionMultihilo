package ejemplos.visibilidad;

/**
 * En el main se crean dos hilos (workers) visibles y otros dos invisibles y se comprueba si hay diferencia en el resultado.
 *
 */
class Main{
    public static void main(String[] args) throws InterruptedException {
        TaskVisible h1 = new TaskVisible();
        TaskVisible h2 = new TaskVisible();

        TaskInvisible h3 = new TaskInvisible();
        TaskInvisible h4 = new TaskInvisible();

        System.out.println("Hilos visibles:");
        System.out.println("===============");
        h1.start();
        h1.join();

        h2.start();
        h2.join();


        System.out.println("Hilos invisibles:");
        System.out.println("=================");
        h3.start();
        h3.join();

        h4.start();
        h4.join();
    }
}
