package ejercicios.ejercicio5;

public class Coche implements Runnable
{
    private String nombre;
    private int velocidad;
    private int distanciaRecorrida;

    public Coche(String nombre, int velocidad, int distanciaRecorrida)
    {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.distanciaRecorrida = distanciaRecorrida;
    }

    @Override
    public void run()
    {

    }

    public void avanzar()
    {

    }

    public void mostrarProgreso()
    {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public void setDistanciaRecorrida(int distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
    }

}
