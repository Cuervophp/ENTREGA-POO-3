package EJERCICIO2;

public class Piramide extends FiguraGeometrica {

    private final double ladoBase;
    private final double altura;
    private final double apotema;

    public Piramide(
            double ladoBase,
            double altura,
            double apotema) {

        if (ladoBase <= 0 || altura <= 0 || apotema <= 0) {
            throw new IllegalArgumentException(
                    "Las dimensiones deben ser mayores que cero.");
        }

        this.ladoBase = ladoBase;
        this.altura = altura;
        this.apotema = apotema;
    }

    @Override
    public void calcular() {
        volumen = (ladoBase * ladoBase * altura) / 3.0;

        superficie = ladoBase * ladoBase
                + 2 * ladoBase * apotema;
    }
}
