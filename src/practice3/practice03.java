package practice3;
    import java.util.Scanner;
public class practice03 {
   public static void main() {
       Scanner scanner = new Scanner(System.in);
       System.out.println("=== ЗАВДАННЯ 17 ===");
        System.out.print("Введіть x: ");
        int x1 = scanner.nextInt();
        System.out.print("Введіть y: ");
        int y1 = scanner.nextInt();
        int max = (x1 > y1) ? x1 : y1;
        System.out.println("Більше число: " + max);
        System.out.println("=== ЗАВДАННЯ 18 ===");
       System.out.print("Введіть n: ");
       int n = scanner.nextInt();
       int abs = (n < 0) ? -n : n;
       System.out.println("|n| = " + abs);
       System.out.println("=== ЗАВДАННЯ 19 ===");
       System.out.println("Введіть число: ");
       int number = scanner.nextInt();
       String result = (number % 2 == 0) ? "Парне" : "Непарне";
       System.out.println("Результат: " + result);
       System.out.println("=== ЗАВДАННЯ 20 ===");
        System.out.print("Введіть бал: ");
        int score = scanner.nextInt();
        System.out.println(
                "Результат: " + (score >= 60 ? "Зараховано" : "Незараховано")
                 );
        System.out.println("=== ЗАВДАННЯ 21 ===");
        System.out.print("Введіть n: ");
        int n1= scanner.nextInt();
        String status = (n1 > 0)
                ? "Додатне"
                : (n1 < 0)
                ? "Від'ємне"
                : "Нуль";
        System.out.println(status);
        System.out.println("=== ЗАВДАННЯ 22 ===");
        System.out.println("Сума покупки: ");
        double amount = scanner.nextDouble();
        double finalPrice = amount > 1000
                 ? amount * 0.90
                : amount * 0.98;
        System.out.printf("До сплати зі знижкою: %.2f грн%n", finalPrice);
        System.out.println("=== ЗАВДАННЯ 23 ===");
        System.out.println("Введіть а: ");
        double a = scanner.nextDouble();
        System.out.println("Введіть b: ");
        double b = scanner.nextDouble();
        String results = b != 0
                ? String.format("%.2f", a / b)
                : "Помилка: ділення на нуль неможливе!";
              System.out.println("Результат: " + results);
          System.out.println("=== ЗАВДАННЯ 24 ===");
           System.out.print("Кількість знайдених помилок: ");
        int count = scanner.nextInt();
        String result1 = (count == 1)
                ? "Знайдено 1 помилку"
                : "Знайдено " + count + " помилок";
        System.out.println(result1);

    }
}
