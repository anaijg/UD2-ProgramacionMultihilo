package ejercicios.johanEjercicio.banco;


   // Cuando varios hilos acceden a un mismo recurso compartido, pueden producirse condiciones de carrera.
   // Para evitarlo, se usa synchronized.


public class BancoJohan {

    public static void main(String[] args) {
        queEmpiceElAcion();
    }



    public static void queEmpiceElAcion(){
        CuentaBancaria cuenta = new CuentaBancaria(100); // Saldo inicial de 100

        // Creando clientes (hilos)
        Thread cliente1 = new Thread(new Cliente(cuenta, true, 50), "Cliente 1");  // Deposita 50
        Thread cliente2 = new Thread(new Cliente(cuenta, false, 30), "Cliente 2"); // Retira 30
        Thread cliente3 = new Thread(new Cliente(cuenta, false, 80), "Cliente 3"); // Retira 80

        // Iniciando los hilos
        cliente1.start();
        cliente2.start();
        cliente3.start();
    }
}



