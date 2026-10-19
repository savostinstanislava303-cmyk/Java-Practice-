package practice3;
import java.util.Scanner;
public class homework3 {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ЗАВДАННЯ 2 ===");
        System.out.print("Введіть вагу відправлення (кг): ");
        double weight = scanner.nextDouble();
        System.out.print("Введіть відстань транспортування (км): ");
        int distance = scanner.nextInt();
        if (weight <= 0 || weight > 50.0) {
            System.out.println("Помилка: вага повинна бути > 0 та <= 50 кг.");
            scanner.close();
            return;
        }
        if (distance <= 0) {
            System.out.println("Помилка: відстань повинна бути більшою за 0 км.");
            scanner.close();
            return;
        }
        System.out.print("Оберіть пункт призначення " +
                "(1 - Відділення, 2 - Поштомат, 3 - Кур'єр): ");
        int deliveryType = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Чи є у вас карта Premium? (так/ні): ");
        String premiumAnswer = scanner.nextLine();
        double baseTariff;
        String deliveryName;
        switch (deliveryType) {
            case 1 -> {
                baseTariff = 50.0;
                deliveryName = "Відділення";
            }
            case 2 -> {
                if (weight > 15.0) {
                    System.out.println(
                            "Помилка: поштомат не приймає посилки вагою понад 15 кг.");
                    scanner.close();
                    return;
                }
                baseTariff = 60.0;
                deliveryName = "Поштомат";
            }
            case 3 -> {
                baseTariff = 100.0;
                deliveryName = "Кур'єрська доставка до дверей";
            }
            default -> {
                System.out.println("Помилка: невідомий тип доставки.");
                scanner.close();
                return;
            }
        }
        double distanceFee;
        if (distance <= 50) {
            distanceFee = 0.0;
        } else if (distance <= 200) {
            distanceFee = 35.0;
        } else {
            distanceFee = 80.0;
        }
        double subtotal = baseTariff + distanceFee;
        boolean isPremium = premiumAnswer.equalsIgnoreCase("так");
        double finalCost = isPremium
                ? subtotal * 0.80
                : subtotal;
        System.out.println();
        System.out.println("------------- НАКЛАДНА ДОСТАВКИ -------------");
        System.out.printf("Тип доставки:              %s (базовий тариф: %.2f грн)%n",
                deliveryName, baseTariff);
        System.out.printf("Доплата за відстань:       %.2f грн (%d км)%n",
                distanceFee, distance);
        System.out.printf("Сума до знижки:            %.2f грн%n", subtotal);
        if (isPremium) {
            System.out.println("Статус клієнта:             Premium (-20%)");
        } else {
            System.out.println("Статус клієнта:             Звичайний");
        }
        System.out.println("---------------------------------------------");
        System.out.printf("РАЗОМ ДО СПЛАТИ:            %.2f грн%n", finalCost);
        System.out.println("=============================================");
         System.out.println("=== ЗАВДАННЯ 3 ===");
         System.out.print("Введіть вік позичальника: ");
        int age = scanner.nextInt();
        System.out.print("Введіть офіційний місячний дохід (грн): ");
        double monthlyIncome = scanner.nextDouble();
        System.out.print("Чи є негативна кредитна історія? (true/false): ");
        boolean hasBadCreditHistory = scanner.nextBoolean();
        System.out.print("Введіть запитувану суму кредиту (грн): ");
        double loanAmount = scanner.nextDouble();
        System.out.print("Введіть бажаний термін (місяців): ");
        int loanMonths = scanner.nextInt();
        boolean ageIsValid = age >= 21 && age <= 65;
        boolean creditHistoryIsGood = !hasBadCreditHistory;
        boolean isPaymentAffordable =
                (loanMonths > 0)
                        && ((loanAmount / loanMonths) <= (monthlyIncome * 0.5));
        double interestRate = monthlyIncome >= 35000
                ? 14.5
                : 21.0;
        boolean approved =
                ageIsValid
                        && creditHistoryIsGood
                        && isPaymentAffordable;
        System.out.println();
        System.out.println("------------- РІШЕННЯ СКОРИНГУ -------------");
        if (approved) {
            double monthlyPayment = loanAmount / loanMonths;
            double paymentPercent =
                    monthlyPayment / monthlyIncome * 100.0;
            System.out.println("Статус заявки:               СХВАЛЕНО");
            System.out.printf("Орієнтовний платіж/міс:      %.2f грн (%.1f%% від доходу)%n",
                    monthlyPayment, paymentPercent);
            System.out.printf("Персональна ставка:          %.1f%% річних%n",
                    interestRate);
            System.out.printf("Максимально допустимий платіж: %.2f грн/міс%n",
                    monthlyIncome * 0.5);
        } else {
            System.out.println("Статус заявки:               ВІДХИЛЕНО");
            if (!ageIsValid) {
                System.out.println(
                        "Відмова: вік не відповідає критеріям (21-65 років)");
            } else if (!creditHistoryIsGood) {
                System.out.println(
                        "Відмова: виявлено негативну кредитну історію");
            } else if (!isPaymentAffordable) {
                System.out.println(
                        "Відмова: термін кредиту некоректний або " +
                        "щомісячний платіж перевищує 50% доходу");
            }
        }
        System.out.println("=============================================");
        scanner.close();


    }
}
