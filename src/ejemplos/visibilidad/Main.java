package ejemplos.visibilidad;

public class Main {
    public static void main(String[] args) {
        EjemploVisibilidad ejemploVisible = new EjemploVisibilidad(0);
        EjemploVisibilidad ejemploInvisible = new EjemploVisibilidad(0);

        Thread worker1 = new Thread(new TaskVisible());
        Thread worker2 = new Thread(new TaskVisible());
        Thread worker3 = new Thread(() -> {
            EjemploVisibilidad ejemplo = new EjemploVisibilidad(0);
            ejemplo.incrementar(5);
            System.out.println(Thread.currentThread().getName() + " - Valor resultante (invisible): " + ejemplo.getNumero());
        });
        Thread worker4 = new Thread(() -> {
            EjemploVisibilidad ejemplo = new EjemploVisibilidad(0);
            ejemplo.incrementar(5);
            System.out.println(Thread.currentThread().getName() + " - Valor resultante (invisible): " + ejemplo.getNumero());
        });

        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();

        try {
            worker1.join();
            worker2.join();
            worker3.join();
            worker4.join();
        } catch (InterruptedException e) {
            System.out.println("Algo ha ido mal en algún join()");
        }
    }
}
