package ejercicios.ejemplo.sincronizacion.compartirdatos;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Contador contador = new Contador();
        MyThread hilo1 = new MyThread(contador);
        MyThread hilo2 = new MyThread(contador);

        hilo1.start();
        hilo1.join();

        hilo2.start();
        hilo2.join();

        System.out.println("El contador es: " + contador.getValue());
    }
}
