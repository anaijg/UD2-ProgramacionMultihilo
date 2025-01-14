package ejemplos;

public class CuentaAtrásThread extends Thread{
    private int countDown = 10;
    private static int taskCount = 0;

    public CuentaAtrásThread() {
        taskCount++;
    }

    public CuentaAtrásThread(int countDown) {
        this.countDown = countDown;
        taskCount++;
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
        CuentaAtrásThread cuentaAtrás1 = new CuentaAtrásThread();
        cuentaAtrás1.start();

        // segundo hilo
        System.out.println("¡Comienza la cuenta atrás!");
        CuentaAtrásThread cuentaAtrás2 = new CuentaAtrásThread();
        cuentaAtrás2.start();
    }
}
