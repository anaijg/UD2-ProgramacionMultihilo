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

