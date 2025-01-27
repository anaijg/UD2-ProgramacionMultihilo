package ejercicios.ejercicio5;

import utilidades.Color;
import utilidades.Emoji;

import java.util.Scanner;

public class Coche implements Runnable {
    private String nombre;
    private int distancia_Recorrida;
    private int distancia_Total;
    private int velocidad_coches;
    private static boolean carreraTerminada = false;

    public Coche(String nombre, int velocidad_coches, int distancia_Total) {
        this.nombre = nombre;
        this.velocidad_coches = velocidad_coches;
        this.distancia_Total = distancia_Total;
        this.distancia_Recorrida = 0;
    }

    @Override
    public void run() {
        while (distancia_Recorrida < distancia_Total && !carreraTerminada) {
            avanzar();
            mostraProgreso();
            try {
                Thread.sleep(1000); // Espera 1 segundo
            } catch (InterruptedException ex1) {
                ex1.printStackTrace();
            }
        }
        if (distancia_Recorrida >= distancia_Total && !carreraTerminada) {
            carreraTerminada = true;
            System.out.println("\n¡" + nombre + " ha ganado la carrera!");
        }
    }

    public void mostraProgreso() {
        int porcentaje = (distancia_Recorrida * 100) / distancia_Total;
        int barraProgreso = porcentaje / 5;
        StringBuilder barra = new StringBuilder("[");
        for (int i = 0; i < 20; i++) {
            if (i < barraProgreso) {
                barra.append("=");
            } else {
                barra.append(" ");
            }
        }
        barra.append("] ").append(porcentaje).append("%");
        System.out.println(nombre + " " + barra.toString());
    }

    public void avanzar() {
        distancia_Recorrida += velocidad_coches;
        if (distancia_Recorrida >= distancia_Total) {
            distancia_Recorrida = distancia_Total;
        }
    }

    public static boolean isCarreraTerminada() {
        return carreraTerminada;
    }
}

class MainCoches {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce la distancia del circuito (metros):");
        int distancia = teclado.nextInt();
        System.out.println("Introduce el número de coches (máximo 4):");
        int numeroCoches = teclado.nextInt();

        Coche[] coches = new Coche[numeroCoches];
        Thread[] hilos = new Thread[numeroCoches];

        for (int i = 0; i < numeroCoches; i++) {
            System.out.println("Introduce la velocidad del coche " + (i + 1) + " (metros/segundo):");
            int velocidad = teclado.nextInt();
            coches[i] = new Coche("Coche " + (i + 1), velocidad, distancia);
            hilos[i] = new Thread(coches[i]);
        }

        System.out.println("\n¡Comienza la carrera!");
        for (Thread hilo : hilos) {
            hilo.start();
        }

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