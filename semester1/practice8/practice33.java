package practice8;

import java.util.Arrays;
class Progression {
    protected double firstTerm;
    protected double step;
    public Progression(double firstTerm, double step) {
        this.firstTerm = firstTerm;
        this.step = step;
    }
    public double getTerm(int index) {
        return 0;
    }
    public double[] generateFirstN(int n) {
        double[] terms = new double[n];

        for (int i = 1; i <= n; i++) {
            terms[i - 1] = getTerm(i);
        }

        return terms;
    }
    @Override
    public String toString() {
        return "Перші 5 членів прогресії: " +
                Arrays.toString(generateFirstN(5));
    }
}
class ArithmeticProgression extends Progression {
    public ArithmeticProgression(double firstTerm, double difference) {
        super(firstTerm, difference);
    }
    @Override
    public double getTerm(int n) {
        return firstTerm + (n - 1) * step;
    }
    @Override
    public String toString() {
        return "Арифметична прогресія" +
                "\nФормула: a(n) = a1 + (n - 1) * d" +
                "\nПерший член: " + firstTerm +
                "\nРізниця: " + step +
                "\n" + super.toString();
    }
}
class GeometricProgression extends Progression {
    public GeometricProgression(double firstTerm, double ratio) {
        super(firstTerm, ratio);
    }
    @Override
    public double getTerm(int n) {
        return firstTerm * Math.pow(step, n - 1);
    }
    @Override
    public String toString() {
        return "Геометрична прогресія" +
                "\nФормула: b(n) = b1 * q^(n - 1)" +
                "\nПерший член: " + firstTerm +
                "\nЗнаменник: " + step +
                "\n" + super.toString();
    }
}
public class practice33 {
    public static void main(String[] args) {
        ArithmeticProgression arithmetic =
                new ArithmeticProgression(2, 3);
        GeometricProgression geometric =
                new GeometricProgression(2, 2);
        System.out.println("===== АРИФМЕТИЧНА ПРОГРЕСІЯ =====");
        System.out.println(arithmetic);
        System.out.println("\n===== ГЕОМЕТРИЧНА ПРОГРЕСІЯ =====");
        System.out.println(geometric);
    }

}
