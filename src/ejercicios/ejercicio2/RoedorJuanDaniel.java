package ejercicios.ejercicio2;

import utilidades.Color;
import utilidades.Emoji;

public class RoedorJuanDaniel implements Runnable {
    private String nombre;
    private int tiempoEnComer;
    private Color color;
    private Emoji emoji;

    public RoedorJuanDaniel(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.color = color;
        this.emoji = emoji;
    }

    public void comer(){
        System.out.println("Color: " + color + "\nNombre: " + nombre + "\nEmoji: " + emoji);
    }

    @Override
    public void run() {
        comer();
    }
}
