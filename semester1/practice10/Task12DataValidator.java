package practice10;

interface DataValidator {
    boolean isValid(String input);
    default String validateOrDefault(String input, String fallback) {
        return isValid(input) ? input : fallback;
    }
    static boolean isNotNullOrBlank(String s) {
        return s != null && !s.isBlank();
    }
}
class EmailValidator implements DataValidator {
    @Override
    public boolean isValid(String input) {
        return DataValidator.isNotNullOrBlank(input)
                && input.contains("@")
                && input.contains(".");
    }
}
class PositiveNumberValidator implements DataValidator {
    @Override
    public boolean isValid(String input) {
        if (!DataValidator.isNotNullOrBlank(input)) {
            return false;
        }
        try {
            return Double.parseDouble(input) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

public class Task12DataValidator {
    public static void main(String[] args) {
        EmailValidator emailValidator = new EmailValidator();
        PositiveNumberValidator numberValidator =
                new PositiveNumberValidator();
        String email = "student@gmail.com";
        System.out.println("=== Перевірка Email ===");
        System.out.println("Введене значення: " + email);
        System.out.println("Чи правильне: " + emailValidator.isValid(email));
        System.out.println("Результат: "
                + emailValidator.validateOrDefault(email, "Невірний Email"));
        String wrongEmail = "studentgmail.com";
        System.out.println("\nНеправильний Email: " + wrongEmail);
        System.out.println("Результат: "
                + emailValidator.validateOrDefault(wrongEmail, "Невірний Email"));
        String number = "25.5";
        System.out.println("\n=== Перевірка числа ===");
        System.out.println("Введене значення: " + number);
        System.out.println("Чи додатне: " + numberValidator.isValid(number));
        System.out.println("Результат: "
                + numberValidator.validateOrDefault(number, "Невірне число"));
        String negativeNumber = "-10";
        System.out.println("\nВід'ємне число: " + negativeNumber);
        System.out.println("Результат: "
                + numberValidator.validateOrDefault(negativeNumber, "Невірне число"));
        System.out.println("\n=== Static-метод ===");
        System.out.println("Чи не порожній рядок: "
                + DataValidator.isNotNullOrBlank("Hello"));
    }
}

