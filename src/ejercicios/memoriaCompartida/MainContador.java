package ejercicios.memoriaCompartida;

public class MainContador {
    public static void main(String[] args) {
        var contador = new Contador();
        HiloContador hiloContador1 = new HiloContador(contador);
        HiloContador hiloContador2 = new HiloContador(contador);

        try {
            hiloContador1.start();
            hiloContador2.start();
            hiloContador1.join();
            hiloContador2.join();

        } catch (InterruptedException e){
            // Mostrar mensaje de error si ocurre una interrupción en alguno de los joins
            System.out.println("Algo ha ido mal en algún join()");

            // Restaurar el estado de interrupción del hilo actual
            Thread.currentThread().interrupt();
        } finally {
            System.out.println("Contador en: " + contador.getValor());

        }
    }
}