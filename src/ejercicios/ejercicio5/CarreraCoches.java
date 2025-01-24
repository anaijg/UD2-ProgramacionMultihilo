package ejercicios.ejercicio5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarreraCoches
{
    List<Coche> coches = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        int distanciaCircuito = -1;
        boolean error = false;

        String respuestaDistanciaCircuito;
        do
        {
            System.out.print("Introduce la distancia del circuito (metros): ");
            respuestaDistanciaCircuito = sc.next();
        }
        while (!isValidInt(respuestaDistanciaCircuito, "Introduzca un número válido"));

        distanciaCircuito = Integer.parseInt(respuestaDistanciaCircuito);
    }

    private static boolean isValidInt(String stringToConvert, String message)
    {
        try
        {
            Integer.parseInt(stringToConvert);
            return true;
        }
        catch (Exception e)
        {
            System.out.println(message);
            return false;
        }
    }
}
