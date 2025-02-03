package ejemplos.visibilidad;

class TaskInvisible implements Runnable {
    @Override
    public void run() {
        EjemploVisibilidad ejemplo = new EjemploVisibilidad(0);
        ejemplo.incrementar(5);
        System.out.println(Thread.currentThread().getName() + " - Valor resultante: " + ejemplo.getNumero());
    }
}
