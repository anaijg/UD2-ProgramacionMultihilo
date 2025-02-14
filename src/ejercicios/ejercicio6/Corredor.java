package ejercicios.ejercicio6;

public class Corredor extends Thread{
    private int dorsal;

    public Corredor(int dorsal) {
        this.dorsal = dorsal;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    @Override
    public void run() {
        super.run();
    }
}
class Relevos{
    public static void main(String[] args) {
        Corredor corredor1 = new Corredor(1);
        Corredor corredor2 = new Corredor(2);
        Corredor corredor3 = new Corredor(3);
        Corredor corredor4 = new Corredor(4);
        Thread hilo1 = new Thread(corredor1);
    }
}
