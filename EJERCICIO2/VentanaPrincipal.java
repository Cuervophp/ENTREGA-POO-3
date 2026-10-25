package EJERCICIO2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaPrincipal extends JFrame
        implements ActionListener {

    private final String[] figuras = {
        "Cilindro",
        "Esfera",
        "Pirámide",
        "Cubo",
        "Prisma"
    };

    public VentanaPrincipal() {
        super("Calculadora de figuras geométricas");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(430, 260);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(
                new BorderLayout(12, 12));

        panel.setBorder(
                BorderFactory.createEmptyBorder(
                        18, 22, 18, 22));

        JLabel titulo = new JLabel(
                "Volumen y superficie",
                SwingConstants.CENTER);

        titulo.setFont(
                new Font("SansSerif", Font.BOLD, 20));

        panel.add(titulo, BorderLayout.NORTH);

        JPanel botones = new JPanel(
                new GridLayout(0, 2, 10, 10));

        for (String figura : figuras) {
            JButton boton = new JButton(figura);
            boton.addActionListener(this);
            botones.add(boton);
        }

        panel.add(botones, BorderLayout.CENTER);

        JLabel pie = new JLabel(
                "Seleccione una figura para ingresar "
                + "sus dimensiones.",
                SwingConstants.CENTER);

        panel.add(pie, BorderLayout.SOUTH);

        setContentPane(panel);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        String figuraSeleccionada =
                evento.getActionCommand();

        new VentanaFigura(
                figuraSeleccionada).setVisible(true);
    }
}








