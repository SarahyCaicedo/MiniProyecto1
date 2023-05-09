package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ayuda extends JFrame {
    public static JButton botonAyuda;
    private JPanel contenedorBoton, contenedorImagen;
    private JLabel imagenLabel;
    private Listener listener;

    public Ayuda(){

        super("AYUDA");
        botonAyuda= new JButton("Help");
        listener=new Listener();
        botonAyuda.addActionListener(listener);
        imagenLabel=new JLabel();


        contenedorBoton= new JPanel();
        contenedorImagen=new JPanel();
        contenedorBoton.add(botonAyuda);
        contenedorImagen.add(imagenLabel);


        this.add(contenedorBoton, BorderLayout.SOUTH);
        this.add(contenedorImagen,BorderLayout.CENTER);

        add(contenedorBoton, BorderLayout.SOUTH);
        getContentPane().add(contenedorImagen, BorderLayout.CENTER);
        int x = 400;
        int y = 150;
        setLocation(x,y);
        setIconImage(new ImageIcon(getClass().getResource("/recursos/Logo.png")).getImage());
        pack();

    }


    public class Listener implements ActionListener{

        private ImageIcon imagen;
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()== botonAyuda){

                System.out.println("Evento capturado");
                imagenLabel.setIcon(null);
                ImageIcon imagen = new ImageIcon(getClass().getResource("/recursos/ayuda.png"));
                Image imageEscala = imagen.getImage().getScaledInstance(480, 420, Image.SCALE_SMOOTH);
                ImageIcon imagenFinal = new ImageIcon(imageEscala);
                imagenLabel.setIcon(imagenFinal);
                setSize(500,470);
                setVisible(true);

            }

        }
    }
}
