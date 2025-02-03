package ejemplos.visibilidad;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        EjemploVisible ejemploVisible = new EjemploVisible(0);
        // Crear dos hilos visibles
        Thread invisible_hilo1 = new Thread(new TaskInvisible());
        Thread invisible_hilo2 = new Thread(new TaskInvisible());

        // Crear dos hilos invisibles
        Thread visible_hilo1 = new Thread(new TaskVisible(ejemploVisible));
        Thread visible_hilo2 = new Thread(new TaskVisible(ejemploVisible));

        // Iniciar los hilos
        invisible_hilo1.start();
        invisible_hilo2.start();
        visible_hilo1.start();
        visible_hilo2.start();


        try {
            invisible_hilo1.join();
            invisible_hilo2.join();
            visible_hilo1.join();
            visible_hilo2.join();

        } catch (InterruptedException e) {
            System.out.println("Algo ha ido mal en algún join()");
        }

        // Imprimir el resultado final
        System.out.println("Valor final del ejemplo visible: " + ejemploVisible.getNumero());
    }
}