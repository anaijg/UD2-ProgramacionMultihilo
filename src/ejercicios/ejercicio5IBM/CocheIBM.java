package ejercicios.ejercicio5IBM;

public class CocheIBM extends Thread {
    private String nombre;
    private int velocidad; // metros por segundo
    private int distanciaRecorrida;
    private int distanciaTotal;
    private boolean carreraActiva;
    private static boolean carreraFinalizada = false;
    private static final Object lock = new Object();

    public CocheIBM(String nombre, int velocidad, int distanciaTotal)
    {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.distanciaTotal = distanciaTotal;
        this.distanciaRecorrida = 0;
        this.carreraActiva = true;
    }

    @Override
    public void run()
    {
        while (distanciaRecorrida < distanciaTotal && !CocheIBM.isCarreraFinalizada())
        {
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                System.out.println(nombre + " fue interrumpido.");
            }

            distanciaRecorrida += velocidad;

            if (distanciaRecorrida >= distanciaTotal)
            {
                distanciaRecorrida = distanciaTotal;
                if (!CocheIBM.isCarreraFinalizada())
                {
                    carreraFinalizada = true;
                    System.out.println("\n¡" + nombre + " ha ganado la carrera!");
                }
            }

            mostrarProgreso();
        }
    }

    public String mostrarProgreso()
    {
        synchronized (lock)
        {
            int porcentaje = (int) ((double) distanciaRecorrida / distanciaTotal * 100);
            StringBuilder progressBar = new StringBuilder();
            progressBar.append(nombre).append(" [");
            int barLength = 20;
            int progress = (int) ((double) porcentaje / 100 * barLength);
            for (int i = 0; i < barLength; i++)
            {
                if (i < progress)
                {
                    progressBar.append("=");
                }
                else if (i == progress)
                {
                    progressBar.append(">");
                }
                else
                {
                    progressBar.append(" ");
                }
            }
            progressBar.append("] ").append(porcentaje).append("%");
            return progressBar.toString();
        }
    }

    public void detener()
    {
        carreraActiva = false;
    }

    public String getNombre()
    {
        return nombre;
    }

    public static boolean isCarreraFinalizada()
    {
        return carreraFinalizada;
    }
}
