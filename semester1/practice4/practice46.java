package practice4;
import java.util.Scanner;
public class practice46 {
     public static void main() {
         Scanner scanner = new Scanner(System.in);
         System.out.println("=== ЗАВДАННЯ 36 Таблиця множення Піфагора ===");
         for (int i=1; i<=10; i++) {
             for (int j = 1; j <= 10; j++) {
                 System.out.print(i * j + "\t");
             }
             System.out.println();
         }
         System.out.println("=== ЗАВДАННЯ 37 ===");
         System.out.println("Введіть висоту H: ");
         int H = scanner.nextInt();
         System.out.println("Введіть ширину W: ");
         int W = scanner.nextInt();
         for (int i=1; i<=H; i++){
             for(int j=1; j<=W; j++){
                 if (i ==1 || i==H || j==1 || j==W){
                     System.out.print("*");
                 }else{
                     System.out.print(" ");
                 }
             }
             System.out.println();
         }
         System.out.println("=== ЗАВДАННЯ 38 Прямокутний трикутник ===");
         System.out.println("Введіть висоту N: ");
         int N = scanner.nextInt();
         for (int i=1; i<=N; i++){
             for (int j=1; j<=N; j++){
                 System.out.println("*");
             }
         }
         System.out.println("=== ЗАВДАННЯ 39 ===");
         System.out.println("Введіть N: ");
         int n = scanner.nextInt();
         System.out.println("Введіть прості числа: ");
         for (int i = 2; i <= N; i++) {
         boolean isPrime = true;
         for (int j = 2; j < i; j++) {
        if (i % j == 0) {
            isPrime = false;
            break;
        }
     }
          if (isPrime) {
        System.out.print(i + " ");
    }
        }
      System.out.println();


         

     }
}
