package modelo;

public class Dado {
    public Dado() {

    }

    public int lanzar() {
        return (int) (Math.random() * 6) + 1;
    }

    public int caraOpuesta(int dado) {
        int opuesto = 7 - dado;
        return opuesto;
    }

}


