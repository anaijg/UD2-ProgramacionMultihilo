package ejemplos.visibilidad;


public class Main {

    private static int contador = 0; // Variable compartida entre hilos

    public static void main(String[] args) throws InterruptedException {

        // Crear dos hilos visibles
        Thread hilo1 = new Thread(new Worker(true));
        Thread hilo2 = new Thread(new Worker(true));

        // Crear dos hilos invisibles
        Thread hilo3 = new Thread(new Worker(false));
        Thread hilo4 = new Thread(new Worker(false));

        // Iniciar los hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();

        // Esperar que los hilos terminen
        hilo1.join();
        hilo2.join();
        hilo3.join();
        hilo4.join();

        // Imprimir el resultado final
        System.out.println("Valor final del contador: " + contador);
    }

    // Worker que incrementa el contador dependiendo de su visibilidad
    static class Worker implements Runnable {

        private final boolean visible;

        public Worker(boolean visible) {
            this.visible = visible;
        }

        @Override
        public void run() {
            // Si el hilo es visible, se sincroniza para evitar problemas de visibilidad
            if (visible) {
                synchronized (Main.class) {
                    for (int i = 0; i < 1000; i++) {
                        contador++;
                    }
                }
            } else {
                // Si el hilo es invisible, simplemente incrementa el contador sin sincronización
                for (int i = 0; i < 1000; i++) {
                    contador++;
                }
            }
        }
    }
}


