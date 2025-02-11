package ejercicios.ejercicio6;

public class Corredor extends Thread{

    public String nombre;
    public Corredor(String nombre)
    {
        this.nombre = nombre;
    }

    @Override
    public void run()
    {
        System.out.println("Soy el corredor "+this.nombre+", corriendo...");
        // Tiempo aleatorio entre 1 y 10 segundos
        double tiempoCarrera = Math.random() * 1000;
        try { Thread.sleep((int)tiempoCarrera);
            System.out.println("Terminé");}
        catch (Exception e) { System.out.println("Hubo un error"); }
    }
}
