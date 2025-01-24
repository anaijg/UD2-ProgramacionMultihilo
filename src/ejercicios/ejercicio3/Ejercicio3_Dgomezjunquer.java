package ejercicios.ejercicio3;

import ejercicios.ejercicio2.Roedor;
import utilidades.Color;
import utilidades.Emoji;

import java.util.ArrayList;
import java.util.List;

import static ejercicios.ejercicio2.Ejercicio2_Dgomezjunquer.roedorList;

public class Ejercicio3_Dgomezjunquer {
    public static void main(String[] args)
    {
        List<Thread> ratones = new ArrayList<>();

        for (Roedor roedor : roedorList)
        {
            ratones.add(new Thread(roedor));
        }

        try
        {
            for (Thread raton : ratones)
            {
                raton.start();
                raton.join();
            }
        }
        catch (InterruptedException e)
        {
            System.err.println("Ha ocurrido un problema con la detención de los hilos");
        }
    }
}
