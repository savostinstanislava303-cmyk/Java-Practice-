package practice8;

class Segment1D {
    protected double length;
    public Segment1D(double length) {
        this.length = length;
    }
    @Override
    public String toString() {
        return "Довжина відрізка: " + length;
    }
}
class Square2D extends Segment1D {
    public Square2D(double length) {
        super(length);
    }
    public double getPerimeter() {
        return 4 * length;
    }
    public double getArea() {
        return length * length;
    }
    @Override
    public String toString() {
        return super.toString() +
                "\nПериметр квадрата: " + getPerimeter() +
                "\nПлоща квадрата: " + getArea();
    }
}
class Cube3D extends Square2D {
    public Cube3D(double length) {
        super(length);
    }
    @Override
    public double getArea() {
        return 6 * super.getArea();
    }
    public double getVolume() {
        return length * length * length;
    }
    @Override
    public String toString() {
        return super.toString() +
                "\nПовна площа поверхні куба: " + getArea() +
                "\nОб'єм куба: " + getVolume();
    }
}
public class practice30 {
    public static void main(String[] args) {
        Segment1D segment = new Segment1D(5);
        Square2D square = new Square2D(5);
        Cube3D cube = new Cube3D(5);
        System.out.println("===== ВІДРІЗОК =====");
        System.out.println(segment);
        System.out.println("\n===== КВАДРАТ =====");
        System.out.println(square);
        System.out.println("\n===== КУБ =====");
        System.out.println(cube);
    }
}