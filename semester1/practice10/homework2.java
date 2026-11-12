package practice10;

interface CashbackCapable {
    double MAX_CASHBACK_UAH = 500.0;
    double getCashbackRate();
    default double calculateCashback(double baseAmount) {
        return Math.min(MAX_CASHBACK_UAH, baseAmount * getCashbackRate());
    }
}
interface Refundable {
    boolean requestRefund(String reason);
    boolean isRefunded();
}
interface BlockchainVerifiable {
    String getTxHash();
    int getConfirmations();
    default boolean isFinalized() {
        return getConfirmations() >= 12;
    }
}
abstract class AbstractPaymentTransaction {
    private final String txId;
    private final double baseAmountUah;
    private boolean processed;
    public AbstractPaymentTransaction(String txId, double baseAmountUah) {
        this.txId = txId;
        this.baseAmountUah = baseAmountUah;
        this.processed = false;
    }
    public abstract double calculateFee();
    public abstract String getPaymentChannel();

    public final boolean process() {
        if (baseAmountUah <= 0 || processed) {
            return false;
        }
        processed = true;
        return true;
    }
    public final double getTotalCharged() {
        return baseAmountUah + calculateFee();
    }
    public String getTxId() {
        return txId;
    }
    public double getBaseAmountUah() {
        return baseAmountUah;
    }
    public boolean isProcessed() {
        return processed;
    }
}
class PremiumCardPayment extends AbstractPaymentTransaction
        implements CashbackCapable, Refundable {
    private final String maskedPan;
    private final double cashbackRate;
    private boolean refunded;
    public PremiumCardPayment(String txId, double amount,
                              String maskedPan) {
        super(txId, amount);
        this.maskedPan = maskedPan;
        this.cashbackRate = 0.03;
        this.refunded = false;
    }
    @Override
    public double calculateFee() {
        return getBaseAmountUah() * 0.01;
    }
    @Override
    public String getPaymentChannel() {
        return "Visa Infinite";
    }
    @Override
    public double getCashbackRate() {
        return cashbackRate;
    }
    @Override
    public boolean requestRefund(String reason) {
        if (isProcessed() && !refunded) {
            refunded = true;
            return true;
        }

        return false;
    }
    @Override
    public boolean isRefunded() {
        return refunded;
    }
}
class CryptoUsdtPayment extends AbstractPaymentTransaction
        implements CashbackCapable, BlockchainVerifiable {
    private final String txHash;
    private final int confirmations;
    public CryptoUsdtPayment(String txId, double amount,
                             String txHash, int confirmations) {
        super(txId, amount);
        this.txHash = txHash;
        this.confirmations = confirmations;
    }
    @Override
    public double calculateFee() {
        return 40.0;
    }
    @Override
    public String getPaymentChannel() {
        return "USDT TRC-20";
    }
    @Override
    public double getCashbackRate() {
        return 0.01;
    }
    @Override
    public String getTxHash() {
        return txHash;
    }
    @Override
    public int getConfirmations() {
        return confirmations;
    }
}
final class TaxTreasuryPayment extends AbstractPaymentTransaction
        implements Refundable {
    private final String taxCode;
    private boolean refunded;
    public TaxTreasuryPayment(String txId, double amount,
                              String taxCode) {
        super(txId, amount);
        this.taxCode = taxCode;
        this.refunded = false;
    }
    @Override
    public double calculateFee() {
        return 0.0;
    }
    @Override
    public String getPaymentChannel() {
        return "ДержКазначейство";
    }
    @Override
    public boolean requestRefund(String reason) {
        if (isProcessed() && !refunded) {
            refunded = true;
            return true;
        }
        return false;
    }
    @Override
    public boolean isRefunded() {
        return refunded;
    }
}
public class homework2 {
    public static void main(String[] args) {
        AbstractPaymentTransaction[] ledger = {
                new PremiumCardPayment(
                        "TX-101", 20000.0, "**** **** **** 1234"),
                new CryptoUsdtPayment(
                        "TX-102", 8500.0,
                        "0x9f8a...c4", 18),
                new TaxTreasuryPayment(
                        "TX-103", 5000.0, "12345678")
        };
        auditPayments(ledger);
    }
    public static void auditPayments(
            AbstractPaymentTransaction[] ledger) {
        double totalTurnover = 0.0;
        double totalFees = 0.0;
        double totalCashback = 0.0;
        System.out.println(
                "================ ПРОЦЕСИНГОВИЙ ЦЕНТР FINTECH " + "(POLYMORPHISM & INTERFACES) ================");
        System.out.println(
                "\n[1. ПРОВЕДЕННЯ ПАКЕТУ ТРАНЗАКЦІЙ (final process())]:");
        for (AbstractPaymentTransaction tx : ledger) {
            if (tx.process()) {
                double amount = tx.getBaseAmountUah();
                double fee = tx.calculateFee();
                double total = tx.getTotalCharged();
                totalTurnover += amount;
                totalFees += fee;
                System.out.printf(
                        "  ✅ [%s | %s] Сума: %8.2f грн | "
                                + "Комісія: %6.2f грн | Всього: %8.2f грн%n",
                        tx.getTxId(),
                        tx.getPaymentChannel(),
                        amount,
                        fee,
                        total
                );
            }
        }
        System.out.println(
                "\n[2. АВТОМАТИЧНИЙ АУДИТ МОЖЛИВОСТЕЙ "
                        + "(Pattern Matching instanceof)]:");
        for (AbstractPaymentTransaction tx : ledger) {
            if (!tx.isProcessed()) {
                continue;
            }
            if (tx instanceof CashbackCapable cashback) {
                double cashbackAmount =
                        cashback.calculateCashback(tx.getBaseAmountUah());
                totalCashback += cashbackAmount;
                System.out.printf(
                        "  💰 [CashbackCapable] %s: нараховано %.0f%% "
                                + "= %.2f грн%n",
                        tx.getTxId(),
                        cashback.getCashbackRate() * 100,
                        cashbackAmount
                );
            }
            if (tx instanceof BlockchainVerifiable blockchain) {
                System.out.printf(
                        "  ⛓️ [BlockchainVerifiable] %s: Hash=%s, "
                                + "Підтверджень=%d (Finalized: %s)%n",
                        tx.getTxId(),
                        blockchain.getTxHash(),
                        blockchain.getConfirmations(),
                        blockchain.isFinalized()
                );
            }
            if (tx instanceof PremiumCardPayment
                    && tx instanceof Refundable refundable) {
                boolean success =
                        refundable.requestRefund("Подвійне списання");
                System.out.printf(
                        "  🔄 [Refundable] Спроба повернення %s "
                                + "('Подвійне списання'): %s%n",
                        tx.getTxId(),
                        success ? "УСПІШНО ПОВЕРНЕНО!" : "ВІДМОВЛЕНО"
                );
            }
        }
        System.out.println("\n[ПІДСУМКОВИЙ ЗВІТ ШЛЮЗУ]:");
        System.out.printf(
                "  Сумарний базовий оборот:  %10.2f грн%n",
                totalTurnover
        );
        System.out.printf(
                "  Сумарна комісія шлюзу:    %10.2f грн%n",
                totalFees
        );
        System.out.printf(
                "  Сумарний виплачений кешбек: %8.2f грн%n",
                totalCashback
        );
        System.out.println(
                "========================================================================================="
        );
    }
}

