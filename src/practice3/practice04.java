package practice3;
import java.util.Scanner;
public class practice04 {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ЗАВДАННЯ 25 ===");
        int x = 10;
        int divisor = 0;
        /*
         * && працює ліниво
         * Оскільки divisor != 0 має значення false,
         * права частина x / divisor  не обчислюється
         * Тому ArithmeticException не виникає
         */
        if (divisor != 0 && (x / divisor > 1)) {
            System.out.println("Успішне ділення");
        } else {
            System.out.println(
                    "Ділення безпечно пропущено завдяки short-circuit!"
            );
            System.out.println("=== ЗАВДАННЯ 26 ===");
            int counter1 = 0;
        int counter2 = 0;
        boolean b1 = false && (++counter1 > 0);
        boolean b2 = false & (++counter2 > 0);
        System.out.println("b1 = " + b1);
        System.out.println("counter1 = " + counter1);
        System.out.println("b2 = " + b2);
        System.out.println("counter2 = " + counter2);
        System.out.println(
                "&& не обчислює праву частину, якщо ліва false."
        );
        System.out.println(
                "& завжди обчислює обидві частини."
        );
        System.out.println("=== ЗАВДАННЯ 27 ===");
         int number = 5;
        /*
         * number > 0 є true
         * Тому || не обчислює праву частину
         * Ділення 10/0 не виконується
         */
        if (number > 0 || (10 / 0 == 0)) {
            System.out.println(
                    "Умова виконана, аварійне ділення не викликалося!"
            );
        }
        System.out.println("=== ЗАВДАННЯ 28 ===");
         int counterA = 0;
        int counterB = 0;
        boolean test1 = true || (++counterA > 0);
        boolean test2 = true | (++counterB > 0);
        System.out.println("test1 = " + test1);
        System.out.println("counterA = " + counterA);
        System.out.println("test2 = " + test2);
        System.out.println("counterB = " + counterB);
        System.out.println(
                "|| пропускає праву частину після true."
        );
        System.out.println(
                "| завжди обчислює обидві частини."
        );
        System.out.println("=== ЗАВДАННЯ 29 ===");
        System.out.print("Години: ");
        int hours = scanner.nextInt();
        System.out.print("Хвилини: ");
        int minutes = scanner.nextInt();
        boolean isValidTime =
                (hours >= 0 && hours <= 23)
                        && (minutes >= 0 && minutes <= 59);
        if (isValidTime) {
            System.out.printf("Коректний час: %02d:%02d%n", hours, minutes);
        } else {
            System.out.println("Помилка: некоректний час.");
        }
        System.out.println("=== ЗАВДАННЯ 30 ===");
        System.out.print("Введіть a: ");
        double a = scanner.nextDouble();
        System.out.print("Введіть b: ");
        double b = scanner.nextDouble();
        System.out.print("Введіть c: ");
        double c = scanner.nextDouble();
        boolean exists =
                a > 0 && b > 0 && c > 0
                        && a + b > c
                        && a + c > b
                        && b + c > a;
        System.out.println("Трикутник існує: " + exists);
        System.out.println("=== ЗАВДАННЯ 31 ===");
          System.out.print("Введіть n: ");
        int n = scanner.nextInt();
        boolean isEvenBitwise = (n & 1) == 0;
        boolean isEvenNormal = n % 2 == 0;
        System.out.println("Через &: " + isEvenBitwise);
        System.out.println("Через %: " + isEvenNormal);
        System.out.println(
                "Оператор & перевіряє молодший двійковий біт числа."
        );
        System.out.println("=== ЗАВДАННЯ 32 ===");
         System.out.print("Правильний PIN? (true/false): ");
        boolean isPinCorrect = scanner.nextBoolean();
        System.out.print("Картка активна? (true/false): ");
        boolean isCardActive = scanner.nextBoolean();
        System.out.print("Баланс достатній? (true/false): ");
        boolean hasSufficientBalance = scanner.nextBoolean();
        System.out.print("Добовий ліміт перевищено? (true/false): ");
        boolean isDailyLimitExceeded = scanner.nextBoolean();
        boolean transactionAllowed =
                isPinCorrect
                        && isCardActive
                        && hasSufficientBalance
                        && !isDailyLimitExceeded;
        if (transactionAllowed) {
            System.out.println("Транзакцію дозволено.");
        } else {
            System.out.println("Транзакцію відхилено.");
        }



        }
    }
}
