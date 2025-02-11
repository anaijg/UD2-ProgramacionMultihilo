public class Relevos {
    public static void main(String[] args) {
        System.out.println("-Crear Corredores-");
        
        Corredor corredor1 = new Corredor(1);
        Corredor corredor2 = new Corredor(2);
        Corredor corredor3 = new Corredor(3);
        Corredor corredor4 = new Corredor(4);
        
        corredor1.setSiguiente(corredor2);
        corredor2.setSiguiente(corredor3);
        corredor3.setSiguiente(corredor4);
        
        System.out.println("-Salida-");
        corredor4.start();
        corredor3.start();
        corredor2.start();
        corredor1.start();
        
        try {
            corredor1.join();
            corredor2.join();
            corredor3.join();
            corredor4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("-Todos finalizaron-");
    }
}
