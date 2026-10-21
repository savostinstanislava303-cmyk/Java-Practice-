package practice5;
import java.util.Scanner;
import java.util.Locale;
public class homework5 {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     scanner.useLocale(Locale.US);
     System.out.println("=== ЗАВДАННЯ 1 Фінансова аналітика щоденного виторгу кав'ярні===");
     String[] days = {"Понеділок", "Вівторок", "Середа", "Четвер","П'ятниця", "Субота", "Неділя"};
     double[] sales = new double[7];
     double total = 0;
        int bestDay = 0;
        int worstDay = 0;
         System.out.println("=== ФІНАНСОВИЙ ЗВІТ КАВ'ЯРНІ ЗА ТИЖДЕНЬ ===");
        for (int i = 0; i < sales.length; i++) {
            System.out.print("Введіть виторг за " + days[i] + " (грн): ");
            sales[i] = scanner.nextDouble();
            total += sales[i];
            if (sales[i] > sales[bestDay]) {
                bestDay = i;
            }
            if (sales[i] < sales[worstDay]) {
                worstDay = i;
            }
        }
        double average = total / sales.length;
        System.out.println("\n---------------- ПІДСУМКИ ----------------");
        System.out.printf("Загальний тижневий виторг: %.2f грн%n", total);
        System.out.printf("Середній виторг на день: %.2f грн%n", average);
        System.out.printf("Найкращий день: %s (%.2f грн)%n",
                days[bestDay], sales[bestDay]);
        System.out.printf("Найгірший день: %s (%.2f грн)%n",
                days[worstDay], sales[worstDay]);
        System.out.println("\nДні з виторгом вище середнього:");
        for (int i = 0; i < sales.length; i++) {
            if (sales[i] > average) {
                System.out.printf("- %s: %.2f грн%n",
                        days[i], sales[i]);
            }
        }



}
}
