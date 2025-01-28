package ejercicios.ejercicio5_davidT;
import java.util.ArrayList;
import java.util.Scanner;

public class CarreraCoches{
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int metrosCircui,numCoches,i,metrosSeg;

        System.out.println("Introduce la distancia del circuito");
        metrosCircui = sc.nextInt();
        System.out.println("Introduce el numero de coches:(maximo 4)");
        numCoches = sc.nextInt();

        if(!(numCoches<1 || numCoches>4)){

            ArrayList<Coche> coches = new ArrayList<>();
            for(i=0;i<numCoches;i++){
                System.out.println("Introduce la velocidad del coche"+(i+1)+ " metros/segundo:");
                metrosSeg= sc.nextInt();
                coches.add(new Coche("Coche"+(i+1),metrosSeg,metrosCircui));
            }
            ArrayList<Thread> hilos = new ArrayList<>();
            for(Coche coche: coches){
                Thread hilo = new Thread(coche);
                hilos.add(hilo);
            }

            System.out.println("Comienza la carrera");
            //Iniciamos todos los hilos por igual
            for (Thread hilo: hilos){
                hilo.start();
            }

            for(Thread hilo: hilos){
                try{
                    hilo.join();
                }catch (InterruptedException ex){
                    System.out.println("Accidente en la pista" + ex.getMessage());
                }
            }

        }else {
            System.out.println("El numero de coches no es valido");
        }
    }

}