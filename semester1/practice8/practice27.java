package practice8;

class PaymentCard {
    private String cardHolder;
    protected double balance;
    public PaymentCard(String cardHolder, double balance) {
        this.cardHolder = cardHolder;
        this.balance = balance;
    }
    public boolean pay(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }
    public String getCardHolder() {
        return cardHolder;
    }
    @Override
    public String toString() {
        return "Власник картки: " + cardHolder +
                "\nБаланс: " + balance + " грн";
    }
}
class DebitCard extends PaymentCard {
    private double dailyLimit;
    public DebitCard(String cardHolder, double balance,
                     double dailyLimit) {
        super(cardHolder, balance);
        this.dailyLimit = dailyLimit;
    }
    @Override
    public boolean pay(double amount) {
        if (amount > dailyLimit) {
            return false;
        }
        return super.pay(amount);
    }
    public double getDailyLimit() {
        return dailyLimit;
    }
    @Override
    public String toString() {
        return super.toString() +
                "\nДенний ліміт: " + dailyLimit + " грн";
    }
}
class CashbackPlatinumCard extends DebitCard {
    private double cashbackPercent;
    private double accumulatedCashback;
    public CashbackPlatinumCard(String cardHolder, double balance,
                                double dailyLimit, double cashbackPercent) {
        super(cardHolder, balance, dailyLimit);
        this.cashbackPercent = cashbackPercent;
        this.accumulatedCashback = 0;
    }
    @Override
    public boolean pay(double amount) {
        boolean success = super.pay(amount);
        if (success) {
            accumulatedCashback += amount * cashbackPercent / 100;
        }
        return success;
    }
    @Override
    public String toString() {
        return super.toString() +
                "\nКешбек: " + cashbackPercent + "%" +
                "\nНакопичений кешбек: " +
                accumulatedCashback + " грн";
    }
}
public class practice27 {
    public static void main(String[] args) {
        CashbackPlatinumCard card = new CashbackPlatinumCard(
                "Данило",
                10000,
                5000,
                5
        );
        System.out.println("===== ПОЧАТКОВИЙ СТАН КАРТКИ =====");
        System.out.println(card);
        System.out.println("===== ПОКУПКА =====");
        double purchase = 2000;
        if (card.pay(purchase)) {
            System.out.println("Оплата на " + purchase + " грн успішна!");
        } else {
            System.out.println("Оплату відхилено!");
        }
        System.out.println("===== СТАН КАРТКИ ПІСЛЯ ПОКУПКИ =====");
        System.out.println(card);
    }
}