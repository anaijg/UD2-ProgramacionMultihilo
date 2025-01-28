package ejercicios.ejercicio4_davidT;

import utilidades.Color;
import utilidades.Emoji;
import ejercicios.ejercicio3_davidT.entity.RoedorEntity;
import utilidades.Color;
import utilidades.Emoji;

import java.util.Scanner;

public class Roedor implements Runnable{
    private final ejercicios.ejercicio3_davidT.entity.RoedorEntity roe ;
    public Roedor(String nombre, int tiempoEnComer, Color color, Emoji emoji) {
        this.roe = new RoedorEntity(nombre, tiempoEnComer, color, emoji);
    }


    public void comer(){
        try {
            System.out.println(roe.getColor() + "El ratón " + roe.getNombre() + roe.getEmoji() + " ha empezado a alimentarse.");
            Thread.sleep(roe.getTiempoEnComer() * (long) 1000);
            System.out.println(roe.getColor() + "El ratón " + roe.getNombre() + roe.getEmoji() + " ha terminado de alimentarse.");
        } catch (InterruptedException e) {
            System.out.println("Interrupted exception del método sleep.");
            /* Clean up whatever needs to be handled before interrupting  */
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run() {
        comer();
    }
}

class MainRoedores{
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        // creamos los ratones
        ejercicios.ejercicio3_davidT.Roedor taskFievel = new ejercicios.ejercicio3_davidT.Roedor("Fievel", 4, Color.BLACK, Emoji.RAT);
        ejercicios.ejercicio3_davidT.Roedor taskJerry = new ejercicios.ejercicio3_davidT.Roedor("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK);
        ejercicios.ejercicio3_davidT.Roedor taskPinky = new ejercicios.ejercicio3_davidT.Roedor("Pinky", 3, Color.RED, Emoji.MOUSE);
        ejercicios.ejercicio3_davidT.Roedor taskMickey = new ejercicios.ejercicio3_davidT.Roedor("Mickey", 6, Color.YELLOW, Emoji.HAMSTER);
        Thread hiloFievel = new Thread(taskFievel);
        Thread hiloJerry = new Thread(taskJerry);
        Thread hiloPinky = new Thread(taskPinky);
        Thread hiloMickey = new Thread(taskMickey);

        menu(hiloFievel,hiloJerry,hiloPinky,hiloMickey);

    }
    public static void menu(Thread hiloFievel,Thread hiloJerry,Thread hiloPinky,Thread hiloMickey){
        System.out.println("-------MENU-------");
        System.out.println("1- Hamster educados");
        System.out.println("2- Hamster salvajes");
        System.out.println("0 - SALIR");
        int num = scan.nextInt();

        switch (num){
            case 1:
                esperar(hiloFievel,hiloJerry,hiloPinky,hiloMickey);
                break;
            case 2:
                atacar(hiloFievel,hiloJerry,hiloPinky,hiloMickey);
                break;
            case 0:
                System.out.println("SALIENDO...");
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }

    }
    public static void esperar(Thread hiloFievel,Thread hiloJerry,Thread hiloPinky,Thread hiloMickey){
        try{
            hiloFievel.start();
            hiloFievel.join();
            hiloJerry.start();
            hiloJerry.join();
            hiloPinky.start();
            hiloPinky.join();
            hiloMickey.start();
            hiloMickey.join();

            menu(hiloFievel,hiloJerry,hiloPinky,hiloMickey);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public static void atacar(Thread hiloFievel,Thread hiloJerry,Thread hiloPinky,Thread hiloMickey){
        try{
            hiloFievel.start();
            hiloJerry.start();
            hiloPinky.start();
            hiloMickey.start();

            menu(hiloFievel,hiloJerry,hiloPinky,hiloMickey);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}