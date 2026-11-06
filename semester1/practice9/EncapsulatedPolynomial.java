package practice9;


import java.util.Arrays;
public class EncapsulatedPolynomial {
    private final double[] coeffs;
    public EncapsulatedPolynomial(double[] coeffs) {
        this.coeffs = Arrays.copyOf(coeffs, coeffs.length);
    }
    public int getDegree() {
        return coeffs.length - 1;
    }
    public double getCoefficient(int power) {
        if (power < 0 || power >= coeffs.length) {
            throw new IndexOutOfBoundsException("Некоректний степінь!");
        }
        return coeffs[power];
    }
    public double evaluate(double x) {
        double result = 0;
        for (int i = coeffs.length - 1; i >= 0; i--) {
            result = result * x + coeffs[i];
        }
        return result;
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = coeffs.length - 1; i >= 0; i--) {
            double coefficient = coeffs[i];
            if (coefficient == 0) {
                continue;
            }
            if (result.length() > 0 && coefficient > 0) {
                result.append(" + ");
            } else if (coefficient < 0) {
                result.append(" - ");
            }
            double absCoefficient = Math.abs(coefficient);
            if (i == 0 || absCoefficient != 1) {
                result.append(absCoefficient);
            }
            if (i == 1) {
                result.append("x");
            } else if (i > 1) {
                result.append("x^").append(i);
            }
        }
        if (result.length() == 0) {
            return "0";
        }
        return result.toString();
    }
    public static void main(String[] args) {
        double[] coefficients = {2, 3, 4};
        EncapsulatedPolynomial polynomial =
                new EncapsulatedPolynomial(coefficients);
        System.out.println("Многочлен: " + polynomial);
        System.out.println("Степінь: " + polynomial.getDegree());
        System.out.println("Коефіцієнт при x: " +
                polynomial.getCoefficient(1));
        System.out.println("Значення при x = 2: " +
                polynomial.evaluate(2));
    }
}


