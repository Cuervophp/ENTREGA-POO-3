package EJERCICIO1;

public class Notas {

    private final double[] listaNotas = new double[5];

    public void establecerNota(int indice, double nota) {
        if (indice < 0 || indice >= listaNotas.length) {
            throw new IllegalArgumentException(
                "Índice de nota inválido."
            );
        }

        if (!Double.isFinite(nota) || nota < 0 || nota > 5) {
            throw new IllegalArgumentException(
                "Cada nota debe estar entre 0.0 y 5.0."
            );
        }

        listaNotas[indice] = nota;
    }

    public double calcularPromedio() {
        double suma = 0;

        for (double nota : listaNotas) {
            suma += nota;
        }

        return suma / listaNotas.length;
    }

    public double calcularDesviacion() {
        double promedio = calcularPromedio();
        double sumaCuadrados = 0;

        for (double nota : listaNotas) {
            sumaCuadrados += Math.pow(nota - promedio, 2);
        }

        return Math.sqrt(sumaCuadrados / listaNotas.length);
    }

    public double calcularMayor() {
        double mayor = listaNotas[0];

        for (double nota : listaNotas) {
            if (nota > mayor) {
                mayor = nota;
            }
        }

        return mayor;
    }

    public double calcularMenor() {
        double menor = listaNotas[0];

        for (double nota : listaNotas) {
            if (nota < menor) {
                menor = nota;
            }
        }

        return menor;
    }
}