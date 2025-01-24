package ejercicios.ejercicio2;

public enum Emoji {
    Raton_Alejandro("🐭"),
    Raton_johan("🐀");


    private final String simbolo;

    Emoji(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return simbolo;
    }
}
