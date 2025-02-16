package ejercicios.johanEjercicio.banco;

public class CuentaBancaria {

    // Atributos
    private int saldo;


    // Constructor y ponemos un saldo inicial a la cuenta para despues poder hacer las pruebas
    public CuentaBancaria(int saldoInicial) {
        this.saldo = saldoInicial;
    }


    // el metodo depositar es synchronized para que no se pueda depositar al mismo tiempo ya que se puede generar un error
    // en el saldo de la cuenta si se deposita al mismo tiempo en la cuenta o se retira al mismo tiempo de la cuenta
    public synchronized void depositar(int cantidad){
        saldo += cantidad;
        System.out.println(Thread.currentThread().getName() + " depositó: " + cantidad + " | Saldo actual: " + saldo);

    }

    // el metodo retirar es synchronized para que no se pueda retirar al mismo tiempo ya que se puede generar un error como en
    // el metodo depositar
    public synchronized void retirar(int cantidad) {
        if (saldo >= cantidad) {
            saldo -= cantidad;
            System.out.println(Thread.currentThread().getName() + " retiró: " + cantidad + " | Saldo actual: " + saldo);
        } else {
            System.out.println(Thread.currentThread().getName() + " intentó retirar: " + cantidad + " | Fondos insuficientes.");
        }
    }

    // Metodo para obtener el saldo de la cuenta bancaria
    public int getSaldo() {
        return saldo;
    }

}
