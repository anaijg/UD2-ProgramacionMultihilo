package ejercicios.ejercicio6;

public class Carrera_relevos_Miguel {

    static class Corredor extends Thread {
        private final String nombre;
        private final Thread corredorAnterior;

        public Corredor(String nombre, Thread corredorAnterior) {
            this.nombre = nombre;
            this.corredorAnterior = corredorAnterior;
        }

        @Override
        public void run() {
            try {
                if (corredorAnterior != null) {
                    corredorAnterior.join(); // Espera a que el corredor anterior termine
                }
                System.out.println("Soy el corredor: " + nombre + ", empiezo a correr...");
                Thread.sleep((long) (Math.random() * 3000) + 1000); // Simula el tiempo de carrera
                System.out.println("He terminado. " + nombre);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Relevos {
        public static void main(String[] args) {
            System.out.println("Todos los hilos creados.");
            System.out.println("¡Doy la salida!");

            Corredor c1 = new Corredor("corredor 1", null);
            Corredor c2 = new Corredor("corredor 2", c1);
            Corredor c3 = new Corredor("corredor 3", c2);
            Corredor c4 = new Corredor("corredor 4", c3);

            c1.start();
            c2.start();
            c3.start();
            c4.start();

            try {
                c4.join(); // Esperamos a que el último corredor termine
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Todos los hilos terminaron.");
        }
    }

}
