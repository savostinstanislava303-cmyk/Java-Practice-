package practice3;
 import java.util.Scanner;
public class practice05 {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ЗАВДАННЯ 33 ===");
        System.out.print("Введіть номер дня (1-7): ");
        int day = scanner.nextInt();
        switch (day) {
            case 1:
                System.out.println("Понеділок");
                break;
            case 2:
                System.out.println("Вівторок");
                break;
            case 3:
                System.out.println("Середа");
                break;
            case 4:
                System.out.println("Четвер");
                break;
            case 5:
                System.out.println("П'ятниця");
                break;
            case 6:
                System.out.println("Субота");
                break;
            case 7:
                System.out.println("Неділя");
                break;
            default:
                System.out.println("Некоректний номер дня");
                break;
        }
        System.out.println("=== ЗАВДАННЯ 34 ===");
        System.out.print("Введіть номер дня (1-7): ");
        int day1 = scanner.nextInt();
        switch (day1) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("Будній (робочий) день");
                break;
            case 6:
            case 7:
                System.out.println("Вихідний день");
                break;
            default:
                System.out.println("Некоректний номер дня");
                break;
        }
        System.out.println("=== ЗАВДАННЯ 35 ===");
        System.out.println("Введіть номер місяця: ");
        int month = scanner.nextInt();
        int days = switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> 28;
            default -> 0;
        };
        if (days == 0) {
            System.out.println("Неіснуючий місяць.");
        } else {
            System.out.println("Кількість днів: " + days);
        }
        System.out.println("=== ЗАВДАННЯ 36 ===");
        System.out.println("Введіть місяць: ");
        String month1 = scanner.nextLine().toLowerCase();
        String season = switch (month1) {
            case "грудень", "січень", "лютий" -> "Зима";
            case "березень", "квітень", "травень" -> "Весна";
            case "червень", "липень", "серпень" -> "Літо";
            case "вересень", "жовтень", "листопад" -> "Осінь";
            default -> "Невідомий місяць";
        };
        System.out.println("Пора року: " + season);
        System.out.println("=== ЗАВДАННЯ 37 ===");
        System.out.print("Вага товару (кг): ");
        double weight = scanner.nextDouble();
        System.out.print(
                "Оберіть спосіб доставки "
                        + "(1 - Самовивіз, 2 - Кур'єр, 3 - Поштомат): "
        );
        int deliveryType = scanner.nextInt();
        double deliveryCost = switch (deliveryType) {
            case 1 -> 0.0;
            case 2 -> {
                if (weight > 5) {
                    yield 150.0;
                } else {
                    yield 90.0;
                }
            }
            case 3 -> 60.0;
            default -> -1.0;
        };
        if (deliveryCost < 0) {
            System.out.println("Некоректний спосіб доставки.");
        } else {
            System.out.printf(
                    "Вартість доставки: %.2f грн%n",
                    deliveryCost
            );
        }
        System.out.println("=== ЗАВДАННЯ 38 ===");
        System.out.print("Число 1: ");
        double a = scanner.nextDouble();
        System.out.print("Оберіть операцію (+, -, *, /): ");
        char op = scanner.next().charAt(0);
        System.out.print("Число 2: ");
        double b = scanner.nextDouble();
        String result = switch (op) {
            case '+' -> String.valueOf(a + b);
            case '-' -> String.valueOf(a - b);
            case '*' -> String.valueOf(a * b);
            case '/' -> {
                if (b == 0) {
                    yield "Помилка: ділення на нуль!";
                }
                yield String.valueOf(a / b);
            }
            default -> "Помилка: невідома операція.";
        };
        System.out.println("Результат: " + result);
        System.out.println("=== ЗАВДАННЯ 39 ===");
        System.out.print("Введіть команду: ");
        String command = scanner.nextLine();
        /*
         * Для String == порівнює посилання на об'єкти,
         * а не текстовий вміст
         */
        if (command.equalsIgnoreCase("start")) {
            System.out.println("Через equalsIgnoreCase: START знайдено.");
        }
        String result1 = switch (command.toLowerCase()) {
            case "start" -> "Система успішно запущена!";
            case "pause" -> "Система призупинена.";
            case "stop" -> "Система зупинена.";
            case "exit" -> "Вихід із системи.";
            default -> "Невідома команда!";
        };
        System.out.println(result1);
        System.out.println("=== ЗАВДАННЯ 40 ===");
        final int correctPin = 1234;
        System.out.print("Введіть PIN: ");
        int pin = scanner.nextInt();
        if (pin != correctPin) {
            System.out.println("Невірний PIN. Доступ заборонено.");
            return;
        }
        System.out.println("Авторизація успішна!");
        double balance = 5000.0;
        System.out.println();
        System.out.println("1: Перевірити баланс");
        System.out.println("2: Поповнити рахунок");
        System.out.println("3: Зняти готівку");
        System.out.println("4: Завершити роботу");
        System.out.print(
                "Оберіть дію "
                        + "(1 - Баланс, 2 - Поповнення, "
                        + "3 - Зняття, 4 - Вихід): "
        );
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> {
                System.out.printf(
                        "Ваш баланс: %.2f грн%n",
                        balance
                );
            }
            case 2 -> {
                System.out.print("Введіть суму поповнення: ");
                double amount = scanner.nextDouble();
                if (amount > 0) {
                    balance += amount;

                    System.out.printf(
                            "Рахунок поповнено на %.2f грн.%n",
                            amount
                    );
                    System.out.printf(
                            "Новий баланс: %.2f грн%n",
                            balance
                    );
                } else {
                    System.out.println(
                            "Помилка: сума повинна бути більшою за 0."
                    );
                }
            }
            case 3 -> {
                System.out.print("Введіть суму зняття: ");
                double amount = scanner.nextDouble();
                // Short-circuit: друга частина не перевіряється,
                // якщо amount <= 0
                boolean canWithdraw =
                        amount > 0 && amount <= balance;
                if (canWithdraw) {
                    double commission =
                            amount > 1000
                                    ? amount * 0.01
                                    : 0.0;
                    double total = amount + commission;
                    if (total <= balance) {
                        balance -= total;

                        System.out.printf(
                                "Комісія операції: %.2f грн%n",
                                commission
                        );
                        System.out.printf(
                                "Видано: %.2f грн%n",
                                amount
                        );
                        System.out.printf(
                                "Залишок на рахунку: %.2f грн%n",
                                balance
                        );
                    } else {
                        System.out.println(
                                "Недостатньо коштів з урахуванням комісії."
                        );
                    }

                } else {
                    System.out.println(
                            "Помилка: некоректна сума або недостатньо коштів."
                    );
                }
            }
            case 4 -> {
                System.out.println("Дякуємо за використання банкомата!");
            }
            default -> {
                System.out.println("Некоректний пункт меню.");
            }
        }
        System.out.println("==========================================");
    }




}
