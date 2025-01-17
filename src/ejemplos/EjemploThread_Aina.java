package ejemplos;

public class EjemploThread_Aina extends Thread{
    // En este caso si queremos añadirle nombre tendríamos que crearlo asi y dos constructores uno con nombre y otro sin
//
//    private String name;
//
//    public EjemploThread_Aina(String name, String name1) {
//        super(name);
//        this.name = name1;
//    }
//
//    public EjemploThread_Aina() {
//    }

    @Override
    public void run() {
        // Aquí dentro ponemos el código que queremos que ejecute el hilo
        System.out.println("Hilo corriendo " + Thread.currentThread().getName());
    }
}

class Main2{
    public static void main(String[] args) {

        EjemploThread_Aina hilo1 = new EjemploThread_Aina();
        hilo1.start();

        EjemploThread_Aina hilo2 = new EjemploThread_Aina();
        hilo2.start();

        System.out.println("Hilo principal " + Thread.currentThread().getName());

    }
}
