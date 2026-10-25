package EJERCICIO2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaFigura extends JFrame
        implements ActionListener {

    private final String tipo;
    private final JTextField[] campos;
    private final JLabel resultado =
            new JLabel("Los resultados aparecerán aquí.");

    private final JButton calcular =
            new JButton("Calcular");

    private final String[] nombres;

    public VentanaFigura(String tipo) {
        super("Figura: " + tipo);

        this.tipo = tipo;

        switch (tipo) {
            case "Cilindro":
                nombres = new String[]{"Radio", "Altura"};
                break;

            case "Esfera":
                nombres = new String[]{"Radio"};
                break;

            case "Pirámide":
                nombres = new String[]{
                    "Lado de la base cuadrada",
                    "Altura",
                    "Apotema"
                };
                break;

            case "Cubo":
                nombres = new String[]{"Lado"};
                break;

            default:
                nombres = new String[]{
                    "Largo", "Ancho", "Altura"
                };
                break;
        }

        campos = new JTextField[nombres.length];

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(410, 280);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(
                new BorderLayout(10, 10));

        panel.setBorder(
                BorderFactory.createEmptyBorder(
                        16, 16, 16, 16));

        JLabel titulo = new JLabel(
                tipo + " - dimensiones",
                SwingConstants.CENTER);

        titulo.setFont(
                new Font("SansSerif", Font.BOLD, 17));

        panel.add(titulo, BorderLayout.NORTH);

        JPanel formulario = new JPanel(
                new GridLayout(nombres.length, 2, 8, 8));

        for (int i = 0; i < nombres.length; i++) {
            formulario.add(new JLabel(nombres[i] + ":"));

            campos[i] = new JTextField();
            formulario.add(campos[i]);
        }

        panel.add(formulario, BorderLayout.CENTER);

        calcular.addActionListener(this);

        JPanel inferior = new JPanel(
                new GridLayout(2, 1, 6, 6));

        inferior.add(calcular);
        inferior.add(resultado);

        panel.add(inferior, BorderLayout.SOUTH);

        setContentPane(panel);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        try {
            double[] valores = new double[campos.length];

            for (int i = 0; i < campos.length; i++) {
                String texto = campos[i].getText()
                        .trim()
                        .replace(',', '.');

                if (texto.isEmpty()) {
                    throw new IllegalArgumentException(
                            "Complete todas las dimensiones.");
                }

                valores[i] = Double.parseDouble(texto);

                if (!Double.isFinite(valores[i])
                        || valores[i] <= 0) {
                    throw new IllegalArgumentException(
                            "Todas las dimensiones deben ser "
                            + "mayores que cero.");
                }
            }

            FiguraGeometrica figura;

            switch (tipo) {
                case "Cilindro":
                    figura = new Cilindro(
                            valores[0], valores[1]);
                    break;

                case "Esfera":
                    figura = new Esfera(valores[0]);
                    break;

                case "Pirámide":
                    figura = new Piramide(
                            valores[0],
                            valores[1],
                            valores[2]);
                    break;

                case "Cubo":
                    figura = new Cubo(valores[0]);
                    break;

                default:
                    figura = new Prisma(
                            valores[0],
                            valores[1],
                            valores[2]);
                    break;
            }

            figura.calcular();

            resultado.setText(String.format(
                    "<html>Volumen: %.2f u³<br>"
                    + "Superficie: %.2f u²</html>",
                    figura.getVolumen(),
                    figura.getSuperficie()));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Ingrese números válidos.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Dato inválido",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}