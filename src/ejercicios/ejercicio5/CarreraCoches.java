package ejercicios.ejercicio5;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class CarreraCoches {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Configurar la distancia del circuito
        System.out.print("Introduce la distancia del circuito (metros): ");
        int distancia = scanner.nextInt();

        // Configurar el número de coches (máximo 4)
        int numCoches;
        do {
            System.out.print("Introduce el número de coches (máximo 4): ");
            numCoches = scanner.nextInt();
        } while (numCoches < 1 || numCoches > 4);

        // Configurar la velocidad de cada coche
        int[] velocidades = new int[numCoches];
        for (int i = 0; i < numCoches; i++) {
            System.out.printf("Introduce la velocidad del coche %d (metros/segundo): ", i + 1);
            velocidades[i] = scanner.nextInt();
        }

        System.out.println("\n¡Comienza la carrera!");
        System.out.println("=====================");

        // Variable para controlar si la carrera ha terminado
        AtomicBoolean carreraTerminada = new AtomicBoolean(false);

        // Crear y ejecutar los hilos de los coches
        Thread[] hilos = new Thread[numCoches];
        for (int i = 0; i < numCoches; i++) {
            int cocheId = i + 1;
            hilos[i] = new Thread(new Coche(cocheId, velocidades[i], distancia, carreraTerminada));
            hilos[i].start();
        }

        // Esperar a que todos los hilos terminen
        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n¡Carrera finalizada!");
    }
}