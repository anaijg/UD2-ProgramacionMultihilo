package ejemplos.memoriacompartida;


class HiloContador extends Thread {
    private final Contador contador;

    public HiloContador(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        contador.incrementar();
    }
}

class HiloContadorRunnable implements Runnable {
    private final Contador contador;

    public HiloContadorRunnable(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        contador.incrementar();
    }
}

