package ejercicios.ejercicio5;

import java.util.Scanner;

class Coche implements Runnable {
    private final String nombre;
    private final int velocidad; // metros por segundo
    private int distanciaRecorrida;
    private final int distanciaTotal;
    private boolean enCarrera;

    public Coche(String nombre, int velocidad, int distanciaTotal) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.distanciaTotal = distanciaTotal;
        this.distanciaRecorrida = 0;
        this.enCarrera = true;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public boolean isEnCarrera() {
        return enCarrera;
    }

    @Override
    public void run() {
        while (distanciaRecorrida < distanciaTotal && enCarrera) {
            distanciaRecorrida += velocidad;
            if (distanciaRecorrida > distanciaTotal) {
                distanciaRecorrida = distanciaTotal;
            }
            mostrarProgreso();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void detener() {
        enCarrera = false;
    }

    private void mostrarProgreso() {
        int progreso = (distanciaRecorrida * 100) / distanciaTotal;
        int barra = progreso / 5;
        StringBuilder barraProgreso = new StringBuilder("[");

        for (int i = 0; i < 20; i++) {
            if (i < barra) {
                barraProgreso.append("=");
            } else if (i == barra) {
                barraProgreso.append(">");
            } else {
                barraProgreso.append(" ");
            }
        }

        barraProgreso.append("] ").append(progreso).append("%");
        System.out.println(nombre + " " + barraProgreso.toString());
    }
}

public class carreraCoches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce la distancia del circuito (metros): ");
        int distanciaTotal = scanner.nextInt();

        System.out.print("Introduce el número de coches (máximo 4): ");
        int numCoches = scanner.nextInt();

        if (numCoches > 4) {
            System.out.println("Número de coches no puede ser mayor a 4.");
            return;
        }

        Coche[] coches = new Coche[numCoches];
        Thread[] hilos = new Thread[numCoches];

        for (int i = 0; i < numCoches; i++) {
            System.out.print("Introduce la velocidad del coche " + (i + 1) + " (metros/segundo): ");
            int velocidad = scanner.nextInt();
            coches[i] = new Coche("Coche " + (i + 1), velocidad, distanciaTotal);
            hilos[i] = new Thread(coches[i]);
        }

        for (Thread hilo : hilos) {
            hilo.start();
        }

        boolean carreraEnMarcha = true;
        while (carreraEnMarcha) {
            for (int i = 0; i < numCoches; i++) {
                if (coches[i].getDistanciaRecorrida() == distanciaTotal) {
                    System.out.println("¡" + coches[i].getNombre() + " ha ganado la carrera!");
                    carreraEnMarcha = false;
                    break;
                }
            }

            if (!carreraEnMarcha) {
                for (Coche coche : coches) {
                    coche.detener();
                    System.out.println(coche.getNombre() + " ha recorrido " + coche.getDistanciaRecorrida() + " metros.");
                }
                System.out.println("¡Carrera finalizada!");
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        scanner.close();
    }
}