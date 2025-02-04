package ejercicios.ejercicio5;

import java.util.Scanner;

class Coche_AlejandroTorres extends Thread {
    private String nombre;
    private int velocidad;
    private int distanciaRecorrida;
    private int distanciaTotal;
    private boolean carreraActiva;

    public Coche_AlejandroTorres(String nombre, int velocidad, int distanciaTotal) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.distanciaTotal = distanciaTotal;
        this.distanciaRecorrida = 0;
        this.carreraActiva = true;
    }

    @Override
    public void run() {
        while (carreraActiva && distanciaRecorrida < distanciaTotal) {
            distanciaRecorrida += velocidad;
            if (distanciaRecorrida > distanciaTotal) {
                distanciaRecorrida = distanciaTotal;
            }
            try {
                Thread.sleep(1000); // Avanza cada segundo
            } catch (InterruptedException e) {
                System.out.println(nombre + " fue interrumpido.");
                Thread.currentThread().interrupt();
            }
        }
    }

    public void mostrarProgreso() {
        int porcentaje = (distanciaRecorrida * 100) / distanciaTotal;
        System.out.print(nombre + " [");
        for (int i = 0; i < 20; i++) {
            if (i < porcentaje / 5) {
                System.out.print("=");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println("] " + porcentaje + "%");
    }

    public void detener() {
        carreraActiva = false;
    }

    public int getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public String getNombre() {
        return nombre;
    }
}

public class CarreraCoches_AlejandroTorres {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce la distancia del circuito (metros): ");
        int distanciaTotal = scanner.nextInt();

        System.out.print("Introduce el número de coches (máximo 4): ");
        int numCoches = scanner.nextInt();

        if (numCoches < 1 || numCoches > 4) {
            System.out.println("Número de coches no válido. Debe ser entre 1 y 4.");
            return;
        }

        Coche_AlejandroTorres[] coches = new Coche_AlejandroTorres[numCoches];

        for (int i = 0; i < numCoches; i++) {
            System.out.print("Introduce la velocidad del coche " + (i + 1) + " (metros/segundo): ");
            int velocidad = scanner.nextInt();
            coches[i] = new Coche_AlejandroTorres("Coche " + (i + 1), velocidad, distanciaTotal);
        }

        System.out.println("\n¡Comienza la carrera!");
        System.out.println("===================");

        for (Coche_AlejandroTorres coche : coches) {
            coche.start();
        }

        boolean carreraEnCurso = true;

        while (carreraEnCurso) {
            // Mostrar progreso de cada coche
            for (Coche_AlejandroTorres coche : coches) {
                coche.mostrarProgreso();
            }
            System.out.println("===================");

            for (Coche_AlejandroTorres coche : coches) {
                if (coche.getDistanciaRecorrida() >= distanciaTotal) {
                    System.out.println("\n¡" + coche.getNombre() + " ha ganado la carrera!");
                    carreraEnCurso = false;
                    break;
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("La carrera fue interrumpida.");
                Thread.currentThread().interrupt();
            }
        }

        for (Coche_AlejandroTorres coche : coches) {
            coche.detener();
        }

        System.out.println("\n¡Carrera finalizada!");
    }
}
