package practice9;

public class Main25 {
    public static void main(String[] args) {
        AbstractShape circle = new CircleShape("Червоний", 3);
        AbstractShape rectangle = new RectangleShape("Синій", 4, 5);
        System.out.println(circle);
        System.out.println(rectangle);
        AbstractShape[] shapes = {circle, rectangle};
        double totalArea = 0;
        for (AbstractShape shape : shapes) {
            totalArea += shape.getArea();
        }
        System.out.printf(java.util.Locale.US, "Сумарна площа: %.2f%n", totalArea);
    }
}
