package practice10;

class VectorMathOverload {
    public double norm(double x) {
        return Math.abs(x);
    }
    public double norm(double x, double y) {
        return Math.sqrt(x * x + y * y);
    }
    public double norm(double[] v) {
        double sum = 0;
        for (double value : v) {
            sum += value * value;
        }
        return Math.sqrt(sum);
    }
}
abstract class BinaryOperation {
    public abstract double apply(double a, double b);
}
class AddOp extends BinaryOperation {
    @Override
    public double apply(double a, double b) {
        return a + b;
    }
}
class MultiplyOp extends BinaryOperation {
    @Override
    public double apply(double a, double b) {
        return a * b;
    }
}
class HypotenuseOp extends BinaryOperation {
    @Override
    public double apply(double a, double b) {
        return Math.sqrt(a * a + b * b);
    }
}
public class task3 {
    public static void main(String[] args) {
        VectorMathOverload math = new VectorMathOverload();
        System.out.println("СТАТИЧНИЙ ПОЛІМОРФІЗМ");
        System.out.println("Норма числа 5: "
                + math.norm(5.0));
        System.out.println("Норма точки (3, 4): "
                + math.norm(3.0, 4.0));
        double[] vector = {3.0, 4.0, 5.0};
        System.out.println("Норма масиву: "
                + math.norm(vector));
        System.out.println("\nДИНАМІЧНИЙ ПОЛІМОРФІЗМ");
        BinaryOperation[] operations = {
                new AddOp(),
                new MultiplyOp(),
                new HypotenuseOp()
        };
        for (BinaryOperation op : operations) {
            System.out.println(
                    op.getClass().getSimpleName()
                            + ": "
                            + op.apply(3.0, 4.0)
            );
        }
    }
}
