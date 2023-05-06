package modelo;

import modelo.Dado;


public class CaraDado {

    private Dado lanzar;

    private int dado;
    public CaraDado(int dado) {
        this.dado = dado;
        lanzar = new Dado();
    }

    public boolean volverIntentar(int dado) {
            if (3 == dado) {
                lanzar.lanzar();

                return  true;

            } else {
               return false;
            }
    }
    public boolean inactivarDado(int dado) {
        if (4 == dado) {
            return  true;

        } else {
            return false;
        }

    }

    public boolean caraOpuesta(int dado) {
        if (5 == dado) {
            return  true;

        } else {
            return false;
        }

    }

    public boolean activarDado(int dado) {
        if (6 == dado) {
            return  true;

        } else {
            return false;
        }

    }

    public boolean dragon(int dado) {
        if (2 == dado) {
            return  true;

        } else {
            return false;
        }
    }

    public int caraSuma(int dado) {
        if (1 == dado) {
           dado = 42;
        }
        return dado;
    }



}
