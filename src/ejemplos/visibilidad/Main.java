package ejemplos.visibilidad;

/**
 * En el main se crean dos hilos (workers) visibles y otros dos invisibles y se comprueba si hay diferencia en el resultado.
 *
 */
class  MainVisibilidad{
public static void main(String[] args) {
    EjemploVisibilidad contadorVisible = new EjemploVisibilidad(0);
    EjemploInvisibilidad contadorInvisible = new EjemploInvisibilidad(0);

    //Creamos dos hilos visibles
    Thread hilo1 = new Thread(new TaskVisible(contadorVisible), "Hilo Visible 1");
    Thread hilo2 = new Thread(new TaskVisible(contadorVisible), "Hilo Visible 2");


    //Creamos dos hilos invisibles
    Thread hilo3 = new Thread(new TaskInvisible(contadorInvisible),"Hilo Invisible 1");
    Thread hilo4 = new Thread(new TaskInvisible(contadorInvisible),"Hilo Invisible 2");

    //Iniciamos los hilos
    hilo1.start();
    hilo2.start();
    hilo3.start();
    hilo4.start();

    try{
        hilo1.join();
        hilo2.join();
        hilo3.join();
        hilo4.join();
    }catch (InterruptedException ex1){
        System.out.println(ex1.getMessage());
        ex1.printStackTrace();

    }



}
}