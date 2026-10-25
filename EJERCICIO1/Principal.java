package EJERCICIO1;

import javax.swing.SwingUtilities;

public class Principal {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new VentanaPrincipal().setVisible(true));
    }
}