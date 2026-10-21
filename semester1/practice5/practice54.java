package practice5;
import java.util.Scanner;
import java.util.Arrays;
public class practice54 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ЗАВДАННЯ 23 ===");
        int[][] table = {{1, 3, 2}, {5, 4, 5}, {7, 6, 9}};
        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table[row].length; col++)
                System.out.print(table[row][col] + "\t");
            System.out.println();
        }
        System.out.println("=== ЗАВДАННЯ 24 ===");
        int[][] matrix = {
                {10, 20, 30, 40},
                {50, 60, 70, 80}
        };
        System.out.println("Рядкі: " + matrix.length);
        System.out.println("Стовпчикі: " + matrix[0].length);
        System.out.println("Лівий верхній: " + matrix[0][0]);
        System.out.println("Правий верхній: " + matrix[0][matrix[0].length - 1]);
        System.out.println("Лівий нижній: " + matrix[matrix.length - 1][0]);
        System.out.println("Правий нижній: " + matrix[matrix.length - 1][matrix[matrix.length - 1].length - 1]);
        System.out.println("=== ЗАВДАННЯ 25 ===");
        int[][] grid = new int[3][4];
        int counter = 1;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) grid[row][col] = counter++;
        }
        printMatrix(grid);
        System.out.println("=== ЗАВДАННЯ 26 ===");
        int[][] randomGrid = new int[4][3];
        for (int row = 0; row < randomGrid.length; row++)
            for (int col = 0; col < randomGrid[row].length; col++)
                randomGrid[row][col] = (int) (Math.random() * 90) + 10;
        System.out.println(Arrays.deepToString(randomGrid));
        printMatrix(randomGrid);
        System.out.println("=== ЗАВДАННЯ 27 ===");
        int[][] multTable = new int[9][9];
        for (int i = 0; i < multTable.length; i++)
            for (int j = 0; j < multTable[i].length; j++)
                multTable[i][j] = (i + 1) * (j + 1);
        for (int[] row : multTable) {
            for (int value : row) {
                System.out.printf("%4d", value);
            }
            System.out.println();
        }
        System.out.println("=== ЗАВДАННЯ 28 ===");
        int[][] matrix1 = new int[5][5];
        for (int row = 0; row < matrix1.length; row++)
            for (int col = 0; col < matrix1[row].length; col++)
                matrix1[row][col] = (row == col) ? 1 : 0;
        printMatrix(matrix1);
        System.out.println("=== ЗАВДАННЯ 29 ===");
        int[][] matrix2 = new int[4][4];
        for (int row = 0; row < matrix2.length; row++) Arrays.fill(matrix2[row], 1);
        Arrays.fill(matrix2[1], 0);
        for (int row = 0; row < matrix2.length; row++) matrix2[row][2] = 7;
        printMatrix(matrix2);
        System.out.println("=== ЗАВДАННЯ 30 ===");
        int[][] matrix3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int sum = 0, count = 0;
        for (int[] row : matrix3)
            for (int value : row) {
                sum += value;
                count++;
            }
        System.out.println("Сума: " + sum);
        System.out.println("Кількість елементів: " + count);
        System.out.println("Середнє: " + (double) sum / count);
        System.out.println("=== ЗАВДАННЯ 31 ===");
        int[][] matrix4 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[] rowSums = new int[matrix4.length];
        for (int row = 0; row < matrix4.length; row++) {
            for (int col = 0; col < matrix4[row].length; col++) rowSums[row] += matrix4[row][col];
            System.out.println("Рядок " + row + ": сума = " + rowSums[row]);
        }
        System.out.println("=== ЗАВДАННЯ 32 ===");
        int[][] matrix5 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printMatrix(matrix5);
        System.out.print("Суми стовпчиків: ");
        for (int col = 0; col < matrix5[0].length; col++) {
            int sum1 = 0;
            for (int row = 0; row < matrix5.length; row++) sum1 += matrix5[row][col];
            System.out.print(sum1 + " ");
        }
        System.out.println();
        System.out.println("=== ЗАВДАННЯ 33 ===");
        int[][] matrix6 = {{-4, 12, 7, 3}, {9, -2, 25, 1}, {6, 14, -8, 11}};
        int max = matrix6[0][0], maxRow = 0, maxCol = 0;
        for (int row = 0; row < matrix6.length; row++)
            for (int col = 0; col < matrix6[row].length; col++)
                if (matrix6[row][col] > max) {
                    max = matrix6[row][col];
                    maxRow = row;
                    maxCol = col;
                }
        printMatrix(matrix6);
        System.out.println("Максимум: " + max + " у комірці [" + maxRow + ", " + maxCol + "]");
        System.out.println("=== ЗАВДАННЯ 34 ===");
        int[][] matrix7 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int mainDiagonal = 0, secondaryDiagonal = 0;
        for (int i = 0; i < matrix7.length; i++) {
            mainDiagonal += matrix7[i][i];
            secondaryDiagonal += matrix7[i][matrix7.length - 1 - i];
        }
        System.out.println("Сума головної діагоналі: " + mainDiagonal);
        System.out.println("Сума побічної діагоналі: " + secondaryDiagonal);
        if (mainDiagonal > secondaryDiagonal) System.out.println("Головна діагональ має більшу суму.");
        else if (mainDiagonal < secondaryDiagonal) System.out.println("Побічна діагональ має більшу суму.");
        else System.out.println("Суми діагоналей рівні.");
        System.out.println("=== ЗАВДАННЯ 35 ===");
        int[][] matrix8 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] transposed = new int[matrix8.length][matrix8.length];
        for (int i = 0; i < matrix8.length; i++)
            for (int j = 0; j < matrix8[i].length; j++) transposed[j][i] = matrix8[i][j];
        System.out.println("Початкова матриця:");
        printMatrix(matrix8);
        System.out.println("Транспонована матриця:");
        printMatrix(transposed);
        System.out.println("=== ЗАВДАННЯ 36 ===");
        int[][] ladder = new int[4][];
        for (int row = 0; row < ladder.length; row++) {
            ladder[row] = new int[row + 1];
            Arrays.fill(ladder[row], row);
            System.out.println(Arrays.toString(ladder[row]));
        }
        System.out.println("=== ЗАВДАННЯ 37 ===");
        String[][] weekSchedule = {
                {"Вища математика", "Основи програмування", "Фізика"},
                {"Англійська мова", "Історія України"},
                {"Основи програмування", "Основи програмування", "Бази даних", "Фізвиховання"},
                {"Дискретна математика"},
                {"Філософія", "Основи алгоритмізації", "Практикум"}
        };
        String[] days = {"Понеділок", "Вівторок", "Середа", "Четвер", "П'ятниця"};
        for (int i = 0; i < weekSchedule.length; i++) {
            System.out.println(days[i] + " (" + weekSchedule[i].length + " пари):");
            for (int j = 0; j < weekSchedule[i].length; j++)
                System.out.println("  " + (j + 1) + ". " + weekSchedule[i][j]);
        }
        System.out.println("=== ЗАВДАННЯ 38 ===");
        int[][] pascal = new int[5][];
        for (int i = 0; i < pascal.length; i++) {
            pascal[i] = new int[i + 1];
            pascal[i][0] = 1;
            pascal[i][i] = 1;
            for (int j = 1; j < i; j++)
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            System.out.println(Arrays.toString(pascal[i]));
        }
        System.out.println("=== ЗАВДАННЯ 39 ===");
        int[][][] cube = new int[3][3][3];
        for (int x = 0; x < cube.length; x++)
            for (int y = 0; y < cube[x].length; y++)
                for (int z = 0; z < cube[x][y].length; z++)
                    cube[x][y][z] = x + y + z;
        for (int x = 0; x < cube.length; x++) {
            System.out.println("--- Шар X = " + x + " ---");
            for (int y = 0; y < cube[x].length; y++) {
                for (int z = 0; z < cube[x][y].length; z++) System.out.print(cube[x][y][z] + "\t");
                System.out.println();
            }
        }
        System.out.println("=== ЗАВДАННЯ 40 ===");
        String[] cities = {"Київ", "Львів", "Одеса"};
        String[] days1 = {"Пн", "Вт", "Ср", "Чт", "Пт", "Сб", "Нд"};
        double[][][] weather = {
                {{15, 8}, {16, 9}, {17, 10}, {14, 7}, {18, 11}, {19, 12}, {17, 9}},
                {{13, 6}, {14, 7}, {15, 8}, {12, 5}, {16, 9}, {17, 10}, {15, 7}},
                {{19, 12}, {20, 13}, {21, 14}, {18, 11}, {22, 15}, {23, 16}, {21, 13}}
        };
        double coldestNight = weather[0][0][1];
        int coldCity = 0, coldDay = 0;
        for (int city = 0; city < weather.length; city++) {
            double daySum = 0;
            for (int day = 0; day < weather[city].length; day++) {
                daySum += weather[city][day][0];
                if (weather[city][day][1] < coldestNight) {
                    coldestNight = weather[city][day][1];
                    coldCity = city;
                    coldDay = day;
                }
            }
            System.out.printf("Середня денна температура, %s: %.2f°C%n", cities[city], daySum / weather[city].length);
        }
        System.out.printf("Найхолодніша ніч: %.1f°C, місто %s, день %s%n",
                coldestNight, cities[coldCity], days1[coldDay]);
    }




          public static void printMatrix ( int[][] grid){
              for (int row = 0; row < grid.length; row++) {
                  for (int col = 0; col < grid[row].length; col++) {
                      System.out.print(grid[row][col] + "\t");
                  }
                  System.out.println();
              }
          }
      }

