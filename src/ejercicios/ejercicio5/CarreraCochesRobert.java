package ejercicios.ejercicio5;

import java.util.Scanner;

public class CarreraCochesRobert {
    protected int distanciaTotal;
    protected Coche[] coches;

    public CarreraCochesRobert(int distanciaTotal, int numCoches) {
        this.distanciaTotal = distanciaTotal;
        this.coches = new Coche[numCoches];
    }

    public void agregarCoche(int index, Coche coche) {
        coches[index] = coche;
    }

    public void iniciarCarrera() {
        System.out.println("¡Comienza la carrera!\n===================");

        // Crear y comenzar los hilos de cada coche
        Thread[] hilos = new Thread[coches.length];
        for (int i = 0; i < coches.length; i++) {
            hilos[i] = new Thread(coches[i]);
            hilos[i].start();
        }

        boolean carreraTerminada = false;
        while (!carreraTerminada) {
            carreraTerminada = true;
            for (Coche coche : coches) {
                if (!coche.haGanado()) {
                    carreraTerminada = false;
                }
            }

            try {
                Thread.sleep(1000); // Espera para simular el paso del tiempo
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("\n¡Carrera finalizada!");
        for (Coche coche : coches) {
            coche.mostrarProgreso(); // Mostrar el estado final de los coches
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir distancia total del circuito
        System.out.println("Introduce la distancia del circuito (metros):");
        int distancia = scanner.nextInt();

        // Pedir número de coches (máximo 4)
        System.out.println("Introduce el número de coches (máximo 4):");
        int numCoches = scanner.nextInt();

        // Validación para que el número de coches no sea mayor a 4
        if (numCoches < 1 || numCoches > 4) {
            System.out.println("El número de coches debe ser entre 1 y 4.");
            return;
        }

        // Crear la carrera y añadir los coches
        CarreraCochesRobert carrera = new CarreraCochesRobert(distancia, numCoches);

        for (int i = 0; i < numCoches; i++) {
            // Generar una velocidad aleatoria entre 20 m/s y 60 m/s
            int velocidad = (int) (Math.random() * (50 - 20 + 1) + 20);

            // Crear un coche con la velocidad aleatoria
            Coche coche = new Coche("Coche " + (i + 1), velocidad, distancia);
            carrera.agregarCoche(i, coche);
        }

        // Iniciar la carrera
        carrera.iniciarCarrera();
    }
}
