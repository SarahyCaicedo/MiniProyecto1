package controlador;

import modelo.CaraDado;
import modelo.Dado;
import vista.EfectoCara;
import vista.ImagenDado;

public class ControlCara {

    private CaraDado cara;

    private EfectoCara mensaje;


    private ImagenDado vista;



    public ControlCara(){



    }
    public void metodo(int dado){
        cara= new CaraDado(dado);
        mensaje = new EfectoCara();
        if(cara.volverIntentar(dado)){
            mensaje.getseleccionar();
            meeple();
            System.out.println("Si paso"+dado);
        }
        if(cara.caraSuma(dado)==42){
            mensaje.actualizar();
            System.out.println("Si paso"+dado);
        }

    }

    public void meeple(){

    }

}
