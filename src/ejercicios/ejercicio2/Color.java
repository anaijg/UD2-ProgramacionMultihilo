package ejercicios.ejercicio2;

public enum Color {
    CYAN("\033[36m"),
    BLACK("\033[30m"),
    WHITE("\033[37m"),
    RED("\033[31m"),
    RESET("\u001B[0m");

    private final String code;

    Color(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}