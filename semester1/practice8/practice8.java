package practice8;

class InvoiceItemTask8 {
    private String description;
    private int quantity;
    private double unitPrice;
    private double discountPercent;
    // Конструктор
    public InvoiceItemTask8(String description, int quantity,
                            double unitPrice, double discountPercent) {
        this.description = description;
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            this.quantity = 0;
        }
        if (unitPrice >= 0) {
            this.unitPrice = unitPrice;
        } else {
            this.unitPrice = 0.0;
        }
        if (discountPercent >= 0 && discountPercent <= 50) {
            this.discountPercent = discountPercent;
        } else {
            this.discountPercent = 0.0;
        }
    }

    public double getFinalAmount() {
        double total = quantity * unitPrice;
        return total - (total * discountPercent / 100);
    }
    @Override
    public String toString() {
        return String.format(
                java.util.Locale.US,
                "%s | Кількість: %d | Ціна: %.2f грн | Знижка: %.1f%% | Разом: %.2f грн",
                description, quantity, unitPrice,
                discountPercent, getFinalAmount()
        );
    }
}
class InvoiceMainTask8 {
    public static void main(String[] args) {
        InvoiceItemTask8 item1 = new InvoiceItemTask8(
                "Монітор", 2, 6499.50, 10
        );
        InvoiceItemTask8 item2 = new InvoiceItemTask8(
                "Клавіатура", 3, 1200.00, 15
        );
        InvoiceItemTask8 item3 = new InvoiceItemTask8(
                "Миша", 1, 600.00, 0
        );
        System.out.println(item1);
        System.out.println(item2);
        System.out.println(item3);
        System.out.println("\nПозиція чека: " + item1);
        System.out.println("Кінцева сума першого товару: "
                + item1.getFinalAmount() + " грн");
    }
}
