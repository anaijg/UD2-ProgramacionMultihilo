package ejercicios.ejercicio6;

public class Relevos {
    public static void main(String[] args) {

        Corredor corredor1 = new Corredor(1);
        Corredor corredor2 = new Corredor(2);
        Corredor corredor3 = new Corredor(3);
        Corredor corredor4 = new Corredor(4);

        Thread hilo1 = new Thread(corredor1);
        Thread hilo2 = new Thread(corredor2);
        Thread hilo3 = new Thread(corredor3);
        Thread hilo4 = new Thread(corredor4);



        System.out.println("Todos los hilos creados\n¡Doy la salida!");

        try {
            hilo1.start();
            hilo1.join();
            hilo2.start();
            hilo2.join();
            hilo3.start();
            hilo3.join();
            hilo4.start();
            hilo4.join();
        } catch (InterruptedException e) {
            System.out.println("error " + e.getMessage());
        }


    }
}
