package practice9;

public class practice3 {
    public static void main(String[] args) {
        CryptoVault wallet = new CryptoVault(
                "BTC-123456789",
                "mySecretPhrase",
                2.5
        );
        System.out.println("Початковий стан гаманця:");
        System.out.println(wallet);
        wallet.sendBtc(0.5, "BTC-987654321");
        System.out.println("Спроба розблокування:");
        boolean unlocked = wallet.unlock("mySecretPhrase");
        System.out.println("Гаманець розблоковано: " + unlocked);
        System.out.println("Відправлення Bitcoin:");
        wallet.sendBtc(0.5, "BTC-987654321");
        System.out.println("Стан після відправлення:");
        System.out.println(wallet);
        wallet.lock();
        System.out.println("Після блокування:");
        System.out.println(wallet);
        wallet.sendBtc(0.3, "BTC-111222333");
        System.out.println("Кінцевий стан гаманця:");
        System.out.println(wallet);
    }
}
