package ejercicios.ejercicio6;

/*
Esperar a que el corredor anterior termine antes de iniciar su ejecución.
Imprimir mensajes de estado antes y después de correr.
Simular el tiempo de carrera con Thread.sleep().
*/

public class Corredor extends Thread {

    private int id;

    Corredor(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Soy el corredor " + id + ", corriendo...");
    }

    @Override
    public void interrupt() {
        super.interrupt();
        System.out.println("Termina el corredor " + id);
    }
}
