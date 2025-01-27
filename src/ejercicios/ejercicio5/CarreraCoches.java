package ejercicios.ejercicio5;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarreraCoches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce la distancia del circuito (metros): ");
        int distanciaTotal = scanner.nextInt();

        System.out.print("Introduce el número de coches (máximo 4): ");
        int numCoches = Math.min(scanner.nextInt(), 4);

        List<Thread> hilos = new ArrayList<>();
        List<Coche> coches = new ArrayList<>();

        for (int i = 1; i <= numCoches; i++) {
            System.out.print("Introduce la velocidad del coche " + i + " (metros/segundo): ");
            int velocidad = scanner.nextInt();

            Coche coche = new Coche("Coche " + i, velocidad, distanciaTotal);
            coches.add(coche);

            Thread hilo = new Thread(coche);
            hilos.add(hilo);
        }

        System.out.println("\n¡Comienza la carrera!");
        System.out.println("===================");

        // Inicia todos los hilos
        for (Thread hilo : hilos) {
            hilo.start();
        }

        // Espera a que un coche termine la carrera
        boolean carreraTerminada = false;
        while (!carreraTerminada) {
            for (Coche coche : coches) {
                if (coche.getDistanciaRecorrida() >= distanciaTotal) {
                    carreraTerminada = true;
                    System.out.println("\n¡" + coche.getNombre() + " ha ganado la carrera!");
                    break;
                }
            }
        }

        // Interrumpe todos los hilos activos
        for (Thread hilo : hilos) {
            hilo.interrupt();
        }

        // Muestra la distancia final de los demás coches
        System.out.println("\n¡Carrera finalizada!");
        for (Coche coche : coches) {
            System.out.println(coche.getNombre() + " recorrió " + coche.getDistanciaRecorrida() + " metros.");
        }

        scanner.close();
    }
}

