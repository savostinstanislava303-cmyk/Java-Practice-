package practice9;

public class Main18 {
    public static void main(String[] args) {
        ShoppingOrder order = new ShoppingOrder();
        order.addItem("Хліб", 25.50, 2);
        order.addItem("Молоко", 42.00, 1);
        order.addItem("Хліб", 25.50, 1);
        order.addItem("Шоколад", 60.00, 2);
        System.out.println(order);
        System.out.println("Загальна сума: " + order.calculateGrandTotal());
    }
}

