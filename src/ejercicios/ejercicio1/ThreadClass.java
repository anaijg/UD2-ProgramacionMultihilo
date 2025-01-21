package ejercicios.ejercicio1;

import java.sql.Array;

public class ThreadClass implements Runnable
{
    public static final String RESET = "\033[0m";  // Reset
    public static final String RED = "\033[0;31m";     // Rojo
    public static final String GREEN = "\033[0;32m";   // Verde
    public static final String YELLOW = "\033[0;33m";  // Amarillo
    public static final String BLUE = "\033[0;34m";    // Azul

    @Override
    public void run()
    {
        Thread mainThread = Thread.currentThread();
        String mainThreadName = mainThread.getName();
        String mainThreadPriority = String.valueOf(mainThread.getPriority());
        String mainThreadID = String.valueOf(mainThread.getId());

        System.out.println("**************************");
        System.out.println("DATOS DEL HILO PRINCIPAL");
        System.out.println("**************************\n");
        System.out.println(BLUE+"Nombre del hilo: " + mainThreadName+RESET);
        System.out.println(RED+"Prioridad del hilo: " + mainThreadPriority+RESET);
        System.out.println(GREEN+"ID del hilo: " + mainThreadID+RESET);

        System.out.println("\n*********************");
        System.out.println("DATOS DEL LOS HILOS");
        System.out.println("*********************\n");

        int activeCount = Thread.activeCount();
        Thread[] threads = new Thread[activeCount];
        Thread.enumerate(threads);

        int count = 1;
        for (Thread thread : threads)
        {
            System.out.println(YELLOW+"\nHilo Nº" + count++ + RESET);
            System.out.println(BLUE + "Nombre del hilo: " + thread.getName() + RESET);
            System.out.println(RED + "Prioridad del hilo: " + thread.getPriority() + RESET);
            System.out.println(GREEN + "ID del hilo: " + thread.getId() + RESET);
            System.out.println("------------------------------");
        }
    }

    public static void main(String[] args)
    {
        ThreadClass myCustomThread = new ThreadClass();
        Thread myThread = new Thread(myCustomThread, "Mi Hilo");
        myThread.setPriority(Thread.MAX_PRIORITY);
        myThread.start();

    }
}
