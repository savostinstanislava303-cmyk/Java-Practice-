package practice8;

class Matrix2D {
    protected double[][] data;
    private int rows;
    private int cols;
    public Matrix2D(double[][] source) {
        if (source == null || source.length == 0 ||
                source[0] == null || source[0].length == 0) {
            throw new IllegalArgumentException("Матриця не може бути порожньою!");
        }
        rows = source.length;
        cols = source[0].length;
        data = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            if (source[i] == null || source[i].length != cols) {
                throw new IllegalArgumentException("Матриця повинна бути прямокутною!");
            }
            for (int j = 0; j < cols; j++) {
                data[i][j] = source[i][j];
            }
        }
    }
    // Кількість рядків
    public int getRows() {
        return rows;
    }
    // Кількість стовпців
    public int getCols() {
        return cols;
    }
    public double getElement(int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            throw new IndexOutOfBoundsException("Неправильний індекс!");
        }
        return data[r][c];
    }
    public void setElement(int r, int c, double val) {
        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            throw new IndexOutOfBoundsException("Неправильний індекс!");
        }

        data[r][c] = val;
    }
    public double getSum() {
        double sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += data[i][j];
            }
        }
        return sum;
    }
    public double getMaxElement() {
        double max = data[0][0];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (data[i][j] > max) {
                    max = data[i][j];
                }
            }
        }
        return max;
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            result.append("[ ");

            for (int j = 0; j < cols; j++) {
                result.append(String.format(
                        java.util.Locale.US, "%8.2f ", data[i][j]
                ));
            }
            result.append("]\n");
        }
        return result.toString();
    }
}
class SquareMatrix extends Matrix2D {
    public SquareMatrix(double[][] source) {
        super(source);
        if (getRows() != getCols()) {
            System.out.println("Попередження: матриця не є квадратною!");
        }
    }
    public int getDimension() {
        return getRows();
    }
    public double getTrace() {
        double trace = 0;
        for (int i = 0; i < getDimension(); i++) {
            trace += data[i][i];
        }
        return trace;
    }
    public boolean isSymmetric() {
        if (getRows() != getCols()) {
            return false;
        }
        for (int i = 0; i < getDimension(); i++) {
            for (int j = i + 1; j < getDimension(); j++) {
                if (Math.abs(data[i][j] - data[j][i]) > 1e-9) {
                    return false;
                }
            }
        }
        return true;
    }
    public double getDeterminant() {
        int n = getDimension();
        if (getRows() != getCols()) {
            return 0.0;
        }
        if (n == 2) {
            return data[0][0] * data[1][1]
                    - data[0][1] * data[1][0];
        }
        // Визначник матриці 3x3 за правилом Саррюса
        if (n == 3) {
            return data[0][0] * data[1][1] * data[2][2]
                    + data[0][1] * data[1][2] * data[2][0]
                    + data[0][2] * data[1][0] * data[2][1]
                    - data[0][2] * data[1][1] * data[2][0]
                    - data[0][1] * data[1][0] * data[2][2]
                    - data[0][0] * data[1][2] * data[2][1];
        }

        return 0.0;
    }
    @Override
    public String toString() {
        return super.toString()
                + "Характеристики SquareMatrix:\n"
                + String.format(
                        java.util.Locale.US,
                        "Розмір = %dx%d | Слід (Trace) = %.2f"
                                + " | Симетрична = %b | det(A) = %.2f\n",
                        getRows(), getCols(),
                        getTrace(), isSymmetric(), getDeterminant()
                );
    }
}
class CramerMatrixSolver extends SquareMatrix {
    private double[] freeTerms;
    public CramerMatrixSolver(double[][] coefficients, double[] freeTerms) {
        super(coefficients);
        if (freeTerms == null || freeTerms.length != getRows()) {
            throw new IllegalArgumentException(
                    "Кількість вільних членів повинна відповідати кількості рядків!"
            );
        }
        this.freeTerms = new double[freeTerms.length];
        for (int i = 0; i < freeTerms.length; i++) {
            this.freeTerms[i] = freeTerms[i];
        }
    }
    // Розв'язання системи методом Крамера
    public double[] solve() {
        int n = getDimension();
        if (n != 2 && n != 3) {
            System.out.println(
                    "Метод Крамера підтримує матриці 2x2 та 3x3!"
            );
            return new double[0];
        }
        double mainDeterminant = getDeterminant();
        if (Math.abs(mainDeterminant) < 1e-9) {
            System.out.println(
                    "Єдиного розв'язку системи не існує!"
            );
            return new double[0];
        }
        double[] roots = new double[n];
        for (int col = 0; col < n; col++) {
            double[][] replaced = new double[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j == col) {
                        replaced[i][j] = freeTerms[i];
                    } else {
                        replaced[i][j] = data[i][j];
                    }
                }
            }
            SquareMatrix temp = new SquareMatrix(replaced);
            roots[col] = temp.getDeterminant() / mainDeterminant;
        }
        return roots;
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Розширена матриця системи [A | B]:\n");
        for (int i = 0; i < getRows(); i++) {
            result.append("[ ");
            for (int j = 0; j < getCols(); j++) {
                result.append(String.format(
                        java.util.Locale.US, "%8.2f ", data[i][j]
                ));
            }
            result.append("| ");
            result.append(String.format(
                    java.util.Locale.US, "%8.2f ", freeTerms[i]
            ));
            result.append("]\n");
        }
        result.append(String.format(
                java.util.Locale.US,
                "Головний визначник det(A) = %.2f\n",
                getDeterminant()
        ));
        double[] roots = solve();
        if (roots.length == 0) {
            result.append("Розв'язок: єдиного розв'язку немає.\n");
        } else {
            result.append("Розв'язок системи: ");
            for (int i = 0; i < roots.length; i++) {
                result.append(String.format(
                        java.util.Locale.US,
                        "x%d = %.2f", i + 1, roots[i]
                ));
                if (i < roots.length - 1) {
                    result.append(", ");
                }
            }
            result.append("\n");
        }
        return result.toString();
    }
}
      // ГОЛОВНИЙ КЛАС
