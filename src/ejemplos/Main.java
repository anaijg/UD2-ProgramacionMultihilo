package ejemplos;

public class Main {
    public static void main(String[] args) {
//        Creamos un contador y los hilos
        Contador contador = new Contador();
        MyThread hilo1 = new MyThread(contador);
        MyThread hilo2 = new MyThread(contador);
//      Los iniciamos esperando
    }
}
