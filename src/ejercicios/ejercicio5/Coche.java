package ejercicios.ejercicio5;

public class Coche implements Runnable {
    private String nombre;
    private int velocidad; // metros por segundo
    private int distanciaRecorrida;
    private final int distanciaTotal;
    private boolean carreraTerminada;
    private static boolean hayGanador = false;

    public Coche(String nombre, int velocidad, int distanciaTotal) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.distanciaTotal = distanciaTotal;
        this.distanciaRecorrida = 0;
        this.carreraTerminada = false;
    }

    @Override
    public void run() {
        while (!carreraTerminada && distanciaRecorrida < distanciaTotal) {
            try {
                Thread.sleep(1000); // Actualización cada segundo
                avanzar();
                mostrarProgreso();

                if (distanciaRecorrida >= distanciaTotal && !hayGanador) {
                    hayGanador = true;
                    System.out.println("\n¡" + nombre + " ha ganado la carrera!");
                }

                if (hayGanador) {
                    carreraTerminada = true;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        if (!hayGanador) {
            System.out.println("\n" + nombre + " ha recorrido " + distanciaRecorrida + " metros");
        }
    }

    private void avanzar() {
        distanciaRecorrida += velocidad;
        if (distanciaRecorrida > distanciaTotal) {
            distanciaRecorrida = distanciaTotal;
        }
    }

    private void mostrarProgreso() {
        int porcentaje = (distanciaRecorrida * 100) / distanciaTotal;
        int barraLongitud = 20;
        int progreso = (porcentaje * barraLongitud) / 100;

        StringBuilder barra = new StringBuilder("\r" + nombre + " [");
        for (int i = 0; i < barraLongitud; i++) {
            if (i < progreso) {
                barra.append("=");
            } else if (i == progreso) {
                barra.append(">");
            } else {
                barra.append(" ");
            }
        }
        barra.append("] ").append(porcentaje).append("%");

        System.out.println(barra);
    }
}