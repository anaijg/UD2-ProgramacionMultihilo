package ejercicios.ejercicio2;

public enum Ejercicio2_Color_Gonzalo {
    GRIS, MARRON, BLANCO, AMARILLO;

    @Override
    public String toString() {
        switch(this) {
            case GRIS: return "Gris";
            case MARRON: return "Marrón";
            case BLANCO: return "Blanco";
            case AMARILLO: return "Amarillo";
            default: return "Desconocido";
        }
    }
}
