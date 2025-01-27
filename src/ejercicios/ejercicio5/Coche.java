package ejercicios.ejercicio5;

import java.util.ArrayList;

public class Coche implements Runnable{

    private int velocidad;
    private int distanciaTotal;
    private int progreso;
    private int numCoche;

    public Coche(int numCoche, int velocidad, int distanciaTotal) {
        this.numCoche = numCoche;
        this.velocidad = velocidad;
        this.distanciaTotal = distanciaTotal;
    }

    @Override
    public void run() {

        while (progreso < distanciaTotal) {


            try {
                Thread.sleep(1000);
                avanzar();
                mostrarProgreso();
            } catch (InterruptedException e) {
                System.out.println("Llamando al safety car");
            }
        }

    }

    private void mostrarProgreso() {
        int porcentaje = (progreso * 100) / distanciaTotal;
        if (porcentaje > 100){
            porcentaje = 100;
        }
        int longitudBarra = 20;
        int avance = (porcentaje * longitudBarra) / 100;

        StringBuilder barra = new StringBuilder("[");
        for (int i = 0; i < avance; i++) {
            barra.append("=");
        }
        if (avance < longitudBarra) {
            barra.append(">");
        }
        while (barra.length() < longitudBarra + 1) {
            barra.append(" ");
        }
        barra.append("] ").append(porcentaje).append("%");

        System.out.println("Coche "+ numCoche + barra.toString());
    }


    private void avanzar() {
        progreso += velocidad;
    }

}

