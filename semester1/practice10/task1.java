package practice10;

abstract class PaymentInstrument {
    private final String payerName;
    public PaymentInstrument(String payerName) {
        this.payerName = payerName;
    }
    public String getPayerName() {
        return payerName;
    }
    public abstract double calculateFee(double amount);
    public double processPayment(double amount) {
        return amount + calculateFee(amount);
    }
}
class BankCardInstrument extends PaymentInstrument {
    public BankCardInstrument(String payerName) {
        super(payerName);
    }
    @Override
    public double calculateFee(double amount) {
        return amount * 0.015 + 5.0;
    }
}
class CryptoTokenInstrument extends PaymentInstrument {
    private double gasFeeUah;
    public CryptoTokenInstrument(String payerName, double gasFeeUah) {
        super(payerName);
        this.gasFeeUah = gasFeeUah;
    }
    @Override
    public double calculateFee(double amount) {
        return gasFeeUah;
    }
}
class IbanDirectInstrument extends PaymentInstrument {
    public IbanDirectInstrument(String payerName) {
        super(payerName);
    }
    @Override
    public double calculateFee(double amount) {
        if (amount <= 50000) {
            return 0.0;
        } else {
            return amount * 0.005;
        }
    }
}
public class task1 {
    public static void main(String[] args) {
        double amount = 10000.0;
        double totalExpenses = 0.0;
        PaymentInstrument[] payments = {
                new BankCardInstrument("Anna"),
                new CryptoTokenInstrument("Ivan", 120.0),
                new IbanDirectInstrument("Olena")
        };
        for (PaymentInstrument payment : payments) {
            double fee = payment.calculateFee(amount);
            double total = payment.processPayment(amount);
            System.out.println("Платник: " + payment.getPayerName());
            System.out.println("Комісія: " + fee + " грн");
            System.out.println("Загальна сума: " + total + " грн");

            totalExpenses += total;

            System.out.println("----------------------");
        }

        System.out.println("Сумарні витрати: " + totalExpenses + " грн");
    }
}
