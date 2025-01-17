package ejemplos;

import java.util.concurrent.ThreadLocalRandom;

public class SimulacionRestaurante {
    static class Camarero implements Runnable {
        private final String nombre;
        private final int numMesas;

        public Camarero(String nombre, int numMesas) {
            this.nombre = nombre;
            this.numMesas = numMesas;
        }

        @Override
        public void run() {
            try {
                for (int i = 1; i <= numMesas; i++) {
                    // Simular tiempo de atención a la mesa (entre 1 y 5 segundos)
                    int tiempoAtencion = ThreadLocalRandom.current().nextInt(1000, 5001);

                    System.out.printf("Camarero %s: Atendiendo mesa %d%n", nombre, i);
                    Thread.sleep(tiempoAtencion);

                    // Simular tiempo de preparación en cocina (entre 2 y 8 segundos)
                    int tiempoPreparacion = ThreadLocalRandom.current().nextInt(2000, 8001);
                    System.out.printf("Camarero %s: Esperando pedido de mesa %d en cocina%n", nombre, i);
                    Thread.sleep(tiempoPreparacion);

                    // Simular entrega del pedido (entre 1 y 3 segundos)
                    int tiempoEntrega = ThreadLocalRandom.current().nextInt(1000, 3001);
                    System.out.printf("Camarero %s: Entregando pedido a mesa %d%n", nombre, i);
                    Thread.sleep(tiempoEntrega);

                    System.out.printf("Camarero %s: ¡Mesa %d atendida completamente!%n", nombre, i);
                }
                System.out.printf("Camarero %s: ¡He terminado mi turno!%n", nombre);

            } catch (InterruptedException e) {
                System.out.printf("Camarero %s: Me han interrumpido%n", nombre);
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Iniciando simulación del restaurante ===");

        // Crear tres camareros que atenderán 4 mesas cada uno
        Thread camarero1 = new Thread(new Camarero("Juan", 4));
        Thread camarero2 = new Thread(new Camarero("María", 4));
        Thread camarero3 = new Thread(new Camarero("Pedro", 4));

        // Iniciar los hilos
        camarero1.start();
        camarero2.start();
        camarero3.start();

        // Esperar a que todos los camareros terminen
        try {
            camarero1.join();
            camarero2.join();
            camarero3.join();
            System.out.println("=== Simulación finalizada ===");
        } catch (InterruptedException e) {
            System.out.println("La simulación fue interrumpida");
            Thread.currentThread().interrupt();
        }
    }
}