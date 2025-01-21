package ejercicios.ejercicio1;

import javax.swing.plaf.TableHeaderUI;

public class InfoHiloJuanDaniel implements Runnable {
    @Override
    public void run() {
        // Obtenemos el hilo actual
        // aqui se refiere al hilo que estamos ejecutando a partir de la clase InfoHiloJuanDaniel
        Thread hiloActual = Thread.currentThread();

        // Mostramos la información del hilo actual
        System.out.println("=== Información del Hilo Actual ===");
        System.out.println("Nombre del hilo: " + hiloActual.getName());
        System.out.println("Prioridad del hilo: "+ hiloActual.getPriority()); // mayor prioridad: 10, menor prioridad: 1
        System.out.println("ID del hilo: "+ hiloActual.getId());


        // Contamos el número de hilos activos
        int hilosActivos = hiloActual.getThreadGroup().activeCount();
        Thread[] arrayHilosActivos = new Thread[hilosActivos];

        // Obtenemos todos los hilos activos
        int hilosReales = Thread.currentThread().getThreadGroup().enumerate(arrayHilosActivos, true);


        // Mostramos el número total de hilos activos y sus nombres
        System.out.println("\n=== Hilos Activos ===");
        for (int i = 0; i < hilosReales; i++) {
            System.out.println((i + 1)+ " " + arrayHilosActivos[i].getName());
        }

    }

    public static void main(String[] args) {
        System.out.println("En el main imprimo Thread.currentThread: " + Thread.currentThread().getName());
        // Creamos una instancia de nuestra clase
        // 1) primero creamos un objeto de tipo Runnable
        InfoHiloJuanDaniel task1 = new InfoHiloJuanDaniel();

        // Creamos un nuevo hilo con un nombre personalizado
        // Creamos un hilo y le pasamos en el contructor la task
        Thread hilo1 = new Thread(task1, "Mi hilo favorito");

        // Establecemos una prioridad personalizada (1-10)
        hilo1.setPriority(10);

        // Iniciamos el hilo
        hilo1.start();

        // Esperamos a que el hilo termine

    }
}
