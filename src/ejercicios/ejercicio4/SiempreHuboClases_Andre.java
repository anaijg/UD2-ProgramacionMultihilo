package ejercicios.ejercicio4;

import utilidades.Color;
import utilidades.Emoji;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SiempreHuboClases_Andre implements Runnable{
    String nombre;
    int tiempoEnComer;
    Color color;
    Emoji emoji;

    public SiempreHuboClases_Andre(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
        this.nombre = nombre;
        this.tiempoEnComer = tiempoEnComer;
        this.color = color;
        this.emoji = emoji;
    }

    public int getTiempoEnComer() {
        return tiempoEnComer;
    }

    public void comer () {
        System.out.println(color.getCode()+" " +nombre+" "+ emoji.getEmoji()+" tarda "+tiempoEnComer+"s en comer");
        try{
            Thread.sleep(tiempoEnComer* 1000L);
        }catch (InterruptedException e){
            System.out.println("El Roedor"+nombre+"fue intemrrupido mientras comia ");
            Thread.currentThread().interrupt();
        }
        System.out.println(color.getCode()+" "+nombre+ " "+emoji.getEmoji()+"Ha terminado de comer ");
    }

    @Override
    public void run() {
    comer();
    }

        public static void noEsparamos(List<SiempreHuboClases_Andre> roedoresMalos){
            System.out.println("Roedor que no espera ");
            roedoresMalos.sort(Comparator.comparingInt(SiempreHuboClases_Andre::getTiempoEnComer));
            for (SiempreHuboClases_Andre roedor : roedoresMalos) {
                Thread thread = new Thread(roedor);
                thread.start();
            }
        }

        public static void esperar(List<SiempreHuboClases_Andre>roedoresBuenos){
            System.out.println("Roedor que espera ");
            roedoresBuenos.sort(Comparator.comparingInt(SiempreHuboClases_Andre::getTiempoEnComer));
            for (SiempreHuboClases_Andre roedor : roedoresBuenos) {
                Thread thread = new Thread(roedor);
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    System.err.println("El hilo fue interrumpido.");
                    Thread.currentThread().interrupt();
                }
            }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<SiempreHuboClases_Andre>roedores = new ArrayList<>();
        roedores.add(new SiempreHuboClases_Andre("Fievel",3,Color.RED,Emoji.RAT));
        roedores.add(new SiempreHuboClases_Andre("Jerry",4,Color.GREEN,Emoji.MOUSE));
        roedores.add(new SiempreHuboClases_Andre("Pinky",5,Color.WHITE,Emoji.HAMSTER));
        roedores.add(new SiempreHuboClases_Andre("Mickey",6,Color.CYAN,Emoji.CHIPMUNK));
        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Roedores NO esperan para comer");
            System.out.println("2. Roedores SÍ esperan para comer");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: \n");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    noEsparamos(roedores);
                    break;
                case 2:
                    esperar(roedores);
                    break;
                case 0:
                    System.out.println("Programa Finalizado");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 0);

        sc.close();
    }

}
