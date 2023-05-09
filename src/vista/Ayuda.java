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
                imagen = new ImageIcon(getClass().getResource("/recursos/ayudamemoria.JPG"));
                imagenLabel.setIcon(imagen);
                setSize(760,565);
                setVisible(true);

            }

        }
    }
}
