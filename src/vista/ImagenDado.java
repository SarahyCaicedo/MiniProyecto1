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
 INTENCION: Esta clase tiene como porposito crear los dados y escuchar los eventos.
 */
package vista;

import controlador.ControlDado;
import modelo.Dado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ImagenDado {

    public static boolean exitoso;
    private ControlDado controlito;
    public JButton[] dadito;
    private Titulo titulo;
    private String texto;
    private JPanel dadosActivos, dadosInactivos, dadosUtilizados, tablaPuntaje;
    public static JButton botonPresionado, secundario;
    private JTable tablon;
    private Listener listener;
    private int respuesta, indice, caraInactiva;


    public ImagenDado() {

        secundario = new JButton();
        dadito = new JButton[10];
        listener = new Listener();
        titulo = new Titulo();
        dadosActivos = new JPanel(new GridLayout(3, 3, 10, 10));
        dadosActivos.setOpaque(false);
        dadosInactivos = new JPanel();
        dadosInactivos.setOpaque(false);
        dadosInactivos.setPreferredSize(new Dimension(200, 200));
        for (int i = 0; i < 10; i++) {
            if (i < 7) {
                dadito[i] = new JButton();
                dadito[i].setPreferredSize(new Dimension(80, 80));
                dadito[i].addActionListener(listener);
                dadito[i].addMouseListener(listener);
                dadito[i].setVisible(false);
                dadosActivos.add(dadito[i]);
                texto = "Dados activos";
                dadosActivos.setBorder(titulo.gettitulo(texto));

            } else if (i > 6) {
                dadito[i] = new JButton();
                dadito[i].setPreferredSize(new Dimension(80, 80));
                dadosInactivos.add(dadito[i], BorderLayout.CENTER);
                dadito[i].setEnabled(false);
                dadito[i].setVisible(false);
                dadito[i].addActionListener(listener);
                dadito[i].addMouseListener(listener);
                texto = "Dados inactivos";
                dadosInactivos.setBorder(titulo.gettitulo(texto));
            }

        }
    }

    public boolean mostrarBotones() {
        int i = 0;
        while (i < 10) {
            dadito[i].setVisible(true);
            i++;
        }
        return true;
    }

    public void imagenDelDado(int dados, int indice) {
        ImageIcon imagen = new ImageIcon(getClass().getResource("/recursos/Cara-" + dados + ".png"));
        Image imageEscala = imagen.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon imagenFinal = new ImageIcon(imageEscala);
        dadito[indice].setIcon(imagenFinal);
        texto = "" + dados;
        dadito[indice].setActionCommand(texto);
        System.out.println("Entra a la función y colocan la imagen " + dadito[indice].getActionCommand() + "este es el indice" + indice);
    }

    public JPanel getDadosActivos() {
        return dadosActivos;

    }

    public JPanel getDadosUtilizados() {
        dadosUtilizados = new JPanel(new GridLayout(3, 3, 10, 10));
        texto = "Dados Utilizados";
        dadosUtilizados.setBorder(titulo.gettitulo(texto));
        dadosUtilizados.setOpaque(false);
        return dadosUtilizados;
    }

    public JPanel getTablaPuntaje() {
        tablaPuntaje = new JPanel();
        tablaPuntaje.setLayout(new BorderLayout());
        texto = "Marcador de puntaje";
        tablaPuntaje.setBorder(titulo.gettitulo(texto));
        tablaPuntaje.setOpaque(false);
        tablaPuntaje.add(getTabloid(), BorderLayout.CENTER);

        return tablaPuntaje;
    }

    public JTable getTabloid() {
        Object[][] data = {{"", "", 1, 3}, {6, 10, 15, 21}, {28, 36, 45, 55}

        };

        String[] columnNames = {"", "", "", ""};

        JTable table = new JTable(data, columnNames);
        table.setRowHeight(87);
        table.setGridColor(Color.BLACK);
        table.setBackground(new Color(135, 206, 255));
        table.setForeground(Color.BLACK);
        table.setFont(new Font("Serif", Font.PLAIN, 45));
        table.setIntercellSpacing(new Dimension(10, 10));
        table.setOpaque(false);

        return table;

    }

    public JPanel getDadsInactivation() {
        return dadosInactivos;
    }

    public void mensaje(int dado) {

        switch (dado) {
            case 1:
                respuesta = JOptionPane.showConfirmDialog(null,
                        "Por  presione el dado que desea cambiar", "INFORMACIÓN", JOptionPane.CLOSED_OPTION);
                break;
            case 2:
                respuesta = JOptionPane.showConfirmDialog(null,
                        "Por favor  el dado que desea cambiar", "INFORMACIÓN", JOptionPane.CLOSED_OPTION);
                break;
            case 3:
                respuesta = JOptionPane.showConfirmDialog(null,
                        "Por favor de doble clic sobre el dado que desea reelanzar", "INFORMACIÓN", JOptionPane.CLOSED_OPTION);
                break;
            case 4:
                respuesta = JOptionPane.showConfirmDialog(null,
                        "Por favor de doble clic sobre el dado que desea inactivar", "INFORMACIÓN", JOptionPane.CLOSED_OPTION);
                break;
            case 5:
                respuesta = JOptionPane.showConfirmDialog(null
                        , "Por favor de doble clic sobre el dado que desea ver su cara opuesta", "INFORMACIÓN", JOptionPane.CLOSED_OPTION);

                break;
            case 6:

                respuesta = JOptionPane.showConfirmDialog(null,
                        "De doble clic sobre el dado de los dados\n" + "inactivos que desea activar", "INFORMACIÓN", JOptionPane.CLOSED_OPTION);
                break;

        default:
        System.out.println("FALLO");
        break;
    }


}

public class Listener implements ActionListener, MouseListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        controlito = new ControlDado();
        botonPresionado = (JButton) e.getSource();
        if (exitoso == false) {
            for (int i = 0; i < controlito.getCaraPrincipal().length; i++) {
                if (botonPresionado == dadito[i]) {
                    dadosActivos.remove(dadito[i]);
                    dadosUtilizados.add(dadito[i]).setEnabled(false);
                    dadosActivos.revalidate();
                    dadosActivos.repaint();
                    controlito.metodo(Integer.parseInt(e.getActionCommand()));

                    break;
                }

            }

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        controlito = new ControlDado();
        Dado modeloDado = new Dado();
        String dado = "";
        String opuesto = "";
        try {
            if (exitoso == true && controlito.Estado() == 3) {
                if (e.getClickCount() == 2 && botonPresionado.getText() != "3") {
                    int dices = -1;
                    for (int i = 0; i < dadito.length; i++) {
                        if (dadito[i] == e.getSource()) {
                            dado = dadito[i].getActionCommand();
                            dices = i;
                            exitoso = false;
                            break;
                        }
                    }
                    if (dices != -1 && exitoso == false) {
                        int caraNueva = controlito.nuevo;
                        imagenDelDado(caraNueva, dices);
                        JOptionPane.showConfirmDialog(null, "La cara cambio a : " + modeloDado.getCaras(caraNueva), "INFORMACIÓN", JOptionPane.CLOSED_OPTION);
                    }

                    System.out.println("sale meeple");
                }
            }

            if (exitoso == true && controlito.Estado() == 4) {
                if (e.getClickCount() == 2 && botonPresionado.getText() != "4") {
                    int dices = -1;
                    for (int i = 0; i < dadito.length; i++) {
                        if (dadito[i] == e.getSource()) {
                            dado = dadito[i].getActionCommand();
                            dices = i;
                            exitoso = false;
                            break;
                        }
                    }
                    if (dices != -1 && exitoso == false) {
                        dadosActivos.remove(dadito[dices]);
                        dadito[dices].setEnabled(false);
                        dadosInactivos.add(dadito[dices]);
                        dadosActivos.revalidate();
                        dadosActivos.repaint();
                        JOptionPane.showConfirmDialog(null, "Se inactivo el dado: " + modeloDado.getCaras(Integer.parseInt(dado)), "INFORMACIÓN", JOptionPane.CLOSED_OPTION);
                    }
                    System.out.println("sale nave");
                }
            }
            if (exitoso == true && controlito.Estado() == 5) {
                if (e.getClickCount() == 2 && botonPresionado.getText() != "5") {
                    int dices = -1;
                    for (int i = 0; i < dadito.length; i++) {
                        if (dadito[i] == e.getSource()) {
                            opuesto = dadito[i].getActionCommand();
                            dices = i;
                            exitoso = false;
                            break;
                        }
                    }
                    if (dices != -1 && exitoso == false) {
                        int caraOpuesta = modeloDado.caraOpuesta(Integer.parseInt(opuesto));
                        imagenDelDado(caraOpuesta, dices);
                        dadosActivos.revalidate();
                        dadosActivos.repaint();
                        JOptionPane.showConfirmDialog(null, "Cara opuesta del dado: " + modeloDado.getCaras(caraOpuesta), "INFORMACIÓN", JOptionPane.CLOSED_OPTION);
                    }
                    System.out.println("sale heroe");
                }
            }

            if (exitoso == true && controlito.Estado() == 6) {
                if (e.getClickCount() == 2 && botonPresionado.getText() != "6") {
                    int dices = -1;

                    for (int i = 7; i < dadito.length; i++) {
                        if (dadito[i] == e.getSource()) {
                            dices = i;
                            exitoso = false;
                            break;
                        }

                    }
                    if (dices != -1 && exitoso == false) {

                        int nuevoDadoActivo = controlito.nuevo;
                        imagenDelDado(nuevoDadoActivo, dices);
                        dadosInactivos.remove(dadito[dices]);
                        dadito[dices].setEnabled(true);
                        dadosActivos.add(dadito[dices]);
                        JOptionPane.showConfirmDialog(null, "El nuevo dado activo es: " + modeloDado.getCaras(nuevoDadoActivo), "INFORMACIÓN", JOptionPane.CLOSED_OPTION);
                        dadosInactivos.revalidate();
                        dadosInactivos.repaint();
                        dadosActivos.revalidate();
                        dadosActivos.repaint();

                    }
                    System.out.println("sale corazon");

                }

            }


        } catch (NullPointerException ex) {
            System.out.println("Es nulo");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {


    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}

}
