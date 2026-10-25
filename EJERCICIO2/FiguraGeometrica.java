package EJERCICIO2;

public abstract class FiguraGeometrica {

    protected double volumen;
    protected double superficie;

    public double getVolumen() {
        return volumen;
    }

    public double getSuperficie() {
        return superficie;
    }

    public abstract void calcular();
}