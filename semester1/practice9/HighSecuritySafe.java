package practice9;

public class HighSecuritySafe {
     private int pinCode;
    private double storedCash;
    private int failedAttempts;
    private boolean permanentlyBlocked;
    public HighSecuritySafe(int pinCode, double storedCash) {
        this.pinCode = pinCode;
        this.storedCash = storedCash;
        this.failedAttempts = 0;
        this.permanentlyBlocked = false;
    }
    private boolean checkAccess(int enteredPin) {
        if (permanentlyBlocked) {
            System.out.println("Сейф заблокований!");
            return false;
        }
        if (enteredPin != pinCode) {
            failedAttempts++;
            System.out.println("Неправильний PIN-код!");
            System.out.println("Кількість невдалих спроб: " + failedAttempts);
            if (failedAttempts >= 3) {
                permanentlyBlocked = true;
                System.out.println("Сейф заблоковано назавжди!");
            }
            return false;
        }
        failedAttempts = 0;
        return true;
    }
    public void putCash(int pin, double amount) {
        if (!checkAccess(pin)) {
            return;
        }
        if (amount <= 0) {
            System.out.println("Сума повинна бути більшою за 0!");
            return;
        }
        storedCash += amount;
        System.out.println("Гроші успішно додано: " + amount);
    }
    public void takeCash(int pin, double amount) {
        if (!checkAccess(pin)) {
            return;
        }
        if (amount <= 0) {
            System.out.println("Сума повинна бути більшою за 0!");
            return;
        }
        if (amount > storedCash) {
            System.out.println("У сейфі недостатньо грошей!");
            return;
        }
        storedCash -= amount;
        System.out.println("Гроші успішно знято: " + amount);
    }
    @Override
    public String toString() {
        return "HighSecuritySafe{" +
                "storedCash=" + storedCash +
                ", failedAttempts=" + failedAttempts +
                ", permanentlyBlocked=" + permanentlyBlocked +
                '}';
    }
}
