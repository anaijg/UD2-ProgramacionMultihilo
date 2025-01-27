package ejercicios.ejercicio5;

import java.util.ArrayList;
import java.util.Scanner;

public class Coche implements Runnable{
    private String nombre;
    private int velocidad;
    private int distRecorrida = 0;
    private int disTotal;

    public Coche(String nombre, int velocidad, int disTotal) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.disTotal = disTotal;
    }

    public void mostrarProgreso(){
        int porcentaje = distRecorrida*100 / disTotal; //Calculamos el porcentaje que ha recorrido el coche
        int numIguales = porcentaje/10; //calculamos los = que van a aparecer por pantalla (he puesto que como maximo sean 10 siempre)
        String barra = "=".repeat(numIguales);//Creamos la barra que es el simbolo = y se repite tantas veces como sea el valor de numIguales que hemos calculado antes
        barra = String.format("%-10s", barra); //Creamos el formato de la barra que va a estar alineado a la izquierda y va a tener 10 posiciones y dependiendo cual sea el valor de la barra, pondrá ese numero de iguales y lo demas lo rellenará con espacios
        System.out.printf("%s [%s] %d%%\n", nombre, barra, porcentaje); // Se imprime el progreso con el formato: nombre [barra(con el numero de iguales y de espacios necesarios)] porcentaje%
    }

    public void avanzar() throws InterruptedException {
        while (distRecorrida < disTotal) {
            distRecorrida += velocidad; //Si la distancia recorrida por el coche es menor que la distancia del circuito, como la velocidad es en m/s y el circuito está en metros y cada iteracion es cada segundo, pues sumamos a la distancia recorrida la velocidad del coche

            if (distRecorrida >= disTotal) {
                distRecorrida = disTotal;
                System.out.println(nombre + " ha ganado la carrera!");
                break; //Las dos distancias se igualan, se imprime el ganador y se sale del bucle
            }
            mostrarProgreso();//Se muestra el progreso de cada coche
            Thread.sleep(1000);//Se "duerme" el hlo durante 1 segundo y se vuelve a ejecutar el bucle , hasta que la distancia recorrida sea igual o mayor a la distancia total
        }
    }

    @Override
    public void run() {
        try {
            this.avanzar();
        } catch (InterruptedException e) {
               mostrarProgreso(); //Si el metodo avanzar saca esta excepcion, un hilo ha sido interrumpido lo que significa que un coche ya ha ganado y se muestra el progreso de los demas
        }
    }
}





class MainCarrera{
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Thread> arrayHilos = new ArrayList<>();

        System.out.print("Introduce la distancia del circuito (metros): ");
        int distanciaTotal = teclado.nextInt();

        System.out.println("Introduce cuantos coches participan(maximo cuatro)");
        int coches = teclado.nextInt();

        for (int i = 0; i <coches; i++) {
            System.out.println("Introduce la velocidad del coche numero " + (i+1) );
            int velocidad = teclado.nextInt();
            arrayHilos.add(new Thread(new Coche("Coche" + (i+1), velocidad,distanciaTotal)));
        }
        for (Thread hilo : arrayHilos){
            hilo.start();
        }


        for (Thread hilo : arrayHilos) {
            try {
                hilo.join();
                for (Thread hiloInterrumpir : arrayHilos) {
                    if (hiloInterrumpir.isAlive()) {
                        hiloInterrumpir.interrupt();
                        hiloInterrumpir.join();
                    }
                }
                break; // Sale del bucle ya que un coche ha ganado
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Carrera Finalizada");

    }

}
