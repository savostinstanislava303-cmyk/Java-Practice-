package practice4;
import java.util.Scanner;
public class practice43 {
     public static void main() {
         Scanner scanner = new Scanner(System.in);
         System.out.println("=== ЗАВДАННЯ 14 ===");
         int choice;
         do {
         System.out.println("=== МЕНЮ ===");
            System.out.println("1. Розпочати нову гру");
            System.out.println("2. Завантажити збереження");
            System.out.println("3. Налаштування");
            System.out.println("0. Вихід");
            System.out.print("Ваш вибір: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Починаємо нову гру");
                    break;
                case 2:
                    System.out.println("Завантаження збереження");
                    break;
                case 3:
                    System.out.println("Відкрито налаштування");
                    break;
                case 0:
                    System.out.println("Вихід з програми.");
                    break;
                default:
                    System.out.println("Невірний пункт меню!");
               }
             } while (choice != 0);
              System.out.println("=== ЗАВДАННЯ 15 ===");
             int age;
             do {
            System.out.print("Введіть вік (1-120): ");
            age = scanner.nextInt();
           } while (age < 1 || age > 120);
          System.out.println("Вік підтверджено: " + age);
          System.out.println("=== ЗАВДАННЯ 16 ===");
         final int correctPin = 1234;
          int pin;
          int attempts = 0;
           boolean accessGranted = false;
          do {
             System.out.print("Введіть PIN: ");
            pin = scanner.nextInt();
            attempts++;
            if (pin == correctPin) {
                accessGranted = true;
                System.out.println("Доступ надано");
            } else {
                System.out.println("Неправильний PIN.");
            }
        } while (!accessGranted && attempts < 3);
        if (!accessGranted) {
            System.out.println("Карту заблоковано!");
        }
         System.out.println("=== ЗАВДАННЯ 17 ===");
         char answer;
        do {
            System.out.print("Введіть перше число: ");
            double a = scanner.nextDouble();
            System.out.print("Введіть друге число: ");
            double b = scanner.nextDouble();
            System.out.println("Сума: " + (a + b));
            System.out.print("Бажаєте продовжити? (y/n): ");
            answer = scanner.next().charAt(0);
        } while (answer == 'y' || answer == 'Y');
         System.out.println("=== ЗАВДАННЯ 18 ===");
          int die1;
        int die2;
        int attempts2 = 0;
        do {
            die1 = (int) (Math.random() * 6) + 1;
            die2 = (int) (Math.random() * 6) + 1;
            attempts2++;

            System.out.println(
                    "Кидок " + attempts2 + ": " + die1 + " і " + die2
            );
        } while (die1 != die2);
        System.out.println("Випав дубль!");
        System.out.println("Кількість спроб: " + attempts2);
         System.out.println("=== ЗАВДАННЯ 19 ===");
         System.out.print("Введіть чисельник: ");
        double numerator = scanner.nextDouble();
        double denominator;
        do {
            System.out.print("Введіть знаменник (не 0): ");
            denominator = scanner.nextDouble();
            if (denominator == 0) {
                System.out.println("Помилка: на нуль ділити не можна!");
            }
        } while (denominator == 0);
        System.out.println("Результат: " + numerator / denominator);
         System.out.println("=== ЗАВДАННЯ 20 ===");
          int score;
        int sum = 0;
        int count = 0;
        do {
            System.out.print("Введіть бал (0-100), від'ємне число для завершення: ");
            score = scanner.nextInt();
            if (score >= 0 && score <= 100) {
                sum += score;
                count++;
            } else if (score > 100) {
                System.out.println("Некоректний бал!");
            }
        } while (score >= 0);
        if (count > 0) {
            double average = (double) sum / count;
            System.out.println("Середній бал: " + average);
        } else {
            System.out.println("Оцінки не введені.");
        }




     }
}
