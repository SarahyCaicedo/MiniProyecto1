package modelo;

public class Dado {
    private int volverALanzar;
    private final String[] cara = new String[]{"42", "Dragon", "Meeple", "Nave", "Heroe", "Corazon"};
    public static String Caras;

    public Dado() {

    }

    public int lanzar() {
        return (int) (Math.random() * 6) + 1;
    }

    public int caraOpuesta(int dado) {
        int opuesto = 7 - dado;
        return opuesto;
    }

    public boolean dragon(int dado) {
        if (2 == dado) {
            return true;

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

    public int meeple(int dado) {
        if (3 == dado) {
            volverALanzar = this.lanzar();
            return volverALanzar;
        }
        return volverALanzar;

    }

    public int nave(int dado) {
        if (4 == dado) {
            return dado;
        } else {
            return 0;
        }

    }

    public int heroe(int dado) {
        if (5 == dado) {
            return dado;
        } else {
            return 0;
        }

    }

    public int corazon(int dado) {
        if (6 == dado) {
            volverALanzar = this.lanzar();
            return volverALanzar;
        } else {
            return 0;
        }
    }

    public String getCaras(int dado) {
        Caras = cara[dado - 1];
        return Caras;
    }
}


