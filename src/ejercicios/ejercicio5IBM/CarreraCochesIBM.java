package ejercicios.ejercicio5IBM;

import java.util.Scanner;

public class CarreraCochesIBM
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce la distancia del circuito (metros): ");
        int distanciaTotal = scanner.nextInt();

        System.out.print("Introduce el número de coches (máximo 4): ");
        int numCoches = scanner.nextInt();
        if (numCoches < 1 || numCoches > 4)
        {
            System.out.println("Número de coches no válido. Debe ser entre 1 y 4.");
            return;
        }

        CocheIBM[] coches = new CocheIBM[numCoches];
        for (int i = 0; i < numCoches; i++)
        {
            System.out.print("Introduce la velocidad del coche " + (i + 1) + " (metros/segundo): ");
            int velocidad = scanner.nextInt();
            coches[i] = new CocheIBM("Coche " + (i + 1), velocidad, distanciaTotal);
        }

        System.out.println("\n¡Comienza la carrera!");
        System.out.println("===================");

        for (CocheIBM coche : coches)
        {
            coche.start();
        }

        boolean carreraActiva = true;
        while (carreraActiva)
        {
            carreraActiva = !CocheIBM.isCarreraFinalizada();

            StringBuilder progreso = new StringBuilder();
            for (CocheIBM coche : coches)
            {
                progreso.append(coche.mostrarProgreso()).append("\n");
            }
            System.out.println(progreso);
            System.out.println("-------------------");

            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                System.out.println("La carrera fue interrumpida.");
                Thread.currentThread().interrupt();
            }
        }

        for (CocheIBM coche : coches)
        {
            coche.detener();
        }

        System.out.println("\n¡Carrera finalizada!");

        for (CocheIBM coche : coches)
        {
            System.out.println(coche.mostrarProgreso());
        }
    }
}
