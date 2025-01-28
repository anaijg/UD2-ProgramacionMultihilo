package pruebas.ejercicio1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Semaforo implements Runnable {
    private EstadoSemaforo estado;


    @Override
    public void run() {
        turno();
    }

    public void turno() {

        ArrayList<EstadoSemaforo> estadoSemaforos = new ArrayList<>();
        estadoSemaforos.add(EstadoSemaforo.VERDE);
        estadoSemaforos.add(EstadoSemaforo.AMARILLO);
        estadoSemaforos.add(EstadoSemaforo.ROJO);
        estadoSemaforos.add(EstadoSemaforo.GRIS);



        while (true) {
            for (EstadoSemaforo estado : estadoSemaforos) {

                try {
                    switch (estado) {
                        case VERDE:
                            System.out.println("\n" + EstadoSemaforo.GRIS + "\n" + EstadoSemaforo.GRIS + "\n" + EstadoSemaforo.VERDE + "\n--".repeat(4));
                            Thread.sleep(8000);
                            break;

                        case AMARILLO:
                            System.out.println("\n" + EstadoSemaforo.GRIS + "\n" + EstadoSemaforo.AMARILLO + "\n" + EstadoSemaforo.GRIS + "\n--".repeat(4));
                            Thread.sleep(4000);
                            break;

                        case ROJO:
                            System.out.println("\n" + EstadoSemaforo.ROJO + "\n" + EstadoSemaforo.GRIS + "\n" + EstadoSemaforo.GRIS + "\n--".repeat(4));
                            Thread.sleep(9000);
                            break;

                        default:

                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        Semaforo semaforo = new Semaforo();
        Thread hilo1 = new Thread(semaforo, "task1");
        hilo1.start();
    }
}
