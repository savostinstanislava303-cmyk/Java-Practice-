package practice9;

 class Point2D {
    private double x;
    private double y;
    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double distanceTo(Point2D other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
public class CompositeCircle {
    private double radius;
    private final Point2D center;
    public CompositeCircle(double centerX, double centerY, double radius) {
        this.center = new Point2D(centerX, centerY);
        if (radius <= 0) {
            this.radius = 1.0;
        } else {
            this.radius = radius;
        }
    }
    public boolean containsPoint(Point2D p) {
        return center.distanceTo(p) <= radius;
    }
    @Override
    public String toString() {
        return "Коло: центр = " + center + ", радіус = " + radius;
    }

    public static void main(String[] args) {
        CompositeCircle circle = new CompositeCircle(0, 0, 5);
        Point2D point1 = new Point2D(3, 4);
        Point2D point2 = new Point2D(6, 6);
        Point2D point3 = new Point2D(0, 0);
        System.out.println(circle);
        System.out.println("Точка " + point1 + " належить колу: "
                + circle.containsPoint(point1));
        System.out.println("Точка " + point2 + " належить колу: "
                + circle.containsPoint(point2));
        System.out.println("Точка " + point3 + " належить колу: "
                + circle.containsPoint(point3));
    }
}
