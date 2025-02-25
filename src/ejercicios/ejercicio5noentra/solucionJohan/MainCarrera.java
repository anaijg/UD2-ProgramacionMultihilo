package ejercicios.ejercicio5noentra.solucionJohan;

import java.util.*;

public class MainCarrera {

    public static void main(String[] args) {
        loQueDiosQuiera();
    }

    // Método que obtiene la configuración de la carrera y la información de los pilotos y la cantidad de cohces
    // y agregados por el usuario y los mete en un arraysHasMap Finalmente, el método devuelve una lista de dos
    // HashMap, uno que contiene la clave "distanciaTotal" con su respectivo valor y otro que contiene la clave
    // "numCoches" con su valor correspondiente..
    public static ArrayList<HashMap<String, Integer>>  obtenerConfiguracionCarrera(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la distancia total del circuito (Metros): ");
        int distanciaTotal = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el número de coches (máximo 4): ");
        int numCoches = Math.min(scanner.nextInt(), 4);
        scanner.nextLine();

        return new ArrayList<HashMap<String, Integer>>(Arrays.asList(
                new HashMap<String, Integer>() {{
                    put("distanciaTotal", distanciaTotal);
                }},
                new HashMap<String, Integer>() {{
                    put("numCoches", numCoches);
                }}
        ));
    }

    // Este método permite la creación de pilotos utilizando la información ingresada por el usuario.
    // La información recopilada es almacenada en un array de tipo Piloto, el cual es devuelto por el
    // método al finalizar el proceso.
    public static Piloto[] crearPilotos(int numCoches) {
        Piloto[] pilotos = new Piloto[numCoches];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < numCoches; i++) {
            System.out.print("Ingrese el nombre del piloto " + (i + 1) + ": ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese la determinación del piloto " + (i + 1) + " (1-10): ");
            int determinacion = scanner.nextInt();
            scanner.nextLine();

            pilotos[i] = new Piloto(nombre, determinacion);
        }

        return pilotos;
    }

    // Este método permite la creación de Coches utilizando la información ingresada por el usuario.
    // La información recopilada es almacenada en un array de tipo Coches, el cual es devuelto por el
    // método al finalizar el proceso
    public static Coche[] crearCoches(int numCoches, int distanciaTotal, Piloto[] pilotos) {
        Coche[] coches = new Coche[numCoches];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < numCoches; i++) {
            System.out.print("Ingrese el nombre del coche " + (i + 1) + ": ");
            String nombreCoche = scanner.nextLine();

            System.out.print("Ingrese la velocidad base del coche " + (i + 1) + " (km/h): ");
            int velocidadBase = scanner.nextInt();
            scanner.nextLine();

            coches[i] = new Coche(nombreCoche, velocidadBase, distanciaTotal, pilotos[i]);
        }

        return coches;
    }

   //                                      Comienza la Acciion
   // El método iniciarCarrera inicia una carrera de coches utilizando hilos para simular el movimiento de cada coche.
   // El método recibe un array de coches que participarán en la carrera y crea un hilo para cada uno de ellos.
   // Luego, inicia cada uno de los hilos y muestra el progreso de la carrera en la consola.
   // El método se encarga de verificar si la carrera ha finalizado y determinar al ganador,
   //  así como de mostrar el podio y los resultados finales de la carrera.
    public static void iniciarCarrera(Coche[] coches) {
        Thread[] hilos = new Thread[coches.length];
        for (int i = 0; i < coches.length; i++) {
            hilos[i] = new Thread(coches[i]);
        }

        for (int i = 0; i < coches.length; i++) {
            hilos[i].start();
        }

        boolean carreraEnCurso = true;
        Coche ganador = null;

        while (carreraEnCurso) {
            carreraEnCurso = false;

            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("¡Comienza la carrera!");
            System.out.println("===================");

            for (Coche coche : coches) {
                if (!coche.isTerminado()) {
                    carreraEnCurso = true;
                }
                coche.mostrarProgreso();

                if (coche.isTerminado() && ganador == null) {
                    ganador = coche;
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        if (ganador != null) {
            System.out.printf("\n¡%s ha ganado la carrera con el piloto %s!\n", ganador.getNombre(), ganador.getPiloto().getNombre());
        }


        List<Coche> listaCoches = Arrays.asList(coches);
        Collections.sort(listaCoches, Comparator.comparingInt(Coche::getDistanciaRecorrida).reversed());

        System.out.println("\nPodio de la carrera:");
        for (int i = 0; i < Math.min(3, listaCoches.size()); i++) {
            Coche coche = listaCoches.get(i);
            System.out.printf("%d. %s (Piloto: %s) - %d unidades recorridas\n", i + 1, coche.getNombre(), coche.getPiloto().getNombre(), coche.getDistanciaRecorrida());
        }


        System.out.println("\nCarrera finalizada. Resultados:");
        for (Coche coche : coches) {
            System.out.printf("%s (Piloto: %s) recorrió %d unidades.\n", coche.getNombre(), coche.getPiloto().getNombre(), coche.getDistanciaRecorrida());
        }
    }

    // Este método muestra un menú de opciones para que el usuario pueda elegir entre crear sus propios coches y pilotos,
    // utilizar una configuración predefinida, o salir del programa. Dependiendo de la elección del usuario, el método
    // ejecuta las acciones correspondientes y finalmente inicia la carrera.
    public static void  loQueDiosQuiera (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido a la carrera de coches");
        System.out.println("1. Organizar tu propia carrera");
        System.out.println("2. Iniciiar carrera predefinida");
        System.out.println("0. Salir");
        int opcion = scanner.nextInt();
        switch (opcion){
            case 1:
                ArrayList<HashMap<String, Integer>> configuracion = obtenerConfiguracionCarrera();
                int distanciaTotal = configuracion.get(0).get("distanciaTotal");
                int numCoches = configuracion.get(1).get("numCoches");

                Piloto[] pilotos = crearPilotos(numCoches);
                Coche[] coches = crearCoches(numCoches, distanciaTotal, pilotos);

                iniciarCarrera(coches);
                break;
            case 2:
                Piloto[] pilotosTwo = new Piloto[] {
                        new Piloto("Johan montoya", 10),
                        new Piloto("Kamily sena", 8),
                        new Piloto("alejandro alonso", 8),
                        new Piloto("sisa ", 7)
                };

                Coche[] cochesTwo = new Coche[] {
                        new Coche("Ferrari", 9, 500, pilotosTwo[0]),
                        new Coche("Mercedes", 10, 500, pilotosTwo[1]),
                        new Coche("Red Bull", 10, 500, pilotosTwo[2]),
                        new Coche("McLaren", 10, 500, pilotosTwo[3])
                };

                iniciarCarrera(cochesTwo);

                break;
            case 0:
                System.out.println("Gracias por participar");
                break;
        }

    }


}
