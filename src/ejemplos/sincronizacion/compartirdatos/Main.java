package ejemplos.sincronizacion.compartirdatos;

public class Main {
    public static void main(String[] args) {
    Contador contador = new Contador();
    MyThread hilo1 = new MyThread(contador);
    MyThread hilo2 = new MyThread(contador);

    // los iniciamos, esperamos a que termine
        hilo1.start();
        try {
            hilo1.join();
        }catch (InterruptedException ex1){
            System.err.println("Error"+ex1.getMessage());
            Thread.currentThread().interrupt();

        }

        hilo2.start();
        try {
            hilo2.join();
        }catch (InterruptedException ex1){
            System.err.println("Error"+ex1.getMessage());
            Thread.currentThread().interrupt();

        }

        System.out.println("Contador: " +contador.getValor());

    }



}
