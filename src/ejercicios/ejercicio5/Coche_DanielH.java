package ejercicios.ejercicio5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Coche_DanielH extends Thread {
    private final String nombre;
    private final int distanciaCircuito;
    private final int velocidad;
    private int distanciaRecorrida = 0;
    private boolean enCarrera = true;

    public Coche_DanielH(String nombre, int distanciaCircuito, int velocidad) {
        this.nombre = nombre;
        this.distanciaCircuito = distanciaCircuito;
        this.velocidad = velocidad;
    }

    @Override
    public void run() {
        while (enCarrera && distanciaRecorrida < distanciaCircuito) {
            avanzar();
            mostrarProgreso();
            try {
                Thread.sleep(1000); // Actualización cada segundo
            } catch (InterruptedException e) {
                System.out.println(nombre + " ha sido interrumpido.");
            }
        }
    }

    public synchronized void detener() {
        enCarrera = false;
    }

    private void avanzar() {
        if (enCarrera) {
            distanciaRecorrida += velocidad;
            if (distanciaRecorrida >= distanciaCircuito) {
                distanciaRecorrida = distanciaCircuito;
            }
        }
    }

    private synchronized void mostrarProgreso() {
        int porcentaje = (distanciaRecorrida * 100) / distanciaCircuito;
        String barra = "=".repeat(porcentaje / 5) + " ".repeat(20 - (porcentaje / 5));
        System.out.println(nombre + ": [" + barra + "] " + porcentaje + "%");
    }

    public int getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean haTerminado() {
        return distanciaRecorrida >= distanciaCircuito;
    }
}

class CarreraCoche_DanielHs_DanielH {
    private final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        // Configuración de la carrera
        System.out.println("Bienvenido a la carrera de coches.");
        System.out.print("Introduce la distancia del circuito (en metros): ");
        int distanciaCircuito = sc.nextInt();

        System.out.print("Introduce el número de coches (1-4): ");
        int numeroCoche_DanielHs = Math.min(Math.max(sc.nextInt(), 1), 4);

        List<Coche_DanielH> coches = new ArrayList<>();
        for (int i = 1; i <= numeroCoche_DanielHs; i++) {
            System.out.print("Introduce la velocidad del Coche_DanielH " + i + " (en metros/segundo): ");
            int velocidad = sc.nextInt();
            coches.add(new Coche_DanielH("Coche_DanielH " + i, distanciaCircuito, velocidad));
        }

        // Inicio de la carrera
        System.out.println("\n¡Comienza la carrera!");
        for (Coche_DanielH coche : coches) {
            coche.start();
        }

        // Monitorear el progreso y determinar el ganador
        Coche_DanielH ganador = null;
        while (ganador == null) {
            for (Coche_DanielH coche : coches) {
                if (coche.haTerminado()) {
                    ganador = coche;
                    break;
                }
            }
            Thread.sleep(500); // Evitar consumo excesivo de CPU
        }

        // Detener los demás coches
        for (Coche_DanielH coche : coches) {
            if (!coche.equals(ganador)) {
                coche.detener();
            }
        }

        System.out.println("\n¡" + ganador.getNombre() + " ha ganado la carrera!");

        // Esperar a que terminen todos los hilos
        for (Coche_DanielH coche : coches) {
            coche.join();
        }

        // Mostrar resultados finales
        System.out.println("\nResultados finales:");
        for (Coche_DanielH coche : coches) {
            System.out.println(coche.getNombre() + " recorrió " + coche.getDistanciaRecorrida() + " metros.");
        }

        sc.close();
    }
}
