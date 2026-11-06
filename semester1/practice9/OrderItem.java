package practice9;

public class OrderItem {
    private final String productName;
    private final double unitPrice;
    private int quantity;
    public OrderItem(String productName, double unitPrice, int quantity) {
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Назва товару не може бути порожньою");
        }
        if (unitPrice < 0) {
            throw new IllegalArgumentException("Ціна не може бути від'ємною");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Кількість має бути додатною");
        }
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }
    public String getProductName() {
        return productName;
    }
    public double getUnitPrice() {
        return unitPrice;
    }
    public int getQuantity() {
        return quantity;
    }
    public void increaseQuantity(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Приріст має бути додатним");
        }
        quantity += amount;
    }
    public double getItemTotal() {
        return unitPrice * quantity;
    }
}

