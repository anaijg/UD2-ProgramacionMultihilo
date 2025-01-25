package ejercicios.ejercicio5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Coche_Aina implements Runnable {
    private String nombre;
    private int velocidad;
    private int distanciaCircuito;
    private int distanciaRecorrida = 0;
    private boolean enCarrera = true;

    public Coche_Aina(String nombre, int velocidad, int distanciaCircuito) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.distanciaCircuito = distanciaCircuito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        while (enCarrera && distanciaRecorrida < distanciaCircuito) {
            avanzar();
            mostrarProgreso();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void avanzar() {
        distanciaRecorrida += velocidad;
        if (distanciaRecorrida > distanciaCircuito) {
            distanciaRecorrida = distanciaCircuito;
        }
    }

    private void mostrarProgreso() {
        int porcentaje = (distanciaRecorrida * 100) / distanciaCircuito;
        int barras = porcentaje / 5; // Cada barra representa el 5%
        StringBuilder barraProgreso = new StringBuilder("[");
        for (int i = 0; i < 20; i++) { // 20 segmentos totales
            if (i < barras) {
                barraProgreso.append("=");
            } else if (i == barras) {
                barraProgreso.append(">");
            } else {
                barraProgreso.append(" ");
            }
        }
        barraProgreso.append("] ").append(porcentaje).append("%");
        System.out.println(nombre + " " + barraProgreso);
    }

    public void detener() {
        enCarrera = false;
    }

    public int getDistanciaRecorrida() {
        return distanciaRecorrida;
    }
}

class CarreraCoches_Aina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce la distancia del circuito (metros): ");
        int distanciaCircuito = scanner.nextInt();

        System.out.print("Introduce el número de coches (máximo 4): ");
        int numCoches = scanner.nextInt();
        if (numCoches > 4) {
            System.out.println("Máximo 4 coches.");
            return;
        }

        List<Coche_Aina> coches = new ArrayList<>();
        List<Thread> hilos = new ArrayList<>();

        for (int i = 1; i <= numCoches; i++) {
            System.out.print("Introduce la velocidad del coche " + i + " (metros/segundo): ");
            int velocidad = scanner.nextInt();
            Coche_Aina coche = new Coche_Aina("Coche " + i, velocidad, distanciaCircuito);
            coches.add(coche);
            hilos.add(new Thread(coche));
        }

        System.out.println("\n¡Comienza la carrera!");
        System.out.println("======================");

        for (Thread hilo : hilos) {
            hilo.start();
        }

        boolean carreraActiva = true;
        while (carreraActiva) {
            for (Coche_Aina coche : coches) {
                if (coche.getDistanciaRecorrida() >= distanciaCircuito) {
                    System.out.println("\n¡Carrera finalizada!");
                    System.out.println("\n¡" + coche.getNombre() + " ha ganado la carrera!");
                    carreraActiva = false;
                    break;
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }


        for (Coche_Aina coche : coches) {
            coche.detener();
        }

        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        for (Coche_Aina coche : coches) {
            System.out.println(coche.getNombre() + " recorrió " + coche.getDistanciaRecorrida() + " metros.");
        }

        scanner.close();
    }
}
