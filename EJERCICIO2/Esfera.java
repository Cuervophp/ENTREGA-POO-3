package EJERCICIO2;

public class Esfera extends FiguraGeometrica {

    private final double radio;

    public Esfera(double radio) {
        if (radio <= 0) {
            throw new IllegalArgumentException(
                    "El radio debe ser mayor que cero.");
        }

        this.radio = radio;
    }

    @Override
    public void calcular() {
        volumen = (4.0 / 3.0)
                * Math.PI * Math.pow(radio, 3);

        superficie = 4 * Math.PI * radio * radio;
    }
}
