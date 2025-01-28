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
            }catch (InterruptedException e){

            }
        }
    }

    private void mostrarProgreso(){

    }

    private void avanzar(){

    }
}