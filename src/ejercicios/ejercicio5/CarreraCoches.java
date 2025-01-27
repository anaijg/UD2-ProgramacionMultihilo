package ejercicios.ejercicio5;

import java.util.Scanner;

public class CarreraCoches {

    private int distancia;

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce la distancia del circuito en metros");
        int distancia = teclado.nextInt();
        int numeroCoches;
        do {
            System.out.println("Introduce el número de coches (máximo 4)");
            numeroCoches = teclado.nextInt();
        } while (numeroCoches < 1 || numeroCoches > 4);

        Thread[] coches = new Thread[numeroCoches];

        for (int i = 0; i < numeroCoches; i++) {

            System.out.println("Introduce el dorsal del coche" + (i + 1));
            int numeroCoche = teclado.nextInt();
            System.out.println("Introduce la velocidad del coche " + (i + 1));
            int velocidad = teclado.nextInt();


            coches[i] = new Thread(new Coche(numeroCoche, velocidad, distancia));
        }

        System.out.println("Comienza la carrera!");
        for (Thread coche : coches) {
            coche.start();
        }

        for (Thread coche : coches) {
            try {
                coche.join();
            } catch (InterruptedException e) {
                System.out.println("Salida de pista!!");
            }

        }
    }

}
