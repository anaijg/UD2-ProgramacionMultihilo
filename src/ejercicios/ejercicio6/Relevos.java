package ejercicios.ejercicio6;

public class Relevos
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println("Doy la salida");
            for (int i = 1; i < 5; i++)
            {
                Corredor corredor = new Corredor("Corredor " + i);
                corredor.start();
                corredor.join();
            }
            System.out.println("Todos los hilos terminaron");
        }
        catch (Exception e)
        {
            System.out.println("Hubo un error");
        }
    }
}
