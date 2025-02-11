package ejercicios.ejercicio6;

public class Relevos {
    public static void main(String[] args) {
        Corredor corredor1 = new Corredor("1");
        Corredor corredor2 = new Corredor("2");
        Corredor corredor3 = new Corredor("3");
        Corredor corredor4 = new Corredor("4");

        System.out.println("Todos los hilos creados");
        System.out.println("Doy la salida");

        corredor1.start();
        try {
            corredor1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        corredor2.start();
        try {
            corredor2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        corredor3.start();
        try {
            corredor3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        corredor4.start();
        try {
            corredor4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("todos los hilos terminaros");
    }
}
