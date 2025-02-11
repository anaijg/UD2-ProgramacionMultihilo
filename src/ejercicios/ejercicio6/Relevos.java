package ejercicios.ejercicio6;

/*
Crear y lanzar los cuatro hilos.
Asegurar que corran en orden utilizando join().
Imprimir los mensajes correspondientes en main.
*/

import java.util.Random;

public class Relevos {
    public static void main(String[] args) {
        Corredor corredor1 = new Corredor(1);
        Corredor corredor2 = new Corredor(2);
        Corredor corredor3 = new Corredor(3);
        Corredor corredor4 = new Corredor(4);
        Corredor corredor5 = new Corredor(5);

        try {
            System.out.println("Todos los hilos creados.");
            System.out.println("¡Doy la salida!");
            corredor1.start();
            Thread.sleep(new Random().nextInt(1000 , 3000));
            corredor1.join();
            corredor1.interrupt();

            corredor2.start();
            Thread.sleep(new Random().nextInt(1000 , 3000));
            corredor2.join();
            corredor2.interrupt();

            corredor3.start();
            Thread.sleep(new Random().nextInt(1000 , 3000));
            corredor3.join();
            corredor3.interrupt();

            corredor4.start();
            Thread.sleep(new Random().nextInt(1000 , 3000));
            corredor4.join();
            corredor4.interrupt();
            System.out.println("Terminé.\n" +
                    "Todos los hilos terminaron.");

        } catch (Exception e) {

        }

    }
}
