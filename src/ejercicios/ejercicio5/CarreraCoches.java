package ejercicios.ejercicio5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarreraCoches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Thread> hilosCoches = new ArrayList<>();

        // Configuración de la carrera
        System.out.print("Introduce la distancia del circuito (metros): ");
        int distanciaCircuito = scanner.nextInt();

        System.out.print("Introduce el número de coches (máximo 4): ");
        int numCoches = Math.min(scanner.nextInt(), 4);

        // Configuración de cada coche
        for (int i = 0; i < numCoches; i++) {
            System.out.print("Introduce la velocidad del coche " + (i + 1) + " (metros/segundo): ");
            int velocidad = scanner.nextInt();

            Coche coche = new Coche("Coche " + (i + 1), velocidad, distanciaCircuito);
            Thread hiloCoche = new Thread(coche);
            hilosCoches.add(hiloCoche);
        }

        System.out.println("\n¡Comienza la carrera!");
        System.out.println("===================");

        // Iniciar la carrera
        for (Thread hilo : hilosCoches) {
            hilo.start();
        }

        // Esperar a que todos los coches terminen
        for (Thread hilo : hilosCoches) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n¡Carrera finalizada!");
        scanner.close();
    }
}