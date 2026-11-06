package practice9;

class BankAccount {
    private final String iban;
    private double balance;
    public BankAccount(String iban, double balance) {
        this.iban = iban;
        this.balance = balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }
    public double getBalance() {
        return balance;
    }
    @Override
    public String toString() {
        return "IBAN: " + iban +
                ", баланс: " + balance + " грн";
    }
}
public class PlasticCard {
    private final String cardNumber;
    private final String expiryDate;
    private boolean blocked;
    private final BankAccount linkedAccount;
    public PlasticCard(String cardNumber, String expiryDate,
                       BankAccount linkedAccount) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.linkedAccount = linkedAccount;
        this.blocked = false;
    }
    public boolean payAtTerminal(double amount) {
        if (blocked) {
            System.out.println("Картка заблокована!");
            return false;
        }
        return linkedAccount.withdraw(amount);
    }
    public void blockCard() {
        blocked = true;
    }
    public void unblockCard() {
        blocked = false;
    }
    @Override
    public String toString() {
        return "Номер картки: " + cardNumber +
                ", термін дії: " + expiryDate +
                ", заблокована: " + blocked;
    }
    public static void main(String[] args) {
        BankAccount familyAccount =
                new BankAccount("UA123456789", 10000);
        PlasticCard card1 =
                new PlasticCard("1111-2222", "12/28", familyAccount);
        PlasticCard card2 =
                new PlasticCard("3333-4444", "06/29", familyAccount);
        System.out.println("Початковий стан рахунку:");
        System.out.println(familyAccount);
        System.out.println("\nОплата першою карткою: 1500 грн");
        if (card1.payAtTerminal(1500)) {
            System.out.println("Оплату успішно виконано!");
        } else {
            System.out.println("Недостатньо коштів або помилка!");
        }
        System.out.println(familyAccount);
        System.out.println("\nОплата другою карткою: 2000 грн");
        if (card2.payAtTerminal(2000)) {
            System.out.println("Оплату успішно виконано!");
        } else {
            System.out.println("Недостатньо коштів або помилка!");
        }
        System.out.println(familyAccount);
        System.out.println("\nБлокуємо першу картку:");
        card1.blockCard();
        card1.payAtTerminal(500);
        System.out.println("\nОплата другою карткою: 500 грн");
        if (card2.payAtTerminal(500)) {
            System.out.println("Оплату успішно виконано!");
        }
        System.out.println("\nКінцевий стан рахунку:");
        System.out.println(familyAccount);
    }
}

