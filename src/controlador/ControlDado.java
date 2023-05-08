package controlador;

import modelo.Dado;
import vista.ImagenDado;


public class ControlDado {

    private Dado modeloDado;

    public static boolean exitoso, estadoAccion;
    private ImagenDado imagenDado;

    public static int lanzamientos, indice, nuevo;

    public static int dados;

    public static String[] caraPrincipal = new String[10];

    public static String[] caraOpuesta = new String[10];

    public ControlDado(Dado modeloDado, ImagenDado imagenDado) {

        this.modeloDado = modeloDado;
        this.imagenDado = imagenDado;

    }

    public ControlDado() {
        modeloDado = new Dado();
        imagenDado = new ImagenDado();
        this.nuevo = nuevo;

    }

    public void LanzarDado() {
        for (indice = 0; indice < 10; indice++) {
            lanzamientos = modeloDado.lanzar();
            imagenDado.imagenDelDado(lanzamientos, indice);
            caraPrincipal[indice] = String.valueOf(lanzamientos);
            int opuesto = modeloDado.caraOpuesta(lanzamientos);
            caraOpuesta[indice] = String.valueOf(opuesto);
        }
    }

    public String[] getCaraPrincipal() {
        return caraPrincipal;
    }

    public void metodo(int dado) {

        if (dado == 3) {
            dados=3;
            nuevo = modeloDado.meeple(dado);
            ImagenDado.exitoso = true;
            imagenDado.mensaje(dado);
            System.out.println("Dado nuevo: " + nuevo+" Estado: "+Estado());
        }
        if (modeloDado.nave(dado) == 4) {
            dados=4;
            nuevo = modeloDado.nave(dado);
            ImagenDado.exitoso = true;
            imagenDado.mensaje(dado);
            System.out.println("Dado inactivo: " + nuevo+" Estado: "+Estado());

        }
        if (modeloDado.heroe(dado) == 5) {
            dados=5;
            nuevo = modeloDado.heroe(dado);
            ImagenDado.exitoso = true;
            imagenDado.mensaje(dado);
            System.out.println("Cara opuesta: " + nuevo+" Estado: "+Estado());
        }
        if (dado == 6) {
            dados=6;
            nuevo = modeloDado.corazon(dado);
            ImagenDado.exitoso = true;
            imagenDado.mensaje(dado);
            System.out.println("Dado volverse activar: " + nuevo+" Estado: "+Estado());
        }

        else if (modeloDado.caraSuma(dado) == 42) {
            System.out.println("Si paso" + dado);
        }

    }

    public int Estado(){
        if (dados==1) {
            System.out.println("Entro al 42");
            dados=1;
            return dados;
        }
        if (dados==2) {
            System.out.println("Entro al dragon");
            dados=2;
            return dados;
        }
        if (dados==3) {
            System.out.println("Entro al meeple");
            dados=3;
            return dados;
        }
        if (dados==4) {
            System.out.println("Entro a nave");
            dados=4;
            return dados;
        }
        if (dados==5) {
            System.out.println("Entro a heroe");
            dados=5;
            return dados;
        }
        if (dados==6) {
            System.out.println("Entro a corazon");
            dados=6;
            return dados;
        }
        else{
            return 0;
        }

    }


}


