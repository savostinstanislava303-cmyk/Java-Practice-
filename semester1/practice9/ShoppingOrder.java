package practice9;

import java.util.Locale;
public class ShoppingOrder {
    private static final int MAX_ITEMS = 10;
    private final OrderItem[] items = new OrderItem[MAX_ITEMS];
    private int itemCount;
    public void addItem(String name, double price, int qty) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getProductName().equalsIgnoreCase(name)) {
                items[i].increaseQuantity(qty);
                return;
            }
        }
        if (itemCount >= items.length) {
            throw new IllegalStateException("Замовлення заповнене (максимум " + MAX_ITEMS + " позицій)");
        }
        items[itemCount++] = new OrderItem(name, price, qty);
    }
    public double calculateGrandTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += items[i].getItemTotal();
        }
        return total;
    }
    @Override
    public String toString() {
        String line = "=".repeat(44);
        StringBuilder sb = new StringBuilder();
        sb.append(line).append('\n');
        sb.append(String.format("%24s%n", "ФІСКАЛЬНИЙ ЧЕК"));
        sb.append(line).append('\n');
        if (itemCount == 0) {
            sb.append("(порожньо)\n");
        }
        for (int i = 0; i < itemCount; i++) {
            OrderItem item = items[i];
            sb.append(String.format(Locale.US, "%d. %-14s %2d x %8.2f = %9.2f%n",
                    i + 1,
                    item.getProductName(),
                    item.getQuantity(),
                    item.getUnitPrice(),
                    item.getItemTotal()));
        }
        sb.append(line).append('\n');
        sb.append(String.format(Locale.US, "%-30s %13.2f%n", "РАЗОМ ДО СПЛАТИ:", calculateGrandTotal()));
        sb.append(line);
        return sb.toString();
    }
}

