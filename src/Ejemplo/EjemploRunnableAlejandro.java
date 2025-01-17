package Ejemplo;

/**
 * dos formas de crear hilos
 * 1) Implementando Runnable <- la buena
 * 2) Extendiendo thread
 */

public class EjemploRunnableAlejandro implements Runnable{

    @Override
    public void run() {
        //Aqui dentro ponemos el codigo que quieres que ejecute el hilo
        System.out.println("Hilo corriendo " + Thread.currentThread().getName());
    }
}

//Creo la clase donde se ejecutan los hilos
class main{
    public static void main (String[] args){
        //Para lanzar un hilo:
        //1) Creo un objeto de la clase que implementa Runnable
        EjemploRunnableAlejandro task1 = new EjemploRunnableAlejandro();
        //2) Ahora si, creamos el objeto thread pasandole en el constructor la task
        Thread hilo1 = new Thread(task1);
        Thread hilo2 = new Thread(task1,"hilo negro");
        //3)Lanzamos el hilo ocn el metodo start
        hilo1.start();
        hilo2.start();

        //Y siempre anda por detras el hilo main
        System.out.println("El main es este " + Thread.currentThread().getName());
    }
}
