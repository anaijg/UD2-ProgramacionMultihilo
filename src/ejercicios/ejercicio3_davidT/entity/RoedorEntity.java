package ejercicios.ejercicio3_davidT.entity;

import utilidades.Color;
import utilidades.Emoji;

public class RoedorEntity {
    private String nombre;
    private int tiempoEnComer;
    private Color color;
    private Emoji emoji;

    public RoedorEntity(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.color = color;
        this.emoji = emoji;
    }


    public RoedorEntity() {
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getTiempoEnComer() {
        return tiempoEnComer;
    }

    public void setTiempoEnComer(int tiempoEnComer) {
        this.tiempoEnComer = tiempoEnComer;
    }

    public Emoji getEmoji() {
        return emoji;
    }

    public void setEmoji(Emoji emoji) {
        this.emoji = emoji;
    }

    @Override
    public String toString() {
        return "Roedor{" +
                "nombre='" + nombre + '\'' +
                ", tiempoEnComer=" + tiempoEnComer +
                ", color=" + color +
                ", emoji=" + emoji +
                '}';
    }
}
