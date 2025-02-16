package ejercicios.johanEjercicio.deadlockEjemplo;

  // ¿Qué es un Deadlock?
//Un deadlock ocurre cuando dos o más hilos quedan atrapados esperando recursos que nunca se liberan.
// Es como si dos personas se estiraran la mano para saludarse, pero cada una espera a que la otra
// mueva su mano primero.

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Scanner;

public class DeadlockEjemplo {

    public static void main(String[] args) {
        menu();
    }


    public static void Deadlock (){

        Mano manoJohan = new Mano("Mano");
        Mano manoPepe = new Mano("Mano");

        // Hilo de johan: bloquea su mano derecha y espera la izquierda
        Thread johan = new Thread(() -> {
            synchronized (manoJohan) {
                System.out.println("Johan extendió su mano...");

                try { Thread.sleep(100); } catch (InterruptedException e) { }

                synchronized (manoPepe) {
                    System.out.println("Johan logró saludar a Pedro 🤝");
                }

                System.out.printf("cara de payaso");
            }
        });

        // Hilo de pepe: bloquea su mano izquierda y espera la derecha
        Thread pepe = new Thread(() -> {
            synchronized (manoPepe) {
                System.out.println("Pepe extendió su mano...");

                try { Thread.sleep(100); } catch (InterruptedException e) { }

                synchronized (manoJohan) {
                    System.out.println("Pepe logró saludar a Juan 🤝");
                }
            }
        });

        johan.start();
        pepe.start();


       /* Hilo que detecta si hay Deadlock, nosotros en si no podemos ver si ocurre un deadlock pero lo que si podemos hacer es
           tener un hilo que se encargue de dectetar cuando pase esto y cuando suceda eso hacer un accion para cambiar el estado
           de los hilos, en esta ocasion hacemos que termine el proceso con interrupt
        *
        */
        Thread detector = new Thread(() -> {
            ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
            while (true) {
                long[] deadlockedThreads = threadBean.findDeadlockedThreads();
                if (deadlockedThreads != null) {
                    System.out.println("⚠️ El Detic a detectado un Deadlock: cara de payaso 🤡");
                    johan.interrupt();
                    pepe.interrupt();
                    menu(); // aca llamos menu() ya que como ocurrio un Deadlock es real, y aunque el detector de deadlock
                    // interrumpe los hilos (johan.interrupt() y pepe.interrupt()), esto no los desbloquea si están esperando
                    // dentro de un synchronized, porque synchronized no responde a la interrupción.
                    //  Si synchronized no responde a interrupt(), entonces ¿para qué interrumpir los hilos en el detector de deadlock?
                    //
                    //La razón por la que se pone interrupt() es porque en algunos casos puede ayudar a desbloquear un hilo
                    // si está esperando en ciertos métodos bloqueantes. Sin embargo, en este caso particular de synchronized,
                    // no tiene efecto directo.
                    break;  // Terminamos el programa
                }
                try { Thread.sleep(500); } catch (InterruptedException e) {}
            }
        });

        detector.setDaemon(true);  // Hilo en segundo plano
        detector.start();

        try {
            johan.join();
            pepe.join();
            detector.join();
        } catch (InterruptedException e) {
            System.out.println("Los hilos fueron interrumpidos.");
        }

    }


    public static void ManeraCorrecta (){

        Mano manojohan = new Mano("Mano johan");
        Mano manoPepe = new Mano("Mano pepe");

        Thread johan = new Thread(() -> {
            synchronized (manoPepe) {
                System.out.println("Johan extendió su mano...");
                synchronized (manojohan) {
                    System.out.println("Johan logró saludar a Pedro 🤝");
                }
            }
        });

        Thread pepe = new Thread(() -> {
            synchronized (manoPepe) {
                System.out.println("Pepe extendió su mano...");
                synchronized (manojohan) {
                    System.out.println("Pepe logró saludar a Juan 🤝");
                }
            }
        });

        johan.start();
        pepe.start();

        try {
            johan.join();
            pepe.join();
        } catch (InterruptedException e) {
            System.out.println("Los hilos fueron interrumpidos.");
        }

    }

    public static void menu () {
        Scanner pepe = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("\n Menú:");
                System.out.println("1️⃣ Ver resultado de Deadlock");
                System.out.println("2️⃣ Ver código correcto");
                System.out.println("0️⃣ Salir");

                int opcion = pepe.nextInt();

                if (opcion < 0 || opcion > 2) {  //  Corregido el error lógico
                    System.out.println(" Opción no válida. Intenta de nuevo.");
                    continue;
                }

                switch (opcion) {
                    case 1:
                        Deadlock();
                        break;
                    case 2:
                        ManeraCorrecta();
                        break;
                    case 0:
                        System.out.println("👋 Adiós, que tengas un lindo día!");
                        System.exit(1);
                        return;  //  Salir del método en vez de usar System.exit()
                }
            }
        } finally {
            pepe.close(); //  Cerramos el Scanner cuando ya no se necesite
        }
    }
}