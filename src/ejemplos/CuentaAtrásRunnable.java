package ejemplos;

public class CuentaAtrásRunnable implements Runnable{
    private int countDown = 10;
    private int taskCount = 0;
    // variable estática que es común para todos los objetos; si un objeto cambia su valor, cambia para todos los objetos
    private static int taskCounter = 0;

    public CuentaAtrásRunnable() {
        taskCount = ++taskCounter;
    }

    public CuentaAtrásRunnable(int countDown) {
        this.countDown = countDown;
        taskCount = ++taskCounter;
    }

    @Override
    public void run() {
        // aquí metemos lo que tenga que hacer el hilo, en este caso contar hacia atrás
        while (countDown > 0) {
            System.out.println("#" + taskCount + " (" + countDown + ")");
            countDown--;
        }
    }

    public static void main(String[] args) {
        // primer hilo
        System.out.println("¡Comienza la cuenta atrás!");
        //CuentaAtrásRunnable cuentaAtrás1 = new CuentaAtrásRunnable();
        CuentaAtrásRunnable task1 = new CuentaAtrásRunnable();
        Thread hilo1 = new Thread(task1);
        hilo1.start();
        System.out.println("¡Comienza la cuenta atrás!");
        // segundo hilo
        CuentaAtrásRunnable task2 = new CuentaAtrásRunnable();
        Thread hilo2 = new Thread(task2);
        hilo2.start();
    }
}
