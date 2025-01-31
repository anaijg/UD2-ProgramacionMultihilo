//Author: Daniel Hernández Garcia
package ejercicios.ejercicio5.solucionDani;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarreraCoche {
    private final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Bienvenido a la carrera de coches.");
        System.out.print("Introduce la distancia del circuito (en metros): ");
        int distanciaCircuito = sc.nextInt();

        System.out.print("Introduce el número de coches (1-4): ");
        int numeroCoches = Math.min(Math.max(sc.nextInt(), 1), 4);

        List<Coche_DanielH> coches = new ArrayList<>();
        for (int i = 1; i <= numeroCoches; i++) {
            System.out.print("Introduce la velocidad del coche " + i + " (en metros/segundo): ");
            int velocidad = sc.nextInt();
            coches.add(new Coche_DanielH("Coche " + i, distanciaCircuito, velocidad));
        }


        System.out.println("\n¡Comienza la carrera!");
        for (Coche_DanielH coche : coches) {
            coche.start();
        }


        Coche_DanielH ganador = null;
        while (ganador == null) {
            for (Coche_DanielH coche : coches) {
                if (coche.haTerminado()) {
                    ganador = coche;
                    break;
                }
            }
            Thread.sleep(500);
        }


        for (Coche_DanielH coche : coches) {
            if (!coche.equals(ganador)) {
                coche.detener();
            }
        }

        System.out.println("\n¡" + ganador.getNombre() + " ha ganado la carrera!");


        for (Coche_DanielH coche : coches) {
            coche.join();
        }

        System.out.println("\nResultados finales:");
        for (Coche_DanielH coche : coches) {
            System.out.println(coche.getNombre() + " recorrió " + coche.getDistanciaRecorrida() + " metros.");
        }

        sc.close();
    }
}

