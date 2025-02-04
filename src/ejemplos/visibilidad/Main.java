package ejemplos.visibilidad;

/**
 * En el main se crean dos hilos (workers) visibles y otros dos invisibles y se comprueba si hay diferencia en el resultado.
 *
 */
class Main {
    public static void main(String[] args) {
        TaskVisible tareaVisible = new TaskVisible();
        TaskInvisible tareaInvisible = new TaskInvisible();
        Thread hiloVisible = new Thread(tareaVisible, "Hilo Visible");
        Thread hiloInvisible = new Thread(tareaInvisible, "Hilo Invisible");

        hiloVisible.start();
        hiloInvisible.start();



    }
}