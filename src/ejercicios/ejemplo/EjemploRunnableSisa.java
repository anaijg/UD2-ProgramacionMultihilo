package ejercicios.ejemplo;

public class EjemploRunnableSisa implements Runnable{

    @Override
    public void run() {
        System.out.println("Hola, soy un hilo" + Thread.currentThread().getName());
    }

    class Main{
        public static void main(String[] args) {
            EjemploRunnableSisa task1 = new EjemploRunnableSisa();
            Thread hilo = new Thread(task1);
            Thread hilo1 = new Thread(task1, "Hilo 1");

            hilo.start();

            System.out.println("El hilo principal es este: " +
                    Thread.currentThread().getName());

        }
    }
}
