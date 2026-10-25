package EJERCICIO2;

public class Cilindro extends FiguraGeometrica {

    private final double radio;
    private final double altura;

    public Cilindro(double radio, double altura) {
        if (radio <= 0 || altura <= 0) {
            throw new IllegalArgumentException(
                    "Radio y altura deben ser mayores que cero.");
        }

        this.radio = radio;
        this.altura = altura;
    }

    @Override
    public void calcular() {
        volumen = Math.PI * radio * radio * altura;

        superficie = 2 * Math.PI * radio
                * (radio + altura);
    }
}