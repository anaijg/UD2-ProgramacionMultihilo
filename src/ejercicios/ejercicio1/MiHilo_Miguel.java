package ejercicios.ejercicio1;

class InfoHilo implements Runnable {
    @Override
    public void run() {
        Thread hiloActual = Thread.currentThread();
        System.out.println("=== Información del Hilo Actual ===");
        System.out.println("Nombre del hilo: " + hiloActual.getName());
        System.out.println("Prioridad del hilo: " + hiloActual.getPriority());
        System.out.println("ID del hilo: " + hiloActual.getId());

        // Obtener y mostrar todos los hilos activos
        ThreadGroup grupoActual = Thread.currentThread().getThreadGroup();
        while (grupoActual.getParent() != null) {
            grupoActual = grupoActual.getParent();
        }
        Thread[] hilosActivos = new Thread[grupoActual.activeCount()];
        grupoActual.enumerate(hilosActivos, true);

        System.out.println("\n=== Hilos Activos (" + hilosActivos.length + ") ===");
        for (Thread hilo : hilosActivos) {
            if (hilo != null) {
                System.out.println("- " + hilo.getName());
            }
        }
    }
}

public class MiHilo_Miguel {
    public static void main(String[] args) {
        Thread miHilo = new Thread(new InfoHilo(), "Mi_Hilo_personalizado");
        miHilo.setPriority(Thread.MAX_PRIORITY); // Prioridad máxima que es = (10)
        miHilo.start();

        try {
            miHilo.join(); // Esperar a que el hilo termine
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
