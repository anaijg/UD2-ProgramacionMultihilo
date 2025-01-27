package ejercicios.ejercicio5;

import java.util.concurrent.atomic.AtomicBoolean;

public class Coche implements Runnable {
    private final int id;
    private final int velocidad;
    private final int distanciaCircuito;
    private final AtomicBoolean carreraTerminada;

    private int distanciaRecorrida;

    public Coche(int id, int velocidad, int distanciaCircuito, AtomicBoolean carreraTerminada) {
        this.id = id;
        this.velocidad = velocidad;
        this.distanciaCircuito = distanciaCircuito;
        this.carreraTerminada = carreraTerminada;
        this.distanciaRecorrida = 0;
    }

    @Override
    public void run() {
        while (distanciaRecorrida < distanciaCircuito && !carreraTerminada.get()) {
            try {
                // Avanzar la distancia según la velocidad
                distanciaRecorrida += velocidad;

                // Calcular porcentaje completado
                int porcentaje = Math.min((distanciaRecorrida * 100) / distanciaCircuito, 100);

                // Generar la barra de progreso
                String barraProgreso = generarBarraProgreso(porcentaje);

                // Mostrar el progreso del coche
                System.out.printf("Coche %d %s %d%%\n", id, barraProgreso, porcentaje);

                // Verificar si el coche ha ganado
                if (distanciaRecorrida >= distanciaCircuito) {
                    carreraTerminada.set(true);
                    System.out.printf("\n¡Coche %d ha ganado la carrera!\n", id);
                }

                // Esperar 1 segundo antes del siguiente avance
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Mostrar la distancia final recorrida por el coche
        if (!carreraTerminada.get()) {
            System.out.printf("Coche %d terminó con %d%% del recorrido.\n",
                    id, Math.min((distanciaRecorrida * 100) / distanciaCircuito, 100));
        }
    }

    private String generarBarraProgreso(int porcentaje) {
        int bloques = porcentaje / 5; // Cada bloque representa el 5% de la barra
        StringBuilder barra = new StringBuilder("[");
        for (int i = 0; i < 20; i++) {
            if (i < bloques) {
                barra.append("=");
            } else if (i == bloques) {
                barra.append(">");
            } else {
                barra.append(" ");
            }
        }
        barra.append("]");
        return barra.toString();
    }
}