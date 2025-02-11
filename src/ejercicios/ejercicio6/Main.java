package ejercicios.ejercicio6;

import ejercicios.ejercicio4_davidT.Roedor;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Corredor corredor1 = new Corredor();
        Corredor corredor2 = new Corredor();
        Corredor corredor3 = new Corredor();
        Corredor corredor4 = new Corredor();


        ArrayList<Corredor> corredores = new ArrayList<>();

        corredor1.setDorsal(1);
        corredor2.setDorsal(2);
        corredor3.setDorsal(3);
        corredor4.setDorsal(4);

        corredores.add(corredor1);
        corredores.add(corredor2);
        corredores.add(corredor3);
        corredores.add(corredor4);

        // Crear una lista dinámica para los hilos
        ArrayList<Thread> hilos = new ArrayList<>();

        //Tengo a los corredores pero necesito meterlos en hilos
        for (Corredor corredor : corredores) {
            Thread hilo = new Thread(corredor);
            hilos.add(hilo);
        }
        //recorro cada git hilo y lo incio
        for (Thread hilo : hilos) {
            hilo.start();
            try{
                hilo.join();
            }catch (InterruptedException ex){
                System.out.println("Error de hilo");
            }
        }

        System.out.println("Todos han terminado");

    }
}


