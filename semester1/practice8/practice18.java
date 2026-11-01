package practice8;

class StandardTransfer {
    protected double amount;
    public StandardTransfer(double amount) {
        this.amount = amount;
    }
    public double getFee() {
        return amount * 0.01;
    }
    public double getTotalWithFee() {
        return amount + getFee();
    }
    @Override
    public String toString() {
        return "Сума переказу: " + amount +
                ", комісія: " + getFee() +
                ", загальна сума: " + getTotalWithFee();
    }
}
class InternationalTransfer extends StandardTransfer {
    private String countryCode;
    private static final double SWIFT_FEE = 15.0;
    public InternationalTransfer(double amount, String countryCode) {
        super(amount);
        this.countryCode = countryCode;
    }
    @Override
    public double getFee() {
        return super.getFee() * 2 + SWIFT_FEE;
    }
    @Override
    public String toString() {
        return "Міжнародний переказ до країни " + countryCode +
                ", сума переказу: " + amount +
                ", комісія: " + getFee() +
                ", загальна сума з комісією: " + getTotalWithFee();
    }
}
public class practice18 {
    public static void main(String[] args) {
        StandardTransfer standard = new StandardTransfer(1000);
        InternationalTransfer international =
                new InternationalTransfer(1000, "US");
        System.out.println(standard);
        System.out.println();
        System.out.println(international);
    }
}
