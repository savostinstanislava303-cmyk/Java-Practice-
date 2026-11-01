package practice8;

class Product {
    private String sku;
    private String title;
    private double price;
    private int stock;
    // Конструктор
    public Product(String sku, String title, double price, int stock) {
        this.sku = sku;
        this.title = title;
        if (price >= 0.0) {
            this.price = price;
        } else {
            this.price = 0.0;
        }
        if (stock >= 0) {
            this.stock = stock;
        } else {
            this.stock = 0;
        }
    }
    public String getSku() {
        return sku;
    }
    public String getTitle() {
        return title;
    }
    public double getPrice() {
        return price;
    }
    public int getStock() {
        return stock;
    }
    public void setPrice(double price) {
        if (price >= 0.0) {
            this.price = price;
        } else {
            this.price = 0.0;
        }
    }
    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        } else {
            this.stock = 0;
        }
    }

    // Розрахунок загальної вартості
    public double getTotalCost() {
        return price * stock;
    }
    @Override
    public String toString() {
        return String.format(
                "[SKU: %s] %s | Ціна: %.2f грн | Залишок: %d шт. | Разом: %.2f грн",
                sku, title, price, stock, getTotalCost()
        );
    }
}
class ProductTask2 {
    public static void main(String[] args) {
        Product product1 = new Product("A-101", "Монітор", 6499.50, 4);
        Product product2 = new Product("B-205", "Клавіатура", 1299.99, 5);
        Product product3 = new Product("C-310", "Миша", 599.00, 10);
        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product3);
    }
}