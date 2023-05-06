package vista;


import controlador.ControlRonda;
import modelo.Dado;
import controlador.ControlDado;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class GUI extends JFrame {
    private ImagenDado dados;
    private JFrame frame;
    private JPanel fondo, opciones;
    private Title titulo;
    private Listener listener;
    private JButton btnLanzarDado;
    private int conteo = 1;



    public GUI() {

        listener = new Listener();
        titulo = new Title();
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
        JPanel panelBotones = new JPanel();
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

                if (controlRonda.rondas(conteo) == true) {
                    btnLanzarDado.setEnabled(false);
                }


            }


        }

    }


}


