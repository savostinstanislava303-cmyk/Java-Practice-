package practice9;

abstract class AbstractTransaction {
    private final String txId;
    protected final double amount;
    public AbstractTransaction(String txId, double amount) {
        if (txId == null || txId.isBlank()) {
            throw new IllegalArgumentException("ID транзакції не може бути порожнім");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Сума переказу має бути додатною");
        }
        this.txId = txId;
        this.amount = amount;
    }
    public String getTxId() {
        return txId;
    }
    public double getAmount() {
        return amount;
    }
    public abstract double calculateCommission();
    public final double getTotalDebit() {
        return amount + calculateCommission();
    }
    @Override
    public String toString() {
        return "Транзакція " + txId;
    }
}
class DomesticTransfer extends AbstractTransaction {
    private static final double COMMISSION_RATE = 0.005; // 0.5%
    private static final double MIN_COMMISSION = 5.0;    // грн
    public DomesticTransfer(String txId, double amount) {
        super(txId, amount);
    }
    @Override
    public double calculateCommission() {
        return Math.max(amount * COMMISSION_RATE, MIN_COMMISSION);
    }
}
class CryptoTransfer extends AbstractTransaction {
    private final double networkGasFee;
    public CryptoTransfer(String txId, double amount, double networkGasFee) {
        super(txId, amount);
        if (networkGasFee < 0) {
            throw new IllegalArgumentException("Комісія мережі не може бути від'ємною");
        }
        this.networkGasFee = networkGasFee;
    }
    public double getNetworkGasFee() {
        return networkGasFee;
    }
    @Override
    public double calculateCommission() {
        return networkGasFee;
    }
}
public class TransactionDemo {
    public static void main(String[] args) {
        AbstractTransaction[] transactions = {
            new DomesticTransfer("TX-001", 500),     // 0.5% = 2.50 -> мінімум 5.00
            new DomesticTransfer("TX-002", 10000),   // 0.5% = 50.00
            new CryptoTransfer("TX-003", 2000, 12.5)
        };
        for (AbstractTransaction t : transactions) {
            System.out.printf("%s -> сума: %.2f, комісія: %.2f, всього списано: %.2f%n",
                    t, t.getAmount(), t.calculateCommission(), t.getTotalDebit());
        }
    }
}

