package vista;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Title extends JLabel {

    private Border border;

    public Title() {


    }

    public Border gettitulo(String text){
        Font font = new Font("Arial", Font.BOLD, 24);
        border = BorderFactory.createCompoundBorder(
                new LineBorder(Color.GRAY, 2),
                new TitledBorder(
                        new LineBorder(Color.BLUE, 4),
                        text,
                        TitledBorder.CENTER,
                        TitledBorder.DEFAULT_POSITION,
                        font,
                        Color.BLUE
                )
        );

        return  border;

    }

}
