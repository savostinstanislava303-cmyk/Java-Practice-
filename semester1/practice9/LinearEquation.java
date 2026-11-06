package practice9;

public class LinearEquation {
    private static final double EPSILON = 1e-6;
    private final double a;
    private final double b;
    private final double c;
    public LinearEquation(double a, double b, double c) {
        if (a == 0 && b == 0) {
            throw new IllegalArgumentException("Коефіцієнти a і b не можуть бути одночасно нульовими");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getA() {
        return a;
    }
    public double getB() {
        return b;
    }
    public double getC() {
        return c;
    }
    public boolean isSatisfiedBy(double x, double y) {
        return Math.abs(a * x + b * y - c) < EPSILON;
    }
    @Override
    public String toString() {
        return a + "x + " + b + "y = " + c;
    }
}

