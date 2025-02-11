package ejercicios.ejercicio6;

public class Relevos_Aina {
    public static void main(String[] args) {
        Corredores_Aina corredor1 = new Corredores_Aina("1");
        Corredores_Aina corredor2 = new Corredores_Aina("2");
        Corredores_Aina corredor3 = new Corredores_Aina("3");
        Corredores_Aina corredor4 = new Corredores_Aina("4");

        System.out.println("Todos los hilos creados.");
        System.out.println("¡Doy la salida!");

        corredor1.start();

        try {
            corredor1.join();
        } catch (InterruptedException e) {
            e.getMessage();
            Thread.currentThread().interrupt();
        }
        corredor2.start();
        try {
            corredor2.join();
        } catch (InterruptedException e) {
            e.getMessage();
            Thread.currentThread().interrupt();
        }

        corredor3.start();

        try {
            corredor3.join();
        } catch (InterruptedException e) {
            e.getMessage();
            Thread.currentThread().interrupt();
        }

        corredor4.start();
        try {
            corredor4.join();
        } catch (InterruptedException e) {
            e.getMessage();
            Thread.currentThread().interrupt();
        }

        System.out.println("Todos los hilos terminaron.");
    }
}