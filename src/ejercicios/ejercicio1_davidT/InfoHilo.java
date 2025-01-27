package ejercicios.ejercicio1_davidT;

public class InfoHilo implements Runnable {

    private String name;

    public InfoHilo(String name){
        this.name = name;
    }

    @Override
    public void run() {
        // Obtenemos el hilo actual
        Thread hilo = Thread.currentThread();
        String name = hilo.getName();
        // Print the name of the thread and a message
        System.out.println("["+ name +"]"+"Dentro del hilo");

        //Priority
        System.out.println("["+ name +"]"+" Priority: "+hilo.getPriority());

        // Suggest to the thread scheduler to yield the processor to other threads
        Thread.yield();

        //Id del hilo
        System.out.println("["+name+"]"+"Id: "+hilo.threadId());

        // Grupo del hilo donde se estan ejecutnado a la vez
        System.out.println("["+ name +"]"+ "ThreadGroup: "+hilo.getThreadGroup());

        // Contamos el número de hilos activos
        System.out.println("["+ name +"]"+"ThreadGroup count: "+ hilo.getThreadGroup().activeCount());
        // Obtenemos todos los hilos activos
        //int hilosReales = Thread.currentThread().getThreadGroup().enumerate(arrayHilosActivos, true);


        // Mostramos el número total de hilos activos y sus nombres
        System.out.println("\n=== Hilos Activos === (" + hilo.getThreadGroup().activeCount() +")");
        System.out.println("1. " + hilo.getThreadGroup().getName());
        System.out.println("2. " + hilo.getState());
        System.out.println("3. " + name);
        // Mostramos la información del hilo actual
        System.out.println("=== Información del Hilo Actual === ");
        System.out.println("Nombre del hilo: " + name);
        System.out.println("Prioridad del hilo: " + hilo.getPriority());
        System.out.println("ID del hilo: " + hilo.threadId());
    }

    public static void main(String[] args) {
        // Creamos una instancia de nuestra clase
        // Creamos un nuevo hilo con un nombre personalizado
        Thread hiloMain = new Thread(new InfoHilo("Hilo1"));
        hiloMain.setName("Hilo1");
        // Establecemos una prioridad personalizada (1-10)
        hiloMain.setPriority(10);
        // Iniciamos el hilo
        hiloMain.start();
        // Esperamos a que el hilo termine
        hiloMain.interrupt();

    }
}