package ejercicios.ejercicio3;

import ejercicios.ejercicio2.RoedorJohan;
import utilidades.Color;
import utilidades.Emoji;

public class RoedoresET {

    public static void main(String[] args) {
        RoedorJohan taskMickey = new RoedorJohan("Mickey", 6, Color.YELLOW, Emoji.HAMSTER);
        RoedorJohan taskFievel = new RoedorJohan("Fievel", 4, Color.BLACK, Emoji.RAT);
        RoedorJohan taskPinky = new RoedorJohan("Pinky", 3, Color.RED, Emoji.MOUSE);
        RoedorJohan taskJerry = new RoedorJohan("Jerry", 5, Color.GREEN, Emoji.CHIPMUNK);


        Thread hiloFievel = new Thread(taskFievel);
        Thread hiloJerry = new Thread(taskJerry);
        Thread hiloPinky = new Thread(taskPinky);
        Thread hiloMickey = new Thread(taskMickey);

      try {

          hiloFievel.start();
          hiloFievel.join();
          // La línea hiloFievel.join(); en el código de Java que hace que el hilo actual
          // espere a que el hilo hilo1 termine su ejecución antes de continuar.
          // Esto es útil cuando necesitas asegurarte de que un hilo específico haya
          // completado su tarea antes de proceder con la ejecución del código en el
          // hilo principal o en otro hilo.

          hiloJerry.start();
          hiloJerry.join();

          hiloPinky.start();
          hiloPinky.join();

          hiloMickey.start();
          hiloMickey.join();

      }catch (InterruptedException e){
          e.printStackTrace();
      }

    }
}
