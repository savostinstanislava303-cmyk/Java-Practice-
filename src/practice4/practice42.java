package practice4;
import java.util.Scanner;
public class practice42 {
     public static void main() {
         Scanner scanner = new Scanner(System.in);
         System.out.println("=== ЗАВДАННЯ 6 Космічний зворотній відлік ===");
         int number = 10;
         while (number >= 1) {
         System.out.println(number);
         number--;
         }
         System.out.print("Поїхали! Ракета запущена!");
         System.out.println();
         System.out.println("=== ЗАВДАННЯ 7 ===");
         int sum = 0;
        int number1;
        System.out.println("Вводьте числа. 0 — завершення.");
        while (true) {
            number1 = scanner.nextInt();
            if (number1 == 0) {
                break;
            }
            sum += number1;
        }
        System.out.println("Сума: " + sum);
        System.out.println("=== ЗАВДАННЯ 8 степені двійки ===");
        System.out.print("Введіть M: ");
        int m = scanner.nextInt();
        int power = 1;
        while (power <= m) {
            System.out.print(power + " ");
            power *= 2;
        }
        System.out.println();
        System.out.println("=== ЗАВДАННЯ 9 ===");
          System.out.print("Введіть додатне число: ");
        int n = scanner.nextInt();
        int original = n;
        int digits = 0;
        int sum1 = 0;
        while (n > 0) {
            int digit = n % 10;
            sum1 += digit;
            digits++;
            n /= 10;
        }
        System.out.println("Число: " + original);
        System.out.println("Кількість цифр: " + digits);
        System.out.println("Сума цифр: " + sum1);
        System.out.println("=== ЗАВДАННЯ 10 реверс цілого числа ===");
        System.out.println("Введіть додатне число: ");
        int n1 = scanner.nextInt();
        int reversed = 0;
        while (n > 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n /= 10;
        }
        System.out.println("Реверс: " + reversed);
        System.out.println("=== ЗАВДАННЯ 11 ===");
        System.out.println("Введіть суму S: ");
        double s = scanner.nextDouble();
        System.out.println("Введіть річну ставку P(%): ");
        double p = scanner.nextDouble();
        double inital = s;
        int year = 0;
        while (s<inital*2){
            s+=s*p/100;
            year++;
        }
        System.out.println("Кількість років: "+year);
        System.out.println("Сума:"+s);
        System.out.println("=== ЗАВДАННЯ 12 найменший дільник числа ===");
        System.out.println("Введіть число N>1: ");
        int n2 = scanner.nextInt();
        int divisor = 2;
        while (n%divisor!=0){
            divisor++;
        }
        System.out.println("Найменший дільник: " + divisor);
        System.out.println("=== ЗАВДАННЯ 13 ===");
        int secret =(int)(Math.random()*100)+1;
        int attempts = 0;
        int guess = 0;
        System.out.println("Я загадав число від 1 до 100: ");
        while (guess!=secret){
            System.out.print("Ваша здогадка: ");
            guess = scanner.nextInt();
            attempts ++;
            if (guess<secret){
                System.out.println("Більше:");
            }else if (guess>secret) {
                System.out.println("Менше:");
            }else {
                System.out.println("Ви вгадали:");
            }
            System.out.println("Кількість спроб:"+attempts);
        }




     }
}
