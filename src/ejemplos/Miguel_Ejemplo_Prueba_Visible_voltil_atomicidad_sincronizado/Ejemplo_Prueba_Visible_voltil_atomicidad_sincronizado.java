package ejemplos.Miguel_Ejemplo_Prueba_Visible_voltil_atomicidad_sincronizado;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Ejemplo_Prueba_Visible_voltil_atomicidad_sincronizado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            // Mostrar el resumen en formato tabla
            System.out.println("+------------------+-------------------------+------------+--------------+--------------+");
            System.out.println("| Opción           | Visibilidad entre hilos | Atomicidad | Bloquea hilos | Rendimiento |");
            System.out.println("+------------------+-------------------------+------------+--------------+--------------+");
            System.out.println("| 1. volatil       | ✅ Sí                   | ❌ No      | ❌ No        | 🚀 Rápido   |");
            System.out.println("| 2. sincronizado  | ✅ Sí                   | ✅ Sí      | ✅ Sí        | 🐢 Lento    |");
            System.out.println("| 3. Atomicidad    | ✅ Sí                   | ✅ Sí      | ❌ No        | ⚡ Eficiente |");
            System.out.println("+------------------+-------------------------+------------+--------------+--------------+");

            // Pedir al usuario que elija una opción
            System.out.print("Elige una opción (1-3) o 0 para salir: ");
            opcion = scanner.nextInt();

            System.out.println(); // Salto de línea

            // Ejecutar la opción elegida
            switch (opcion) {
                case 1:
                    probarVolatile();
                    break;
                case 2:
                    probarSynchronized();
                    break;
                case 3:
                    probarAtomicInteger();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("❌ Opción no válida, intenta de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    // Prueba con volatile
    private static void probarVolatile() {
        System.out.println("🔹 volatil:");
        System.out.println("- Permite que todos los hilos vean el valor más reciente.");
        System.out.println("- No garantiza atomicidad, puede haber problemas con que hilo llega antes a ejecutarse.");
        System.out.println("- Útil cuando un hilo escribe y otros solo leen.");
        System.out.println();

        EjemploVolatile ejemplo = new EjemploVolatile(0);
        ejecutarHilos(ejemplo);
    }

    // Prueba con synchronized
    private static void probarSynchronized() {
        System.out.println("🔹 sincronizado:");
        System.out.println("- Permite acceso exclusivo a una variable o bloque de código.");
        System.out.println("- Evita condiciones de carrera.");
        System.out.println("- Puede causar bloqueos si muchos hilos intentan acceder.");
        System.out.println();

        EjemploSynchronized ejemplo = new EjemploSynchronized(0);
        ejecutarHilos(ejemplo);
    }

    // Prueba con AtomicInteger
    private static void probarAtomicInteger() {
        System.out.println("🔹 Atomicidad:");
        System.out.println("- Proporciona operaciones atómicas sin necesidad de sincronizar.");
        System.out.println("- Es más eficiente que el metodo sincronizado en operaciones numéricas simples.");
        System.out.println("- No bloquea hilos, lo que mejora el rendimiento.");
        System.out.println();

        EjemploAtomic ejemplo = new EjemploAtomic(0);
        ejecutarHilos(ejemplo);
    }

    // Método que ejecuta dos hilos que incrementan el número
    private static void ejecutarHilos(EjemploInterface ejemplo) {
        // Crear los hilos
        Thread hilo1 = new Thread(() -> ejemplo.incrementar(5));
        Thread hilo2 = new Thread(() -> ejemplo.incrementar(10));

        // Iniciar los hilos
        hilo1.start();
        hilo2.start();

        try {
            // Esperar a que ambos hilos terminen
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            System.out.println("Algo ha ido mal en algún join()");
        }

        // Mostrar el valor final del contador
        System.out.println("Valor final del contador: " + ejemplo.getNumero());
        System.out.println();
    }

    // Interfaz para que todas las clases tengan los mismos métodos
    interface EjemploInterface {
        int getNumero();
        void incrementar(int numero);
    }

    // Implementación usando volatile
    static class EjemploVolatile implements EjemploInterface {
        private volatile int numero;

        public EjemploVolatile(int numero) {
            this.numero = numero;
        }

        public int getNumero() {
            return numero;
        }

        public void incrementar(int numero) {
            this.numero += numero; // No es atómico, puede haber condiciones de que hilo llegue antes
        }
    }

    // Implementación usando synchronized
    static class EjemploSynchronized implements EjemploInterface {
        private int numero;

        public EjemploSynchronized(int numero) {
            this.numero = numero;
        }

        public synchronized int getNumero() {
            return numero;
        }

        public synchronized void incrementar(int numero) {
            this.numero += numero; // Protegido contra condiciones de carrera
        }
    }

    // Implementación usando AtomicInteger
    static class EjemploAtomic implements EjemploInterface {
        private final AtomicInteger numero = new AtomicInteger();

        public EjemploAtomic(int numero) {
            this.numero.set(numero);
        }

        public int getNumero() {
            return numero.get();
        }

        public void incrementar(int numero) {
            this.numero.addAndGet(numero); // Operación atómica eficiente
        }
    }
}
