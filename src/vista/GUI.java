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
 INTENCION: Esta clase tiene como porposito capturaar el evento principal al momento de lanzar los dados.
 */
package vista;


import controlador.ControlRonda;
import modelo.Dado;
import controlador.ControlDado;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GUI extends JFrame {
    private final ImagenDado dados;
    public static JFrame frame;
    private final JPanel fondo, opciones;
    private final Titulo titulo;
    private final Listener listener;
    private JButton btnLanzarDado, botonAyudaMemoria;
    private int conteo = 1;



    public GUI() {

        listener = new Listener();
        titulo = new Titulo();
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        opciones = new JPanel(new GridLayout(2, 2));
        String texto = "De clic en el botón 'Lanzar Dados'";
        opciones.setBorder(titulo.gettitulo(texto));
        opciones.setOpaque(false);

        fondo = new Fondo(new ImageIcon(getClass().getResource("/recursos/Fondo.png")).getImage());
        frame.setContentPane(fondo);

        dados = new ImagenDado();
        opciones.add(dados.getDadosActivos());
        opciones.add(dados.getDadsInactivation());
        opciones.add(dados.getTablaPuntaje());
        opciones.add(dados.getDadosUtilizados());

        frame.getContentPane().add(opciones, BorderLayout.CENTER);

        initGUI();
        frame.setIconImage(new ImageIcon(getClass().getResource("/recursos/Logo.png")).getImage());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setTitle("GEEK OUT! MASTERS");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private void initGUI() {
        btnLanzarDado = new JButton("Lanzar Dado");
        btnLanzarDado.setPreferredSize(new Dimension(80,80));

        JPanel panelBotones = new JPanel(new GridLayout(2,1,520,520));
        panelBotones.setOpaque(false);
        panelBotones.setPreferredSize(new Dimension(200, 650));
        panelBotones.add(btnLanzarDado, BorderLayout.CENTER);
        panelBotones.setOpaque(false);
        String texto = "Opciones";
        panelBotones.setBorder(titulo.gettitulo(texto));


        frame.getContentPane().add(panelBotones, BorderLayout.EAST);
        btnLanzarDado.addActionListener(listener);



    }


    public static void main(String[] arg) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI vista = new GUI();


            }
        });
    }


    public class Listener implements ActionListener {
        private ImageIcon image;

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == btnLanzarDado) {
                Dado dado = new Dado();
                ControlDado controlDado = new ControlDado(dado, dados);
                controlDado.LanzarDado();
                String texto2 = "Ronda#" + conteo;
                ControlRonda controlRonda = new ControlRonda();
                controlRonda.rondas(conteo);
                opciones.setBorder(titulo.gettitulo(texto2));
                conteo++;
                dados.mostrarBotones();

                if ( controlRonda.rondas(conteo) == true) {
                    btnLanzarDado.setEnabled(false);
                }


            }

        }

    }
   /* public class escucha implements ActionListener {
        private ImageIcon image;

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == botonAyudaMemoria){
                System.out.println("ingreso al if del escucha");
                imageLabel.setIcon(null);
                this.image= new ImageIcon(getClass().getResource("/recursos/ayudamemoria.JPG"));
                imageLabel.setIcon(image);
            }
        }


    }*/
}





