
package modelo;

import javax.swing.*;

public class Ronda {

    private int num = 0;
    private JButton[] activos = new JButton[10];

    public Ronda(int num) {
        this.num = num;
    }

    public boolean inhabilitar() {
        if (num > 5) {
            return true;
        } else {
            return false;
        }
    }


    public int getNum() {
        return num;
    }
}
