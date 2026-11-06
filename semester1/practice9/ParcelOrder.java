package practice9;

class DeliveryAddress {
    private String city;
    private String street;
    private int postOfficeNumber;
    public DeliveryAddress(String city, String street, int postOfficeNumber) {
        this.city = city;
        this.street = street;
        this.postOfficeNumber = postOfficeNumber;
    }
    public boolean isValid() {
        return city != null && !city.isEmpty()
                && street != null && !street.isEmpty()
                && postOfficeNumber > 0;
    }
    @Override
    public String toString() {
        return "Місто: " + city +
                ", вулиця: " + street +
                ", відділення №" + postOfficeNumber;
    }
}
public class ParcelOrder {
    private final String orderId;
    private double weightKg;
    private DeliveryAddress destination;
    private boolean shipped;
    public ParcelOrder(String orderId, double weightKg,
                       DeliveryAddress destination) {

        this.orderId = orderId;
        this.weightKg = weightKg;
        if (destination == null || !destination.isValid()) {
            throw new IllegalArgumentException("Некоректна адреса доставки!");
        }
        this.destination = destination;
        this.shipped = false;
    }
    public void changeDestination(DeliveryAddress newAddress) {
        if (shipped) {
            System.out.println("Помилка! Посилку вже відправлено. Адресу змінити неможливо.");
            return;
        }
        if (newAddress == null || !newAddress.isValid()) {
            System.out.println("Некоректна адреса!");
            return;
        }
        this.destination = newAddress;
        System.out.println("Адресу доставки успішно змінено!");
    }
    public void markAsShipped() {
        shipped = true;
        System.out.println("Посилку відправлено!");
    }
    @Override
    public String toString() {
        return "Замовлення №" + orderId +
                "\nВага: " + weightKg + " кг" +
                "\nАдреса доставки: " + destination +
                "\nСтатус: " + (shipped ? "Відправлено" : "Не відправлено");
    }
    public static void main(String[] args) {
        DeliveryAddress address1 =
                new DeliveryAddress("Київ", "Хрещатик", 15);
        DeliveryAddress address2 =
                new DeliveryAddress("Чернігів", "Шевченка", 8);
        ParcelOrder order =
                new ParcelOrder("ORD-001", 2.5, address1);
        System.out.println("Початкове замовлення:");
        System.out.println(order);
        System.out.println("\nЗміна адреси:");
        order.changeDestination(address2);
        System.out.println(order);
        System.out.println("\nВідправка посилки:");
        order.markAsShipped();
        System.out.println(order);
        System.out.println("\nСпроба повторної зміни адреси:");
        order.changeDestination(address1);
        System.out.println("\nКінцевий стан:");
        System.out.println(order);
    }
}

