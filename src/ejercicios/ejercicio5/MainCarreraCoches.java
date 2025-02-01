package ejercicios.ejercicio5;

import java.util.*;

class Carrera_Coches_Miguel extends Thread {
    private final String nombre;
    private final int velocidad; // en metros por segundo
    private int distanciaRecorrida = 0;
    private final int distanciaTotal;
    private static boolean carreraTerminada = false;
    public static final List<Carrera_Coches_Miguel> ganadores = new ArrayList<>();

    public Carrera_Coches_Miguel(String nombre, int velocidad, int distanciaTotal) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.distanciaTotal = distanciaTotal;
    }

    @Override
    public void run() {
        while (distanciaRecorrida < distanciaTotal && !carreraTerminada) {
            avanzar();
            mostrarProgreso();
            try {
                Thread.sleep(1000); // Simula el paso del tiempo (1 segundo)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (distanciaRecorrida >= distanciaTotal) {
            synchronized (ganadores) {
                ganadores.add(this);
                if (!carreraTerminada) {
                    carreraTerminada = true;
                }
            }
        }
    }

    private void avanzar() {
        distanciaRecorrida += velocidad;
        if (distanciaRecorrida > distanciaTotal) {
            distanciaRecorrida = distanciaTotal;
        }
    }

    private void mostrarProgreso() {
        int porcentaje = (int) ((double) distanciaRecorrida / distanciaTotal * 100);
        int barras = porcentaje / 5; // 20 barras en total

        StringBuilder barraProgreso = new StringBuilder("[");
        for (int i = 0; i < 20; i++) {
            if (i < barras) {
                barraProgreso.append("=");
            } else if (i == barras) {
                barraProgreso.append(">");
            } else {
                barraProgreso.append(" ");
            }
        }
        barraProgreso.append("] ");

        System.out.println(nombre + " " + barraProgreso + porcentaje + "%");
    }

    public String getNombre() {
        return nombre;
    }

    public void mostrarEstadoFinal() {
        mostrarProgreso();
    }
}

public class MainCarreraCoches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce la distancia del circuito (metros): ");
        int distanciaTotal = scanner.nextInt();

        System.out.print("Introduce el número de coches (máximo 4): ");
        int numCoches = scanner.nextInt();
        if (numCoches > 4) numCoches = 4;

        List<Carrera_Coches_Miguel> coches = new ArrayList<>();

        for (int i = 1; i <= numCoches; i++) {
            System.out.print("Introduce la velocidad del coche " + i + " (metros/segundo): ");
            int velocidad = scanner.nextInt();
            coches.add(new Carrera_Coches_Miguel("Coche " + i, velocidad, distanciaTotal));
        }

        System.out.println("\n¡Comienza la carrera!");
        System.out.println("===================");

        for (Carrera_Coches_Miguel coche : coches) {
            coche.start();
        }

        // Esperar a que todos los hilos terminen
        for (Carrera_Coches_Miguel coche : coches) {
            try {
                coche.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n¡Carrera finalizada!");

        // Determinar qué hacer en caso de empate
        List<Carrera_Coches_Miguel> ganadores = Carrera_Coches_Miguel.ganadores;
        if (ganadores.size() == 1) {
            System.out.println("¡" + ganadores.getFirst().getNombre() + " ha ganado la carrera!");
        } else {
            System.out.println("\n⚠️ Empate entre los siguientes coches:");
            for (Carrera_Coches_Miguel coche : ganadores) {
                System.out.println("➡️ " + coche.getNombre());
            }

            System.out.println("\n¿Cómo quieres decidir el ganador?");
            System.out.println("1️⃣ Declarar a todos como ganadores");
            System.out.println("2️⃣ Elegir un ganador al azar");
            System.out.println("3️⃣ Elegir manualmente el ganador");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("¡Ganadores: ");
                    for (Carrera_Coches_Miguel coche : ganadores) {
                        System.out.print(coche.getNombre() + " ");
                    }
                    System.out.println("!");
                }
                case 2 -> {
                    Random random = new Random();
                    Carrera_Coches_Miguel ganadorSorteo = ganadores.get(random.nextInt(ganadores.size()));
                    System.out.println("¡" + ganadorSorteo.getNombre() + " ha sido elegido al azar como el ganador!");
                }
                case 3 -> {
                    System.out.println("\nEscribe el número del coche que quieres que gane:");
                    for (int i = 0; i < ganadores.size(); i++) {
                        System.out.println((i + 1) + "️⃣ " + ganadores.get(i).getNombre());
                    }
                    int eleccion = scanner.nextInt();
                    if (eleccion >= 1 && eleccion <= ganadores.size()) {
                        System.out.println("¡" + ganadores.get(eleccion - 1).getNombre() + " ha sido elegido como el ganador!");
                    } else {
                        System.out.println("❌ Opción inválida. Se declaran todos ganadores.");
                        System.out.print("¡Ganadores: ");
                        for (Carrera_Coches_Miguel coche : ganadores) {
                            System.out.print(coche.getNombre() + " ");
                        }
                        System.out.println("!");
                    }
                }
                default -> System.out.println("❌ Opción inválida. Se declaran todos ganadores.");
            }
        }

        // Mostrar estado final de los coches después de la carrera
        System.out.println("\nEstado final de los coches:");
        for (Carrera_Coches_Miguel coche : coches) {
            coche.mostrarEstadoFinal();
        }

        scanner.close();
    }
}
