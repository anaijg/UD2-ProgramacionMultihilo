package ejercicios.ejercicio5;

import java.util.Scanner;

public class CarreraCoches {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce la distancia: ");
        int distancia = teclado.nextInt();

        System.out.print("Introduce el nª de coches: ");
        int nCoches = Math.min(teclado.nextInt(),4);

        Coche[] coches = new Coche[nCoches];
        Thread[] hilos = new Thread[nCoches];

        for (int i = 0; i < nCoches; i++){
            System.out.println("Introduce la velocidad del coche " + (i+1) + ": ");
            int velocidad = teclado.nextInt();
            coches[i] = new Coche("Coche " + (i+1), velocidad, distancia);
            hilos[i] = new Thread(coches[i]);
        }

        System.out.println("============ GO ============");

        for (Thread hilo : hilos){
            hilo.start();
        }

        boolean terminado = false;
        while (!terminado){
            terminado = true;
            for (Coche coche : coches){
                if (!coche.terminado2()){
                    terminado = false;
                    break;
                }
            }
        }

        for (Thread hilo : hilos){
            hilo.interrupt();
        }

        Coche ganador = null;
        for (Coche coche : coches){
            if (coche.terminado2()){
                ganador = coche;
                break;
            }
        }

        if (ganador != null){
            System.out.println("El ganador es: " + ganador.getNombre());
        }

        System.out.println("============ FIN ============");

    }
}