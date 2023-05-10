/*
 Autores:
 Sarahy Gisselle Caicedo Betancourth
 Kevin Andres Giron Villegas
 <sarahy.caicedo@correounivalle.edu.co>
 <kevin.giron@correounivalle.edu.co>
 Fecha creación: 2023-05-04
 Fecha última modificación: 2023-05-07
*/
package controlador;

import modelo.Ronda;
import vista.GUI;
import vista.ImagenDado;

/*
 *INTENCION: Tiene como proposito controlar y manejar la logica del juego para
 *  determinar cuantas ondas se han jugado y validar si se ha llegado al final
 */

public class ControlRonda {
    public static Ronda num;
    public static ImagenDado imagenDado;

    public static ControlDado controlDado;


    /*
     * Constructor de la clase
     */

    public ControlRonda() {
    }

    /*
     * Recibe como parametro el numero actual de la ronda y crea una instancia de la
     * clase ronda para verificar si se ha alcanzado el limite de 5 rondas.
     */

    public int rondas(int ron) {
        num = new Ronda(ron);
        if (num.inhabilitar() <= 5) {
            return num.getNum();
        } else {
            return num.getNum();
        }
    }

    /*
     * Recibe la cantidad de caras en una ronda y el numero de dado correspondiente,
     * crea una instancia de la clase Ronda y llama a la funcion estadoFinal, determinando
     * si se ha llegado al final del juego.
     */

    public static void recorrer(String[] vigentes) {
        num = new Ronda();
        imagenDado = new ImagenDado();
        boolean todosIguales = true;
        for (int i = 1; i < vigentes.length; i++) {
            if (!vigentes[i].equals(vigentes[0])) {
                todosIguales = false;
                break;
            }
        }
        System.out.println("Dados" + controlDado.dados);

        if (vigentes[0].equals("1") && todosIguales == true) {
                GUI.mensajeRondas(Integer.parseInt(vigentes[0]));
        } else if (vigentes[0].equals("2") && todosIguales == true) {
            GUI.mensajeRondas(Integer.parseInt(vigentes[0]));
                System.out.println("Pierdes todos los puntos.");
        } else if (vigentes[0].equals("3") && todosIguales == true) {
            GUI.mensajeRondas(Integer.parseInt(vigentes[0]));
                System.out.println("No sumas.");
        } else if (vigentes[0].equals("4") && todosIguales == true) {
            GUI.mensajeRondas(Integer.parseInt(vigentes[0]));
                System.out.println("No sumas.");
        } else if (vigentes[0].equals("5") && todosIguales == true) {
            GUI.mensajeRondas(Integer.parseInt(vigentes[0]));
                System.out.println("No sumas.");
        } else if(vigentes[0].equals("6") && todosIguales == true){
            GUI.mensajeRondas(Integer.parseInt(vigentes[0]));
        }


    }


}
