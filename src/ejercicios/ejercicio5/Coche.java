package ejercicios.ejercicio5;

public class Coche implements Runnable {
    private String nombre;
    private int velocidad;
    private int distancia;
    private int progreso;
    private boolean terminado;

    public Coche(String nombre, int velocidad, int distancia) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.distancia = distancia;
        this.progreso = 0;
        this.terminado = false;
    }

    @Override
    public void run() {
        while (progreso < distancia && !Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000);
                avanzar();
                mostrarProgreso();
            }catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void avanzar(){
        progreso += velocidad;
        if (progreso >= distancia){
            progreso =  distancia;
            terminado = true;
        }
    }

    public void mostrarProgreso(){
        int porcentaje = (int) ((double) progreso / distancia * 100);
        System.out.println(nombre + " " + porcentaje + "%");
    }


    public boolean terminado2(){
        return terminado;
    }
    public int getProgreso(){
        return progreso;
    }
    public String getNombre(){
        return nombre;
    }


}
