package ejercicios.ejercicio5_davidT;


public class Coche implements Runnable{

    private String nombre;
    private int velocidad,distanciaCircuito,totalRecorrido,progreso;
    //Necesito tener algo que me diga si he finalizado
    private boolean fin = false;

    public Coche(String nombre, int velocidad, int distanciaCircuito) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.distanciaCircuito = distanciaCircuito;
    }

    @Override
    public void run() {

        while(progreso<distanciaCircuito && !fin){
            try{
                Thread.sleep(1000);
                avanzar();
                mostrarProgreso();
            }catch (InterruptedException e){
                System.out.println("El coche " + this.nombre + " se ha estrellado");
            }
        }
        if (progreso >= distanciaCircuito && !fin) {
            fin = true;
            System.out.println("Coche " + this.nombre + " ha ganado la carrera!");
        }

        if (!fin) {
            mostrarProgreso();
        }
    }

    private void mostrarProgreso() {
        int porcentaje = (progreso * 100) / distanciaCircuito;
        if (porcentaje > 100){
            porcentaje = 100;
        }
        int longitudBarra = 50;
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

        System.out.println("Coche "+ this.nombre + barra.toString());
    }


    private void avanzar() {
        progreso += velocidad;
    }

}