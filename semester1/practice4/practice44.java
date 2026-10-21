package practice4;
import java.util.Scanner;
public class practice44 {
     public static void main() {
         Scanner scanner = new Scanner(System.in);
         System.out.println("=== ЗАВДАННЯ 21 ===");
         System.out.print("Введіть А: ");
         int A = scanner.nextInt();
         System.out.print("Введіть B: ");
         int B = scanner.nextInt();
         for (int i=A; i<=B; i++){
             if (i%2==0){
                 System.out.println(i+" ");
             }
         }
         System.out.println("=== ЗАВДАННЯ 22 Обчислення факторіала ===");
         System.out.println("Введіть N: ");
         int n = scanner.nextInt();
         long factorial = 1;
         for (int i=1; i<=n; i++){
             factorial *=i;
         }
         System.out.println("Факторіал:" + factorial);
         System.out.println("=== ЗАВДАННЯ 23  Таблиця кубів та квадратів ===");
         System.out.printf("%-10s %-10s %-10s%n", "Число", "Квадрат", "Куб");
         for (int i = 1; i <= 10; i++) {
          System.out.printf("%-10d %-10d %-10d%n",
            i, i * i, i * i * i);
}
         System.out.println("=== ЗАВДАННЯ 24 ===");
         for (int i = 1; i<=50; i++){
             if (i % 3 == 0||i % 5 ==0 ){
                 continue;
             }
             System.out.println(i + " ");
         }
           System.out.println("=== ЗАВДАННЯ 25 Пошук першого кратного числа ===");
         for (int i =100; i<=200; i++){
             if (i % 7 == 0||i % 13==0){
                  System.out.println("Знайдено: " + i);
                 break;
             }
         }
         System.out.println("=== ЗАВДАННЯ 26 ===");
         for (char c = 'A'; c <= 'Z'; c++) {
         System.out.println(c + " = " + (int) c);
         }
         System.out.println("=== ЗАВДАННЯ 27 Знакозмінна сума ряду ===");
         System.out.println("Введіть n: ");
         int n1 = scanner.nextInt();
         int sum = 0;
         for (int i=1; i<=n1; i++){
             if (i%2 == 0){
                 sum-=i;
                 }else {
                 sum+=i;
             }
         }
         System.out.println("Сума: "+sum);
         System.out.println("=== ЗАВДАННЯ 28 ===");
         System.out.println("Введіть a1: ");
         int a1 = scanner.nextInt();
         System.out.println("Введіть d: ");
         int d = scanner.nextInt();
         System.out.println("Введіть n: ");
         int n2 = scanner.nextInt();
         int sum1 = 0;
         for (int i=0; i<n2; i++){
             int value = a1 + i * d;
             System.out.print(value+" ");
             sum1+=value;
         }
         System.out.println("Сума:"+sum1);


         
         




     }
}
