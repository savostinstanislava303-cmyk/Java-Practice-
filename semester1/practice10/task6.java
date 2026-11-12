package practice10;

public class task6 {
    abstract static class DifferentiableFunction {
        public abstract double f(double x);

        public double derivativeAt(double x) {
            double h = 1e-5;
            return (f(x + h) - f(x - h)) / (2 * h);
        }
    }
    static class QuadraticParabola extends DifferentiableFunction {
        private double a, b, c;

        public QuadraticParabola(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        @Override
        public double f(double x) {
            return a * x * x + b * x + c;
        }
    }
    static class NaturalLogFunction extends DifferentiableFunction {
        private double k;
        public NaturalLogFunction(double k) {
            this.k = k;
        }
        @Override
        public double f(double x) {
            if (x <= 0) {
                throw new IllegalArgumentException("x має бути більше 0");
            }
            return k * Math.log(x);
        }
    }
    static class ExponentialGrowth extends DifferentiableFunction {
        private double A, lambda;
        public ExponentialGrowth(double A, double lambda) {
            this.A = A;
            this.lambda = lambda;
        }
        @Override
        public double f(double x) {
            return A * Math.exp(lambda * x);
        }
    }
    public static void main(String[] args) {
        DifferentiableFunction[] functions = {
                new QuadraticParabola(2, 3, 1),
                new NaturalLogFunction(4),
                new ExponentialGrowth(2, 0.5)
        };
        double x = 2.0;
        System.out.printf("%-25s %-15s %-15s%n",
                "Function", "f(x)", "Derivative");
        System.out.println("-------------------------------------------------------");
        String[] names = {
                "QuadraticParabola",
                "NaturalLogFunction",
                "ExponentialGrowth"
        };
        for (int i = 0; i < functions.length; i++) {
            double value = functions[i].f(x);
            double derivative = functions[i].derivativeAt(x);
            System.out.printf("%-25s %-15.6f %-15.6f%n",
                    names[i], value, derivative);
        }
    }
}


