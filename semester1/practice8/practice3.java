package practice8;

class Circle {
    private double radius;
    // Конструктор
    public Circle(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            this.radius = 1.0;
        }
    }
    // Геттер
    public double getRadius() {
        return radius;
    }
    // Сеттер
    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            this.radius = 1.0;
        }
    }
    public double getArea() {
        return Math.PI * radius * radius;
    }
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }
    @Override
    public String toString() {
        return String.format(
                java.util.Locale.US,
                "Circle{radius=%.2f, area=%.2f, circumference=%.2f}",
                radius, getArea(), getCircumference()
        );
    }
}
class CircleTask3 {
    public static void main(String[] args) {
        Circle circle1 = new Circle(5.0);
        Circle circle2 = new Circle(-3.0);
        System.out.println("Перше коло:");
        System.out.println(circle1);
        System.out.println("\nДруге коло:");
        System.out.println(circle2);
        circle1.setRadius(-10.0);
        System.out.println("\nПісля зміни радіуса:");
        System.out.println(circle1);
    }
}