package ejercicios.ejercicio1;

public class InfoHilo implements Runnable {


    @Override
    public void run() {
        //obtenemos el hilo actual
        Thread hiloActual = Thread.currentThread();

        //Mostramos la información del hilo actual
        System.out.println("====");
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
