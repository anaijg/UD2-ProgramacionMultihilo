package ejemplos.threadyrunnable;

public class CuentaAtrasRunnable implements Runnable{
    private int countDown = 10;
    private int taskNumber = 0;
    // variable estática que es común para todos los objetos; si un objeto cambia su valor, cambia para todos los objetos
    private static int taskCounter = 0;

    // cada vez que creamos un objeto de esta clase, se incrementa taskCounter
    public CuentaAtrasRunnable(int countDown) {
        this.countDown = countDown;
        taskCounter++;
        taskNumber = taskCounter;
    }

    @Override
    public void run() {
        // aquí metemos lo que tenga que hacer el hilo, en este caso contar hacia atrás
        while (countDown > 0) {
            System.out.println("#" + taskNumber + " (" + countDown + ")");
            countDown--;
        }
    }

    public static void main(String[] args) {
        // primer hilo
        System.out.println("¡Comienza la primera cuenta atrás!");
        CuentaAtrasRunnable task1 = new CuentaAtrasRunnable(10);
        Thread hilo1 = new Thread(task1);
        hilo1.start();

        // segundo hilo
        System.out.println("¡Comienza la segunda cuenta atrás!");
        CuentaAtrasRunnable task2 = new CuentaAtrasRunnable(5);
        Thread hilo2 = new Thread(task2);
        hilo2.start();

        // y el main siempre presente
        System.out.println(Thread.currentThread().getName());
    }
}