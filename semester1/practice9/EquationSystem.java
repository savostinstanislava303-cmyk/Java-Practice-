package practice9;

public class EquationSystem {
    private final LinearEquation[] equations;
    private int count;
    public EquationSystem(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Місткість має бути додатною");
        }
        this.equations = new LinearEquation[capacity];
        this.count = 0;
    }
    public int getCount() {
        return count;
    }
    public boolean addEquation(LinearEquation equation) {
        if (equation == null || count >= equations.length) {
            return false;
        }
        equations[count++] = equation;
        return true;
    }
    public boolean checkSolution(double x, double y) {
        if (count == 0) {
            return false;
        }
        for (int i = 0; i < count; i++) {
            if (!equations[i].isSatisfiedBy(x, y)) {
                return false;
            }
        }
        return true;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Система рівнянь:\n");
        if (count == 0) {
            sb.append("(порожньо)");
            return sb.toString();
        }
        for (int i = 0; i < count; i++) {
            sb.append(i + 1).append(") ").append(equations[i]);
            if (i < count - 1) {
                sb.append('\n');
            }
        }
        return sb.toString();
    }
}

