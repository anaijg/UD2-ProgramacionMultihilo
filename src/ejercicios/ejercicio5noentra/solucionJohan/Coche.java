package ejercicios.ejercicio5noentra.solucionJohan;

class Coche implements Runnable{

    private final String nombre;
    private final int velocidad;
    private final int distanciaTotal;
    private final Piloto piloto;
    private int distanciaRecorrida;
    private static boolean campeon = false;
    private boolean terminado = false;

    public Coche(String nombre, int velocidad, int distanciaTotal, Piloto piloto) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.distanciaTotal = distanciaTotal;
        this.piloto = piloto;
        this.distanciaRecorrida = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public int getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public boolean isTerminado() {
        return terminado;
    }


    // Método run lo modificamos con @Override para que ejecute la carrera del coche y nos diga el ganador.
    @Override
    public void run() {
        while (distanciaRecorrida < distanciaTotal && !campeon) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int velocidadAjustada = velocidad + piloto.getDecterminacion();
            distanciaRecorrida += velocidadAjustada;

            if (distanciaRecorrida >= distanciaTotal && !campeon) {
                synchronized (Coche.class) {
                    if (!campeon) {
                        campeon = true;
                        System.out.println("\n¡" + nombre + " ha ganado la carrera!");
                    }
                }
                terminado = true;
                break;
            }
        }
        terminado = true;
    }

    // Método que muestra el progreso de la carrera con un StringBuilder y le ponemos la distancia visual del la carrera en 50 carecteres,
    //  y Si distanciaRecorrida es 25 y distanciaTotal es 100, el porcentaje seria 25%..
    public void mostrarProgreso() {
        int porcentaje = Math.min((int) ((double) distanciaRecorrida / distanciaTotal * 100), 100);
        int barras = porcentaje / 2;

        StringBuilder barraProgreso = new StringBuilder("[");
        for (int i = 0; i < 50; i++) {
            if (i < barras) {
                barraProgreso.append("=");
            } else {
                barraProgreso.append(" ");
            }
        }

        barraProgreso.append("] ").append(porcentaje).append("% ").append(nombre).append(" (Piloto: ").append(piloto.getNombre()).append(")");

        System.out.println(barraProgreso.toString());
    }
}
