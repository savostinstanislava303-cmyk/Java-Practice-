package practice3;

import java.util.Scanner;

public class practice01 {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть ім'я");
        String firstName = scanner.nextLine();
        System.out.print("Введіть призвіще");
        String lastName = scanner.nextLine();
        System.out.print("Введіть вік");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введіть місто проживання");
        String city = scanner.nextLine();
        System.out.println();
        System.out.println("===Вхідні дані===");
        System.out.println("Ім'я: " + firstName);
        System.out.println("Прізвище: " + lastName);
        System.out.println("Вік: " + age);
        System.out.println("Місто: " + city);
        System.out.println("_________________");
        System.out.println("Привіт," + firstName + " " + lastName + " з міста" + city + " " + "! Твій вік: " + age + "р.");
        System.out.println("=== Завдання 2 ===");
        System.out.print("Введіть перше число");
        int a = scanner.nextInt();
        System.out.print("Введіть друге число");
        int b = scanner.nextInt();
        System.out.println("Сума:" + (a + b));
        System.out.println("Різниця:" + (a - b));
        System.out.println("Добуток:" + (a * b));
        System.out.println("Остача від ділення:" + (a % b));
        System.out.println("=== Завдвння 3 ===");
        System.out.println("Введіть суму в гривнях (UAH): ");
        double uah = scanner.nextDouble();
        System.out.println("Введіть курс USD: ");
        double usd = scanner.nextDouble();
        if (usd != 0) {
            double dollars = uah / usd;
            System.out.printf("Сума до видачі: %.2f USD%n", dollars);
        } else {
            System.out.println("Помилка: курс не може дорівнювати 0.");
        }
        System.out.println("=== Завдвння 4 ===");
        System.out.println("Введіть номер квитка: ");
        int ticketNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введіть повне ім'я студента: ");
        String nameStudent = scanner.nextLine();
        System.out.println("Введіть спеціальність: ");
        String specialty = scanner.nextLine();
        System.out.println("Студент: " + nameStudent + ", квиток №" + ticketNumber + ", спеціальність:" + specialty);
        System.out.println("=== Завдвння 5 ===");
        System.out.println("Ваш зріст (м): ");
        double height = scanner.nextDouble();
        System.out.println("Ваша вага (кг): ");
        double weight = scanner.nextDouble();
        if (height > 0) {
            double bmi = weight / Math.pow(height, 2);
            System.out.printf("Розрахований BMI: %.2f%n", bmi);
        } else {
         System.out.println();
        }
        System.out.println("=== Завдвння 6 ===");
        System.out.println("Введіть символ: ");
        char ch = scanner.next().charAt(0);
        System.out.println("Символ: " + ch + "|" + "Код символу:" + (int) ch);
        System.out.println("=== Завдвння 7 ===");
        System.out.println("Катет A: ");
        double cathetusA = scanner.nextDouble();
        System.out.println("Катет B: ");
        double cathetusB = scanner.nextDouble();
        double hypotenuse = Math.sqrt (  Math.pow(cathetusA, 2) + Math.pow(cathetusB, 2));
        double perimeter = cathetusA + cathetusB + hypotenuse;
        double area = (cathetusA*cathetusB)/2;
        System.out.println("Гіпотенуза: " + hypotenuse);
        System.out.println("Периметр: " + perimeter);
        System.out.println("Площа: " + area);
        System.out.println("=== Завдвння 8 ===");
        System.out.println("Товар: ");
        String productName = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Ціна: ");
        double price = scanner.nextDouble();
        System.out.println("Кількість: ");
        int quantity = scanner.nextInt();
         double total = price * quantity;
        double vat = total * 0.20;
        System.out.println("Товар: " + productName);
        System.out.println("Ціна: " + price);
        System.out.println("Кількість: " + quantity);
        System.out.printf("Загальна сума: %.2f грн (з них ПДВ 20%%: %.2f грн)%n", total, vat);

        scanner.close();
    }
}
