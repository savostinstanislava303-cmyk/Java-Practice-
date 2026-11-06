package practice9;

public class CryptoVault {
    private final String walletAddress;
    private String secretRecoveryPhrase;
    private double btcBalance;
    private boolean locked;
    public CryptoVault(String walletAddress, String secretRecoveryPhrase,
                       double btcBalance) {
        this.walletAddress = walletAddress;
        this.secretRecoveryPhrase = secretRecoveryPhrase;
        this.btcBalance = btcBalance;
        this.locked = true;
    }
    public boolean unlock(String phrase) {
        if (secretRecoveryPhrase.equals(phrase)) {
            locked = false;
            return true;
        }
        return false;
    }
    public void lock() {
        locked = true;
    }
    public boolean sendBtc(double amount, String destination) {
        if (!locked && amount > 0 && btcBalance >= amount) {
            btcBalance -= amount;

            System.out.println("Успішно відправлено " + amount
                    + " BTC на адресу " + destination);
            return true;
        }
        System.out.println("Не вдалося відправити Bitcoin!");
        return false;
    }
    @Override
    public String toString() {
        return "CryptoVault{" +
                "walletAddress='" + walletAddress + '\'' +
                ", locked=" + locked +
                ", btcBalance=" + btcBalance +
                '}';
    }
}
