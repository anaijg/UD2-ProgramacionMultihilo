package ejemplos.sincronizacion.compartirdatos;

public class Main {
    public static void main(String[] args) {
        // creamos un contador y dos hilos
        Contador contador = new Contador();
        MyThread hilo1 = new MyThread(contador);
        MyThread hilo2 = new MyThread(contador);

        // los iniciamos, esperando cada hilo que termine el anterior
        hilo1.start();
        try {
            hilo1.join();
        } catch (InterruptedException e) {
            System.out.println("Ha ido mal el join del primer hilo" + e.getMessage());
            Thread.currentThread().interrupt();
            System.err.println("Error");
        }
        hilo2.start();
        try {
            hilo2.join();
        } catch (InterruptedException e) {
            System.out.println("Ha ido mal el join del primer hilo" + e.getMessage());
            Thread.currentThread().interrupt();
            System.err.println("Error");
        }

        System.out.println("Contador: " + contador.getValor());

    }
}
