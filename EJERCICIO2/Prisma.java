package EJERCICIO2;

public class Prisma extends FiguraGeometrica {

    private final double largo;
    private final double ancho;
    private final double altura;

    public Prisma(
            double largo,
            double ancho,
            double altura) {

        if (largo <= 0 || ancho <= 0 || altura <= 0) {
            throw new IllegalArgumentException(
                    "Las dimensiones deben ser mayores que cero.");
        }

        this.largo = largo;
        this.ancho = ancho;
        this.altura = altura;
    }

    @Override
    public void calcular() {
        volumen = largo * ancho * altura;

        superficie = 2 * (
                largo * ancho
                + largo * altura
                + ancho * altura);
    }
}