package practice8;

class WarehouseItem {
    private String name;
    private int quantity;
    protected double[] priceHistory;
    public WarehouseItem(String name, int quantity, double[] priceHistory) {
        this.name = name;
        this.quantity = quantity;
        this.priceHistory = priceHistory;
    }
    public double getAveragePurchasePrice() {
        if (priceHistory.length == 0) {
            return 0;
        }
        double sum = 0;
        for (double price : priceHistory) {
            sum += price;
        }
        return sum / priceHistory.length;
    }
    @Override
    public String toString() {
        return "Назва товару: " + name +
                "\nКількість на складі: " + quantity +
                "\nСередня закупівельна ціна: " +
                String.format("%.2f", getAveragePurchasePrice());
    }
}
class DiscountedWarehouseItem extends WarehouseItem {
    private String markdownReason;
    private double discountPercent;
    public DiscountedWarehouseItem(String name, int quantity,
                                   double[] priceHistory,
                                   String markdownReason,
                                   double discountPercent) {
        super(name, quantity, priceHistory);
        this.markdownReason = markdownReason;
        this.discountPercent = discountPercent;
    }
    public double calculateSalePrice() {
        double averagePrice = getAveragePurchasePrice();

        return averagePrice * (1 - discountPercent / 100);
    }
    @Override
    public String toString() {
        return super.toString() +
                "\nПричина уцінки: " + markdownReason +
                "\nЗнижка: " + discountPercent + "%" +
                "\nЦіна розпродажу: " +
                String.format("%.2f", calculateSalePrice());
    }
}
public class practice36 {
    public static void main(String[] args) {
        double[] prices = {500, 600, 550, 650};
        DiscountedWarehouseItem item =
                new DiscountedWarehouseItem(
                        "Навушники",
                        15,
                        prices,
                        "Пошкоджена упаковка",
                        20
                );
        System.out.println(item);
    }
}
