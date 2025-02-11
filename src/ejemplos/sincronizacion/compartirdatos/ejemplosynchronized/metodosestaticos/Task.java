package ejemplos.sincronizacion.compartirdatos.ejemplosynchronized.metodosestaticos;

    public class Task implements Runnable{
        @Override
        public void run() {
            MiClase.printNombre();
        }
    }

