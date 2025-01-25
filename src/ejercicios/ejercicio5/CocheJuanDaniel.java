package ejercicios.ejercicio5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CocheJuanDaniel implements Runnable {
    private final String nombre;
    private final int velocidad; // metros por segundo
    private final int distanciaCircuito;
    private int distanciaRecorrida = 0;
    private boolean corriendo = true;

    public CocheJuanDaniel(String nombre, int velocidad, int distanciaCircuito) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.distanciaCircuito = distanciaCircuito;
    }

    public int getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public String getNombre() {
        return nombre;
    }

    public void detener() {
        corriendo = false;
    }

    @Override
    public void run() {
        while (corriendo && distanciaRecorrida < distanciaCircuito) {
            try {
                Thread.sleep(1000); // Simula 1 segundo
                distanciaRecorrida += velocidad;
                if (distanciaRecorrida > distanciaCircuito) {
                    distanciaRecorrida = distanciaCircuito;
                }
            } catch (InterruptedException e) {
                System.out.println(nombre + " ha sido interrumpido.");
                Thread.currentThread().interrupt();
            }
        }
    }

    public String getBarraProgreso() {
        int porcentaje = (distanciaRecorrida * 100) / distanciaCircuito;
        int barraLleno = porcentaje / 5; // Cada 5% representa un símbolo '='
        StringBuilder barra = new StringBuilder("[");
        for (int i = 0; i < 20; i++) {
            if (i < barraLleno) {
                barra.append("=");
            } else if (i == barraLleno) {
                barra.append(">");
            } else {
                barra.append(" ");
            }
        }
        barra.append("] ").append(porcentaje).append("%");
        return barra.toString();
    }
}

class CarreraCoches {
    public CarreraCoches() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<CocheJuanDaniel> coches = new ArrayList<>();

        // Configurar distancia del circuito
        System.out.print("Introduce la distancia del circuito (metros): ");
        int distanciaCircuito = scanner.nextInt();

        // Configurar número de coches
        System.out.print("Introduce el número de coches (máximo 4): ");
        int numCoches = scanner.nextInt();
        numCoches = Math.min(numCoches, 4); // Limitar a un máximo de 4 coches

        // Configurar velocidad de cada coche
        for (int i = 1; i <= numCoches; i++) {
            System.out.print("Introduce la velocidad del coche " + i + " (metros/segundo): ");
            int velocidad = scanner.nextInt();
            coches.add(new CocheJuanDaniel("Coche " + i, velocidad, distanciaCircuito));
        }

        System.out.println("\n¡Comienza la carrera!");
        System.out.println("===================");

        // Iniciar hilos
        List<Thread> hilos = new ArrayList<>();
        for (CocheJuanDaniel coche : coches) {
            Thread hilo = new Thread(coche);
            hilos.add(hilo);
            hilo.start();
        }

        // Monitor de carrera
        CocheJuanDaniel ganador = null;

        while (ganador == null) {
            System.out.println();
            for (CocheJuanDaniel coche : coches) {
                System.out.println(coche.getNombre() + " " + coche.getBarraProgreso());
                if (coche.getDistanciaRecorrida() >= distanciaCircuito && ganador == null) {
                    ganador = coche;
                    System.out.println("\n¡" + ganador.getNombre() + " ha ganado la carrera!");
                    // Detener todos los coches
                    for (CocheJuanDaniel c : coches) {
                        c.detener();
                    }
                    break;
                }
            }
            if (ganador == null) {
                try {
                    Thread.sleep(1000); // Actualización cada segundo
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        // Mostrar progresos finales
        System.out.println();
        for (CocheJuanDaniel coche : coches) {
            if (coche != ganador) {
                System.out.println(coche.getNombre() + " " + coche.getBarraProgreso());
            }
        }

        System.out.println("\n¡Carrera finalizada!");
    }
}
