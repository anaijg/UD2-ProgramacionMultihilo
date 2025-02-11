import java.util.Random;

class Corredor extends Thread {
    private int numero;
    private Corredor siguiente;

    public Corredor(int numero) {
        this.numero = numero;
    }

    public void setSiguiente(Corredor siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public void run() {
        try {
            if (siguiente != null) {
                siguiente.join(); 
            }

            System.out.println("Soy el corredor " + numero + ", corriendo...");

            Thread.sleep(new Random().nextInt(5000) + 1000); 

            System.out.println("Terminé.");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
