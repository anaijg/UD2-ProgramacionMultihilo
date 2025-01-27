package ejercicios.ejercicio6;

public class Coche implements Runnable {
    private String nombre;
    private int velocidad;
    private int distanciaTotal;
    private int distanciaRecorrida = 0;
    private boolean finalizada = false;

    // Constructor;


    public Coche(int velocidad, int distanciaTotal, String nombre) {
        this.velocidad = velocidad;
        this.distanciaTotal = distanciaTotal;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        while (distanciaRecorrida < distanciaTotal && !finalizada) {
            avanzar();
            mostrarProgreso();

            if (distanciaRecorrida >= distanciaTotal) {
                finalizada = true;
                System.out.println(nombre + " Ha ganado la carrera!");
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void avanzar() {
        //distancia recorrida en metros cada segundo hay que sumarle la velocidad, es decir, los metros por segundo que recorre el coche
        distanciaRecorrida += velocidad;
    }

    public void mostrarProgreso() {
        int porcentaje = Math.min((distanciaRecorrida * 100) / distanciaTotal, 100);
        int barras = Math.min(porcentaje / 5, 20);
        String barraProgreso = "[" + "=".repeat(barras) + ">" + " ".repeat(20 - barras) + "] " + porcentaje + "%";

        System.out.println(nombre + " " + barraProgreso);


    }
}
