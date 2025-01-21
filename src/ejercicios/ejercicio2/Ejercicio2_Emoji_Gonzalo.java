package ejercicios.ejercicio2;

public enum Ejercicio2_Emoji_Gonzalo {
    RATA("🐭"),
    ARDILLA("🐿️"),
    RATON("🐁"),
    HAMSTER("🐹");

    private String simbolo;

    Ejercicio2_Emoji_Gonzalo(String simbolo) {
        this.simbolo = simbolo;
    }

    @Override
    public String toString() {
        return simbolo;
    }
}
