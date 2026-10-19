package practice5;
import java.util.Scanner;
import java.util.Arrays;
public class practice52 {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ЗАВДАННЯ 8 Загальна сума та середній бал ===");
        int[] grades = {95, 84, 70, 99, 65, 88, 92};
        int sum = 0;
        for (int grade : grades) sum += grade;
        double average = (double) sum / grades.length;
        System.out.println("Сума: " + sum + ", Середній бал: " + average);
        System.out.println("=== ЗАВДАННЯ 9 ===");
        int[] temps = {18, 21, 15, 24, 13, 27, 20};
        int min = temps[0], max = temps[0], minIndex = 0, maxIndex = 0;
        for (int i = 1; i < temps.length; i++) {
            if (temps[i] < min) {
                min = temps[i];
                minIndex = i;
            }
            if (temps[i] > max) {
                max = temps[i];
                maxIndex = i;
            }
        }
        String[] days = {"Понеділок", "Вівторок", "Середа", "Четвер", "П'ятниця", "Субота", "Неділя"};
        System.out.println("Мінімум: " + min + "°C, день: " + days[minIndex] + " (індекс " + minIndex + ")");
        System.out.println("Максимум: " + max + "°C, день: " + days[maxIndex] + " (індекс " + maxIndex + ")");
        System.out.println("=== ЗАВДАННЯ 10 ===");
        int[] data = {12, -5, 0, 43, -19, 0, -2, 8, 0, 15};
        int positive = 0, negative = 0, zeros = 0;
        for (int value : data) {
            if (value > 0) positive++;
            else if (value < 0) negative++;
            else zeros++;
        }
        System.out.println("Додатних: " + positive);
        System.out.println("Від'ємних: " + negative);
        System.out.println("Нулів: " + zeros);
        System.out.println("=== ЗАВДАННЯ 11 ===");
        int[] numbers = {3, 8, 12, 9, 2, 5, 4, 11, 7, 9};
        int evenCount = 0, oddSum = 0;
        for (int number : numbers) {
            if (number % 2 == 0) evenCount++;
            else oddSum += number;
        }
        System.out.println("Масив: " + Arrays.toString(numbers));
        System.out.println("Кількість парних: " + evenCount);
        System.out.println("Сума непарних: " + oddSum);
        System.out.println("=== ЗАВДАННЯ 12 ===");
        int[] students = {1042, 2031, 3055, 4018, 5099};
        System.out.print("Введіть номер залікової книжки: ");
        int target = scanner.nextInt();
        int foundIndex = -1;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == target) {
                foundIndex = i;
                break;
            }
        }
        if (foundIndex != -1) System.out.println("Знайдено: індекс " + foundIndex + ", позиція " + (foundIndex + 1));
        else System.out.println("Студента з таким номером не знайдено");
        System.out.println("=== ЗАВДАННЯ 13 ===");
        int[] rolls = {3, 6, 2, 6, 1, 4, 6, 5, 2, 6};
        System.out.print("Введіть число від 1 до 6: ");
        target = scanner.nextInt();
        if (target < 1 || target > 6) {
            System.out.println("Число має бути від 1 до 6.");
            return;
        }
        int count = 0;
        for (int roll : rolls) if (roll == target) count++;
        System.out.println("Число " + target + " випало " + count + " раз(и).");
        System.out.println("=== ЗАВДАННЯ 14 ===");
        int[] salaries = {18000, 25000, 32000, 15000, 41000, 29000};
        sum = scanner.nextInt();
        for (int salary : salaries) {
            sum += salary;
        }
        double average1 = (double) sum / salaries.length;
        System.out.println("Середня зарплата: " + average1);
        System.out.print("Зарплати вище середньої: ");
        for (int salary : salaries)
            if (salary > average1)
                System.out.print(salary + " ");
        System.out.println("=== ЗАВДАННЯ 15 ===");
          double[] prices = {42.5, 41.8, 44.1, 40.9, 43.6, 45.0};
        double min1 = prices[0], max1 = prices[0];
        for (double price : prices) {
            if (price < min) min1 = price;
            if (price > max1) max1 = price;
        }
        System.out.printf("Розмах цін: %.2f%n", max1 - min1);
        System.out.println("=== ЗАВДАННЯ 16 ===");
        

        




    }
}
