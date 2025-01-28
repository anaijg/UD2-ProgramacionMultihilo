package ejercicios.Ejercicio4;

import ejercicios.ejercicio2.Roedores_Javier;
import utilidades.Color;
import utilidades.Emoji;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class E4_Javier {

    public static void main(String[] args) {
        Roedores_Javier[] roedores = {
            new Roedores_Javier("Fievel", 4, Color.RED, Emoji.RAT),
            new Roedores_Javier("Jerry", 5, Color.YELLOW, Emoji.CHIPMUNK),
            new Roedores_Javier("Pinky", 3, Color.BLUE, Emoji.MOUSE),
            new Roedores_Javier("Mickey", 6, Color.GREEN, Emoji.HAMSTER)
        };
        ordenarPorTiempoEnComer(roedores);
        Menu(roedores);
    }
    public static void ordenarPorTiempoEnComer(Roedores_Javier[] roedores) {
        Arrays.sort(roedores, Comparator.comparingInt(Roedores_Javier::getTiempoEnComer));
    }
    public static Thread[] covertirAThread(Roedores_Javier[] roedores) {
        Thread[] ratonera = new Thread[roedores.length];
        for (int i = 0; i < roedores.length; i++) {
            ratonera[i] = new Thread(roedores[i]);
            if(ratonera[0] == ratonera[i]) {
                ratonera[0].setPriority(10);
            } if (ratonera[1] == ratonera[i]) {
                ratonera[1].setPriority(9);
            } if (ratonera[2] == ratonera[i]) {
                ratonera[2].setPriority(8);
            } if (ratonera[3] == ratonera[i]) {
                ratonera[3].setPriority(7);
            }
        }
        return ratonera;
    }

    public static void startThreads(Thread[] Raton) {
        try {
            for (Thread hilo : Raton) {
                hilo.start();
                hilo.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void startThreads2(Thread[] Raton) {
        try {
            for (Thread hilo : Raton) {
                hilo.start();
            }
            for (Thread hilo : Raton) {
                hilo.join();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void Menu(Roedores_Javier[] ratones) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n                    La parrillada de Mickey Mause                    \n");

        boolean salir = false;

        do {
            mostrarOpcionesMenu();
            int opcion = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        System.out.println("Opción 1 seleccionada: roedores no esperan a que finalice el anterior para empezar");
                        startThreads2(covertirAThread(ratones));
                        break;
                    case 2:
                        System.out.println("Opción 2 seleccionada: roedores esperan a que finalice el anterior para empezar");
                        startThreads(covertirAThread(ratones));
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        Thread.sleep(500);
                        System.out.println("ESPERO QUE TE HAYA GUSTADO EL PROGRAMA");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, inténtelo de nuevo.");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!salir);



    }


    private static void mostrarOpcionesMenu() {
        System.out.println("1. roedores no esperan a que finalice el anterior para empezar");
        System.out.println("2. roedores esperan a que finalice el anterior para empezar");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }
}
