package ejercicios.ejercicio5;


import utilidades.Emoji;

class Coche implements Runnable {
     String nombre;
     int velocidad;
     int distanciaRecorrida = 0;
     int distanciaTotal;
     static volatile boolean hayGanador = false;

//     recuerda q el volatile ayuda a que cambie por diferentes hilos

    public Coche(String nombre, int velocidad, int distanciaTotal) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.distanciaTotal = distanciaTotal;
    }

    public void avanzar() {
        if (!hayGanador) {
            distanciaRecorrida += velocidad;
            if (distanciaRecorrida >= distanciaTotal) {
                distanciaRecorrida = distanciaTotal;
                hayGanador = true;
                System.out.println("\n¡" + nombre + " ha ganado la carrera!");
            }
        }
    }

    public void Progreso() {
        int porcentaje = Math.min(100, (100 * distanciaRecorrida) / distanciaTotal);
        int barraProgreso = porcentaje / 5;
        String barra = "[" + "=".repeat(barraProgreso)+ Emoji.Ferrary.getEmoji()+ ">" + " ".repeat(20 - barraProgreso) + "] ";
        System.out.println(nombre + " " + barra + porcentaje + "%");
    }

    @Override
    public void run() {
        while (distanciaRecorrida < distanciaTotal && !hayGanador) {
            avanzar();
            Progreso();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}