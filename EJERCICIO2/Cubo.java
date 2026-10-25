package EJERCICIO2;

public class Cubo extends FiguraGeometrica {

    private final double lado;

    public Cubo(double lado) {
        if (lado <= 0) {
            throw new IllegalArgumentException(
                    "El lado debe ser mayor que cero.");
        }

        this.lado = lado;
    }

    @Override
    public void calcular() {
        volumen = Math.pow(lado, 3);
        superficie = 6 * lado * lado;
    }
}
