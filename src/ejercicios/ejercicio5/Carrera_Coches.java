package ejercicios.ejercicio5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Carrera_Coches {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce la distancia del circuito (metros): ");
        int distanciaCircuito = sc.nextInt();

        System.out.print("Introduce el número de coches (máximo 4): ");
        int numCoches = Math.min(sc.nextInt(), 4);

        List<Thread> hilos = new ArrayList<>();

        for (int i = 1; i <= numCoches; i++) {
            System.out.print("Introduce la velocidad del coche " + i + " (metros/segundo): ");
            int velocidad = sc.nextInt();
            Coche coche = new Coche("Coche " + i, velocidad, distanciaCircuito);
            Thread hilo = new Thread(coche);
            hilos.add(hilo);
        }

        System.out.println("\n¡Comienza la carrera!");
        System.out.println("===================");

        for (Thread hilo : hilos) {
            hilo.start();
        }

        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Carrera finalizada");
        sc.close();
    }
}
