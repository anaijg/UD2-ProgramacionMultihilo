package ejemplos.sincronizacion.compartirdatos;

public class Main {
    public static void main(String[] args) {
        Contador contador = new Contador();
        MyThread hilo1 = new MyThread(contador);
        MyThread hilo2 = new MyThread(contador);

        hilo1.start();
        try {
            hilo1.join();
        } catch (InterruptedException e) {
            System.err.println("Ha ido mal el join del hilo 1" + e.getMessage());
            Thread.currentThread().interrupt();
        }

        hilo2.start();
        try {
            hilo2.join();
        } catch (InterruptedException e) {
            System.err.println("Ha ido mal el join del hilo 2" + e.getMessage());
            Thread.currentThread().interrupt();
        }

        System.out.println("Contador: " + contador.getValor());
    }
}
