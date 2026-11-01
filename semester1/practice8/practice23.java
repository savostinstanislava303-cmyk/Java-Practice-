package practice8;

class Point2D {
    private double x;
    private double y;
    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double distanceToOrigin() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
    @Override
    public String toString() {
        return "(" + x + "; " + y + ")";
    }
}
class Point3D extends Point2D {
    private double z;
    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }
    @Override
    public double distanceToOrigin() {
        return Math.sqrt(
                Math.pow(super.distanceToOrigin(), 2) + z * z
        );
    }
    @Override
    public String toString() {
        return "(" + getX() + "; " + getY() + "; " + z + ")";
    }
}
public class practice23 {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(3, 4);
        Point3D point3D = new Point3D(3, 4, 12);
        System.out.println("Точка 2D: " + point2D);
        System.out.println("Відстань до початку координат: " +
                point2D.distanceToOrigin());
        System.out.println();
        System.out.println("Точка 3D: " + point3D);
        System.out.println("Відстань до початку координат: " +
                point3D.distanceToOrigin());
    }
}