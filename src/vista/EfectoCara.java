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
 INTENCION: Esta clase utiliza un metodo que en la programación de interfaces
 gráficas en Java se usa para dibujar y redibujar elementos en un componente de la GUI, como un JPanel o un JLabel.
 */
package vista;

import com.sun.source.tree.ReturnTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EfectoCara  {

    private JOptionPane seleccionar;
    private Listener listener;
    private ImagenDado elementos;




    public EfectoCara()
    {
        elementos = new ImagenDado();

    }
    public JOptionPane getseleccionar(){
        JOptionPane.showConfirmDialog(null,"Por favor presione el dado que desea cambiar","INFORMACIÓN",JOptionPane.CLOSED_OPTION);
        return seleccionar;
    }

    public void setElementos(ImagenDado elementos){
        this.elementos=elementos;
    }

    public void actualizar(){
        JButton sumar = new JButton("42");
        sumar.setBorder(BorderFactory.createEmptyBorder());
        sumar.setContentAreaFilled(false);
        sumar.setFocusPainted(false);
        sumar.setFont(new Font("Serif", Font.BOLD, 20));
        sumar.setForeground(Color.WHITE);
        sumar.setBackground(new Color(52, 152, 219));
        sumar.setOpaque(true);
        elementos.getTabloid().setValueAt(sumar, 0, 0);
    }

    public class Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==elementos.getBotonPresionado()){
                System.out.println("has presionado el botón");
            }

        }
    }







}
