package ejemplos.visibilidad;

public class Main {
    private static volatile int visible = 0;

    private static ThreadLocal<Integer> invisible = ThreadLocal.withInitial(() -> 0);

    public static void incrementarVisible() {
        visible++;
    }

    public static void incrementarInvisible() {
        invisible.set(invisible.get() + 1);
    }

    public static void main(String[] args) {
        Thread hiloVisible1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                incrementarVisible();
            }
        });

        Thread hiloVisible2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                incrementarVisible();
            }
        });

        // Hilos invisibles
        Thread hiloInvisible1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                incrementarInvisible();
            }
        });

        Thread hiloInvisible2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                incrementarInvisible();
            }
        });

        hiloVisible1.start();
        hiloVisible2.start();
        hiloInvisible1.start();
        hiloInvisible2.start();

        try {
            hiloVisible1.join();
            hiloVisible2.join();
            hiloInvisible1.join();
            hiloInvisible2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Resultado visible (compartido entre hilos): " + visible);
        System.out.println("Resultado invisible (no compartido entre hilos): " + invisible.get());
    }
}
/**
 * En el main se crean dos hilos (workers) visibles y otros dos invisibles y se comprueba si hay diferencia en el resultado.
 *
 */
