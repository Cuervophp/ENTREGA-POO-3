package EJERCICIO1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaPrincipal extends JFrame
        implements ActionListener {

    private final JTextField[] campos = new JTextField[5];

    private final JLabel promedio =
            new JLabel("Promedio = —");

    private final JLabel desviacion =
            new JLabel("Desviación estándar = —");

    private final JLabel mayor =
            new JLabel("Valor mayor = —");

    private final JLabel menor =
            new JLabel("Valor menor = —");

    private final JButton calcular =
            new JButton("Calcular");

    private final JButton limpiar =
            new JButton("Limpiar");

    public VentanaPrincipal() {
        super("Notas del estudiante");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520, 390);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel principal = new JPanel(
                new BorderLayout(12, 12));

        principal.setBorder(
                BorderFactory.createEmptyBorder(
                        18, 22, 18, 22));

        JLabel titulo = new JLabel(
                "Análisis de cinco notas",
                SwingConstants.CENTER);

        titulo.setFont(
                new Font("SansSerif", Font.BOLD, 20));

        principal.add(titulo, BorderLayout.NORTH);

        JPanel entradas = new JPanel(
                new GridLayout(5, 2, 10, 8));

        for (int i = 0; i < 5; i++) {
            entradas.add(new JLabel(
                    "Nota " + (i + 1) + " (0.0 a 5.0):"));

            campos[i] = new JTextField();
            entradas.add(campos[i]);
        }

        JPanel resultados = new JPanel(
                new GridLayout(4, 1, 4, 4));

        resultados.setBorder(
                BorderFactory.createTitledBorder(
                        "Resultados"));

        resultados.add(promedio);
        resultados.add(desviacion);
        resultados.add(mayor);
        resultados.add(menor);

        JPanel centro = new JPanel(
                new BorderLayout(10, 10));

        centro.add(entradas, BorderLayout.NORTH);
        centro.add(resultados, BorderLayout.CENTER);

        principal.add(centro, BorderLayout.CENTER);

        calcular.addActionListener(this);
        limpiar.addActionListener(this);

        JPanel botones = new JPanel(
                new FlowLayout(FlowLayout.CENTER, 12, 0));

        botones.add(calcular);
        botones.add(limpiar);

        principal.add(botones, BorderLayout.SOUTH);

        setContentPane(principal);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == limpiar) {
            for (JTextField campo : campos) {
                campo.setText("");
            }

            promedio.setText("Promedio = —");
            desviacion.setText("Desviación estándar = —");
            mayor.setText("Valor mayor = —");
            menor.setText("Valor menor = —");

            return;
        }

        try {
            Notas notas = new Notas();

            for (int i = 0; i < campos.length; i++) {
                String texto = campos[i].getText()
                        .trim()
                        .replace(',', '.');

                // Propuesta: exigir las cinco notas.
                if (texto.isEmpty()) {
                    throw new IllegalArgumentException(
                            "Debe ingresar las cinco notas.");
                }

                // Propuesta: validar que sean números.
                double valor = Double.parseDouble(texto);

                notas.establecerNota(i, valor);
            }

            promedio.setText(String.format(
                    "Promedio = %.2f",
                    notas.calcularPromedio()));

            desviacion.setText(String.format(
                    "Desviación estándar = %.2f",
                    notas.calcularDesviacion()));

            mayor.setText(String.format(
                    "Valor mayor = %.2f",
                    notas.calcularMayor()));

            menor.setText(String.format(
                    "Valor menor = %.2f",
                    notas.calcularMenor()));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Ingrese valores numéricos válidos.",
                    "Error de formato",
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