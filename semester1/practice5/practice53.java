package practice5;
import java.util.Scanner;
import java.util.Arrays;
public class practice53 {
     public static void main() {
         Scanner scanner = new Scanner(System.in);
         System.out.println("=== ЗАВДАННЯ 16 ===");
          String[] cities = {"Київ", "Львів", "Харків", "Одеса", "Дніпро"};
        for (String city : cities)
            System.out.println("Ласкаво просимо до міста " + city + "!");
         System.out.println("=== ЗАВДАННЯ 17 ===");
         double[] salaries = {20000.0, 25000.0, 18000.0, 30000.0};
         for (int i=0; i < salaries.length; i++) salaries[i] *= 1.10;
         System.out.println(Arrays.toString(salaries));
         System.out.println("=== ЗАВДАННЯ 18 ===");
         int[] arr = {1, 2, 3, 4, 5, 6};
          for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(arr));
          System.out.println("=== ЗАВДАННЯ 19 ===");
          int[] base = {2, 4, 6, 8, 10};
          int[] squares = new int [base.length];
           for (int i = 0; i < base.length; i++) squares[i] = base[i] * base[i];
        System.out.println("Початковий: " + Arrays.toString(base));
        System.out.println("Квадрати: " + Arrays.toString(squares));
         System.out.println("=== ЗАВДАННЯ 20 ===");
           int[] arr1 = {1, 4, 3, 7, 9};
        boolean isSorted = true;
        for (int i = 0; i < arr1.length - 1; i++) {
            if (arr1[i] > arr1[i + 1]) { isSorted = false; break; }
        }
        System.out.println("Масив: " + Arrays.toString(arr1));
        System.out.println(isSorted ? "Масив упорядкований за зростанням." : "Масив не впорядкований за зростанням.");
        System.out.println("=== ЗАВДАННЯ 21 ===");
         int[] a = {1, 2, 3};
        int[] b = {4, 5, 6, 7};
        int[] c = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) c[i] = a[i];
        for (int i = 0; i < b.length; i++) c[a.length + i] = b[i];
        System.out.println(Arrays.toString(c));
        System.out.println("=== ЗАВДАННЯ 22 ===");
        int[] test = {45, 12, 89, 3, 27};
        System.out.println("Початок:" + Arrays.toString(test));
        Arrays.sort(test);
         System.out.println("Відсортоване: " + Arrays.toString(test));
        Arrays.fill(test, -1);
        System.out.println("Результат:" +Arrays.toString(test));




     }
}
