package controlador;

import modelo.Dado;
import vista.ImagenDado;


public class ControlDado {

    private Dado modeloDado;
    private ImagenDado vistaDado;

    public static String[] caraPrincipal = new String[10];

    public static String[] caraOpuesta = new String[10];

    public ControlDado(Dado modeloDado, ImagenDado vistaDado) {

        this.modeloDado = modeloDado;
        this.vistaDado = vistaDado;

    }

    public ControlDado() {

    }

    public void LanzarDado() {
        for (int i = 0; i < 10; i++) {
            int lanzamientos = modeloDado.lanzar();
            vistaDado.imagenDelDado(lanzamientos, i);
            caraPrincipal[i] = String.valueOf(lanzamientos);
            int opuesto = modeloDado.caraOpuesta(lanzamientos);
            caraOpuesta[i] = String.valueOf(opuesto);
        }
    }

    public String[] getCaraPrincipal() {
        return caraPrincipal;
    }


}


