    package ejercicios.ejercicio5noentra.solucionJohan;

    public class Piloto {
        private final String nombre;

        private int Decterminacion;

        public Piloto(String nombre, int Decterminacion) {
            this.Decterminacion = Decterminacion;
            this.nombre = nombre;
        }

        public void setDecterminacion(int decterminacion) {
            Decterminacion = decterminacion;
        }

        public String getNombre() {
            return nombre;
        }


        public int getDecterminacion() {
            return Decterminacion;
        }
    }
