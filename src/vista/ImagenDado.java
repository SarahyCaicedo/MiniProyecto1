package vista;

import controlador.ControlDado;
import controlador.ControlCara;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class ImagenDado {
    private JButton[] dadito;
    private Title titulo;
    private String texto;
    private JPanel dadosActivos, dadosInactivos, dadosUtilizados, tablaPuntaje;
    private JButton botonPresionado;
    private JTable tablon;
    private Listener listener;


    public ImagenDado() {
        dadito = new JButton[10];
        listener = new Listener();
        titulo = new Title();
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
        System.out.println(dadito[indice].getActionCommand());
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

    public JTable getTabloid(){
        Object[][] data = {
                {"", "", 1, 3},
                {6, 10, 15, 21},
                {28, 36, 45, 55}

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

    public JButton getBotonPresionado(){
        return botonPresionado;
    }

    public class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ControlDado controlito = new ControlDado();
            ControlCara cara = new ControlCara();
            botonPresionado = (JButton) e.getSource();
            for (int i = 0; i < controlito.getCaraPrincipal().length; i++) {
                if (controlito.getCaraPrincipal()[i].equals(e.getActionCommand())) {
                    if (e.getActionCommand().equals("1") && botonPresionado == dadito[i]) {
                        dadosActivos.remove(dadito[i]);
                        dadosUtilizados.add(dadito[i]).setEnabled(false);
                        cara.metodo(Integer.parseInt(e.getActionCommand()));

                    }
                    if (e.getActionCommand().equals("2") && botonPresionado == dadito[i]) {
                        dadosActivos.remove(dadito[i]);
                        dadosUtilizados.add(dadito[i]).setEnabled(false);
                    }
                    if (e.getActionCommand().equals("3") && botonPresionado == dadito[i]) {
                        dadosActivos.remove(dadito[i]);
                        dadosUtilizados.add(dadito[i]).setEnabled(false);
                        cara.metodo(Integer.parseInt(e.getActionCommand()));

                    }
                    if (e.getActionCommand().equals("4") && botonPresionado == dadito[i]) {
                        dadosActivos.remove(dadito[i]);
                        dadosUtilizados.add(dadito[i]).setEnabled(false);
                    }
                    if (e.getActionCommand().equals("5") && botonPresionado == dadito[i]) {
                        dadosActivos.remove(dadito[i]);
                        dadosUtilizados.add(dadito[i]).setEnabled(false);
                    }
                    if (e.getActionCommand().equals("6") && botonPresionado == dadito[i]) {
                        dadosActivos.remove(dadito[i]);
                        dadosUtilizados.add(dadito[i]).setEnabled(false);
                    }
                }

            }
            dadosActivos.revalidate();
            dadosActivos.repaint();
        }
    }
}
