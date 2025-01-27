package ejercicios.ejercicio6;

import java.util.Scanner;

public class CarreraCoches {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce la distancia del circuito (metros)");
        int distanciaTotal = teclado.nextInt();

        System.out.print("Introduce el número de coches (Máximo 4)");
        int numeroCoches = 0;
        while (numeroCoches < 1 || numeroCoches > 4) {
            numeroCoches = teclado.nextInt();
        }

        Thread[] hilos = new Thread[numeroCoches];
        for (int i = 0; i < numeroCoches; i++) {
            System.out.println("Introduce la velocidad del coche " + (i + 1));
            int velocidad = teclado.nextInt();
            hilos[i] = new Thread(new Coche(velocidad, distanciaTotal, "Coche " + (i + 1)));
        }

        System.out.println("\nComienza la carrera!");
        System.out.println("===================");

        for (Thread hilo : hilos) {
            hilo.start();
        }

        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                System.out.println("Error el hilo" + e.getMessage());
            }
        }

        System.out.println("\nCarrera finalizada!");
    }
}
