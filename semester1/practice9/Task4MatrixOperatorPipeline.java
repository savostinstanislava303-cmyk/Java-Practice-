package practice9;

import java.util.Locale;
public class Task4MatrixOperatorPipeline {
    //  Незмінна інкапсульована матриця
    public static class EncapsulatedMatrix {
        private final int rows;
        private final int cols;
        private final double[][] grid;
        public EncapsulatedMatrix(double[][] source) {
            if (source == null || source.length == 0 || source[0] == null || source[0].length == 0) {
                throw new IllegalArgumentException("Матриця не може бути null або порожньою");
            }
            rows = source.length;
            cols = source[0].length;
            grid = new double[rows][cols];
            for (int i = 0; i < rows; i++) {
                if (source[i] == null || source[i].length != cols) {
                    throw new IllegalArgumentException("Усі рядки мають бути однакової довжини");
                }
                System.arraycopy(source[i], 0, grid[i], 0, cols); // глибоке копіювання
            }
        }
        public int getRows() { return rows; }

        public int getCols() { return cols; }

        public double[][] getGridCopy() {
            double[][] copy = new double[rows][cols];
            for (int i = 0; i < rows; i++) {
                System.arraycopy(grid[i], 0, copy[i], 0, cols);
            }
            return copy;
        }
        public double getElement(int r, int c) {
            if (r < 0 || r >= rows || c < 0 || c >= cols) {
                throw new IndexOutOfBoundsException("Індекси (" + r + ", " + c + ") поза межами " + rows + "x" + cols);
            }
            return grid[r][c];
        }
        public boolean isSquare() { return rows == cols; }
        public double getTrace() {
            if (!isSquare()) {
                throw new IllegalStateException("Слід визначений лише для квадратних матриць");
            }
            double sum = 0;
            for (int i = 0; i < rows; i++) sum += grid[i][i];
            return sum;
        }
        public double getFrobeniusNorm() {
            double sum = 0;
            for (double[] row : grid) {
                for (double v : row) sum += v * v;
            }
            return Math.sqrt(sum);
        }
        public double getDeterminant() {
            if (!isSquare() || (rows != 2 && rows != 3)) {
                throw new UnsupportedOperationException("Визначник реалізовано лише для 2x2 та 3x3");
            }
            if (rows == 2) {
                return grid[0][0] * grid[1][1] - grid[0][1] * grid[1][0];
            }
            return grid[0][0] * grid[1][1] * grid[2][2] + grid[0][1] * grid[1][2] * grid[2][0]
                    + grid[0][2] * grid[1][0] * grid[2][1] - grid[0][2] * grid[1][1] * grid[2][0]
                    - grid[0][0] * grid[1][2] * grid[2][1] - grid[0][1] * grid[1][0] * grid[2][2];
        }
        public String getSummary() {
            String s = rows + "x" + cols + String.format(Locale.US, " | Норма Фробеніуса: %.2f", getFrobeniusNorm());
            if (isSquare()) {
                s += String.format(Locale.US, " | Слід: %.2f", getTrace());
                if (rows == 2 || rows == 3) {
                    s += String.format(Locale.US, " | det: %.2f", getDeterminant());
                }
            }
            return s;
        }
        public String getRowsAsText() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < rows; i++) {
                sb.append("  [");
                for (int j = 0; j < cols; j++) {
                    sb.append(j > 0 ? " " : "").append(String.format(Locale.US, "%7.2f", grid[i][j]));
                }
                sb.append(" ]");
                if (i < rows - 1) sb.append('\n');
            }
            return sb.toString();
        }
        @Override
        public String toString() {
            return "Матриця (" + getSummary() + "):\n" + getRowsAsText();
        }
    }
    // Абстрактний оператор
    public abstract static class AbstractMatrixOperator {
        private final String operatorName;
        public AbstractMatrixOperator(String operatorName) {
            this.operatorName = operatorName;
        }
        public String getOperatorName() { return operatorName; }
        public abstract boolean isApplicable(EncapsulatedMatrix input);
        public abstract EncapsulatedMatrix apply(EncapsulatedMatrix input);
        public final EncapsulatedMatrix executeSafely(EncapsulatedMatrix input) {
            if (input != null && isApplicable(input)) {
                return apply(input);
            }
            System.out.println("Попередження: оператор '" + operatorName
                    + "' не застосовний до вхідної матриці. Повернуто її без змін.");
            return input;
        }
    }
    //Оператори-нащадки
    public static class ScaleMatrixOperator extends AbstractMatrixOperator {
        private final double scaleFactor;
        public ScaleMatrixOperator(double scaleFactor) {
            super("Scale(x" + scaleFactor + ")");
            this.scaleFactor = scaleFactor;
        }
        @Override
        public boolean isApplicable(EncapsulatedMatrix input) { return input != null; }
        @Override
        public EncapsulatedMatrix apply(EncapsulatedMatrix input) {
            double[][] d = input.getGridCopy();
            for (double[] row : d) {
                for (int j = 0; j < row.length; j++) row[j] *= scaleFactor;
            }
            return new EncapsulatedMatrix(d);
        }
    }
    public static class TransposeMatrixOperator extends AbstractMatrixOperator {
        public TransposeMatrixOperator() {
            super("Transpose(A^T)");
        }
        @Override
        public boolean isApplicable(EncapsulatedMatrix input) { return input != null; }
        @Override
        public EncapsulatedMatrix apply(EncapsulatedMatrix input) {
            double[][] d = input.getGridCopy();
            double[][] t = new double[input.getCols()][input.getRows()];
            for (int i = 0; i < input.getRows(); i++) {
                for (int j = 0; j < input.getCols(); j++) t[j][i] = d[i][j];
            }
            return new EncapsulatedMatrix(t);
        }
    }
    public static class DiagonalShiftOperator extends AbstractMatrixOperator {
        private final double lambda;
        public DiagonalShiftOperator(double lambda) {
            super("DiagonalShift(" + (lambda >= 0 ? "+" : "") + lambda + "*I)");
            this.lambda = lambda;
        }
        @Override
        public boolean isApplicable(EncapsulatedMatrix input) {
            return input != null && input.isSquare();
        }
        @Override
        public EncapsulatedMatrix apply(EncapsulatedMatrix input) {
            double[][] d = input.getGridCopy();
            for (int i = 0; i < d.length; i++) d[i][i] += lambda;
            return new EncapsulatedMatrix(d);
        }
    }
    public static class MultiplyByMatrixOperator extends AbstractMatrixOperator {
        private final EncapsulatedMatrix rightMatrix; // композиція: матриця B
        public MultiplyByMatrixOperator(EncapsulatedMatrix rightMatrix) {
            super("Multiply(A×B)");
            if (rightMatrix == null) {
                throw new IllegalArgumentException("Права матриця не може бути null");
            }
            this.rightMatrix = rightMatrix;
        }
        @Override
        public boolean isApplicable(EncapsulatedMatrix input) {
            return input != null && input.getCols() == rightMatrix.getRows();
        }
        @Override
        public EncapsulatedMatrix apply(EncapsulatedMatrix input) {
            double[][] a = input.getGridCopy();
            double[][] b = rightMatrix.getGridCopy();
            double[][] c = new double[input.getRows()][rightMatrix.getCols()];
            for (int i = 0; i < c.length; i++) {
                for (int j = 0; j < c[i].length; j++) {
                    for (int k = 0; k < input.getCols(); k++) c[i][j] += a[i][k] * b[k][j];
                }
            }
            return new EncapsulatedMatrix(c);
        }
    }
    public static class MatrixPipeline {
        private final String pipelineName;
        private final AbstractMatrixOperator[] stages;
        private int stageCount;
        public MatrixPipeline(String pipelineName, int capacity) {
            this.pipelineName = pipelineName;
            this.stages = new AbstractMatrixOperator[capacity];
        }
        public void addStage(AbstractMatrixOperator op) {
            if (op == null) throw new IllegalArgumentException("Оператор не може бути null");
            if (stageCount >= stages.length) throw new IllegalStateException("Конвеєр заповнений");
            stages[stageCount++] = op;
        }
        public EncapsulatedMatrix runPipeline(EncapsulatedMatrix initial) {
            if (initial == null) {
                System.out.println("Попередження: вхідна матриця null, конвеєр не запущено.");
                return null;
            }
            System.out.println("================ КОНВЕЄР " + pipelineName + " ================");
            System.out.println("[ВХІДНА МАТРИЦЯ X0 (" + initial.getSummary() + ")]:");
            System.out.println(initial.getRowsAsText());
            EncapsulatedMatrix current = initial;
            for (int i = 0; i < stageCount; i++) {
                AbstractMatrixOperator op = stages[i];
                String status = op.isApplicable(current) ? "виконано успішно" : "пропущено (не застосовний)";
                System.out.println();
                System.out.println("---> Етап " + (i + 1) + ": Оператор '" + op.getOperatorName() + "' " + status + ":");
                current = op.executeSafely(current);
                System.out.println(current);
            }
            System.out.println("=".repeat(62));
            return current;
        }
    }
    public static void main(String[] args) {
        double[][] source = {{1, 2}, {3, 4}};
        EncapsulatedMatrix x0 = new EncapsulatedMatrix(source);
        System.out.println("--- ПЕРЕВІРКА ІНКАПСУЛЯЦІЇ ---");
        source[0][0] = 999;
        System.out.println("Після зміни вихідного масиву: x0[0][0] = " + x0.getElement(0, 0));
        double[][] copy = x0.getGridCopy();
        copy[1][1] = -777;
        System.out.println("Після зміни getGridCopy():    x0[1][1] = " + x0.getElement(1, 1));
        System.out.println();
        MatrixPipeline pipeline = new MatrixPipeline("МАТРИЧНИХ ОПЕРАТОРІВ", 4);
        pipeline.addStage(new ScaleMatrixOperator(2.0));
        pipeline.addStage(new TransposeMatrixOperator());
        pipeline.addStage(new DiagonalShiftOperator(3.0));
        pipeline.addStage(new MultiplyByMatrixOperator(new EncapsulatedMatrix(new double[][]{{1, 2}, {0, 1}})));
        pipeline.runPipeline(x0);
        System.out.println();
        System.out.println("--- ПЕРЕВІРКА executeSafely ---");
        EncapsulatedMatrix rect = new EncapsulatedMatrix(new double[][]{{1, 2, 3}, {4, 5, 6}});
        System.out.println(new DiagonalShiftOperator(1.0).executeSafely(rect));
    }
}

