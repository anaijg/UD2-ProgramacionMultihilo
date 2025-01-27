package ejercicios.ejercicio5;

public class Coche implements Runnable {
    private String nombre;
    private int velocidad; // metros por segundo
    private int distanciaRecorrida = 0;
    private int distanciaTotal;

    public Coche(String nombre, int velocidad, int distanciaTotal) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.distanciaTotal = distanciaTotal;
    }

    @Override
    public void run() {
        while (distanciaRecorrida < distanciaTotal) {
            avanzar();
            mostrarProgreso();
            try {
                Thread.sleep(1000); // Simula avanzar cada segundo
            } catch (InterruptedException e) {
                System.out.println(nombre + " ha sido interrumpido.");
                break;
            }
        }
        if (distanciaRecorrida >= distanciaTotal) {
            System.out.println("¡" + nombre + " ha terminado la carrera!");
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
        int progreso = porcentaje / 5; // Cada ">" representa un 5% de progreso
        String barra = "=".repeat(progreso) + ">" + " ".repeat(20 - progreso);
        System.out.println(nombre + " [" + barra + "] " + porcentaje + "%");
    }

    public int getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public String getNombre() {
        return nombre;
    }
}
