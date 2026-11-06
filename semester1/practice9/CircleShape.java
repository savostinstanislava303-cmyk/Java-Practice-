package practice9;

public class CircleShape extends AbstractShape {
    private final double radius;
    public CircleShape(String color, double radius) {
        super(color);
        if (radius <= 0) {
            throw new IllegalArgumentException("Радіус має бути додатним");
        }
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

