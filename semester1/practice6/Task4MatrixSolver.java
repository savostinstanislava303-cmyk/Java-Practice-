package practice6;

    public class Task4MatrixSolver {
      static class MatrixSolver {
        private double[][] data;

        public void setMatrix(double[][] data) {
            this.data = data;
        }
        public void printMatrix() {
            for (int i = 0; i < data.length; i++) {
                System.out.print("[ ");
                for (int j = 0; j < data[i].length; j++) {
                    System.out.printf("%7.2f", data[i][j]);
                }
                System.out.println(" ]");
            }
        }
        public double getDeterminant2x2() {
            return data[0][0] * data[1][1]
                    - data[0][1] * data[1][0];
        }
        public double getDeterminant3x3() {
            return data[0][0] * data[1][1] * data[2][2]
                    + data[0][1] * data[1][2] * data[2][0]
                    + data[0][2] * data[1][0] * data[2][1]
                    - data[0][2] * data[1][1] * data[2][0]
                    - data[0][0] * data[1][2] * data[2][1]
                    - data[0][1] * data[1][0] * data[2][2];
        }
        public void transpose() {
            int rows = data.length;
            int columns = data[0].length;
            double[][] transposed = new double[columns][rows];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    transposed[j][i] = data[i][j];
                }
            }

            data = transposed;
        }
        public void solveSystem2x2(double c1, double c2) {
            double delta = getDeterminant2x2();
            double deltaX = c1 * data[1][1]
                    - c2 * data[0][1];
            double deltaY = data[0][0] * c2
                    - data[1][0] * c1;
            System.out.printf("Головний визначник Delta = %.2f%n", delta);
            System.out.printf("Визначник Delta_x = %.2f%n", deltaX);
            System.out.printf("Визначник Delta_y = %.2f%n", deltaY);
            if (Math.abs(delta) > 1e-9) {
                double x = deltaX / delta;
                double y = deltaY / delta;
                System.out.println("\nЗнайдено єдиний розв'язок:");
                System.out.printf("x = %.2f%n", x);
                System.out.printf("y = %.2f%n", y);
            } else if (Math.abs(deltaX) <= 1e-9
                    && Math.abs(deltaY) <= 1e-9) {
                System.out.println("Система має безліч розв'язків");
            } else {
                System.out.println(
                        "Система несумісна (не має розв'язків)"
                );
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(
                "================ МАТРИЧНИЙ КАЛЬКУЛЯТОР ТА СЛАР ================"
        );
        MatrixSolver solver = new MatrixSolver();
        // Матриця 2x2
        double[][] matrix2x2 = {
                {2, 3},
                {4, -1}
        };
        solver.setMatrix(matrix2x2);
        System.out.println("\nПочаткова матриця 2x2 коефіцієнтів A:");
        solver.printMatrix();

        System.out.printf(
                "\nВизначник det(A) = %.2f%n",
                solver.getDeterminant2x2()
        );
        // Транспонування матриці
        solver.transpose();
        System.out.println("\nТранспонована матриця A^T:");
        solver.printMatrix();
        // Розв'язання системи рівнянь
        System.out.println(
                "\n--- РОЗВ'ЯЗАННЯ СИСТЕМИ ЛІНІЙНИХ РІВНЯНЬ  (МЕТОД КРАМЕРА) ---"
        );
        System.out.println("Рівняння:");
        System.out.println("2.00*x + 3.00*y = 8.00");
        System.out.println(" 4.00*x - 1.00*y = 2.00");
        // Повертаємо початкову матрицю коефіцієнтів
        solver.setMatrix(matrix2x2);
        solver.solveSystem2x2(8, 2);
        // Перевірка результату
        System.out.println("\nПеревірка:");
        System.out.println("2 * 1 + 3 * 2 = 8 (ВІРНО!)");
        System.out.println("4 * 1 - 2 = 2 (ВІРНО!)");
        // Матриця 3x3
        double[][] matrix3x3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        solver.setMatrix(matrix3x3);

        System.out.println("\nМатриця 3x3:");
        solver.printMatrix();
        System.out.printf(
                "Визначник det(A) = %.2f%n",
                solver.getDeterminant3x3()
        );
        System.out.println(
                "\n==============================================================="
        );
    }

}
