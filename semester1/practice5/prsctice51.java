package practice5;
import java.util.Scanner;
import java.util.Arrays;
public class prsctice51 {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ЗАВДАННЯ 1  Перший масив та значення за замовчуванням ===");
        int [] numbers = new int [5];
           for (int number : numbers) System.out.print(number + " ");
        System.out.println();
        numbers[0] = 10;
        numbers[2] = 30;
        numbers[numbers.length - 1] = 50;
        System.out.println(Arrays.toString(numbers));
        System.out.println("=== ЗАВДАННЯ 2 ===");
        String [] days = {"Понеділок", "Вівторок", "Середа", "Четвер", "П'ятниця", "Субота", "Неділя"};
        System.out.println("Кількість днів: "+days.length);
        System.out.println("Перший день: " + days[0]);
        System.out.println("Останній день: "+days[days.length - 1]);
        days[5] = "Вихідний (сб)";
        days[6] = "Вихідний (нд)";
        System.out.println(Arrays.toString(days));
        System.out.println("=== ЗАВДАННЯ 3 Модифікація цін на складі===");
        double[] prices = {120.50, 45.00, 890.99, 15.30, 420.00};
        System.out.println("Ціна до знижки: " + Arrays.toString(prices));
        prices[2] = prices[2] * 0.8;
        System.out.println("Ціна після знижки: " + Arrays.toString(prices));
        System.out.println("=== ЗАВДАННЯ 4 ===");
        System.out.println("Введіть N (N>0): ");
        int n = scanner.nextInt();
        if (n<=0) {
            System.out.println("N має бути більший за 0:");
            return;
        }
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) arr[i] = i + 1;
        System.out.println(Arrays.toString(arr));
        System.out.println("=== ЗАВДАННЯ 5 ===");
        int [] arr1 = {4, 8, 15, 16, 23, 42};
        for (int i = arr.length - 1; i>=0; i--){
            System.out.print(arr1[i]);
            if (i > 0) System.out.print(", ");
        }
        System.out.println();
        System.out.println("=== ЗАВДАННЯ 6  Масив степенів двійки ===");
        int [] powers = new int [10];
        powers[0]=1;
        for (int i = 1; i< powers.length; i++) powers[i] = powers [i-1]*2;
        System.out.println(Arrays.toString(powers));
         System.out.println("=== ЗАВДАННЯ 7 ===");
         int[] original = {3, 7, 1, 9, 4};
         int[] copy = new int [original.length];
         for (int i = 0; i< original.length; i++) copy [i] = original[i];
         copy [0] = 999;
         System.out.println("Оригінал:"+Arrays.toString(original));
         System.out.println("Жалкая пародія:"+Arrays.toString(copy));







    }
}
