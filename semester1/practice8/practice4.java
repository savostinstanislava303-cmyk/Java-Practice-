package practice8;

class CardWallet {
    private String cardNumber;
    private String pinCode;
    private double balance;
    // Конструктор
    public CardWallet(String cardNumber, String pinCode, double balance) {
        this.cardNumber = cardNumber;
        this.pinCode = pinCode;
        if (balance >= 0) {
            this.balance = balance;
        } else {
            this.balance = 0.0;
        }
    }

    // Геттер номера картки
    public String getCardNumber() {
        return cardNumber;
    }
    // Геттер балансу
    public double getBalance() {
        return balance;
    }
    public boolean changePin(String oldPin, String newPin) {
        if (this.pinCode.equals(oldPin)) {
            this.pinCode = newPin;
            return true;
        } else {
            return false;
        }
    }
    @Override
    public String toString() {
        String maskedCard = "**** **** **** " +
                cardNumber.substring(cardNumber.length() - 4);
        return String.format(
                java.util.Locale.US,
                "CardWallet{card='%s', balance=%.2f UAH}",
                maskedCard, balance
        );
    }
}

class WalletTask4 {
    public static void main(String[] args) {
        CardWallet wallet = new CardWallet(
                "1234567812344589",
                "1234",
                12500.00
        );

        System.out.println(wallet);
        boolean result1 = wallet.changePin("1234", "5678");
        System.out.println("Зміна PIN-коду: " + result1);
        boolean result2 = wallet.changePin("0000", "1111");
        System.out.println("Зміна PIN-коду: " + result2);
        System.out.println(wallet);
    }
}
