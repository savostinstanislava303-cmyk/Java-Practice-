package practice8;

    class LinearFunction {
    protected double k;
    protected double b;
    public LinearFunction(double k, double b) {
        this.k = k;
        this.b = b;
    }
    public double evaluate(double x) {
        return k * x + b;
    }
    @Override
    public String toString() {
        return "f(x) = " + k + "x + " + b;
    }
}
class QuadraticFunction extends LinearFunction {
    private double a;
    public QuadraticFunction(double a, double k, double b) {
        super(k, b);
        this.a = a;
    }
    @Override
    public double evaluate(double x) {
        return a * x * x + super.evaluate(x);
    }
    public double findVertex() {
        if (a == 0) {
            return Double.NaN;
        }
        return -k / (2 * a);
    }
    @Override
    public String toString() {
        return "f(x) = " + a + "x^2 + " + k + "x + " + b;
    }
}
public class practice35 {
    public static void main(String[] args) {
        LinearFunction linear = new LinearFunction(3, 2);
        QuadraticFunction quadratic =
                new QuadraticFunction(2, 3, 2);
        System.out.println("Лінійна функція:");
        System.out.println(linear);
        System.out.println("Значення при x = 2: " +
                linear.evaluate(2));
        System.out.println();
        System.out.println("Квадратична функція:");
        System.out.println(quadratic);
        System.out.println("Значення при x = 2: " +
                quadratic.evaluate(2));
        System.out.println("Координата вершини параболи x0 = " +
                quadratic.findVertex());
    }
}
