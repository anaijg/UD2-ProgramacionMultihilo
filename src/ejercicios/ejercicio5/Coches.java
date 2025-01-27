package ejercicios.ejercicio5;

public class Coches implements Runnable{
    protected String nombre;
    protected int velocidad;
    protected int distanciaTotal;
    protected int distanciaRecorrida;
    protected boolean haGanado = false;
    private static boolean carreraTerminada = false;


    public Coches(String nombre, int velocidad, int distanciaTotal) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.distanciaTotal = distanciaTotal;
        this.distanciaRecorrida = 0;
    }

    @Override
    public void run() {
        while (distanciaRecorrida < distanciaTotal && !carreraTerminada) {
            try {
                Thread.sleep(1000);
                distanciaRecorrida += velocidad;

                if (distanciaRecorrida >= distanciaTotal && !haGanado) {
                    distanciaRecorrida = distanciaTotal;
                    haGanado = true;
                    carreraTerminada = true;
                    System.out.println(nombre + " ha ganado");

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
                barra.append("=");
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