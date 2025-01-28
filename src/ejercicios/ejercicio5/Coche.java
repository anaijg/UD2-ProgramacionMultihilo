package ejercicios.ejercicio5;

public class Coche implements Runnable{
    protected String nombre;
    protected int velocidad;
    protected int distanciaTotal;
    protected int distanciaRecorrida;
    protected boolean haGanado = false;
    private static boolean carreraTerminada = false;


    public Coche(String nombre, int velocidad, int distanciaTotal) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.distanciaTotal = distanciaTotal;
        this.distanciaRecorrida = 0;
    }

    @Override
    public void run() {
        while (distanciaRecorrida < distanciaTotal && !carreraTerminada) {
            try {
                Thread.sleep(1000); // Avanza cada segundo
                distanciaRecorrida += velocidad;

                if (distanciaRecorrida >= distanciaTotal && !haGanado) {
                    distanciaRecorrida = distanciaTotal;
                    haGanado = true;
                    carreraTerminada = true; // Marca la carrera como terminada
                    System.out.println(nombre + " ha ganado la carrera");

                    // Detiene la ejecución del programa después de que un coche gane
                    System.exit(0);
                }
                mostrarProgreso();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void mostrarProgreso() {
        int porcentaje = (distanciaRecorrida * 100) / distanciaTotal;
        StringBuilder barra = new StringBuilder("[");
        int longitudBarra = 50;
        for (int i = 0; i < longitudBarra; i++) {
            if (i < (porcentaje / 2)) {
                barra.append("=");  // Muestra la barra de progreso
            } else {
                barra.append(" ");
            }
        }
        barra.append("] " + porcentaje + "%");
        System.out.println(nombre + " " + barra.toString());
    }

    public boolean haGanado() {
        return haGanado;
    }
}