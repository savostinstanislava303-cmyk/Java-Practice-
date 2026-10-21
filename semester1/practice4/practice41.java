package practice4;
import java.util.Scanner;
public class practice41 {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ЗАВДАННЯ 1 ===");{
            for (int i = 0; i <7; i++) {
                System.out.println("Java - надійна та кросплатформна мова!");
            }
        }
        System.out.println("=== ЗАВДАННЯ 2 Ехо-повторювач слів ===");
        System.out.print("Введіть текст: ");
        String text = scanner.nextLine();
        System.out.print("Введіть N: ");
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("[" + i + "] " + text);
        }
         System.out.println("=== ЗАВДАННЯ 3 ===");{
             int balance = 0;
             for (int mouth = 1; mouth <= 12; mouth++) {
             balance += 500;
             System.out.println("Місяць" + mouth + ": " + balance + "грн");
             }
        }
        System.out.println("=== ЗАВДАННЯ 4 таблиця еквівалентності валют ===");
        System.out.println("Введіть курс євро до гривні: ");
        double rate = scanner.nextDouble();
        for (int euro = 10; euro <= 100; euro+=10){
            double uah = euro * rate;
            System.out.printf("%d EUR = %.2f грн%n", euro, uah);
        }
         System.out.println("=== ЗАВДАННЯ 5 генератор декоративної рамки ===");
         System.out.println("Введіть ширину рамки: ");
         int frame = scanner.nextInt();
         for (int i = 0; i < frame; i++) {
         System.out.println("=");
        }


    }
}
