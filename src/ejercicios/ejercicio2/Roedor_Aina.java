package ejercicios.ejercicio2;

import utilidades.Color;
import utilidades.Emoji;

public class Roedor_Aina implements Runnable{
    private String nombre;
    private int tiempoEnComer;
    private Color color;
    private Emoji emoji;

    public Roedor_Aina(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.color = color;
        this.emoji = emoji;
    }

    public void comer(){
        System.out.println("Color: " + color + "\nNombre: " + nombre + "\n Emoji: " + emoji);
        System.out.println(nombre + " Ha terminado de comer en " + tiempoEnComer + " segundos");
    }

    @Override
    public void run() {
        comer();
    }
}