public class homework8 {
    public static void main(String[] args) {
        System.out.println(
                "================ ІЄРАРХІЯ МАТРИЦЬ ТА СЛАР ================"
        );
        System.out.println("\n--- 1. Базова матриця Matrix2D ---");
        double[][] basicData = {
                {1, 2, 3},
                {4, 5, 6}
        };
        Matrix2D matrix = new Matrix2D(basicData);
        System.out.println(matrix);
        System.out.printf(
                java.util.Locale.US,
                "Сума елементів = %.2f | Максимальний елемент = %.2f\n",
                matrix.getSum(), matrix.getMaxElement()
        );

        System.out.println("\n--- 2. Квадратна матриця 3x3 (SquareMatrix) ---");
        double[][] squareData = {
                {2, 1, 0},
                {1, 3, 1},
                {0, 1, 2}
        };
        SquareMatrix squareMatrix = new SquareMatrix(squareData);
        System.out.println(squareMatrix);
        System.out.println(
                "\n--- 3. Розв'язувач системи Крамера (CramerMatrixSolver 2x2) ---"
        );
        double[][] coefficients = {
                {2, 3},
                {4, -1}
        };
        double[] freeTerms = {8, 2};
        CramerMatrixSolver solver =
                new CramerMatrixSolver(coefficients, freeTerms);
        System.out.println(solver);
        // Перевірка отриманих коренів
        double[] roots = solver.solve();
        if (roots.length == 2 &&
                Math.abs(roots[0] - 1.0) < 1e-9 &&
                Math.abs(roots[1] - 2.0) < 1e-9) {
            System.out.println("(Перевірка пройдена!)");
        }
        System.out.println(
                "\n=========================================================="
        );
    }
}
