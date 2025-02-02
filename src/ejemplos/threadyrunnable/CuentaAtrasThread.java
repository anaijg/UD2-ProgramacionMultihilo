package ejemplos.threadyrunnable;

public class CuentaAtrasThread extends Thread{
    private int countDown;
    private final int taskNumber;
    private static int taskCounter = 0;

    public CuentaAtrasThread(int countDown) {
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
        CuentaAtrasThread cuentaAtras1 = new CuentaAtrasThread(10);
        cuentaAtras1.start();

        // segundo hilo
        System.out.println("¡Comienza la cuenta atrás!");
        CuentaAtrasThread cuentaAtras2 = new CuentaAtrasThread(5);
        cuentaAtras2.start();
    }
}
