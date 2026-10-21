package practice3;
import java.util.Scanner;
public class practice02 {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("========== Завдання 9 ==========");
        System.out.println("Введіть число: ");
         int number = scanner.nextInt();
         if (number > 0) {
            System.out.println("Число додатне.");
        } else if (number < 0) {
            System.out.println("Число від'ємне.");
        } else {
            System.out.println("Число дорівнює нулю.");
        }
      System.out.println("========== Завдання 10 ==========");
         System.out.println("введіть число: ");
         int number1 = scanner.nextInt();
         if (number1 == 0) {
             System.out.println("Число є нулем");
         } else if (number1 % 2 == 0) {
             System.out.println("Число " + number1 + " є парним");
         } else {
             System.out.println("Число " + number1 + " не є парним");
         }
         System.out.println("========== Завдання 11 ==========");
         System.out.println("Введіть вік: ");
         int age = scanner.nextInt();
         if (age <0 || age >120 ) {
             System.out.println("Некоректний вік: ");
         } else if (age <=12) {
             System.out.println("Дитина");
         } else if (age <=17) {
             System.out.println("Підліток");
         } else if (age <=64) {
             System.out.println("Дорослий");
         } else if (age >=65) {
             System.out.println("Пенсіонер");
         }
         System.out.println("========== Завдання 12 ==========");
         System.out.println("Введіть тестовий бал (0-100): ");
         int score = scanner.nextInt();
         if (score <0 || score > 100) {
          System.out.println("Помилка: некоректний бал!");
         } else if (score >=90 ) {
             System.out.println("Відмінно(А)");
         } else if (score >=82 ) {
             System.out.println("Дуже добре(В)");
         } else if (score >=74 ) {
             System.out.println("Добре(С)");
         } else if (score >=64 ) {
             System.out.println("Задовільно (D)");
         } else if (score >=60 ) {
             System.out.println("Достатньо (E)");
         } else if (score >=0 ) {
             System.out.println("Незадовільно (F)");
         }
         System.out.println("========== Завдання 13 ==========");
         System.out.println("Введіть 1 число:");
         int a1 = scanner.nextInt();
         System.out.println("Введіть 2 число: ");
         int b1 = scanner.nextInt();
         System.out.println("Введіть 3 число: ");
         int c1 = scanner.nextInt();
         int max1 = a1;
         int min1 = a1;
         if (b1 > max1) {
             max1 = b1;
         }
         if (c1 > max1) {
             max1 = c1;
         }
         if (b1 < min1) {
             min1 = b1;
         }
         if (c1 < min1) {
             min1 = c1;
         }
         System.out.println("Максимум: " + max1);
         System.out.println("Мінімум: " + min1);
          System.out.println("========== Завдання 14 ==========");
          System.out.println("Введіть X: ");
          double x1 = scanner.nextDouble();
          System.out.println("Введіть Y: ");
          double y1 = scanner.nextDouble();
          if (x1 == 0 && y1 == 0) {
              System.out.println("Точка (" + x1 + "; " + y1
                    + ") знаходиться в початку координат.");
          } else if (x1 == 0) {
            System.out.println("Точка (" + x1 + "; " + y1
                    + ") лежить на осі Y.");
        } else if (y1 == 0) {
            System.out.println("Точка (" + x1 + "; " + y1
                    + ") лежить на осі X.");
        } else if (x1 > 0 && y1 > 0) {
            System.out.println("Точка (" + x1 + "; " + y1
                    + ") знаходиться у I чверті.");
        } else if (x1 < 0 && y1 > 0) {
            System.out.println("Точка (" + x1 + "; " + y1
                    + ") знаходиться у II чверті.");
        } else if (x1 < 0 && y1 < 0) {
            System.out.println("Точка (" + x1 + "; " + y1
                    + ") знаходиться у III чверті.");
        } else {
            System.out.println("Точка (" + x1 + "; " + y1
                    + ") знаходиться у IV чверті.");
        }
        System.out.println("========== Завдання 15 ==========");
          int x= 5;
          int y = 20;
           /*
         * НЕБЕЗПЕЧНИЙ ВАРІАНТ:
         *
         * if (x > 10)
         *     if (y > 10)
         *         System.out.println("Обидві умови істинні");
         *     else
         *         System.out.println("Else");
         *
         * Компілятор прив'язує else до найближчого if,
         * тобто до if (y > 10).
         */

        // Правильний варіант:
        if (x> 10) {
            if (y > 10) {
                System.out.println("x > 10 та y > 10");
            }
        } else {
            System.out.println("x <= 10");
        }
        System.out.println("========== Завдання 16 ==========");
        System.out.println("Спожито кВт·год: ");
        double consumption = scanner.nextDouble();
        if (consumption < 0) {
            System.out.println("Споживання не може бути від'ємним.");
            return;
        }
        double cost;
        if (consumption <= 100) {
            cost = consumption * 2.64;
        } else {
            cost = 100 * 2.64 + (consumption - 100) * 4.32;
        }
        System.out.printf("Сума до сплати: %.2f грн%n", cost);
    }


    }

