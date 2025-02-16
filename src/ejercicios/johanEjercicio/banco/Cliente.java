package ejercicios.johanEjercicio.banco;

public class Cliente implements Runnable{

    // Atributos
    private CuentaBancaria cuenta;
    private boolean esDeposito;
    private int cantidad;

    // Constructo, ponemos en esDeposito si es un deposito o no y la cantidad que se va a depositar o retirar de la cuenta
    public Cliente(CuentaBancaria cuenta, boolean esDeposito, int cantidad) {
        this.cuenta = cuenta;
        this.esDeposito = esDeposito;
        this.cantidad = cantidad;
    }

    // Metodo run para realizar las transacciones de deposito o retiro y hacemos un simulacion de tiempo de carga
    // de 1 segundo para que se pueda ver el cambio en el saldo de la cuenta y se pueda ver que no se puede depositar
    // o retirar al mismo tiempo de la cuenta Cada cliente intentará realizar 3 transacciones de deposito o retiro
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            if (esDeposito) {
                cuenta.depositar(cantidad);
            } else {
                cuenta.retirar(cantidad);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
