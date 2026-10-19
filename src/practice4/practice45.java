package practice4;
import java.util.Scanner;
public class practice45 {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ЗАВДАННЯ 29 Демонстрація переповнення byte ===");
        byte b=125;
        for (int i=0;i<6; i++){
            System.out.println("Крок"+(i+1)+":"+b);
        }
         System.out.println(
                "Після 127 byte переходить до -128, " +
                "оскільки діапазон byte: -128 ... 127."
        );
         System.out.println("=== ЗАВДАННЯ 30 ===");
         System.out.println("Скільки чисел N?");
         int n = scanner.nextInt();
         int sum =0;
         for (int i=1;i<=n;i++){
             System.out.println("Число"+i+":");
             sum += scanner.nextInt();
         }
         double correctAverage = (double) sum / n;
        double wrongAverage = sum / n;
        System.out.println("Сума: " + sum);
        System.out.println("Правильне середнє: " + correctAverage);
        System.out.println("Без приведення: " + wrongAverage);
        System.out.println("=== ЗАВДАННЯ 31 Шифратор символів (Зсув Цезаря) ===");
        scanner.nextLine();
        System.out.print("Введіть слово: ");
        String word = scanner.nextLine();
        String encrypted = "";
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            encrypted += (char) (ch + 1);
        }
        System.out.println("Зашифрований рядок: " + encrypted);
         System.out.println("=== ЗАВДАННЯ 32 ===");
         double [] prices ={
                 19.99,
                 45.50,
                 12.10,
                 99.95,
                 3.40
         };
             int totalHryvnias = 0;
         int totalKopiykas = 0;
          for (double price : prices) {
            int hryvnias = (int) price;
            int kopiykas = (int) ((price - hryvnias) * 100);
            totalHryvnias += hryvnias;
            totalKopiykas += kopiykas;
        }
        System.out.println("Загальна сума цілих гривень: "
                + totalHryvnias);
        System.out.println("Сума відкинутих копійок: "
                + totalKopiykas);
         System.out.println("=== ЗАВДАННЯ 33 Прогрес-бар завантаження ===");
          for (int i = 1; i <= 50; i++) {
            int percent = (int) (((double) i / 50) * 100);
            System.out.println("Завантажено: " + percent + "%");
        }
           System.out.println("=== ЗАВДАННЯ 34 ===");
            long bigNumber = 3_000_000_000L;
            int result = (int) bigNumber;
            System.out.println("long: " + bigNumber);
        System.out.println("int після приведення: " + result);
        System.out.println(
                "Інформація втрачена через те, " +
                "що 3 000 000 000 не входить у діапазон int."
        );
        System.out.println("=== ЗАВДАННЯ 35 ===");
        System.out.println("Неправильний варіант:");
        for (double d = 0.0; d <= 1.0; d += 0.1) {
            System.out.println(d);
        }
        System.out.println("Правильний варіант:");
        for (int i = 0; i <= 10; i++) {
            double val = i / 10.0;
            System.out.println(val);
        }






    }
}
