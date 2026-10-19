import java.util.Scanner;
public class canculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи перше число:");
        double number1 = scanner.nextDouble();
        System.out.println("введи перше число:");
        double number2 = scanner.nextDouble();
        System.out.println("(+,-,*,/):");
        String operation = scanner.next();
        switch (operation) {
    case "+":
        System.out.println(number1 + number2);
        break;
    case "-":
        System.out.println(number1 - number2);
        break;
    case "*":
        System.out.println(number1 * number2);
        break;
    case "/":
        System.out.println(number1 / number2);
        break;
    default:
        System.out.println("Невідома операція");

}
    }
    }

