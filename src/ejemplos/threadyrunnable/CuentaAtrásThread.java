package ejemplos.threadyrunnable;

public class CuentaAtrásThread extends Thread{
    private int countDown;
    private int taskNumber;
    private static int taskCounter = 0;

    public CuentaAtrásThread(int countDown) {
        this.countDown = countDown;
        taskCounter++;
        this.taskNumber = taskCounter;

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
        System.out.println("¡Comienza la cuenta atrás!");
        CuentaAtrásThread cuentaAtrás1 = new CuentaAtrásThread(10);
        cuentaAtrás1.start();

        // segundo hilo
        System.out.println("¡Comienza la cuenta atrás!");
        CuentaAtrásThread cuentaAtrás2 = new CuentaAtrásThread(5);
        cuentaAtrás2.start();
    }
}
