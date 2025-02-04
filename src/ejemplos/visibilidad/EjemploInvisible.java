package ejemplos.visibilidad;

class Visibilidad {

    private static ThreadLocal<Integer> entero = ThreadLocal.withInitial(() -> 0);

    public int getEntero() {
        return entero.get();
    }

    public Visibilidad() {
    }

    public synchronized void incrementar(int numero) {
        entero.set(entero.get() + numero);
    }
}
