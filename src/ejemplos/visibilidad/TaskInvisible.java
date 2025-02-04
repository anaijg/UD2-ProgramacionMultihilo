package ejemplos.visibilidad;

        /**
         * Clase TaskInvisible
         * Implementa run(),
         * donde se crea un ejemploVisibilidad y se incrementa en cinco,
         * y muestra el nombre del hilo y el valor resultante.
         */
                public class TaskInvisible implements Runnable{
                        EjemploInvisible ejemploInvisible;

                        public TaskInvisible(EjemploInvisible ejemploInvisible) {
                                this.ejemploInvisible = ejemploInvisible;
                        }

                        @Override
                        public void run() {
                                ejemploInvisible.incrementar(5);
                                System.out.println("El nombre del hilo es: " + Thread.currentThread().getName() + " y su valor es: " + ejemploInvisible.getNumero());
                        }

                }