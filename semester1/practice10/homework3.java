package practice10;

interface Evaluable1D {
    double EPSILON = 1e-7;
    double evaluate(double x);
}
interface Integrable1D extends Evaluable1D {
    default double integrateSimpson(double a, double b, int n) {
        if (n < 2) {
            n = 100;
        }
        if (n % 2 != 0) {
            n++;
        }
        double h = (b - a) / n;
        double sum = evaluate(a) + evaluate(b);
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            if (i % 2 != 0) {
                sum += 4 * evaluate(x);
            } else {
                sum += 2 * evaluate(x);
            }
        }
        return (h / 3) * sum;
    }
}
interface Differentiable1D extends Evaluable1D {
    double derivative(double x);
    default double numericalDerivative(double x) {
        double h = 1e-5;
        return (evaluate(x + h) - evaluate(x - h)) / (2 * h);
    }
}
interface NewtonRootFindable extends Differentiable1D {
    default double findRootNewton(double x0, int maxIter) {
        double x = x0;
        for (int i = 0; i < maxIter; i++) {
            double functionValue = evaluate(x);
            double derivativeValue = derivative(x);
            if (Math.abs(functionValue) <= EPSILON) {
                return x;
            }
            if (Math.abs(derivativeValue) < 1e-12) {
                System.out.println(
                        "  [Warning] Похідна занадто мала. Метод зупинено."
                );
                return x;
            }
            x = x - functionValue / derivativeValue;
        }
        return x;
    }
}
abstract class AbstractMathFunction implements Integrable1D {
    private final String formulaTitle;
    public AbstractMathFunction(String formulaTitle) {
        this.formulaTitle = formulaTitle;
    }
    public final String getFormulaTitle() {
        return formulaTitle;
    }
}
final class PolynomialFunction extends AbstractMathFunction
        implements NewtonRootFindable {
    private final double[] coeffs;
    public PolynomialFunction(double[] coeffs) {
        super("P(x) = -5.00 - 2.00*x + 0.00*x^2 + 1.00*x^3");
        this.coeffs = coeffs.clone();
    }
    @Override
    public double evaluate(double x) {
        double result = 0;
        for (int i = coeffs.length - 1; i >= 0; i--) {
            result = result * x + coeffs[i];
        }
        return result;
    }
    @Override
    public double derivative(double x) {
        double result = 0;
        for (int i = coeffs.length - 1; i >= 1; i--) {
            result = result * x + i * coeffs[i];
        }
        return result;
    }
}
class DampedHarmonyFunction extends AbstractMathFunction
        implements NewtonRootFindable {
    private final double amplitude;
    private final double decayRate;
    private final double omega;
    public DampedHarmonyFunction(
            double amplitude,
            double decayRate,
            double omega) {
        super("D(x) = 4.00 * exp(-0.50*x) * cos(2.00*x)");
        this.amplitude = amplitude;
        this.decayRate = decayRate;
        this.omega = omega;
    }
    @Override
    public double evaluate(double x) {
        return amplitude
                * Math.exp(-decayRate * x)
                * Math.cos(omega * x);
    }
    @Override
    public double derivative(double x) {
        return -amplitude
                * Math.exp(-decayRate * x)
                * (decayRate * Math.cos(omega * x)
                + omega * Math.sin(omega * x));
    }
}
class StepHeavisideFunction extends AbstractMathFunction {
    private final double threshold;
    private final double lowValue;
    private final double highValue;
    public StepHeavisideFunction(
            double threshold,
            double lowValue,
            double highValue) {
        super("Step(x) = {2.0 при x < 1.5; 5.0 при x >= 1.5}");
        this.threshold = threshold;
        this.lowValue = lowValue;
        this.highValue = highValue;
    }
    @Override
    public double evaluate(double x) {
        if (x < threshold) {
            return lowValue;
        }
        return highValue;
    }
}
public class homework3 {
    public static void main(String[] args) {
        AbstractMathFunction[] functions = {
                new PolynomialFunction(
                        new double[]{-5.0, -2.0, 0.0, 1.0}
                ),
                new DampedHarmonyFunction(
                        4.0, 0.5, 2.0
                ),
                new StepHeavisideFunction(
                        1.5, 2.0, 5.0
                )
        };
        System.out.println(
                "================ ЧИСЕЛЬНИЙ АНАЛІЗ: "
                        + "ІНТЕРФЕЙСИ ТА ПОЛІМОРФІЗМ ================"
        );
        System.out.printf(
                "Дослідження поліморфного масиву AbstractMathFunction[%d] "
                        + "на відрізку [0.00; 3.00]:%n",
                functions.length
        );
        for (int i = 0; i < functions.length; i++) {
            AbstractMathFunction fn = functions[i];
            System.out.printf(
                    "%n%d. Функція: %s [%s]%n",
                    i + 1,
                    fn.getFormulaTitle(),
                    fn.getClass().getSimpleName()
            );
            int steps = (i == 2) ? 1000 : 100;
            double integral = fn.integrateSimpson(
                    0.0, 3.0, steps
            );
            System.out.printf(
                    "   -> Інтеграл Сімпсона на [0.0; 3.0] "
                            + "(N=%d): %.6f",
                    steps,
                    integral
            );
            if (i == 0) {
                System.out.printf(
                        " (Точне значення: %.6f)",
                        -3.75
                );
            }
            System.out.println();
            if (fn instanceof NewtonRootFindable rf) {
                double derivativePoint;
                double initialGuess;
                if (fn instanceof PolynomialFunction) {
                    derivativePoint = 2.0;
                    initialGuess = 2.0;
                } else {
                    derivativePoint = 1.0;
                    initialGuess = 0.7;
                }
                double analytical = rf.derivative(derivativePoint);
                double numerical =
                        rf.numericalDerivative(derivativePoint);
                System.out.printf(
                        "   -> [Differentiable1D] Похідна в точці %.1f: "
                                + "аналітична = %.6f | чисельна = %.6f%n",
                        derivativePoint,
                        analytical,
                        numerical
                );
                double root = rf.findRootNewton(
                        initialGuess, 100
                );
                System.out.printf(
                        "   -> [NewtonRootFindable] Корінь f(x) = 0 "
                                + "(старт x0=%.1f): x* = %.7f "
                                + "(Перевірка f(x*) = %.2e)%n",
                        initialGuess,
                        root,
                        fn.evaluate(root)
                );
            } else {
                System.out.println(
                        "   -> [Info] Функція розривна "
                                + "(не реалізує Differentiable1D / "
                                + "NewtonRootFindable) — "
                                + "пошук дотичних пропущено."
                );
            }
        }
        System.out.println(
                "\n=========================================================================="
        );
    }
}

