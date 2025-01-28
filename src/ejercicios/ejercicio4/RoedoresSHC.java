package ejercicios.ejercicio4;


import ejercicios.ejercicio2.RoedorJohan;
import utilidades.Color;
import utilidades.Emoji;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class RoedoresSHC {

    public static void main(String[] args) {

        RoedorJohan[] ratones = {
                new RoedorJohan("Mickey", 6, Color.YELLOW, Emoji.HAMSTER),
                new RoedorJohan("Fievel", 1, Color.BLACK, Emoji.RAT),
                new RoedorJohan("Pinky", 3, Color.RED, Emoji.MOUSE),
                new RoedorJohan("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK)
        };
        ordenarPorTiempoEnComer(ratones);
        Menu(ratones);

    }


    // El método ordenarPorTiempoEnComer organiza un array de objetos RoedorJohan en función del tiempo que
    // cada uno tarda en comer. Se utiliza el método Arrays.sort con un Comparator personalizado que compara
    // los tiempos de dos RoedorJohan. Después de ordenar, los objetos se guardan en un array de RoedorJohan
    // organizados de menor ah mayor
    public static void ordenarPorTiempoEnComer(RoedorJohan[] ratones) {
        Arrays.sort(ratones, new Comparator<RoedorJohan>() {
            @Override
            public int compare(RoedorJohan r1, RoedorJohan r2) {
                return Integer.compare(r1.getTiempoEnComer(), r2.getTiempoEnComer());
            }
        });
    }

    // Metodo que convierte las ratonera en Threads y le asigna una prioridad a cada uno segun su tiempo en comer
    // y devuelve el Arrys de Threads organizados.
    public static Thread[] covertirAThread(RoedorJohan[] ratones) {
        Thread[] ratonera = new Thread[ratones.length];
        for (int i = 0; i < ratones.length; i++) {
            ratonera[i] = new Thread(ratones[i]);
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

    // Metodo que inicia los hilos y los hace esperar a que el anterior termine.
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

    // Metodo que inicia los hilos sin esperar a que el anterior termine.
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

    // Metodo que muestra el menu de opciones y hace un tiempo de carga que no sirve para nada solo por amor al arte y gestiona
    // los movimientos y lo que desea el usuario.
    public static void Menu(RoedorJohan[] ratones) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n                    Diviendinos ah Ratatouille                    \n");

         simularCarga();

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


    // simula una carga en pantalla con un mensaje, esto no sirve para nada solo lo hice por amor al arte.
    private static void simularCarga() {
        String[] mensajes = {"\n           ",".", ".", ".", ".", ".", ".", "  ","Car", "gando ", "este", " gran ", "prog", "rama","  ", ".", ".", ".", ".", ".", ".", " \n"};
        try {
            for (String mensaje : mensajes) {
                System.out.print(mensaje);
                Thread.sleep(500);
            }
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Metodo que muestra las opciones del menu.
    private static void mostrarOpcionesMenu() {
        System.out.println("1. roedores no esperan a que finalice el anterior para empezar");
        System.out.println("2. roedores esperan a que finalice el anterior para empezar");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }
}
