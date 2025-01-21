package ejercicios.ejercicio1;

public class InfoHilo implements Runnable{
    @Override
    public void run() {
        Thread hiloactual = new Thread(this);
        
        System.out.println("====  Informacion del Hilo Actual  ====");
        System.out.println("Nombre del hilo:");
        System.out.println("Prioridad del hilo:");
        System.out.println("ID del hilo:");

        System.out.println("\n===  Hilos Activos  ===");
    }
    public static void main(String[] args) {
        System.out.println("En el main imprime Thread.cuttentThread" + Thread.currentThread().getName());

        InfoHilo task1 = new InfoHilo();
        Thread hiloa1 = new Thread(task1,"Mi hilo fav");
        hiloa1.start();
    }
}


