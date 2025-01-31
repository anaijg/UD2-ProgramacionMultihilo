package ejemplos.memoriacompartida;

public class MainContador {
    public static void main(String[] args) {
        Contador contador = new Contador();
        Thread hilo1 = new Thread(new HiloContador(contador));
        Thread hilo2 = new Thread(new HiloContador(contador));

        try {
            hilo1.start();
            hilo1.join();
            hilo2.start();
            hilo2.join();
        } catch (InterruptedException e) {
            System.out.println("Algo ha ido mal en algún join()");
            hilo1.interrupt();
            hilo2.interrupt();
        } finally {
            System.out.println("Valor final del contador: " + contador.getValor());
        }
    }
}