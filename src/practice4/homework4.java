package practice4;
import java.util.Scanner;
public class homework4 {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ЗАВДАННЯ 2 ===");
        int number;
        do {
            System.out.print("Введіть додатне ціле число: ");
            number = scanner.nextInt();
            if (number <= 0) {
                System.out.println("Помилка: число має бути більшим за 0.");
            }
        } while (number <= 0);
        int originalNumber = number;
        int temp = number;
        int digitCount = 0;
        int digitSum = 0;
        int maxDigit = 0;
        int reversedNumber = 0;
        while (temp > 0) {
            int digit = temp % 10;
            digitCount++;
            digitSum += digit;

            if (digit > maxDigit) {
                maxDigit = digit;
            }
            reversedNumber = reversedNumber * 10 + digit;
            temp /= 10;
        }
        System.out.println("=== АНАЛІЗАТОР РОЗРЯДІВ ЧИСЛА ===");
        System.out.println("Початкове число:     " + originalNumber);
        System.out.println("Кількість цифр:      " + digitCount);
        System.out.println("Сума цифр:           " + digitSum);
        System.out.println("Найбільша цифра:     " + maxDigit);
        System.out.println("Перевернуте число:   " + reversedNumber);
        if (originalNumber == reversedNumber) {
            System.out.println("Результат: Це число є паліндромом! ✨");
        } else {
            System.out.println("Результат: Це звичайне число (не паліндром).");
        }
        System.out.println("================================");
        System.out.println("=== ЗАВДАННЯ 3 ===");
         int n;
        do {
            System.out.print("Скільки чисел Фібоначчі згенерувати (3-30): ");
            n = scanner.nextInt();
            if (n < 3 || n > 30) {
                System.out.println("Введіть N у межах від 3 до 30.");
            }
        } while (n < 3 || n > 30);
        int f1 = 1;
        int f2 = 1;
        double lastRatio = 0.0;
        System.out.println("=== ЧИСЛА ФІБОНАЧЧІ ТА ЗОЛОТИЙ ПЕРЕТИН ===");
        System.out.println("№ 1  | Число: 1");
        System.out.println("№ 2  | Число: 1");
        for (int i = 3; i <= n; i++) {
            int next = f1 + f2;
            double ratio = (double) next / f2;
            lastRatio = ratio;
            System.out.printf("№ %-2d | Число: %-10d | Відношення F(n)/F(n-1) = %.6f%n",
                    i, next, ratio);
            f1 = f2;
            f2 = next;
        }
        System.out.printf("%nПідсумок: знайдено наближення Золотого перетину: %.6f%n", lastRatio);
        System.out.printf("Еталонне значення:                             %.6f%n", 1.6180339);
        System.out.println("=========================================");
        scanner.close();


    }
}
