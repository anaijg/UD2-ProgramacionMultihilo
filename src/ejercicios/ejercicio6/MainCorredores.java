package ejercicios.ejercicio6;

public class MainCorredores {
    public static void main(String[] args) {
        System.out.println("Todos los hilos creados.");
        System.out.println("¡Doy la salida!");

        Corredor corredor1 = new Corredor(1, 5000 + (int) (Math.random() * 5000), null);
        Corredor corredor2 = new Corredor(2, 5000 + (int) (Math.random() * 5000), corredor1);
        Corredor corredor3 = new Corredor(3, 5000 + (int) (Math.random() * 5000), corredor2);
        Corredor corredor4 = new Corredor(4, 5000 + (int) (Math.random() * 5000), corredor3);

        corredor1.start();
        corredor2.start();
        corredor3.start();
        corredor4.start();

        try {
            corredor4.join();
        } catch (InterruptedException e) {
            System.out.println("Algo ha ido mal en algún join()");
        }

        System.out.println("Todos los hilos terminaron.");
    }
}