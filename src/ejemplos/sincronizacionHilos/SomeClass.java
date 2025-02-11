package ejemplos.sincronizacionHilos;

class SomeClass {
    public static void staticMethod() {
        // Código sin sincronizar

        synchronized (SomeClass.class) { // Sincronización sobre la clase
            // Código sincronizado
        }
    }

    public void instanceMethod() {
        // Código sin sincronizar

        synchronized (this) { // Sincronización sobre la instancia actual
            // Código sincronizado

        }
    }
}