package Ejemplo.Sincronizacion.CompartirDatos;

public class Main {
    public static void main(String[] args) {
        //Creamos un ocntador y dos hilos
        Contador contador = new Contador();

        MyThread hilo = new MyThread(contador);
        MyThread hilo1 = new MyThread(contador);

        hilo.start();
        try {
            hilo.join();
        } catch (InterruptedException e) {
            System.out.println("No funciona el join del primer hilo " + e.getMessage());
            Thread.currentThread().interrupt();
        }
        System.out.println("Contador " + contador.getValue());
        hilo1.start();
        try {
            hilo1.join();
        } catch (InterruptedException e) {
            System.out.println("No funciona el join del segundo hilo " + e.getMessage());
        }

        System.out.println("Contador " + contador.getValue());
    }
}
