/*
 Autores:
 Sarahy Gisselle Caicedo Betancourth
 Kevin Andres Giron Villegas
 <sarahy.caicedo@correounivalle.edu.co>
 <kevin.giron@correounivalle.edu.co>
 Fecha creación: 2023-05-01
 Fecha última modificación: 2023-05-06
*/
/*
 INTENCION: Esta clase tiene como porposito establecer un fondo a traves del metodo paintComponent.
 */
package vista;

import javax.swing.*;
import java.awt.*;

public class Fondo extends JPanel {
    private Image imagenFondo;

    public Fondo(Image imagenFondo) {
        this.imagenFondo = imagenFondo;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagenFondo != null) {
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), null);
        }
    }
}