package pruebas.ejercicio1;

public enum EstadoSemaforo {
    ROJO("\uD83D\uDD34"), // 🔴
    AMARILLO("\uD83D\uDFE1"), // 🟡
    VERDE("\uD83D\uDFE2"), // 🟢
    GRIS("\u26AA"); // ⚪

    private final String icono;


    EstadoSemaforo(String icono) {
        this.icono = icono;
    }

    public String getIcono() {
        return icono;
    }

    @Override
    public String toString() {
        return icono;
    }
}
