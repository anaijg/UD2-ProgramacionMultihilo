package ejemplos.memoriacompartida;

public class MainContador {

    public static void main(String[] args) {
        Contador contador = new Contador(0);

        HiloContador hilo1 = new HiloContador(contador);
        HiloContador hilo2 = new HiloContador(contador);

        hilo1.start();
        hilo2.start();

        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            System.out.println("Algo ha ido mal en algún join()");
            hilo1.interrupt();
            hilo2.interrupt();
        }

        System.out.println("Valor final del contador: " + contador.getContador());
    }
}
