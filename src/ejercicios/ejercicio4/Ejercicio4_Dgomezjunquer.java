package ejercicios.ejercicio4;

import ejercicios.ejercicio2.Roedor;
import utilidades.Color;
import utilidades.Emoji;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static ejercicios.ejercicio2.Ejercicio2_Dgomezjunquer.roedorList;

public class Ejercicio4_Dgomezjunquer
{
    public static List<Roedor> roedoresOrdenadosPorTiempoList = new ArrayList<>(roedorList
            .stream()
            .sorted(Comparator.comparingInt(Roedor::getTiempoEnComer))
            .collect(Collectors.toList()));

    public static void OrderByPriorityAndDontWait()
    {
        List<Thread> ratones = new ArrayList<>();

        for (Roedor roedor : roedoresOrdenadosPorTiempoList)
        {
            ratones.add(new Thread(roedor));
        }

        for (Thread raton : ratones)
        {
            raton.start();
        }
    }

    public static void OrderByPriorityAndWait()
    {
        List<Thread> ratones = new ArrayList<>();

        for (Roedor roedor : roedoresOrdenadosPorTiempoList)
        {
            ratones.add(new Thread(roedor));
        }

        for (Thread raton : ratones)
        {
            try
            {
                raton.start();
                raton.join();
            }
            catch (InterruptedException e)
            {
                System.err.println("Ha ocurrido un problema con la detención de los hilos");
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println("Ordenando por prioridad y no esperando a que terminen:");
//        OrderByPriorityAndDontWait();
//        System.out.println("*********************************************");

        System.out.println("Ordenando por prioridad y esperando a que terminen:");
        OrderByPriorityAndWait();
        System.out.println("*********************************************");
    }
}
